package com.qfedu.dcy.mapper;

import com.qfedu.dcy.entity.GUserEntity;
import com.qfedu.dcy.pojo.GUserPojo;

public interface FrontUserMapper {

    /**
     * 添加数据
     * @param gup
     * @return true 添加成功 false 添加失败
     */
    boolean insertUser(GUserPojo gup);

    /**
     * 校验用户数据
     * @param gup
     * @return 无 为null,
     */
    GUserEntity readUser(GUserPojo gup);

    /**
     * 前端用户登录
     * @param gup
     * @return
     */
    GUserEntity userLogin(GUserPojo gup);
}
