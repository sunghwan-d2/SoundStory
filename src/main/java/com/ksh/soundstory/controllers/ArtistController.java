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
    private final ArtistService artistService;

    @Autowired
    public ArtistController(ArticleService articleService, ArtistService artistService) {
        this.articleService = articleService;

        this.artistService = artistService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
    public ModelAndView getArtist() {
        return new ModelAndView("index/artist");
    }

    @RequestMapping(value = "/read", method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
    public ModelAndView getRead(@SessionAttribute("user") UserEntity user,
                                @RequestParam("index") int index) {
        if (user == null) {
            return null;
        }
        ModelAndView modelAndView = new ModelAndView();
        ArticleEntity articles = this.articleService.getArticle(index); // 단일 게시물을 가져옴
        articles.setNickname(user.getNickname());
        modelAndView.addObject("articles", articles);
        return modelAndView;
    }


    @RequestMapping(value = "write", method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
    public ModelAndView getWrite() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index/artist");
        return modelAndView;
    }

    @RequestMapping(value = "write", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ModelAndView postWrite(@SessionAttribute("user") UserEntity user, @ModelAttribute ArticleEntity article) {
        article.setUserEmail(user.getEmail());
        article.setNickname(user.getNickname());
        article.setCreatedAt(LocalDateTime.now());
        Result<?> result = this.articleService.write(article);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("article", article);
        modelAndView.addObject("result", result.name());
        if (result == CommonResult.SUCCESS) {
            modelAndView.setViewName("redirect:/artist/read?index=" + article.getIndex()); // 이 부분 수정// 이 부분 수정
        } else {
            modelAndView.setViewName("index/artist");
        }
        return modelAndView;
    }


}
