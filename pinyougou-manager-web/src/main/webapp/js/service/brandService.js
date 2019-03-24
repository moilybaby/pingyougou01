//服务层
app.service('brandService',function($http){

    //读取列表数据绑定到表单中
    this.findAll=function(){
        return $http.get('../brand/findAll.do');
    }
    //分页
    this.findPage=function(page,size){
        console.log(page);
        return $http.get('../brand/findPage.do?page='+page+'&size='+size);
    }
    //查询实体
    this.findOne=function(id){
        return $http.get('../brand/findOne.do?id='+id);
    }
    //增加
    this.add=function(entity){
        return  $http.post('../brand/add.do',entity );
    }
    //修改
    this.update=function(entity){
        return  $http.post('../brand/update.do',entity );
    }
    //删除
    this.dele=function(ids){
        return $http.get('../brand/delete.do?ids='+ids);
    }
    //搜索
    this.search=function(page,size,searchEntity){
        return $http.post('../brand/search.do?page='+page+"&size="+size, searchEntity);
    }
    //下拉列表数据
    this.selectOptionList=function(){
        return $http.get('../brand/selectOptionList.do');
    }

});
