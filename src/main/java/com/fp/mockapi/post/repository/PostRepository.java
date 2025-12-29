package com.fp.mockapi.post.repository;

import com.fp.mockapi.comments.model.CommentPage;
import com.fp.mockapi.post.model.Post;
import com.fp.mockapi.post.model.PostPage;

import java.util.Optional;

public interface PostRepository {

    PostPage getAll();
    PostPage getAll(int limit, int skip);
    Optional<Post> delete(int id);
}
