package com.ksh.soundstory.controllers;

import com.ksh.soundstory.entities.CommentEntity;
import com.ksh.soundstory.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("artist")
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




}
