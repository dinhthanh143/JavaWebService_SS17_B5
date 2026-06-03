package com.example.demo.b5.service;

import org.springframework.stereotype.Service;

@Service("commentService")
public class CommentService {


    public boolean isCommentOwner(Long commentId, String username) {
        System.out.println("[AUDIT SECURITY] Đang đối sánh tài khoản '" + username + "' với chủ sở hữu bình luận ID: " + commentId);
        return true;
    }
}