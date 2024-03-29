package org.example.service;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.example.pojo.Brand;
import org.example.pojo.PageBean;

import java.util.List;

public interface BrandService {

    /**
     * 查询所有
     */
    List<Brand> selectAll();

    /**
     * 新增
     */
    void add(Brand brand);


    /**
     * 批量删除
     */
    void deleteByIds(int[] ids);

    /**
     * 分页查询
     */
    PageBean<Brand> selectByPage(int currentPage, int pageSize);


    /**
     * 分页条件查询
     */
    PageBean<Brand> selectByPageAndCondition(int currentPage, int pageSize, Brand brand);
}
