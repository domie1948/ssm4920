package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 专业信息
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2020-09-29 15:12:22
 */
@TableName("zhuanyexinxi")
public class ZhuanyexinxiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public ZhuanyexinxiEntity() {
		
	}
	
	public ZhuanyexinxiEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 专业编号
	 */
					
	private String zhuanyebianhao;
	
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
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：专业编号
	 */
	public void setZhuanyebianhao(String zhuanyebianhao) {
		this.zhuanyebianhao = zhuanyebianhao;
	}
	/**
	 * 获取：专业编号
	 */
	public String getZhuanyebianhao() {
		return zhuanyebianhao;
	}
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
