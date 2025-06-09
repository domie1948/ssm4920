package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.XuexiaojieshaoDao;
import com.entity.XuexiaojieshaoEntity;
import com.service.XuexiaojieshaoService;
import com.entity.vo.XuexiaojieshaoVO;
import com.entity.view.XuexiaojieshaoView;

@Service("xuexiaojieshaoService")
public class XuexiaojieshaoServiceImpl extends ServiceImpl<XuexiaojieshaoDao, XuexiaojieshaoEntity> implements XuexiaojieshaoService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<XuexiaojieshaoEntity> page = this.selectPage(
                new Query<XuexiaojieshaoEntity>(params).getPage(),
                new EntityWrapper<XuexiaojieshaoEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<XuexiaojieshaoEntity> wrapper) {
		  Page<XuexiaojieshaoView> page =new Query<XuexiaojieshaoView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<XuexiaojieshaoVO> selectListVO(Wrapper<XuexiaojieshaoEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public XuexiaojieshaoVO selectVO(Wrapper<XuexiaojieshaoEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<XuexiaojieshaoView> selectListView(Wrapper<XuexiaojieshaoEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public XuexiaojieshaoView selectView(Wrapper<XuexiaojieshaoEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
