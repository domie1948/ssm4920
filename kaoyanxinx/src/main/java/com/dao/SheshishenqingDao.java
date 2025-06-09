package com.dao;

import com.entity.SheshishenqingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.SheshishenqingVO;
import com.entity.view.SheshishenqingView;


/**
 * 设施申请
 * 
 * @author 
 * @email 
 * @date 2020-09-29 15:12:23
 */
public interface SheshishenqingDao extends BaseMapper<SheshishenqingEntity> {
	
	List<SheshishenqingVO> selectListVO(@Param("ew") Wrapper<SheshishenqingEntity> wrapper);
	
	SheshishenqingVO selectVO(@Param("ew") Wrapper<SheshishenqingEntity> wrapper);
	
	List<SheshishenqingView> selectListView(@Param("ew") Wrapper<SheshishenqingEntity> wrapper);

	List<SheshishenqingView> selectListView(Pagination page,@Param("ew") Wrapper<SheshishenqingEntity> wrapper);
	
	SheshishenqingView selectView(@Param("ew") Wrapper<SheshishenqingEntity> wrapper);
	
}
