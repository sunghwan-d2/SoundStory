//package com.ksh.soundstory.services;
//
//import com.ksh.soundstory.entities.CommentEntity;
//import com.ksh.soundstory.entities.UserEntity;
//import com.ksh.soundstory.mappers.CommentMapper;
//import com.ksh.soundstory.results.CommonResult;
//import com.ksh.soundstory.results.Result;
//import com.ksh.soundstory.results.comment.DeleteResult;
//import com.ksh.soundstory.results.comment.ModifyResult;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class CommentService {
//    private final CommentMapper commentMapper;
//
//    @Autowired
//    public CommentService(CommentMapper commentMapper) {
//        this.commentMapper = commentMapper;
//    }
//
//    public Result<?> write(CommentEntity comment){
////        commentMapper.setCreatedAt(new Date());
//        return this.commentMapper.insertComment(comment)>0
//                ? CommonResult.SUCCESS
//                : CommonResult.FAILURE;
//
//    }
//    public CommentEntity[] getComments(int articleIndex){
//        return this.commentMapper.selectCommentByArticleIndex(articleIndex);
//
//
//    }
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
//
//    public Result<?> modify(int index, String newContent,UserEntity user){
//        if (user ==null){
//            return ModifyResult.FAILURE_DENIED;
//        }
//        CommentEntity dbComment = this.commentMapper.selectCommentByIndex(index);
//
//        if (dbComment == null){
//            return ModifyResult.FAILURE_DENIED;
//        }
//        if (!user.getEmail().equals(dbComment.getUserEmail())){
//            return ModifyResult.FAILURE_DENIED;
//        }
//
//        dbComment.setContent(newContent);
//        int modifyResult = this.commentMapper.updateComment(dbComment);
//        return modifyResult  >  0
//                ? CommonResult.SUCCESS
//                : CommonResult.FAILURE;
//
//    }
//
//
//}
