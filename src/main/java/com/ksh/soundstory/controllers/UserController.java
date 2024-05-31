package com.ksh.soundstory.controllers;


import com.ksh.soundstory.entites.EmailAuthEntity;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {
    @RequestMapping(value = "/registerEmail", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String postRegisterEmail(EmailAuthEntity emailAuth) {
        System.out.println("전달 받은 이메일 : " + emailAuth.getEmail());
        return null;
    }
}
