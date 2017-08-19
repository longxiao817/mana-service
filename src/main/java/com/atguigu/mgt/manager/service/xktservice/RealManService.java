package com.atguigu.mgt.manager.service.xktservice;

import java.util.List;

import com.atguigu.mgt.manager.bean.TUsers;


public interface RealManService {

    List<TUsers> list();

    int update(Integer uid, TUsers user);

    TUsers getUser(Integer uid);

}
