package com.qfedu.dcy.service;

import com.qfedu.dcy.entity.GUserEntity;
import com.qfedu.dcy.pojo.GUserPojo;

public interface frontUserService {

    /**
     * 添加数据
     * @param gup
     * @return true 添加成功 false 添加失败
     */
    boolean addFrontUser(GUserPojo gup);

    /**
     * 校验用户数据
     * @param gup
     * @return 无 为null,
     */
    GUserEntity readFrontUser(GUserPojo gup);

    /**
     * 前端用户登录
     * @param gup
     * @return
     */
    GUserEntity frontUser(GUserPojo gup);
}
