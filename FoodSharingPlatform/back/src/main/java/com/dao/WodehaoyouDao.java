package com.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.entity.WodehaoyouEntity;
import com.entity.view.WodehaoyouView;
import com.entity.vo.WodehaoyouVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 我的好友
 * 
 * @author 
 * @email 
 * @date 2021-03-12 20:57:00
 */
public interface WodehaoyouDao extends BaseMapper<WodehaoyouEntity> {
	
	List<WodehaoyouVO> selectListVO(@Param("ew") Wrapper<WodehaoyouEntity> wrapper);
	
	WodehaoyouVO selectVO(@Param("ew") Wrapper<WodehaoyouEntity> wrapper);
	
	List<WodehaoyouView> selectListView(@Param("ew") Wrapper<WodehaoyouEntity> wrapper);

	List<WodehaoyouView> selectListView(Pagination page,@Param("ew") Wrapper<WodehaoyouEntity> wrapper);
	
	WodehaoyouView selectView(@Param("ew") Wrapper<WodehaoyouEntity> wrapper);
	
}
