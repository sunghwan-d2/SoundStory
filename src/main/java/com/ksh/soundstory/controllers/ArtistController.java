package com.ksh.soundstory.controllers;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ArtistController {
    @RequestMapping(value="artist",method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
    public ModelAndView getArtist(){
        return new ModelAndView("index/artist");
    }
}
