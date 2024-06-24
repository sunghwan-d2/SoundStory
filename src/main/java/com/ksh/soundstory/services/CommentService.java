package com.ksh.soundstory.services;

import com.ksh.soundstory.entities.CommentEntity;
import com.ksh.soundstory.mappers.CommentMapper;
import com.ksh.soundstory.results.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CommentService {
    private final CommentMapper commentMapper;

    @Autowired
    public CommentService(CommentMapper commentMapper) {
        this.commentMapper = commentMapper;
    }

    public CommonResult put(CommentEntity comment) {
        if (comment.getNickname() == null || comment.getContent() == null ||
                comment.getNickname().length() > 10 ||
                comment.getContent().isEmpty() ||
                comment.getContent().length() > 10000) {
            return CommonResult.FAILURE;
        }
        comment.setCreatedAt(LocalDateTime.now());
        return this.commentMapper.insertComment(comment) > 0
                ? CommonResult.SUCCESS
                : CommonResult.FAILURE;

    } // 댓글 삽입

    public CommentEntity[] selectCommentAll() {
        return this.commentMapper.selectCommentAll();
    } // 전체 댓글을 불러옴


    public CommentEntity get(int index) {
        return this.commentMapper.selectCommentByIndex(index);
    }


    public CommonResult delete(int index) {
        if (index < 1) {
            return CommonResult.FAILURE;
        }
        return this.commentMapper.deleteCommentByIndex(index) > 0
                ? CommonResult.SUCCESS
                : CommonResult.FAILURE;
    }
//    public Result<?> delete(int index, UserEntity user){
//
//        if (user == null){ // 로그인 하지 않은 상황
//            return CommonResult.FAILURE;
//        }
//        CommentEntity dbComment = this.commentMapper.selectCommentByIndex(index);
//        if (dbComment == null){
//            return CommonResult.FAILURE; // 너가 준 index 로 댓글 선택(SELECT) 해왔더니 그런것 없었어.
//        }
//        if (user.getEmail().equals(dbComment.getUserEmail())){
//            return DeleteResult.FAILURE_DENIED; // 로그인한 사람과 댓글 작성자가 다르다면
//        }
//
//
//        return this.commentMapper.deleteCommentByIndex(index)>0
//                ? CommonResult.SUCCESS
//                : CommonResult.FAILURE;
//
//    }




}
