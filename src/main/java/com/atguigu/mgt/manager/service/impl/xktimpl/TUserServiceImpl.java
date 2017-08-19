package com.atguigu.mgt.manager.service.impl.xktimpl;

import java.util.List;

import org.omg.PortableInterceptor.USER_EXCEPTION;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.mgt.manager.bean.TRole;
import com.atguigu.mgt.manager.bean.TUsers;
import com.atguigu.mgt.manager.dao.TUsersMapper;
import com.atguigu.mgt.manager.service.xktservice.TUserService;

@Service
public class TUserServiceImpl implements TUserService {
    @Autowired
    TUsersMapper tUsersMapper;
    
    @Override
    public List<TUsers> list() {
        // TODO Auto-generated method stub
       return tUsersMapper.selectByExample(null);
    }

    @Override
    public TUsers getUser(Integer uid) {
        // TODO Auto-generated method stub
        return tUsersMapper.selectByPrimaryKey(uid);
    }

    @Override
    public int update(Integer uid,TUsers user) {
        // TODO Auto-generated method stub
        user.setUserId(uid);
        return tUsersMapper.updateByPrimaryKey(user);
    }

    @Override
    public void del(Integer uid) {
        // TODO Auto-generated method stub
        tUsersMapper.deleteByPrimaryKey(uid);
        
    }
    
    
}
