package com.ksh.soundstory.controllers;

import com.ksh.soundstory.entities.ArtistEntity;
import com.ksh.soundstory.services.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/artist")
public class ArtistController {
    private final ArtistService artistService;


    @Autowired
    public ArtistController(ArtistService artistService) {
        this.artistService = artistService;
    }


    @RequestMapping(value = "/index", method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
    public ModelAndView getArtist(@RequestParam(value = "artistId") int artistId) {
        ArtistEntity artist = this.artistService.getArtist(artistId);
        ModelAndView modelAndView = new ModelAndView("index/artist");
        modelAndView.addObject("artist", artist);
//        modelAndView.setViewName("redirect:/artist/" + artist.getArtistId());
        return modelAndView;

    }
//    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
//    public ModelAndView getArtist(@RequestParam(value = "page", required = false, defaultValue ="1") int _page) {
//        PageVo page = new PageVo(_page);
//        ModelAndView modelAndView = new ModelAndView();
//        CommentEntity[] comments = this.commentService.getAll(page);
//
//        modelAndView.addObject("comments", comments);
//        modelAndView.addObject("page", page);
//        modelAndView.setViewName("index/artist");
//        return modelAndView;
//    }

}
