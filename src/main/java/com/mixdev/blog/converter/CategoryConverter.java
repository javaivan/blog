package com.mixdev.blog.converter;

import com.mixdev.blog.domain.Category;
import com.mixdev.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A converter class used in views to map id's to actual userProfile objects.
 */
@Component
public class CategoryConverter implements Converter<Object, Category> {

	private static final Logger LOGGER = LoggerFactory.getLogger(CategoryConverter.class);

	@Autowired
	CategoryService categoryService;


	public Category convert(Object element) {
		Integer id = Integer.parseInt((String)element);
		LOGGER.debug("Component Object id: ", id);
		Category postCategory= categoryService.findById(id);
		LOGGER.debug("Component Object to Category: ", postCategory);

		return postCategory;
	}

}