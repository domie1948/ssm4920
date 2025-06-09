package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.SheshishenqingEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.SheshishenqingVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.SheshishenqingView;


/**
 * 设施申请
 *
 * @author 
 * @email 
 * @date 2020-09-29 15:12:23
 */
public interface SheshishenqingService extends IService<SheshishenqingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<SheshishenqingVO> selectListVO(Wrapper<SheshishenqingEntity> wrapper);
   	
   	SheshishenqingVO selectVO(@Param("ew") Wrapper<SheshishenqingEntity> wrapper);
   	
   	List<SheshishenqingView> selectListView(Wrapper<SheshishenqingEntity> wrapper);
   	
   	SheshishenqingView selectView(@Param("ew") Wrapper<SheshishenqingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<SheshishenqingEntity> wrapper);
   	
}

