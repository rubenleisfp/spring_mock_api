package com.fp.mockapi.comments.repository.impl;

import com.fp.mockapi.comments.model.CommentPage;
import com.fp.mockapi.comments.repository.CommentRepository;
import com.fp.mockapi.utils.exceptions.JsonUtils;
import org.springframework.stereotype.Repository;

@Repository
public class CommentRepositoryImpl implements CommentRepository {

    private final CommentPage commentPage;

    public CommentRepositoryImpl() {
        JsonUtils jsonUtils = new JsonUtils();
        commentPage= jsonUtils.getCommentPage();
    }

    @Override
    public CommentPage getAll() {
        return commentPage;
    }

}