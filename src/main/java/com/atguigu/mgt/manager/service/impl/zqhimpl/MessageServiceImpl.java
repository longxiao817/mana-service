package com.atguigu.mgt.manager.service.impl.zqhimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.mgt.manager.bean.TReply;
import com.atguigu.mgt.manager.bean.TReplyExample;
import com.atguigu.mgt.manager.bean.TReplyExample.Criteria;
import com.atguigu.mgt.manager.dao.TReplyMapper;
import com.atguigu.mgt.manager.service.zqhservice.MessageService;
import com.atguigu.project.MyStringUtils;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    TReplyMapper mapper;
    
    
    @Override
    public List<TReply> getAllReply(String searchCondition,String status) {
        System.out.println("service里的"+ searchCondition);
        System.out.println("service里的"+ status);
        
        TReplyExample example = new TReplyExample();
        Criteria criteria = example.createCriteria();
        if(!searchCondition.trim().equals("")){
            criteria.andContentLike("%"+searchCondition+"%");
            
        }
        Criteria criteria2 = example.createCriteria();
        if(!status.trim().equals("")){
            System.out.println("状态条件"+ status);
            criteria2.andStatusEqualTo(Integer.parseInt(status));
            
        }
        example.or(criteria2);
       /* TReplyExample example = new TReplyExample();
        Criteria criteria2 = example.createCriteria();
        criteria2.andStatusEqualTo(status);*/
        
        List<TReply> list = mapper.selectByExample(example);
        return list;
    }


    @Override
    public boolean delete(Integer id) {
        
        return mapper.deleteByPrimaryKey(id)>0?true:false;
    }

}
