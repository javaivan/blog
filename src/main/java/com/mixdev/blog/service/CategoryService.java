package com.mixdev.blog.service;

import com.mixdev.blog.domain.Category;

import java.util.List;

/**
 * Created by mix on 06.02.2016.
 */
public interface CategoryService {

    public Category findById(int id);

    public void save(Category category);

    public List<Category> findAll();
}
