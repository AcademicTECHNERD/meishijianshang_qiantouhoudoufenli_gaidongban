package com.entity.view;

import com.baomidou.mybatisplus.annotations.TableName;
import com.entity.DefaultuserEntity;
import org.apache.commons.beanutils.BeanUtils;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
 

/**
 * 注册用户
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2021-03-12 20:57:00
 */
@TableName("defaultuser")
public class DefaultuserView  extends DefaultuserEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DefaultuserView(){
	}
 
 	public DefaultuserView(DefaultuserEntity defaultuserEntity){
 	try {
			BeanUtils.copyProperties(this, defaultuserEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
