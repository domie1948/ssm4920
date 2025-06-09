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
 * 学校介绍
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2020-09-29 15:12:22
 */
@TableName("xuexiaojieshao")
public class XuexiaojieshaoEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public XuexiaojieshaoEntity() {
		
	}
	
	public XuexiaojieshaoEntity(T t) {
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
	 * 学校名称
	 */
					
	private String xuexiaomingcheng;
	
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
	 * 设置：学校名称
	 */
	public void setXuexiaomingcheng(String xuexiaomingcheng) {
		this.xuexiaomingcheng = xuexiaomingcheng;
	}
	/**
	 * 获取：学校名称
	 */
	public String getXuexiaomingcheng() {
		return xuexiaomingcheng;
	}
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
