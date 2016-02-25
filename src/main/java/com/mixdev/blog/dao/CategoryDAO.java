package com.mixdev.blog.dao;

import com.mixdev.blog.domain.Category;

import java.util.List;

/**
 * Created by mix on 06.02.2016.
 */
public interface CategoryDAO {

    public Category findById(int id);
    public void save(Category category);
    public List<Category> findAllCategory();

}
