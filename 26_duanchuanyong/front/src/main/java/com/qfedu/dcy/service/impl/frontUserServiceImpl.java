package com.qfedu.dcy.service.impl;

import com.qfedu.dcy.mapper.FrontUserMapper;
import com.qfedu.dcy.service.frontUserService;
import com.qfedu.dcy.entity.GUserEntity;
import com.qfedu.dcy.pojo.GUserPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class frontUserServiceImpl implements frontUserService {

    @Autowired
    FrontUserMapper fum;
    /**
     * 添加数据
     * @param gup
     * @return true 添加成功 false 添加失败
     */
    @Override
    public boolean addFrontUser(GUserPojo gup) {
        return  fum.insertUser(gup);
    }

    /**
     * 校验用户数据
     * @param gup
     * @return 无 为null,
     */
    @Override
    public GUserEntity readFrontUser(GUserPojo gup) {
        return fum.readUser(gup);
    }

    /**
     * 前端用户登录
     * @param gup
     * @return
     */
    @Override
    public GUserEntity frontUser(GUserPojo gup) {
        return fum.userLogin(gup);
    }

}
