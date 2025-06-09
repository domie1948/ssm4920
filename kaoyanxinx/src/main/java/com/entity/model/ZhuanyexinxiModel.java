package com.entity.model;

import com.entity.ZhuanyexinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;
 

/**
 * 专业信息
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2020-09-29 15:12:22
 */
public class ZhuanyexinxiModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 专业名称
	 */
	
	private String zhuanyemingcheng;
		
	/**
	 * 图片
	 */
	
	private String tupian;
		
	/**
	 * 专业介绍
	 */
	
	private String zhuanyejieshao;
		
	/**
	 * 专业注意事项
	 */
	
	private String zhuanyezhuyishixiang;
		
	/**
	 * 专业类型
	 */
	
	private String zhuanyeleixing;
				
	
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
	 * 设置：专业介绍
	 */
	 
	public void setZhuanyejieshao(String zhuanyejieshao) {
		this.zhuanyejieshao = zhuanyejieshao;
	}
	
	/**
	 * 获取：专业介绍
	 */
	public String getZhuanyejieshao() {
		return zhuanyejieshao;
	}
				
	
	/**
	 * 设置：专业注意事项
	 */
	 
	public void setZhuanyezhuyishixiang(String zhuanyezhuyishixiang) {
		this.zhuanyezhuyishixiang = zhuanyezhuyishixiang;
	}
	
	/**
	 * 获取：专业注意事项
	 */
	public String getZhuanyezhuyishixiang() {
		return zhuanyezhuyishixiang;
	}
				
	
	/**
	 * 设置：专业类型
	 */
	 
	public void setZhuanyeleixing(String zhuanyeleixing) {
		this.zhuanyeleixing = zhuanyeleixing;
	}
	
	/**
	 * 获取：专业类型
	 */
	public String getZhuanyeleixing() {
		return zhuanyeleixing;
	}
			
}
