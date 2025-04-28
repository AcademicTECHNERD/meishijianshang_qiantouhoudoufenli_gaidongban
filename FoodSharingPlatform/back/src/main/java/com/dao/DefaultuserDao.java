package com.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.entity.DefaultuserEntity;
import com.entity.view.DefaultuserView;
import com.entity.vo.DefaultuserVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 注册用户
 * 
 * @author 
 * @email 
 * @date 2021-03-12 20:57:00
 */
public interface DefaultuserDao extends BaseMapper<DefaultuserEntity> {
	
	List<DefaultuserVO> selectListVO(@Param("ew") Wrapper<DefaultuserEntity> wrapper);
	
	DefaultuserVO selectVO(@Param("ew") Wrapper<DefaultuserEntity> wrapper);
	
	List<DefaultuserView> selectListView(@Param("ew") Wrapper<DefaultuserEntity> wrapper);

	List<DefaultuserView> selectListView(Pagination page,@Param("ew") Wrapper<DefaultuserEntity> wrapper);
	
	DefaultuserView selectView(@Param("ew") Wrapper<DefaultuserEntity> wrapper);
	
}
