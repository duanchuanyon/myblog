package com.qfedu.dcy.service.impl;

import com.qfedu.dcy.entity.GUserEntity;
import com.qfedu.dcy.pojo.GUserPojo;
import com.qfedu.dcy.mapper.ManagerMapper;
import com.qfedu.dcy.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    ManagerMapper mm;


    @Override
    public GUserEntity queryadmin(GUserPojo gup) {
        return mm.readadmin(gup);
    }

    /**
     * 管理员查询所有用户
     * @param gup
     * @return
     */
    @Override
    public List<GUserEntity> queryUsers(GUserPojo gup) {
        return mm.readAllUsers(gup);
    }

    /**
     * 删除
     * @param gup
     * @return 成功 返回true 失败 返回false
     */
    @Override
    public boolean delUsers(GUserPojo gup) {
        return mm.delUsers(gup);
    }

    /**
     * 修改用户
     * @param gup
     * @return 成功 返回true 失败 返回false
     */
    @Override
    public boolean updUsers(GUserPojo gup) {
        return mm.updUsers(gup);
    }

    /**
     * 查询单个用户资料
     * @param gup
     * @return
     */
    @Override
    public GUserEntity queryUsersOne(GUserPojo gup) {
        return mm.readOne(gup);
    }
}
