package com.atguigu.mgt.manager.service.xktservice;

import java.util.List;

import com.atguigu.mgt.manager.bean.TRole;


public interface TRoleService {

    List<TRole> getRole();

    List<TRole> getUserRole(Integer uid);

    List<TRole> list();

    TRole singleRole(Integer rid);

    void del(Integer rid);

    int updateRole(Integer rid, TRole role);

}
