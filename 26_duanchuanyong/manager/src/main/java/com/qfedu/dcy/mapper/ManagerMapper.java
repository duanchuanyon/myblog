package com.qfedu.dcy.mapper;

import com.qfedu.dcy.entity.GUserEntity;
import com.qfedu.dcy.pojo.GUserPojo;

import java.util.List;

public interface ManagerMapper {
    /**
     * 查询用户
     * @param gup
     * @return
     */
    GUserEntity readadmin(GUserPojo gup);

    /**
     * 管理员查询所有用户
     * @param gup
     * @return
     */
    List<GUserEntity> readAllUsers(GUserPojo gup);

    /**
     * 删除
     * @param gup
     * @return 成功 返回true 失败 返回false
     */
    boolean delUsers(GUserPojo gup);

    /**
     * 修改用户
     * @param gup
     * @return 成功 返回true 失败 返回false
     */
    boolean updUsers(GUserPojo gup);

    /**
     * 查询单个用户资料
     * @param gup
     * @return
     */
    GUserEntity readOne(GUserPojo gup);
}
