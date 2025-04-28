package com.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.entity.MeishijianshangEntity;
import com.entity.view.MeishijianshangView;
import com.entity.vo.MeishijianshangVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 美食鉴赏
 * 
 * @author 
 * @email 
 * @date 2021-03-12 20:57:00
 */
public interface MeishijianshangDao extends BaseMapper<MeishijianshangEntity> {
	
	List<MeishijianshangVO> selectListVO(@Param("ew") Wrapper<MeishijianshangEntity> wrapper);
	
	MeishijianshangVO selectVO(@Param("ew") Wrapper<MeishijianshangEntity> wrapper);
	
	List<MeishijianshangView> selectListView(@Param("ew") Wrapper<MeishijianshangEntity> wrapper);

	List<MeishijianshangView> selectListView(Pagination page,@Param("ew") Wrapper<MeishijianshangEntity> wrapper);
	
	MeishijianshangView selectView(@Param("ew") Wrapper<MeishijianshangEntity> wrapper);
	
}
