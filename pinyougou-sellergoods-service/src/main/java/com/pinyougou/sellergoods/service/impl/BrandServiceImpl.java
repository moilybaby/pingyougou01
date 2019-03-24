package com.pinyougou.sellergoods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pinyougou.mapper.TbBrandMapper;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.pojo.TbBrandExample;
import com.pinyougou.sellergoods.service.BrandService;
import entity.PageResult;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private TbBrandMapper BrandMapper;

    @Override
    public List<TbBrand> findAll() {
        return BrandMapper.selectByExample(null);
    }

    @Override
    public PageResult findPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        Page<TbBrand> page = (Page<TbBrand>) BrandMapper.selectByExample(null);
        return new PageResult(page.getTotal(),page.getResult());
    }

    @Override
    public void add(TbBrand brand) {
        //添加品牌
        BrandMapper.insert(brand);

    }

    @Override
    public TbBrand findOne(Long id) {
        return BrandMapper.selectByPrimaryKey(id);
    }

    @Override
    public void update(TbBrand brand) {
        BrandMapper.updateByPrimaryKey(brand);
    }

    @Override
    public void delete(Long[] ids) {
        for (long id:ids) {
        BrandMapper.deleteByPrimaryKey(id);
        }
    }

    @Override
    public PageResult findPage(TbBrand brand, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        TbBrandExample example = new TbBrandExample();
        TbBrandExample.Criteria criteria = example.createCriteria();

        if (brand!=null){
            if (brand.getName()!=null && brand.getName().length()>0){
                criteria.andNameLike("%"+brand.getName()+"%");
            }
            if (brand.getFirstChar()!=null && brand.getFirstChar().length()>0){
                criteria.andFirstCharLike("%"+brand.getFirstChar()+"%");
            }
        }


        Page<TbBrand> page = (Page<TbBrand>) BrandMapper.selectByExample(example);
        return new PageResult(page.getTotal(),page.getResult());
    }
}
