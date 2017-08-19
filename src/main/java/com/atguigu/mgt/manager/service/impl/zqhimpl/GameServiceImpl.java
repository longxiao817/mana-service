package com.atguigu.mgt.manager.service.impl.zqhimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.mgt.manager.bean.TGames;
import com.atguigu.mgt.manager.bean.TGamesExample;
import com.atguigu.mgt.manager.bean.TGamesExample.Criteria;
import com.atguigu.mgt.manager.dao.TGamesMapper;
import com.atguigu.mgt.manager.service.zqhservice.gameService;

@Service
public class GameServiceImpl implements gameService {

    @Autowired
    TGamesMapper gamesMapper;
   
    
    @Override
    public List<TGames> getAllByCondition(TGamesExample example) {
        
        
        return gamesMapper.selectByExample(example);
    }


    @Override
    public void gameDelete(Integer id) {
      gamesMapper.deleteByPrimaryKey(id);
        
    }


    @Override
    public boolean addgame(TGames tGames) {
       
        return gamesMapper.insertSelective(tGames) > 0;
    }


    @Override
    public List<TGames> getAll() {
        
        return gamesMapper.selectByExample(null);
    }

    
    @Override
    public boolean changeStatus(Integer id,String status) {
        TGames games = new TGames();
        String status1 = "辱骂、歧视、挑衅等不友善的内容";
        String status2 = "广告或垃圾信息";
        String status3 = "暴力、色情、政治敏感等违反法律法规的内容";
        if(status1.equals(status)||status2.equals(status)||status3.equals(status)){
            System.out.println("审核不通过");
            games.setId(id);
            games.setStatus(0);
            gamesMapper.updateByPrimaryKeySelective(games);
        }else{
            games.setId(id);
            games.setStatus(1);
            gamesMapper.updateByPrimaryKeySelective(games);
        System.out.println("审核通过");
        }
        return false;
    }


    @Override
    public boolean checkStatus(Integer id) {
        TGames game = gamesMapper.selectByPrimaryKey(id);
        Integer gameStatus = game.getStatus();
        
        return gameStatus==0?false:true;
    }


    @Override
    public TGames getGame(Integer id) {
      
        return gamesMapper.selectByPrimaryKey(id);
    }


    @Override
    public List<TGames> getAll(TGamesExample example) {
        
        return gamesMapper.selectByExample(example);
    }

}
