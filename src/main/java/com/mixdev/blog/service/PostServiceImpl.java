package com.mixdev.blog.service;

import com.mixdev.blog.dao.PostDAO;
import com.mixdev.blog.domain.Post;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by osven on 04.02.16.
 */
@Service("PostService")
@Transactional
public class PostServiceImpl implements PostService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PostServiceImpl.class);

    @Autowired
    private PostDAO dao;

    public Post findById(int id) {
        LOGGER.debug("Find post By id: ", id);

        return dao.findById(id);
    }

    public void save(Post post) {
        LOGGER.debug("Adding a new Post entry with information: {}", post);

        dao.save(post);
    }

    public List<Post> findAll() {
        LOGGER.debug("Finding all Post entries");

        return dao.findAllPost();
    }
}
