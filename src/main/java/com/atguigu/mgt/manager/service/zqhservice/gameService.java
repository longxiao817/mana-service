package com.atguigu.mgt.manager.service.zqhservice;

import java.util.List;

import com.atguigu.mgt.manager.bean.TGames;
import com.atguigu.mgt.manager.bean.TGamesExample;


public interface gameService {
    
    
    public List<TGames> getAllByCondition(TGamesExample example);

    public void gameDelete(Integer id);

    public boolean addgame(TGames tGames);

    public List<TGames> getAll();

    public boolean changeStatus(Integer id, String status);

    public boolean checkStatus(Integer id);

    public TGames getGame(Integer id);

    public List<TGames> getAll(TGamesExample example);
}
