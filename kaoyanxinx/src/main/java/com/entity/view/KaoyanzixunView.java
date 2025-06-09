package com.entity.view;

import com.entity.KaoyanzixunEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 考研资讯
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2020-09-29 15:12:21
 */
@TableName("kaoyanzixun")
public class KaoyanzixunView  extends KaoyanzixunEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public KaoyanzixunView(){
	}
 
 	public KaoyanzixunView(KaoyanzixunEntity kaoyanzixunEntity){
 	try {
			BeanUtils.copyProperties(this, kaoyanzixunEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
