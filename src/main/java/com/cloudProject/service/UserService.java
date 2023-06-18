package com.cloudProject.service;

import com.cloudProject.domain.user.User;
import com.cloudProject.domain.user.UserRepository;
import com.cloudProject.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public void joinUser(UserDto req) {
        int cnt = userRepository.CountUserById(req.getId());
        if(cnt>0) throw new IllegalArgumentException("already");
        userRepository.save(req.toEntity());
    }

    public User loginUser(UserDto req) {
        User user = userRepository.findUserById(req.getId()).orElseThrow(()->new IllegalArgumentException("not found User"));
        if(!user.getPwd().equals(req.getPwd())) throw new IllegalArgumentException("Invalid Password");
        return user;
    }

    public boolean countId(String id){
        if(userRepository.CountUserById(id)>0) return true;
        else return false;
    }
    public boolean existUser(){
        HttpServletRequest sevlet = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        HttpSession session = sevlet.getSession();

        //get session
        String id = session.getAttribute("uid").toString();

        if(countId(id)) return true;
        return false;
    }

    public User getUser() {
        HttpServletRequest sevlet = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        HttpSession session = sevlet.getSession();
        String id = session.getAttribute("uid").toString();
        return userRepository.findUserById(id).orElseThrow(()-> new IllegalArgumentException("not found user"));

    }
}
