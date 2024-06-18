package com.ksh.soundstory.controllers;

import com.ksh.soundstory.entities.ArticleEntity;
import com.ksh.soundstory.entities.UserEntity;
import com.ksh.soundstory.results.CommonResult;
import com.ksh.soundstory.results.Result;
import com.ksh.soundstory.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;

// artist 홈페이지의 댓글 -> article 로 했음 - > comment?
@Controller
@RequestMapping("article")
public class ArticleController {

    private final ArticleService articleService;

    @Autowired
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @RequestMapping(value = "/read", method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
    public ModelAndView getRead(@SessionAttribute("user") UserEntity user) {
        if (user == null) {
            return new ModelAndView("index/artist");
        }
        ModelAndView modelAndView = new ModelAndView();
        ArticleEntity[] article = this.articleService.selectArticle();
        modelAndView.addObject("article", article);
        modelAndView.setViewName("article/read");
        return modelAndView;
    }

//    @RequestMapping(value="/read",method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
//    public ModelAndView postRead(@SessionAttribute("user")UserEntity user){
//        if (user == null){
//            return null;
//        }
//        ModelAndView modelAndView = new ModelAndView();
//        ArticleEntity[] article = this.articleService.selectArticle();
//        modelAndView.addObject("article",article);
//        modelAndView.setViewName("article/read");
//        return modelAndView;
//    }

    @RequestMapping(value = "/write", method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
    public ModelAndView getWrite() {
        return new ModelAndView("index/artist");
    }

    @RequestMapping(value = "/write", method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
    public ModelAndView postWrite(@SessionAttribute("user") UserEntity user,
                                  @ModelAttribute ArticleEntity article) {
        article.setUserEmail(user.getEmail());
        article.setNickname(user.getNickname());
        article.setCreatedAt(LocalDateTime.now());
        Result<?> result = this.articleService.write(article);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("article", article);
        modelAndView.addObject("result", result);
        if (result.equals(CommonResult.SUCCESS)) {
            modelAndView.setViewName("redirect:/article/read?index=" + article.getIndex());
        } else {
            modelAndView.setViewName("index/artist");
        }
        return modelAndView;
    }
}
