package com.token.service;

import com.token.dto.CategoryDTO;
import com.token.dto.CategoryPageQueryDTO;
import com.token.entity.Category;
import com.token.result.PageResult;

public interface CategoryService {

    /**
     * 新增分类
     *
     * @return
     */
    void insert(CategoryDTO categoryDTO);

    /**
     * 根据id删除分类
     *
     * @param ids
     */
    void delete(Long[] ids);


    /**
     * 修改分类信息
     *
     * @param categoryDTO
     */
    void update(CategoryDTO categoryDTO,Long id);

    /**
     * 根据id查询分类信息
     * @param id
     * @return
     */
    Category getCategoryInfo(Long id);

    /**
     * 分类分页查询
     * @param categoryPageQueryDTO
     * @return
     */
    PageResult page(CategoryPageQueryDTO categoryPageQueryDTO);

    /**
     * 修改分类状态
     * @param id
     * @param status
     */
    void status(Long id, Long status);

    Category findCategoryByName(String name);
}
