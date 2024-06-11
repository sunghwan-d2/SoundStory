package com.ksh.soundstory.controllers;

import com.ksh.soundstory.entities.ArticleEntity;
import com.ksh.soundstory.entities.UserEntity;
import com.ksh.soundstory.results.CommonResult;
import com.ksh.soundstory.results.Result;
import com.ksh.soundstory.services.ArticleService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/article")
public class ArticleController {

    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @RequestMapping(value = "read", method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
    public ModelAndView getRead(@RequestParam("index") int index) {
        ArticleEntity[] article = this.articleService.getArticle(index);
        ModelAndView modelAndView = new ModelAndView("index/artist");
        modelAndView.addObject("article", article);
        return modelAndView;
    }

    @RequestMapping(value = "write", method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
    public ModelAndView getWrite() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index/artist");
        return modelAndView;
    }

    @RequestMapping(value = "write", method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
    public ModelAndView postWrite(@SessionAttribute("user") UserEntity user,
                                  ArticleEntity article) {
        article.setUserEmail(user.getEmail());
        article.setCreatedAt(LocalDateTime.now());
        Result<?> result = this.articleService.write(article);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("result", result.name());
        if (result == CommonResult.SUCCESS) {
            modelAndView.setViewName("redirect:/artist/article/read?index=" + article.getIndex());
        } else {
            modelAndView.setViewName("index/artist");
        }
        return modelAndView;
    }
}