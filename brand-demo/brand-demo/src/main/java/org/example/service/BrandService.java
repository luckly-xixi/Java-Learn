package org.example.service;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.example.mapper.BrandMapper;
import org.example.pojo.Brand;
import org.example.util.SqlSessionFactoryUtils;

import java.util.List;

public class BrandService {

        //获取连接
        SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    /**
     * 查询所有
     */

    public List<Brand> selectAll() {

        //获取SqlSession
        SqlSession sqlSession = factory.openSession();

        //获取BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        //调用方法
        List<Brand> brands = mapper.selectAll();

        //关闭资源
        sqlSession.close();

        //返回结果
        return brands;
    }

    /**
     * 添加
     */
    public void add(Brand brand) {
        //获取SqlSession
        SqlSession sqlSession = factory.openSession();

        //获取BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        mapper.add(brand);

        sqlSession.commit();

        sqlSession.close();

    }


    /**
     * 根据 Id 查询
     */

    public Brand selectById(int id) {

        //获取SqlSession
        SqlSession sqlSession = factory.openSession();

        //获取BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        //调用方法
        Brand brand = mapper.selectById(id);

        //关闭资源
        sqlSession.close();

        //返回结果
        return brand;
    }


    /**
     * 修改
     */
    public void update(Brand brand) {
        //获取SqlSession
        SqlSession sqlSession = factory.openSession();

        //获取BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        mapper.update(brand);

        sqlSession.commit();

        sqlSession.close();

    }


    /**
     * 根据 Id 删除
     */

    public void deleteById(int id) {

        //获取SqlSession
        SqlSession sqlSession = factory.openSession();

        //获取BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        //调用方法
        mapper.deleteById(id);

        sqlSession.commit();

        //关闭资源
        sqlSession.close();
    }
}
