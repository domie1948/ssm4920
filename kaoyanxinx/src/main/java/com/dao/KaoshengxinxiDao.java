package com.dao;

import com.entity.KaoshengxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.KaoshengxinxiVO;
import com.entity.view.KaoshengxinxiView;


/**
 * 考生信息
 * 
 * @author 
 * @email 
 * @date 2020-09-29 15:12:22
 */
public interface KaoshengxinxiDao extends BaseMapper<KaoshengxinxiEntity> {
	
	List<KaoshengxinxiVO> selectListVO(@Param("ew") Wrapper<KaoshengxinxiEntity> wrapper);
	
	KaoshengxinxiVO selectVO(@Param("ew") Wrapper<KaoshengxinxiEntity> wrapper);
	
	List<KaoshengxinxiView> selectListView(@Param("ew") Wrapper<KaoshengxinxiEntity> wrapper);

	List<KaoshengxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<KaoshengxinxiEntity> wrapper);
	
	KaoshengxinxiView selectView(@Param("ew") Wrapper<KaoshengxinxiEntity> wrapper);
	
}
