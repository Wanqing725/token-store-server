package com.token.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.token.constant.MessageConstant;
import com.token.constant.StatusConstant;
import com.token.dto.CategoryDTO;
import com.token.dto.CategoryPageQueryDTO;
import com.token.entity.Category;
import com.token.exception.AccountIsDisableException;
import com.token.exception.CategoryIsExistException;
import com.token.mapper.CategoryMapper;
import com.token.result.PageResult;
import com.token.result.Result;
import com.token.service.CategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    /**
     * 新增分类
     *
     * @return
     */
    public void insert(CategoryDTO categoryDTO) {
        Category categoryByName = categoryMapper.getCategoryByName(categoryDTO.getName());
        if (!ObjectUtils.isEmpty(categoryByName)){
            throw new CategoryIsExistException(MessageConstant.CATEGORY_EXIST);
        }
        Category category = Category.builder().build();
        //  拷贝属性
        BeanUtils.copyProperties(categoryDTO, category);
        category.setStatus(StatusConstant.DISABLE);

        categoryMapper.insert(category);
    }

    /**
     * 根据id删除分类
     *
     * @param ids
     */
    public void delete(Long[] ids) {
        //  校验员工状态
        List<Long> status = categoryMapper.getEnableStatusByIds(ids);
        if((!ObjectUtils.isEmpty(status)) && status.size() > 0) {
            //  抛出异常
            throw new AccountIsDisableException(MessageConstant.CATEGORY_STATUS_IS_ENABLE);
        }
        categoryMapper.delete(ids);
    }

    /**
     * 修改分类信息
     *
     * @param categoryDTO
     */
    public void update(CategoryDTO categoryDTO, Long id) {
        Category categoryByName = categoryMapper.getCategoryByName(categoryDTO.getName());
        if (!ObjectUtils.isEmpty(categoryByName)){
            throw new CategoryIsExistException(MessageConstant.CATEGORY_EXIST);
        }

        Category category = Category.builder().build();
        //  拷贝属性
        BeanUtils.copyProperties(categoryDTO, category);

        category.setId(id);

        categoryMapper.update(category);
    }

    /**
     * 根据id查询分类信息
     *
     * @param id
     * @return
     */
    public Category getCategoryInfo(Long id) {
        return categoryMapper.getCategoryById(id);
    }

    /**
     * 分类分页查询
     *
     * @param categoryPageQueryDTO
     * @return
     */
    public PageResult page(CategoryPageQueryDTO categoryPageQueryDTO) {
        PageHelper.startPage(categoryPageQueryDTO.getPageNow(), categoryPageQueryDTO.getPageSize());
        Page<Category> page = (Page<Category>) categoryMapper.queryList(categoryPageQueryDTO);
        return PageResult.builder().
                total(page.getTotal()).
                records(page.getResult()).
                build();
    }

    /**
     * 查询分类名称是否存在
     */
    public Category findCategoryByName(String name){
        return categoryMapper.getCategoryByName(name);
    }

    /**
     * 修改分类状态
     * @param id
     * @param status
     */
    public void status(Long id, Long status) {
        Category category = Category.builder().id(id).status(status.intValue()).build();
        categoryMapper.update(category);
    }
}
