package com.pinyougou.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.sellergoods.service.BrandService;
import entity.PageResult;
import entity.Result;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/brand")
public class BrandController {

    @Reference
    private BrandService brandService;

    @RequestMapping("/findAll")
    public List<TbBrand> findAll() {
        return brandService.findAll();
    }
    @RequestMapping("/findPage")
    public PageResult findPage(int page,int size){
        System.out.println(page+"===="+size);
        return brandService.findPage(page,size);
    }
    @RequestMapping("/add")
    public Result add(@RequestBody TbBrand brand){
        try {
            brandService.add(brand);
            return new Result(true,"新增成功");
        }catch (Exception e){
            e.printStackTrace();
            return new Result(false,"添加失败");

        }
    }
    @RequestMapping("/findOne")
    public TbBrand findone(Long id){
        return brandService.findOne(id);
    }
    @RequestMapping("/update")
    public Result update(@RequestBody TbBrand brand){
        try {
            brandService.update(brand);
            return new Result(true,"修改成功");
        }catch (Exception e){
            e.printStackTrace();
            return new Result(false,"修改失败");

        }
    }

    //根据id删除用户
    @RequestMapping("/delete")
    public Result delete(Long[] ids){
        try {
            brandService.delete(ids);
            return new Result(true,"删除成功");
        }catch (Exception e){
            e.printStackTrace();
            return new Result(false,"删除失败");

        }

    }
    @RequestMapping("/search")
    public PageResult search(@RequestBody TbBrand brand,int page,int size){
        return brandService.findPage(brand,page,size);
    }
}
