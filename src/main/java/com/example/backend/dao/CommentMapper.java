package com.example.backend.dao;

import com.example.backend.core.Mapper;
import com.example.backend.model.Comment;
import com.example.backend.web.model.ReplyRequest;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface CommentMapper extends Mapper<Comment> {
    public void addComment(Comment c);
    public void replyComment(ReplyRequest r);

    public List<Comment> allComment(@Param("page")Integer page,@Param("size")Integer size);
    public void updateState(Comment c);
    public Integer commentTotal();

    public List<Comment> commentList(@Param("productID") String productID);  // 商品评论列表
    public Comment latestComment(@Param("productID")String productID);      // 查询商品最新的一条评论

    public Map<String, Object> findApprovalRatingAndCommentCoutByProductID(String productID);
}
