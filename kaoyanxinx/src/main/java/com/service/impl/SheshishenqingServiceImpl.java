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


import com.dao.SheshishenqingDao;
import com.entity.SheshishenqingEntity;
import com.service.SheshishenqingService;
import com.entity.vo.SheshishenqingVO;
import com.entity.view.SheshishenqingView;

@Service("sheshishenqingService")
public class SheshishenqingServiceImpl extends ServiceImpl<SheshishenqingDao, SheshishenqingEntity> implements SheshishenqingService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<SheshishenqingEntity> page = this.selectPage(
                new Query<SheshishenqingEntity>(params).getPage(),
                new EntityWrapper<SheshishenqingEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<SheshishenqingEntity> wrapper) {
		  Page<SheshishenqingView> page =new Query<SheshishenqingView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<SheshishenqingVO> selectListVO(Wrapper<SheshishenqingEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public SheshishenqingVO selectVO(Wrapper<SheshishenqingEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<SheshishenqingView> selectListView(Wrapper<SheshishenqingEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public SheshishenqingView selectView(Wrapper<SheshishenqingEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
