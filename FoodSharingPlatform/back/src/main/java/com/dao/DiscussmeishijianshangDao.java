package com.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.entity.DiscussmeishijianshangEntity;
import com.entity.view.DiscussmeishijianshangView;
import com.entity.vo.DiscussmeishijianshangVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 美食鉴赏评论表
 * 
 * @author 
 * @email 
 * @date 2021-03-12 20:57:00
 */
public interface DiscussmeishijianshangDao extends BaseMapper<DiscussmeishijianshangEntity> {
	
	List<DiscussmeishijianshangVO> selectListVO(@Param("ew") Wrapper<DiscussmeishijianshangEntity> wrapper);
	
	DiscussmeishijianshangVO selectVO(@Param("ew") Wrapper<DiscussmeishijianshangEntity> wrapper);
	
	List<DiscussmeishijianshangView> selectListView(@Param("ew") Wrapper<DiscussmeishijianshangEntity> wrapper);

	List<DiscussmeishijianshangView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussmeishijianshangEntity> wrapper);
	
	DiscussmeishijianshangView selectView(@Param("ew") Wrapper<DiscussmeishijianshangEntity> wrapper);
	
}
