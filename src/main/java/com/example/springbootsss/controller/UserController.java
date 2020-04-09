package com.example.springbootsss.controller;


import com.example.springbootsss.pojo.Resume;
import com.example.springbootsss.pojo.User;
import com.example.springbootsss.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author: 李明
 * @create: 2020-03-25 13:31
 * @Description:
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private ResumeService resumeService;

    @RequestMapping("/login")
    @ResponseBody
    public ModelAndView login(User user, HttpSession httpSession) {

        ModelAndView modelAndView = new ModelAndView();
        if ("admin".equals(user.getUsername()) && "admin".equals(user.getPassword())) {
            httpSession.setAttribute("username",user.getUsername() + System.currentTimeMillis());
            List<Resume> resumes = null;
            try {
                resumes = this.resumeService.queryResumeList();
            } catch (Exception e) {
                e.printStackTrace();
            }
            modelAndView.addObject("resumeList", resumes);
            modelAndView.setViewName("resumeList");
            return modelAndView;
        } else {
            modelAndView.setViewName("index");
            return modelAndView;
        }
    }
}
