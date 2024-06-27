package com.ksh.soundstory.controllers;

import com.ksh.soundstory.entities.CommentEntity;
import com.ksh.soundstory.entities.UserEntity;
import com.ksh.soundstory.results.CommonResult;
import com.ksh.soundstory.results.Result;
import com.ksh.soundstory.services.CommentService;
import com.ksh.soundstory.vos.PageVo;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/comment")
public class CommentController {
    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @RequestMapping(value = "/read", method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
    public ModelAndView getRead(@SessionAttribute("user") UserEntity user,
                                @RequestParam(value = "page", defaultValue = "1") int _page) {
        PageVo page = new PageVo(_page);
        if (user == null) {
            return new ModelAndView("index/artist");
        }
        CommentEntity[] comments = this.commentService.getAll(page);
        ModelAndView modelAndView = new ModelAndView("index/artist");
        modelAndView.addObject("comments", comments);
        modelAndView.addObject("page", page);
        return modelAndView;
    }


    @RequestMapping(value = "/write", method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
    public ModelAndView getWrite(@SessionAttribute("user") UserEntity user) {
        if (user == null) {
            return new ModelAndView("index/artist");
        }
        CommentEntity[] comments = this.commentService.selectCommentAll();
        ModelAndView modelAndView = new ModelAndView("index/artist");
        modelAndView.addObject("comments", comments);

        return modelAndView;
    }

    @RequestMapping(value = "/write", method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
    public ModelAndView postWrite(@SessionAttribute("user") UserEntity user,
                                  @ModelAttribute CommentEntity comment) {
        comment.setUserEmail(user.getEmail());
        comment.setNickname(user.getNickname());
        comment.setCreatedAt(LocalDateTime.now());
        Result<?> result = this.commentService.put(comment);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("comment", comment);
        modelAndView.addObject("result", result);
        if (result.equals(CommonResult.SUCCESS)) {
            modelAndView.setViewName("redirect:/comment/read?index=" + comment.getIndex());
        } else {
            modelAndView.setViewName("index/artist");
        }
        return modelAndView;
    }

    @RequestMapping(value = "/", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String deleteComment(@RequestParam("index") int index) {
        CommonResult result = this.commentService.delete(index);
        JSONObject responseObject = new JSONObject();
        responseObject.put("result", result.name().toLowerCase());
        return responseObject.toString();
    }

}