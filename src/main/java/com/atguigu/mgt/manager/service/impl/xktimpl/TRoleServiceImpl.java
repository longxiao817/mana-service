package com.atguigu.mgt.manager.service.impl.xktimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.mgt.manager.bean.TRole;
import com.atguigu.mgt.manager.bean.TRoleExample;
import com.atguigu.mgt.manager.bean.TRoleExample.Criteria;
import com.atguigu.mgt.manager.dao.TRoleMapper;
import com.atguigu.mgt.manager.service.xktservice.TRoleService;

@Service
public class TRoleServiceImpl implements TRoleService {
    @Autowired
    TRoleMapper tRoleMapper;

    @Override
    public List<TRole> getRole() {
        // TODO Auto-generated method stub
        return tRoleMapper.selectByExample(null);
    }
    
    @Override
    public List<TRole> getUserRole(Integer uid) {
        // TODO Auto-generated method stub
       return tRoleMapper.getUserRole(uid);
    }

    @Override
    public List<TRole> list() {
        // TODO Auto-generated method stub
        return tRoleMapper.selectByExample(null);
    }

    @Override
    public TRole singleRole(Integer rid) {
        // TODO Auto-generated method stub   
        return tRoleMapper.selectByPrimaryKey(rid);
    }

    @Override
    public void del(Integer rid) {
        // TODO Auto-generated method stub
        tRoleMapper.deleteByPrimaryKey(rid);
    }

    @Override
    public int updateRole(Integer rid, TRole role) {
        // TODO Auto-generated method stub
        TRoleExample example=new TRoleExample();
        Criteria createCriteria = example.createCriteria();
        createCriteria.andIdEqualTo(rid);
        int i =tRoleMapper.updateByExampleSelective(role, example);
        return i;
    }
    
    
}
