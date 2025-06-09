package com.dao;

import com.entity.XuexiaojieshaoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.XuexiaojieshaoVO;
import com.entity.view.XuexiaojieshaoView;


/**
 * 学校介绍
 * 
 * @author 
 * @email 
 * @date 2020-09-29 15:12:22
 */
public interface XuexiaojieshaoDao extends BaseMapper<XuexiaojieshaoEntity> {
	
	List<XuexiaojieshaoVO> selectListVO(@Param("ew") Wrapper<XuexiaojieshaoEntity> wrapper);
	
	XuexiaojieshaoVO selectVO(@Param("ew") Wrapper<XuexiaojieshaoEntity> wrapper);
	
	List<XuexiaojieshaoView> selectListView(@Param("ew") Wrapper<XuexiaojieshaoEntity> wrapper);

	List<XuexiaojieshaoView> selectListView(Pagination page,@Param("ew") Wrapper<XuexiaojieshaoEntity> wrapper);
	
	XuexiaojieshaoView selectView(@Param("ew") Wrapper<XuexiaojieshaoEntity> wrapper);
	
}
