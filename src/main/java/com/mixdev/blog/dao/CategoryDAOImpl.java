package com.mixdev.blog.dao;

import com.mixdev.blog.domain.Category;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by mix on 06.02.2016.
 */
@Repository
public class CategoryDAOImpl extends AbstractDao<Integer, Category> implements CategoryDAO {

    public Category findById(int id) {
        Category category = new Category();
        return category;
    }

    public void save(Category category) { persist(category);
    }

    public List<Category> findAllCategory() {
        Criteria criteria = createEntityCriteria().addOrder(Order.asc("title"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List<Category> categories = (List<Category>)criteria.list();
        return categories;
    }
}
