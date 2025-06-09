package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.KaoshengxinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.KaoshengxinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.KaoshengxinxiView;


/**
 * 考生信息
 *
 * @author 
 * @email 
 * @date 2020-09-29 15:12:22
 */
public interface KaoshengxinxiService extends IService<KaoshengxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<KaoshengxinxiVO> selectListVO(Wrapper<KaoshengxinxiEntity> wrapper);
   	
   	KaoshengxinxiVO selectVO(@Param("ew") Wrapper<KaoshengxinxiEntity> wrapper);
   	
   	List<KaoshengxinxiView> selectListView(Wrapper<KaoshengxinxiEntity> wrapper);
   	
   	KaoshengxinxiView selectView(@Param("ew") Wrapper<KaoshengxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<KaoshengxinxiEntity> wrapper);
   	
}

