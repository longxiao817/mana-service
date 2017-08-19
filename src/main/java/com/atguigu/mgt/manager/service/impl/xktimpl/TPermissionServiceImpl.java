package com.atguigu.mgt.manager.service.impl.xktimpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.mgt.manager.bean.TPermission;
import com.atguigu.mgt.manager.bean.TPermissionExample;
import com.atguigu.mgt.manager.bean.TPermissionExample.Criteria;
import com.atguigu.mgt.manager.dao.TPermissionMapper;
import com.atguigu.mgt.manager.service.xktservice.TPermissionService;

@Service
public class TPermissionServiceImpl implements TPermissionService {
    @Autowired
    TPermissionMapper tPermissionMapper;

    @Override
    public List<TPermission> getMenu() {
        // TODO Auto-generated method stub
        List<TPermission> list= tPermissionMapper.selectByExample(null);
        List<TPermission> menu=new ArrayList<>();
        Map<Integer, TPermission> map = new HashMap<Integer, TPermission>();
        
        for (TPermission tPermission : list) {
            map.put(tPermission.getId(), tPermission);
            if(tPermission.getPid()==0){
                menu.add(tPermission);
                tPermission.setChilds(new ArrayList<TPermission>());
            }
        }
        
        for (TPermission per : list) {
            int pid = per.getPid();
            TPermission parenTPermission = map.get(pid);
            
            if(parenTPermission!=null){
                parenTPermission.getChilds().add(per);
            }
        }
        
        
        return menu;
        
        
    }

    @Override
    public List<TPermission> list() {
        // TODO Auto-generated method stub  
        return tPermissionMapper.selectByExample(null);
    }

    @Override
    public List<TPermission> getRolePermisson(Integer rid) {
        // TODO Auto-generated method stub  
        return tPermissionMapper.getRolePermission(rid);
    }

    @Override
    public TPermission getPermission(String perName) {
        // TODO Auto-generated method stub
        TPermissionExample example = new TPermissionExample();
        Criteria createCriteria = example.createCriteria();
        createCriteria.andNameEqualTo(perName);
        List<TPermission> list = tPermissionMapper.selectByExample(example);
        if(list.size()==1){
            return list.get(0);
        }else{
            return null;
        }
       
    }

    @Override
    public int update(Integer perid, TPermission tPermission) {
        // TODO Auto-generated method stub
       return tPermissionMapper.updateByPrimaryKeySelective(tPermission);
    }

    @Override
    public void delete(String perName) {
        // TODO Auto-generated method stub
        TPermissionExample example = new TPermissionExample();
        Criteria createCriteria = example.createCriteria();
        createCriteria.andNameEqualTo(perName);
        tPermissionMapper.deleteByExample(example);
    }

}
