package com.entity.view;

import com.baomidou.mybatisplus.annotations.TableName;
import com.entity.DiscussmeishijianshangEntity;
import org.apache.commons.beanutils.BeanUtils;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
 

/**
 * 美食鉴赏评论表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2021-03-12 20:57:00
 */
@TableName("discussmeishijianshang")
public class DiscussmeishijianshangView  extends DiscussmeishijianshangEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscussmeishijianshangView(){
	}
 
 	public DiscussmeishijianshangView(DiscussmeishijianshangEntity discussmeishijianshangEntity){
 	try {
			BeanUtils.copyProperties(this, discussmeishijianshangEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
