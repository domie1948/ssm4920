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
 * 导师信息
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2020-09-29 15:12:22
 */
@TableName("daoshixinxi")
public class DaoshixinxiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public DaoshixinxiEntity() {
		
	}
	
	public DaoshixinxiEntity(T t) {
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
	 * 导师工号
	 */
					
	private String daoshigonghao;
	
	/**
	 * 密码
	 */
					
	private String mima;
	
	/**
	 * 导师姓名
	 */
					
	private String daoshixingming;
	
	/**
	 * 头像
	 */
					
	private String touxiang;
	
	/**
	 * 手机号
	 */
					
	private String shoujihao;
	
	/**
	 * 导师职称
	 */
					
	private String daoshizhicheng;
	
	/**
	 * 所在学校
	 */
					
	private String suozaixuexiao;
	
	/**
	 * 电子邮箱
	 */
					
	private String dianziyouxiang;
	
	/**
	 * 导师介绍
	 */
					
	private String daoshijieshao;
	
	
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
	 * 设置：导师工号
	 */
	public void setDaoshigonghao(String daoshigonghao) {
		this.daoshigonghao = daoshigonghao;
	}
	/**
	 * 获取：导师工号
	 */
	public String getDaoshigonghao() {
		return daoshigonghao;
	}
	/**
	 * 设置：密码
	 */
	public void setMima(String mima) {
		this.mima = mima;
	}
	/**
	 * 获取：密码
	 */
	public String getMima() {
		return mima;
	}
	/**
	 * 设置：导师姓名
	 */
	public void setDaoshixingming(String daoshixingming) {
		this.daoshixingming = daoshixingming;
	}
	/**
	 * 获取：导师姓名
	 */
	public String getDaoshixingming() {
		return daoshixingming;
	}
	/**
	 * 设置：头像
	 */
	public void setTouxiang(String touxiang) {
		this.touxiang = touxiang;
	}
	/**
	 * 获取：头像
	 */
	public String getTouxiang() {
		return touxiang;
	}
	/**
	 * 设置：手机号
	 */
	public void setShoujihao(String shoujihao) {
		this.shoujihao = shoujihao;
	}
	/**
	 * 获取：手机号
	 */
	public String getShoujihao() {
		return shoujihao;
	}
	/**
	 * 设置：导师职称
	 */
	public void setDaoshizhicheng(String daoshizhicheng) {
		this.daoshizhicheng = daoshizhicheng;
	}
	/**
	 * 获取：导师职称
	 */
	public String getDaoshizhicheng() {
		return daoshizhicheng;
	}
	/**
	 * 设置：所在学校
	 */
	public void setSuozaixuexiao(String suozaixuexiao) {
		this.suozaixuexiao = suozaixuexiao;
	}
	/**
	 * 获取：所在学校
	 */
	public String getSuozaixuexiao() {
		return suozaixuexiao;
	}
	/**
	 * 设置：电子邮箱
	 */
	public void setDianziyouxiang(String dianziyouxiang) {
		this.dianziyouxiang = dianziyouxiang;
	}
	/**
	 * 获取：电子邮箱
	 */
	public String getDianziyouxiang() {
		return dianziyouxiang;
	}
	/**
	 * 设置：导师介绍
	 */
	public void setDaoshijieshao(String daoshijieshao) {
		this.daoshijieshao = daoshijieshao;
	}
	/**
	 * 获取：导师介绍
	 */
	public String getDaoshijieshao() {
		return daoshijieshao;
	}

}
