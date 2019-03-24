package com.pinyougou.sellergoods.service;

import com.pinyougou.pojo.TbBrand;
import entity.PageResult;

import java.util.List;

/**
 * 品牌接口
 */
public interface BrandService {

    List<TbBrand> findAll();

    //分页  pageNum总数
    public PageResult findPage(int pageNum, int pageSize);
    //添加用户
    public void add(TbBrand brand);
    //根据id查找用户
    public TbBrand findOne(Long id);
    //修改用户
    public void update(TbBrand brand);
    //删除用户
    public void delete(Long[] ids);
    //条件查询
    public PageResult findPage(TbBrand brand,int pageNum, int pageSize);

}
