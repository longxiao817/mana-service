package com.atguigu.mgt.manager.service.zqhservice;

import java.util.List;

import com.atguigu.mgt.manager.bean.TReply;


public interface MessageService {

    List<TReply> getAllReply(String searchCondition,String status);

    
    boolean delete(Integer id);

}
