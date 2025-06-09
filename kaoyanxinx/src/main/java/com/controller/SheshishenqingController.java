package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.SheshishenqingEntity;
import com.entity.view.SheshishenqingView;

import com.service.SheshishenqingService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.CommonUtil;


/**
 * 设施申请
 * 后端接口
 * @author 
 * @email 
 * @date 2020-09-29 15:12:23
 */
@RestController
@RequestMapping("/sheshishenqing")
public class SheshishenqingController {
    @Autowired
    private SheshishenqingService sheshishenqingService;
    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,SheshishenqingEntity sheshishenqing, HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("kaoshengxinxi")) {
			sheshishenqing.setKaoshengzhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("daoshixinxi")) {
			sheshishenqing.setDaoshigonghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<SheshishenqingEntity> ew = new EntityWrapper<SheshishenqingEntity>();
		PageUtils page = sheshishenqingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, sheshishenqing), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,SheshishenqingEntity sheshishenqing, HttpServletRequest request){
        EntityWrapper<SheshishenqingEntity> ew = new EntityWrapper<SheshishenqingEntity>();
		PageUtils page = sheshishenqingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, sheshishenqing), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( SheshishenqingEntity sheshishenqing){
       	EntityWrapper<SheshishenqingEntity> ew = new EntityWrapper<SheshishenqingEntity>();
      	ew.allEq(MPUtil.allEQMapPre( sheshishenqing, "sheshishenqing")); 
        return R.ok().put("data", sheshishenqingService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(SheshishenqingEntity sheshishenqing){
        EntityWrapper< SheshishenqingEntity> ew = new EntityWrapper< SheshishenqingEntity>();
 		ew.allEq(MPUtil.allEQMapPre( sheshishenqing, "sheshishenqing")); 
		SheshishenqingView sheshishenqingView =  sheshishenqingService.selectView(ew);
		return R.ok("查询设施申请成功").put("data", sheshishenqingView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") String id){
        SheshishenqingEntity sheshishenqing = sheshishenqingService.selectById(id);
        return R.ok().put("data", sheshishenqing);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") String id){
        SheshishenqingEntity sheshishenqing = sheshishenqingService.selectById(id);
        return R.ok().put("data", sheshishenqing);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody SheshishenqingEntity sheshishenqing, HttpServletRequest request){
    	sheshishenqing.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(sheshishenqing);

        sheshishenqingService.insert(sheshishenqing);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody SheshishenqingEntity sheshishenqing, HttpServletRequest request){
    	sheshishenqing.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(sheshishenqing);

        sheshishenqingService.insert(sheshishenqing);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody SheshishenqingEntity sheshishenqing, HttpServletRequest request){
        //ValidatorUtils.validateEntity(sheshishenqing);
        sheshishenqingService.updateById(sheshishenqing);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        sheshishenqingService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<SheshishenqingEntity> wrapper = new EntityWrapper<SheshishenqingEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("kaoshengxinxi")) {
			wrapper.eq("kaoshengzhanghao", (String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("daoshixinxi")) {
			wrapper.eq("daoshigonghao", (String)request.getSession().getAttribute("username"));
		}

		int count = sheshishenqingService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	


}
