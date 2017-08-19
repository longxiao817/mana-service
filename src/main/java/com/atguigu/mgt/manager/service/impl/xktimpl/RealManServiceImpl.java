package com.atguigu.mgt.manager.service.impl.xktimpl;

import java.util.List;

import org.mybatis.generator.codegen.ibatis2.model.ExampleGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.mgt.manager.bean.TUsers;
import com.atguigu.mgt.manager.bean.TUsersExample;
import com.atguigu.mgt.manager.bean.TUsersExample.Criteria;
import com.atguigu.mgt.manager.dao.TUsersMapper;
import com.atguigu.mgt.manager.service.xktservice.RealManService;

@Service
public class RealManServiceImpl implements RealManService {
    @Autowired
    TUsersMapper tUsersMapper;

    @Override
    public List<TUsers> list() {
        // TODO Auto-generated method stub
        TUsersExample example= new TUsersExample();
        Criteria criteria = example.createCriteria();
        criteria.andCertificationEqualTo(1);
        return tUsersMapper.selectByExample(example);
    }

    @Override
    public int update(Integer uid, TUsers user) {
        // TODO Auto-generated method stub
        user.setUserId(uid);
        return tUsersMapper.updateByPrimaryKey(user);
    }

    @Override
    public TUsers getUser(Integer uid) {
        // TODO Auto-generated method stub
        return tUsersMapper.selectByPrimaryKey(uid);
    }
    
    
}
