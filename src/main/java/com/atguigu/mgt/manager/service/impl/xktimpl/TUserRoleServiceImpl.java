package com.atguigu.mgt.manager.service.impl.xktimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.mgt.manager.bean.TRole;
import com.atguigu.mgt.manager.bean.TUserRole;
import com.atguigu.mgt.manager.bean.TUserRoleExample;
import com.atguigu.mgt.manager.bean.TUserRoleExample.Criteria;
import com.atguigu.mgt.manager.bean.TUserRoleExample.Criterion;
import com.atguigu.mgt.manager.dao.TUserRoleMapper;
import com.atguigu.mgt.manager.service.xktservice.TUserRoleService;

@Service
public class TUserRoleServiceImpl implements TUserRoleService {
    @Autowired
    TUserRoleMapper tUserRoleMapper;

    @Override
    public void del(Integer uid) {
        // TODO Auto-generated method stub
        TUserRoleExample example=new TUserRoleExample();
        Criteria createCriteria = example.createCriteria();
        createCriteria.andUseridEqualTo(uid);
        tUserRoleMapper.deleteByExample(example); 
    }

    @Override
    public void add(Integer uid,String rids) {
        // TODO Auto-generated method stub
        if(rids!=null&&rids!=""){
            if(rids.contains(",")){
                String[] str = rids.split(",");
                for (String ridStr : str) {
                    int rid = Integer.parseInt(ridStr);
                    tUserRoleMapper.insertSelective(new TUserRole(uid, rid));
                }
            }else{
                int rid = Integer.parseInt(rids);
                tUserRoleMapper.insertSelective(new TUserRole(uid, rid)); 
            }
        }
        
    }
    
    
}
