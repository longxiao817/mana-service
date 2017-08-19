package com.atguigu.mgt.manager.service.xktservice;

import java.util.List;

import com.atguigu.mgt.manager.bean.TUsers;


public interface TUserService {

    List<TUsers> list();

    TUsers getUser(Integer uid);

    int update(Integer uid, TUsers user);

    void del(Integer uid);

}
