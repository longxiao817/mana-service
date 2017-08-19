package com.atguigu.mgt.manager.service.xktservice;

import java.util.List;

import com.atguigu.mgt.manager.bean.TPermission;


public interface TPermissionService {

    List<TPermission> getMenu();

    List<TPermission> list();

    List<TPermission> getRolePermisson(Integer rid);

    TPermission getPermission(String perName);

    int update(Integer perid, TPermission tPermission);

    void delete(String perName);

}
