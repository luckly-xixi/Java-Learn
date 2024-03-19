package org.example;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.example.mapper.BrandMapper;
import org.example.pojo.Brand;
import org.example.util.SqlSessionFactoryUtils;

import java.util.List;

public class main {
    public static void main(String[] args) {
        SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();
        SqlSession sqlSession = factory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        //List<Brand> brands = mapper.selectByPage(0, 5);
        Brand brand = new Brand();
        brand.setBrandName("华为");
        //brand.setCompanyName("companyName");
        brand.setStatus(1);
        //brand.setOrdered(111);
        //brand.setDescription("Description");
        //brand.setId(1);

        List<Brand> brands = mapper.selectByPageAndCondition(0, 5, brand);

        System.out.println(brands);


    }
}
