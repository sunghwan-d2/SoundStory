//package com.ksh.soundstory.controllers;
//
//import com.ksh.soundstory.entities.CommentEntity;
//import com.ksh.soundstory.results.CommonResult;
//import com.ksh.soundstory.services.CommentService;
//import org.json.JSONObject;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//@Controller
//@RequestMapping("/comment")
//public class CommentController {
//    private final CommentService commentService;
//
//    @Autowired
//    public CommentController(CommentService commentService) {
//        this.commentService = commentService;
//    }
//
//    @RequestMapping(value = "/write", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
//    @ResponseBody
//    public String postWrite(CommentEntity comment) {
//        CommonResult result = this.commentService.put(comment);
//        JSONObject responseObject = new JSONObject();
//        responseObject.put("result", result.name().toLowerCase());
//        return responseObject.toString();
//    }
//    @RequestMapping(value="/",method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
//    @ResponseBody
//    public String DeleteIndex(@RequestParam(value = "index")int index){
//        CommonResult result = this.commentService.delete(index);
//        JSONObject responseObject = new JSONObject();
//        responseObject.put("result",result.name().toLowerCase());
//        return responseObject.toString();
//    }
//
//}