package com.example.backend.service;

import com.example.backend.core.Service;
import com.example.backend.model.Comment;
import com.example.backend.web.model.CommentResult;
import com.example.backend.web.model.ReplyRequest;
import com.example.backend.web.model.UserComment;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

public interface CommentService extends Service<Comment> {
    void addComment(Comment c);
    void replyComment(ReplyRequest r);

    List<Comment> allComment(Integer page,Integer size);
    void updateState(Comment c);
    Integer commentTotal();

    String saveImage(MultipartFile imageFile) throws Exception;

    List<UserComment> commentList(String productID);
    CommentResult latestComment(String productID);
    List<CommentResult> frameCommentList(String productID);     // （用户前端显示）商品评论列表

    public Map<String, Object> findApprovalRatingAndCommentCoutByProductID(String productID);
}
