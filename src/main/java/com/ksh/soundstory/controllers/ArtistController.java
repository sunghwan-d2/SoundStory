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
    public ArtistController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
    public ModelAndView getArtist() {
        ModelAndView modelAndView = new ModelAndView();
        ArticleEntity[] article = this.articleService.selectArticle();
        modelAndView.addObject("article", article);
        modelAndView.setViewName("index/artist");
        return modelAndView;
//        return new ModelAndView("index/artist");
    }

//    @RequestMapping(value="/1",method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
//    public ModelAndView getArtist1(){
//        return new ModelAndView("index/artist/1.JungKook");
//    }
//
//    @RequestMapping(value="/2",method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
//    public ModelAndView getArtist2(){
//        return new ModelAndView("index/artist/2.NewJeans");
//    }
//
//    @RequestMapping(value="/3",method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
//    public ModelAndView getArtist3(){
//        return new ModelAndView("index/artist/3.ILLIT");
//    }
//
//    @RequestMapping(value="/4",method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
//    public ModelAndView getArtist4(){
//        return new ModelAndView("index/artist/4.IVE");
//    }
//
//    @RequestMapping(value="/5",method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
//    public ModelAndView getArtist5(){
//        return new ModelAndView("index/artist/5.LE SSERAFIM");
//    }
//
//    @RequestMapping(value="/6",method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
//    public ModelAndView getArtist6(){
//        return new ModelAndView("index/artist/6.Aespa");
//    }
//
//    @RequestMapping(value="/7",method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
//    public ModelAndView getArtist7(){
//        return new ModelAndView("index/artist/7.ZICO");
//    }
//
//    @RequestMapping(value="/8",method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
//    public ModelAndView getArtist8(){
//        return new ModelAndView("index/artist/8.IU");
//    }
//
//    @RequestMapping(value="/9",method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
//    public ModelAndView getArtist9(){
//        return new ModelAndView("index/artist/9.V");
//    }
//
//    @RequestMapping(value="/10",method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
//    public ModelAndView getArtist10(){
//        return new ModelAndView("index/artist/10.(G)I-DLE");
//    }
//
//    @RequestMapping(value="/11",method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
//    public ModelAndView getArtist11(){
//        return new ModelAndView("index/artist/11.10CM");
//    }
//
//    @RequestMapping(value="/12",method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
//    public ModelAndView getArtist12(){
//        return new ModelAndView("index/artist/12.RIIZE");
//    }





}
