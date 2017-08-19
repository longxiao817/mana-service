package com.atguigu.mgt.manager.service.impl.xktimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.mgt.manager.bean.TRolePermission;
import com.atguigu.mgt.manager.bean.TRolePermissionExample;
import com.atguigu.mgt.manager.bean.TRolePermissionExample.Criteria;
import com.atguigu.mgt.manager.dao.TRolePermissionMapper;
import com.atguigu.mgt.manager.service.xktservice.TRolePermissionService;

@Service
public class TRolePermissionServiceImpl implements TRolePermissionService {
    @Autowired
    TRolePermissionMapper tRolePermissionMapper;
    
    @Override
    public void update(String pids, Integer rid) {
        // TODO Auto-generated method stub
        TRolePermissionExample example= new TRolePermissionExample();
        Criteria createCriteria = example.createCriteria();
        createCriteria.andRoleidEqualTo(rid);    
        tRolePermissionMapper.deleteByExample(example);
        
        if(pids!=null&&pids!=""){
            if(pids.contains(",")){
                String[] str = pids.split(",");
                for (String pidStr : str) {
                    int pid=Integer.parseInt(pidStr); 
                    TRolePermission record = new TRolePermission();
                    record.setPermissionid(pid);
                    record.setRoleid(rid);
                    tRolePermissionMapper.insertSelective(record);
                }
            }else{
                int pid=Integer.parseInt(pids); 
                TRolePermission record = new TRolePermission();
                record.setPermissionid(pid);
                record.setRoleid(rid);
                tRolePermissionMapper.insertSelective(record);
            }
        }
    }
    
}
