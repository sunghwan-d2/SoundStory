package com.ksh.soundstory.controllers;

import com.ksh.soundstory.entities.CommentEntity;
import com.ksh.soundstory.entities.UserEntity;
import com.ksh.soundstory.services.CommentService;
import com.ksh.soundstory.vos.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/artist")
public class ArtistController {
    private final CommentService commentService;

    @Autowired
    public ArtistController(CommentService commentService) {
        this.commentService = commentService;
    }


    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
    public ModelAndView getArtist() {
        ModelAndView modelAndView = new ModelAndView();
        CommentEntity[] comment = this.commentService.selectCommentAll();

        modelAndView.addObject("comments", comment);
        modelAndView.setViewName("index/artist");
        return modelAndView;
    }

//    @RequestMapping(value = "/read", method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
//    public ModelAndView getRead(@SessionAttribute("user") UserEntity user,
//                                @RequestParam(value = "page", required = false, defaultValue = "1") int _page) {
//        if (user == null) {
//            return new ModelAndView("index/artist");
//        }
//        PageVo page = new PageVo(_page);
//        CommentEntity[] comments = this.commentService.selectCommentAll();
//        CommentEntity[] articles = this.commentService.getAll(page);
//        ModelAndView modelAndView = new ModelAndView("index/artist");
//        modelAndView.addObject("comments", comments);
//        modelAndView.addObject("articles", articles);
//        modelAndView.addObject("page", page);
//
//        return modelAndView;
//    }





}
