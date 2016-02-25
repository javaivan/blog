package com.mixdev.blog.dao;

import com.mixdev.blog.domain.Post;

import java.util.List;

/**
 * Created by osven on 04.02.16.
 */
public interface PostDAO {

    public Post findById(int id);
    public void save(Post post);
    public List<Post> findAllPost();
}
