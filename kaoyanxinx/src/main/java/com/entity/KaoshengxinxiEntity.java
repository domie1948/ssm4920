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
 * 考生信息
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2020-09-29 15:12:22
 */
@TableName("kaoshengxinxi")
public class KaoshengxinxiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public KaoshengxinxiEntity() {
		
	}
	
	public KaoshengxinxiEntity(T t) {
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
	 * 考生账号
	 */
					
	private String kaoshengzhanghao;
	
	/**
	 * 密码
	 */
					
	private String mima;
	
	/**
	 * 考生姓名
	 */
					
	private String kaoshengxingming;
	
	/**
	 * 性别
	 */
					
	private String xingbie;
	
	/**
	 * 年龄
	 */
					
	private Integer nianling;
	
	/**
	 * 考生头像
	 */
					
	private String kaoshengtouxiang;
	
	/**
	 * 手机号
	 */
					
	private String shoujihao;
	
	/**
	 * 邮箱
	 */
					
	private String youxiang;
	
	
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
	 * 设置：考生账号
	 */
	public void setKaoshengzhanghao(String kaoshengzhanghao) {
		this.kaoshengzhanghao = kaoshengzhanghao;
	}
	/**
	 * 获取：考生账号
	 */
	public String getKaoshengzhanghao() {
		return kaoshengzhanghao;
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
	 * 设置：考生姓名
	 */
	public void setKaoshengxingming(String kaoshengxingming) {
		this.kaoshengxingming = kaoshengxingming;
	}
	/**
	 * 获取：考生姓名
	 */
	public String getKaoshengxingming() {
		return kaoshengxingming;
	}
	/**
	 * 设置：性别
	 */
	public void setXingbie(String xingbie) {
		this.xingbie = xingbie;
	}
	/**
	 * 获取：性别
	 */
	public String getXingbie() {
		return xingbie;
	}
	/**
	 * 设置：年龄
	 */
	public void setNianling(Integer nianling) {
		this.nianling = nianling;
	}
	/**
	 * 获取：年龄
	 */
	public Integer getNianling() {
		return nianling;
	}
	/**
	 * 设置：考生头像
	 */
	public void setKaoshengtouxiang(String kaoshengtouxiang) {
		this.kaoshengtouxiang = kaoshengtouxiang;
	}
	/**
	 * 获取：考生头像
	 */
	public String getKaoshengtouxiang() {
		return kaoshengtouxiang;
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
	 * 设置：邮箱
	 */
	public void setYouxiang(String youxiang) {
		this.youxiang = youxiang;
	}
	/**
	 * 获取：邮箱
	 */
	public String getYouxiang() {
		return youxiang;
	}

}
