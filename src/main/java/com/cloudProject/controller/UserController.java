package com.cloudProject.controller;

import com.cloudProject.domain.user.User;
import com.cloudProject.dto.UserDto;
import com.cloudProject.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Slf4j
@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;


    @PostMapping("/api/join")
    public String join(@RequestBody UserDto req){
        log.info("join : "+req.toEntity().toString());

        userService.joinUser(req);
        return "redirect:/";
    }

    @PostMapping("/api/login")
    public String login(@RequestBody UserDto req){
        log.info("login"+req.toString());
        HttpServletRequest sevlet = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();

        User user = userService.loginUser(req);

        HttpSession session = sevlet.getSession();
        session.setAttribute("uid",user.getId());

        System.out.println("sessionId : "+session.getAttribute("uid").toString());
        return "redirect:/page";
    }

    @GetMapping("/logout")
    public String logout(){
        HttpServletRequest sevlet = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        HttpSession session = sevlet.getSession();
        session.invalidate();

        log.info(session.getId());
        return "redirect:/";
    }


    @GetMapping("/test")
    public void test(HttpServletRequest sevlet){
        HttpSession session = sevlet.getSession();
        session.setAttribute("uid","test");
        String id = session.getAttribute("uid").toString();
        System.out.println("sessionId"+id);
    }

}
