package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.entity.DiscussmeishijianshangEntity;
import com.entity.view.DiscussmeishijianshangView;
import com.entity.vo.DiscussmeishijianshangVO;
import com.utils.PageUtils;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


/**
 * 美食鉴赏评论表
 *
 * @author 
 * @email 
 * @date 2021-03-12 20:57:00
 */
public interface DiscussmeishijianshangService extends IService<DiscussmeishijianshangEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussmeishijianshangVO> selectListVO(Wrapper<DiscussmeishijianshangEntity> wrapper);
   	
   	DiscussmeishijianshangVO selectVO(@Param("ew") Wrapper<DiscussmeishijianshangEntity> wrapper);
   	
   	List<DiscussmeishijianshangView> selectListView(Wrapper<DiscussmeishijianshangEntity> wrapper);
   	
   	DiscussmeishijianshangView selectView(@Param("ew") Wrapper<DiscussmeishijianshangEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussmeishijianshangEntity> wrapper);
   	
}

