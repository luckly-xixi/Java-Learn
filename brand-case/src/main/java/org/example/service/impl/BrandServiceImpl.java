package org.example.service.impl;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.example.mapper.BrandMapper;
import org.example.pojo.Brand;
import org.example.pojo.PageBean;
import org.example.service.BrandService;
import org.example.util.SqlSessionFactoryUtils;

import java.util.List;

public class BrandServiceImpl implements BrandService {

    // 获取 factory
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    @Override
    public List<Brand> selectAll() {
        // 获取 Session
        SqlSession sqlSession = factory.openSession();
        // 获取 Mapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        List<Brand> brands = mapper.selectAll();

        sqlSession.close();

        return brands;
    }

    @Override
    public void add(Brand brand) {
        // 获取 Session
        SqlSession sqlSession = factory.openSession();
        // 获取 Mapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        mapper.add(brand);

        sqlSession.commit();

        sqlSession.close();
    }

    @Override
    public void deleteByIds(int[] ids) {
        // 获取 Session
        SqlSession sqlSession = factory.openSession();
        // 获取 Mapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        mapper.deleteByIds(ids);

        sqlSession.commit();

        sqlSession.close();

    }

    @Override
    public PageBean<Brand> selectByPage(int currentPage, int pageSize) {
        SqlSession sqlSession = factory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        int begin = ( currentPage -1 ) * pageSize;//开始索引
        int size = pageSize;// 查询条数

        List<Brand> rows = mapper.selectByPage(begin, size);// 当前页数据
        int totalCount = mapper.selectTotalCount();// 条目数

        PageBean<Brand> pageBean = new PageBean<>();
        pageBean.setRows(rows);
        pageBean.setTotalCount(totalCount);

        sqlSession.close();
        return pageBean;
    }

    @Override
    public PageBean<Brand> selectByPageAndCondition(int currentPage, int pageSize, Brand brand) {
        SqlSession sqlSession = factory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        int begin = ( currentPage - 1 ) * pageSize;//开始索引
        int size = pageSize;// 查询条数

        // 处理 brand 条件，模糊表达式
        String brandName = brand.getBrandName();
        if(brandName != null && brandName.length() > 0) {
            brand.setBrandName("%"+ brandName +"%");
        }
        String companyName = brand.getCompanyName();
        if(companyName != null && companyName.length() > 0) {
            brand.setCompanyName("%"+ companyName +"%");
        }


        List<Brand> rows = mapper.selectByPageAndCondition(begin, size, brand);// 当前页数据
        int totalCount = mapper.selectTotalCountByCondition(brand);// 条目数

        PageBean<Brand> pageBean = new PageBean<>();
        pageBean.setRows(rows);
        pageBean.setTotalCount(totalCount);

        sqlSession.close();
        return pageBean;
    }
}
