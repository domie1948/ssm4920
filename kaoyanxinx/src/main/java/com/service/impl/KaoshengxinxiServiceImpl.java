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


import com.dao.KaoshengxinxiDao;
import com.entity.KaoshengxinxiEntity;
import com.service.KaoshengxinxiService;
import com.entity.vo.KaoshengxinxiVO;
import com.entity.view.KaoshengxinxiView;

@Service("kaoshengxinxiService")
public class KaoshengxinxiServiceImpl extends ServiceImpl<KaoshengxinxiDao, KaoshengxinxiEntity> implements KaoshengxinxiService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<KaoshengxinxiEntity> page = this.selectPage(
                new Query<KaoshengxinxiEntity>(params).getPage(),
                new EntityWrapper<KaoshengxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<KaoshengxinxiEntity> wrapper) {
		  Page<KaoshengxinxiView> page =new Query<KaoshengxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<KaoshengxinxiVO> selectListVO(Wrapper<KaoshengxinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public KaoshengxinxiVO selectVO(Wrapper<KaoshengxinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<KaoshengxinxiView> selectListView(Wrapper<KaoshengxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public KaoshengxinxiView selectView(Wrapper<KaoshengxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
