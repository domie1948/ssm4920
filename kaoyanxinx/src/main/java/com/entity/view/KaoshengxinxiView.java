package com.entity.view;

import com.entity.KaoshengxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 考生信息
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2020-09-29 15:12:22
 */
@TableName("kaoshengxinxi")
public class KaoshengxinxiView  extends KaoshengxinxiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public KaoshengxinxiView(){
	}
 
 	public KaoshengxinxiView(KaoshengxinxiEntity kaoshengxinxiEntity){
 	try {
			BeanUtils.copyProperties(this, kaoshengxinxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
