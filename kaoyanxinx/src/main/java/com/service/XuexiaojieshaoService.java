package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.XuexiaojieshaoEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.XuexiaojieshaoVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.XuexiaojieshaoView;


/**
 * 学校介绍
 *
 * @author 
 * @email 
 * @date 2020-09-29 15:12:22
 */
public interface XuexiaojieshaoService extends IService<XuexiaojieshaoEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<XuexiaojieshaoVO> selectListVO(Wrapper<XuexiaojieshaoEntity> wrapper);
   	
   	XuexiaojieshaoVO selectVO(@Param("ew") Wrapper<XuexiaojieshaoEntity> wrapper);
   	
   	List<XuexiaojieshaoView> selectListView(Wrapper<XuexiaojieshaoEntity> wrapper);
   	
   	XuexiaojieshaoView selectView(@Param("ew") Wrapper<XuexiaojieshaoEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<XuexiaojieshaoEntity> wrapper);
   	
}

