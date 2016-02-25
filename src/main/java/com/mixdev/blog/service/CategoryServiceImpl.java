package com.mixdev.blog.service;

import com.mixdev.blog.dao.CategoryDAO;
import com.mixdev.blog.domain.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by mix on 06.02.2016.
 */
@Service("CategoryService")
@Transactional
public class CategoryServiceImpl implements CategoryService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CategoryServiceImpl.class);

    @Autowired
    private CategoryDAO dao;

    public Category findById(int id) {
        LOGGER.debug("Find category By id: ", id);

        return dao.findById(id);
    }

    public void save(Category category) {
        LOGGER.debug("Adding a new category entry with information: {}", category);
        dao.save(category);
    }

    public List<Category> findAll() {
        LOGGER.debug("Finding all Category entries");
        return dao.findAllCategory();
    }
}
