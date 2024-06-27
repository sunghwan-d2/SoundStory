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
    public ModelAndView getArtist(@RequestParam(value = "page", required = false, defaultValue ="1") int _page) {
        PageVo page = new PageVo(_page);
        ModelAndView modelAndView = new ModelAndView();
        CommentEntity[] comments = this.commentService.getAll(page);

        modelAndView.addObject("comments", comments);
        modelAndView.addObject("page", page);
        modelAndView.setViewName("index/artist");
        return modelAndView;
    }



}
