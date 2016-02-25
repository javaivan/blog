package com.mixdev.blog.dao;

import com.mixdev.blog.domain.Post;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by osven on 04.02.16.
 */
@Repository
public class PostDAOImpl extends AbstractDao<Integer, Post> implements PostDAO{

    public Post findById(int id) {
        Post post = getByKey(id);
        if(post!=null)
            Hibernate.initialize(post.getCategories());
        return post;
    }

    public void save(Post post) { persist(post);}

    public List<Post> findAllPost() {
        Criteria criteria = createEntityCriteria().addOrder(Order.asc("title"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List<Post> posts = (List<Post>)criteria.list();

        // No need to fetch categories since we are not showing them on list page. Let them lazy load.
        // Uncomment below lines for eagerly fetching of categories if you want.
		/*
		for(Post post : posts){
            Hibernate.initialize(post.getCategories());
		}
		*/
        return posts;
    }
}
