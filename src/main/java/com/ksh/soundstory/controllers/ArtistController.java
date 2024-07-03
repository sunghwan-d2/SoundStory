package com.ksh.soundstory.controllers;

import com.ksh.soundstory.entities.ArtistEntity;
import com.ksh.soundstory.entities.CommentEntity;
import com.ksh.soundstory.services.AlbumService;
import com.ksh.soundstory.services.ArtistService;
import com.ksh.soundstory.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/artist")
public class ArtistController {
    private final ArtistService artistService;
    private final AlbumService albumService;
    private final CommentService commentService;


    @Autowired
    public ArtistController(ArtistService artistService, AlbumService albumService, CommentService commentService) {
        this.artistService = artistService;
        this.albumService = albumService;
        this.commentService = commentService;
    }


    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
    public ModelAndView getArtist(@RequestParam(value = "artistId") int artistId) {
        ArtistEntity artist = this.artistService.getArtist(artistId);
        CommentEntity[] comments = this.commentService.selectCommentAll();
        ModelAndView modelAndView = new ModelAndView("index/artist");
        modelAndView.addObject("artist", artist);
        modelAndView.addObject("comments", comments);
        return modelAndView;
    }

    @RequestMapping(value = "/image", method = RequestMethod.GET)
    public ResponseEntity<byte[]> getImage(@RequestParam("artistId") int artistId) {
        ArtistEntity artist = this.artistService.getArtist(artistId);

        if (artist == null) {
            return ResponseEntity.notFound().build(); // 404
        }
        return ResponseEntity
                .ok()
                .contentType(MediaType.parseMediaType(artist.getImageContentType()))
                .contentLength(artist.getImageData().length)
                .body(artist.getImageData());

    }

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


