package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.entity.WodehaoyouEntity;
import com.entity.view.WodehaoyouView;
import com.entity.vo.WodehaoyouVO;
import com.utils.PageUtils;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


/**
 * 我的好友
 *
 * @author 
 * @email 
 * @date 2021-03-12 20:57:00
 */
public interface WodehaoyouService extends IService<WodehaoyouEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<WodehaoyouVO> selectListVO(Wrapper<WodehaoyouEntity> wrapper);
   	
   	WodehaoyouVO selectVO(@Param("ew") Wrapper<WodehaoyouEntity> wrapper);
   	
   	List<WodehaoyouView> selectListView(Wrapper<WodehaoyouEntity> wrapper);
   	
   	WodehaoyouView selectView(@Param("ew") Wrapper<WodehaoyouEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<WodehaoyouEntity> wrapper);
   	
}

