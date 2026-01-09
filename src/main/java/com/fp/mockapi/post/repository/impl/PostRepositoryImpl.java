package com.fp.mockapi.post.repository.impl;

import com.fp.mockapi.post.model.Post;
import com.fp.mockapi.post.model.PostPage;
import com.fp.mockapi.post.repository.PostRepository;
import com.fp.mockapi.utils.exceptions.JsonUtils;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PostRepositoryImpl implements PostRepository {

    private final PostPage postPage;

    public PostRepositoryImpl() {
        JsonUtils jsonUtils = new JsonUtils();
        postPage= jsonUtils.getPostPage();
    }

    @Override
    public PostPage getAll() {
        return postPage;
    }

    @Override
    public PostPage getAll(int limit, int skip) {
        PostPage postPage = null;
        int size = Math.min(limit, this.postPage.getPosts().size());
        int startIndex = skip;
        int endIndex = startIndex + size;
        List<Post> filteredPosts = this.postPage.getPosts().subList(startIndex, endIndex);
        postPage = new PostPage(filteredPosts, this.postPage.getPosts().size(), skip, limit);
        return postPage;
    }

    @Override
    public Optional<Post> delete(int id) {
        PostPage postPage = this.getAll();
        List<Post> posts = postPage.getPosts();
        Optional<Post> postOptional = posts.stream().filter(p -> p.getId() == id).findFirst();
        postOptional.ifPresent(post -> post.setIsDeleted(true));
        return postOptional;
    }

}