package com.entity.model;

import com.entity.XiangmuxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;
 

/**
 * 项目信息
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2020-09-29 15:12:23
 */
public class XiangmuxinxiModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 专业名称
	 */
	
	private String zhuanyemingcheng;
		
	/**
	 * 项目名称
	 */
	
	private String xiangmumingcheng;
		
	/**
	 * 负责人
	 */
	
	private String fuzeren;
		
	/**
	 * 图片
	 */
	
	private String tupian;
		
	/**
	 * 项目内容
	 */
	
	private String xiangmuneirong;
				
	
	/**
	 * 设置：专业名称
	 */
	 
	public void setZhuanyemingcheng(String zhuanyemingcheng) {
		this.zhuanyemingcheng = zhuanyemingcheng;
	}
	
	/**
	 * 获取：专业名称
	 */
	public String getZhuanyemingcheng() {
		return zhuanyemingcheng;
	}
				
	
	/**
	 * 设置：项目名称
	 */
	 
	public void setXiangmumingcheng(String xiangmumingcheng) {
		this.xiangmumingcheng = xiangmumingcheng;
	}
	
	/**
	 * 获取：项目名称
	 */
	public String getXiangmumingcheng() {
		return xiangmumingcheng;
	}
				
	
	/**
	 * 设置：负责人
	 */
	 
	public void setFuzeren(String fuzeren) {
		this.fuzeren = fuzeren;
	}
	
	/**
	 * 获取：负责人
	 */
	public String getFuzeren() {
		return fuzeren;
	}
				
	
	/**
	 * 设置：图片
	 */
	 
	public void setTupian(String tupian) {
		this.tupian = tupian;
	}
	
	/**
	 * 获取：图片
	 */
	public String getTupian() {
		return tupian;
	}
				
	
	/**
	 * 设置：项目内容
	 */
	 
	public void setXiangmuneirong(String xiangmuneirong) {
		this.xiangmuneirong = xiangmuneirong;
	}
	
	/**
	 * 获取：项目内容
	 */
	public String getXiangmuneirong() {
		return xiangmuneirong;
	}
			
}
