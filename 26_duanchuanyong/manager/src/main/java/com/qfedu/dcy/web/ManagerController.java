package com.qfedu.dcy.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qfedu.dcy.entity.GUserEntity;
import com.qfedu.dcy.pojo.GUserPojo;

import com.qfedu.dcy.utils.Data;
import com.qfedu.dcy.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@RestController
public class ManagerController {

    @Autowired
    ManagerService fus;
    //注册
    @RequestMapping("/adminlogin")
    public Object adminlogin(GUserPojo gup){
        Data data = new Data();
        GUserEntity queryResult=fus.queryadmin(gup);

        if (queryResult != null){
            //管理员登录
            data.setCode(1);
        }else {
            data.setCode(-1);
        }
        return data;
    }

    //注册
    @RequestMapping("/adminQuery")
    public Object adminQuery(GUserPojo gup){
        //分页
        PageHelper.startPage(gup.getPageNum(),gup.getPageSize());
        List<GUserEntity> queryResult=fus.queryUsers(gup);

        PageInfo<GUserEntity> pageInfo = new PageInfo<>(queryResult);
        return pageInfo;
    }

    //查询
    @RequestMapping("/adminQueryOne")
    public Object adminQueryOne(GUserPojo gup){
        GUserEntity queryResult=fus.queryUsersOne(gup);
        return queryResult;
    }

    //删除
    @RequestMapping("/admindel")
    public Object admindelete(GUserPojo gup){

        Data data =new Data();
       boolean delResult=fus.delUsers(gup);
       if (delResult){
            data.setCode(1);
       }else {
           data.setCode(-1);
       }
        return data;
    }
    //修改
    @RequestMapping("/adminUpd")
    public Object adminUpdate(GUserPojo gup){

        Data data =new Data();
        boolean delResult=fus.updUsers(gup);
        if (delResult){
            data.setCode(1);
        }else {
            data.setCode(-1);
        }
        return data;
    }



}
