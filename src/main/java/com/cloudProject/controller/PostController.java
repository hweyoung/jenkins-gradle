package com.cloudProject.controller;

import com.cloudProject.domain.post.Post;
import com.cloudProject.domain.post.PostRepository;
import com.cloudProject.domain.user.User;
import com.cloudProject.dto.PostDto;
import com.cloudProject.service.PostService;
import com.cloudProject.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Slf4j
@Controller
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;
    private final PostRepository postRepository;
    private final UserService userService;



    @GetMapping("/page")
    public String index(Model model){
        Iterable<Post> postList = postRepository.findAll();
        for(Post p: postList){
            System.out.println(p.toString());
        }
        model.addAttribute("postList", postList);
        return "post/index";
    }

    @PostMapping("/api/post/create")
    public String create(@RequestBody PostDto req){
        log.info(req.toString());
        if(!userService.existUser())return "redirect:/";
        User user = userService.getUser();
        Post post = req.toEntity();
        post.setUser(user);

        postService.createPost(post);

        return "post/index";
    }


    @GetMapping("/post/{id}")
    public String show(@PathVariable Long id, Model model){
        Post post = postRepository.findByPostIdx(id).orElseThrow(()-> new IllegalArgumentException("not found Post"));
        model.addAttribute("post", post);
        return "post/show";
    }

    @GetMapping("/api/post/{idx}")
    public String delete(@PathVariable Long idx){
        User user = userService.getUser();
        System.out.println("delete 실행중");
        postService.delete(idx, user);
        return "redirect:/page";
    }


}
