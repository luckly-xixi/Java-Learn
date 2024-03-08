package org.example.mapper;

import org.apache.ibatis.annotations.*;
import org.example.pojo.Brand;

import java.util.List;

public interface BrandMapper {

    /**
     * 查询所有
     * @return Brand 集合
     */
    @Select("select * from tb_brand")
    @ResultMap("brandResultMap")
    List<Brand> selectAll();


    /**
     * 新增
     */
    @Insert("insert into tb_brand values (null, #{brandName}, #{companyName}, #{ordered}, #{description}, #{status})")
    void add(Brand brand);


    /**
     * 根据 ID 查询
     * @return Brand 集合
     */
    @Select("select * from tb_brand where id = #{id}")
    @ResultMap("brandResultMap")
    Brand selectById(int id);


    /**
     * 修改
     * @param brand
     */
    @Update("update tb_brand set brand_name = #{brandName}, company_name = #{companyName}, ordered = #{ordered}, description = #{description}, status = #{status} where id = #{id}")
    void update(Brand brand);

    /**
     * 根据 Id 删除
     * @param id
     */
    @Delete("delete from tb_brand where id = #{id}")
    void deleteById(int id);

}
