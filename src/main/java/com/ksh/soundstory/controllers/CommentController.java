package com.ksh.soundstory.controllers;

import com.ksh.soundstory.entities.CommentEntity;
import com.ksh.soundstory.entities.UserEntity;
import com.ksh.soundstory.results.Result;
import com.ksh.soundstory.services.CommentService;
import org.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/comment")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String postIndex(@SessionAttribute("user")UserEntity user,
                            CommentEntity comment){
        comment.setUserEmail(user.getEmail());
        Result<?> result = this.commentService.write(comment);
        JSONObject responseObject = new JSONObject();
        responseObject.put("result",result.name().toLowerCase());
        return responseObject.toString();
    }

    @RequestMapping(value = "/",method = RequestMethod.GET,produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public CommentEntity[] getIndex(@RequestParam("articleIndex")int articleIndex){
        return this.commentService.getComments(articleIndex);
    }

    @RequestMapping(value = "/",method = RequestMethod.DELETE,produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String deleteIndex(@SessionAttribute(value = "user",required = false )UserEntity user,
                              @RequestParam("index") int index){
        Result<?> result = this.commentService.delete(index, user);
        JSONObject responseObject = new JSONObject();
        responseObject.put("result",result.name().toLowerCase());
        return responseObject.toString();

    }

    @RequestMapping(value="/", method = RequestMethod.PATCH,produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String patchIndex(@SessionAttribute(value = "user",required = false)UserEntity user,
                             @RequestParam("index") int index,
                             @RequestParam("newContent") String newContent){
        Result<?> result = this.commentService.modify(index,newContent,user);
        JSONObject responseObject = new JSONObject();
        responseObject.put("result",result.name().toLowerCase());
        return responseObject.toString();

    }



}
