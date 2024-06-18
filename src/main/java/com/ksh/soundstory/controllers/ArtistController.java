package com.ksh.soundstory.controllers;

import com.ksh.soundstory.entities.ArticleEntity;
import com.ksh.soundstory.entities.ArtistEntity;
import com.ksh.soundstory.entities.UserEntity;
import com.ksh.soundstory.results.CommonResult;
import com.ksh.soundstory.results.Result;
import com.ksh.soundstory.services.ArticleService;
import com.ksh.soundstory.services.ArtistService;
import com.ksh.soundstory.services.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("artist")
public class ArtistController {
    private final ArticleService articleService;

    @Autowired
    public ArtistController(ArticleService articleService, ArtistService artistService) {
        this.articleService = articleService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
    public ModelAndView getArtist(@SessionAttribute("user") UserEntity user) {
        ModelAndView modelAndView = new ModelAndView();
        ArticleEntity[] article = this.articleService.selectArticle();
        modelAndView.addObject("article", article);
        modelAndView.setViewName("index/artist");
        return modelAndView;
//        return new ModelAndView("index/artist");
    }

// artist 홈페이지만.



}
