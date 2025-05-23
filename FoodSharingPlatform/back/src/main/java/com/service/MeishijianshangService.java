package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.entity.MeishijianshangEntity;
import com.entity.view.MeishijianshangView;
import com.entity.vo.MeishijianshangVO;
import com.utils.PageUtils;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


/**
 * 美食鉴赏
 *
 * @author 
 * @email 
 * @date 2021-03-12 20:57:00
 */
public interface MeishijianshangService extends IService<MeishijianshangEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<MeishijianshangVO> selectListVO(Wrapper<MeishijianshangEntity> wrapper);
   	
   	MeishijianshangVO selectVO(@Param("ew") Wrapper<MeishijianshangEntity> wrapper);
   	
   	List<MeishijianshangView> selectListView(Wrapper<MeishijianshangEntity> wrapper);
   	
   	MeishijianshangView selectView(@Param("ew") Wrapper<MeishijianshangEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<MeishijianshangEntity> wrapper);
   	
}

