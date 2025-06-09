package com.entity.model;

import com.entity.XuexiaojieshaoEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;
 

/**
 * 学校介绍
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2020-09-29 15:12:22
 */
public class XuexiaojieshaoModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 学校图片
	 */
	
	private String xuexiaotupian;
		
	/**
	 * 学校概况
	 */
	
	private String xuexiaogaikuang;
		
	/**
	 * 学校地区
	 */
	
	private String xuexiaodiqu;
		
	/**
	 * 学校简介
	 */
	
	private String xuexiaojianjie;
				
	
	/**
	 * 设置：学校图片
	 */
	 
	public void setXuexiaotupian(String xuexiaotupian) {
		this.xuexiaotupian = xuexiaotupian;
	}
	
	/**
	 * 获取：学校图片
	 */
	public String getXuexiaotupian() {
		return xuexiaotupian;
	}
				
	
	/**
	 * 设置：学校概况
	 */
	 
	public void setXuexiaogaikuang(String xuexiaogaikuang) {
		this.xuexiaogaikuang = xuexiaogaikuang;
	}
	
	/**
	 * 获取：学校概况
	 */
	public String getXuexiaogaikuang() {
		return xuexiaogaikuang;
	}
				
	
	/**
	 * 设置：学校地区
	 */
	 
	public void setXuexiaodiqu(String xuexiaodiqu) {
		this.xuexiaodiqu = xuexiaodiqu;
	}
	
	/**
	 * 获取：学校地区
	 */
	public String getXuexiaodiqu() {
		return xuexiaodiqu;
	}
				
	
	/**
	 * 设置：学校简介
	 */
	 
	public void setXuexiaojianjie(String xuexiaojianjie) {
		this.xuexiaojianjie = xuexiaojianjie;
	}
	
	/**
	 * 获取：学校简介
	 */
	public String getXuexiaojianjie() {
		return xuexiaojianjie;
	}
			
}
