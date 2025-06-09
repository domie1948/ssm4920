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

import com.entity.KaoshengxinxiEntity;
import com.entity.view.KaoshengxinxiView;

import com.service.KaoshengxinxiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.CommonUtil;


/**
 * 考生信息
 * 后端接口
 * @author 
 * @email 
 * @date 2020-09-29 15:12:22
 */
@RestController
@RequestMapping("/kaoshengxinxi")
public class KaoshengxinxiController {
    @Autowired
    private KaoshengxinxiService kaoshengxinxiService;
    
	@Autowired
	private TokenService tokenService;
	
	/**
	 * 登录
	 */
	@IgnoreAuth
	@RequestMapping(value = "/login")
	public R login(String username, String password, String captcha, HttpServletRequest request) {
		KaoshengxinxiEntity user = kaoshengxinxiService.selectOne(new EntityWrapper<KaoshengxinxiEntity>().eq("kaoshengzhanghao", username));
		if(user==null || !user.getMima().equals(password)) {
			return R.error("账号或密码不正确");
		}
		String token = tokenService.generateToken(user.getId(), username,"kaoshengxinxi",  "考生信息" );
		return R.ok().put("token", token);
	}
	
	/**
     * 注册
     */
	@IgnoreAuth
    @RequestMapping("/register")
    public R register(@RequestBody KaoshengxinxiEntity kaoshengxinxi){
    	//ValidatorUtils.validateEntity(kaoshengxinxi);
    	KaoshengxinxiEntity user = kaoshengxinxiService.selectOne(new EntityWrapper<KaoshengxinxiEntity>().eq("kaoshengzhanghao", kaoshengxinxi.getKaoshengzhanghao()));
		if(user!=null) {
			return R.error("注册用户已存在");
		}
		Long uId = new Date().getTime();
		kaoshengxinxi.setId(uId);
        kaoshengxinxiService.insert(kaoshengxinxi);
        return R.ok();
    }
	
	/**
	 * 退出
	 */
	@RequestMapping("/logout")
	public R logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return R.ok("退出成功");
	}
	
	/**
     * 获取用户的session用户信息
     */
    @RequestMapping("/session")
    public R getCurrUser(HttpServletRequest request){
    	Long id = (Long)request.getSession().getAttribute("userId");
        KaoshengxinxiEntity user = kaoshengxinxiService.selectById(id);
        return R.ok().put("data", user);
    }
    
    /**
     * 密码重置
     */
    @IgnoreAuth
	@RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request){
    	KaoshengxinxiEntity user = kaoshengxinxiService.selectOne(new EntityWrapper<KaoshengxinxiEntity>().eq("kaoshengzhanghao", username));
    	if(user==null) {
    		return R.error("账号不存在");
    	}
    	user.setMima("123456");
        kaoshengxinxiService.updateById(user);
        return R.ok("密码已重置为：123456");
    }


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,KaoshengxinxiEntity kaoshengxinxi, HttpServletRequest request){

        EntityWrapper<KaoshengxinxiEntity> ew = new EntityWrapper<KaoshengxinxiEntity>();
		PageUtils page = kaoshengxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, kaoshengxinxi), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,KaoshengxinxiEntity kaoshengxinxi, HttpServletRequest request){
        EntityWrapper<KaoshengxinxiEntity> ew = new EntityWrapper<KaoshengxinxiEntity>();
		PageUtils page = kaoshengxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, kaoshengxinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( KaoshengxinxiEntity kaoshengxinxi){
       	EntityWrapper<KaoshengxinxiEntity> ew = new EntityWrapper<KaoshengxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( kaoshengxinxi, "kaoshengxinxi")); 
        return R.ok().put("data", kaoshengxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(KaoshengxinxiEntity kaoshengxinxi){
        EntityWrapper< KaoshengxinxiEntity> ew = new EntityWrapper< KaoshengxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( kaoshengxinxi, "kaoshengxinxi")); 
		KaoshengxinxiView kaoshengxinxiView =  kaoshengxinxiService.selectView(ew);
		return R.ok("查询考生信息成功").put("data", kaoshengxinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") String id){
        KaoshengxinxiEntity kaoshengxinxi = kaoshengxinxiService.selectById(id);
        return R.ok().put("data", kaoshengxinxi);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") String id){
        KaoshengxinxiEntity kaoshengxinxi = kaoshengxinxiService.selectById(id);
        return R.ok().put("data", kaoshengxinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody KaoshengxinxiEntity kaoshengxinxi, HttpServletRequest request){
    	kaoshengxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(kaoshengxinxi);
    	KaoshengxinxiEntity user = kaoshengxinxiService.selectOne(new EntityWrapper<KaoshengxinxiEntity>().eq("kaoshengzhanghao", kaoshengxinxi.getKaoshengzhanghao()));
		if(user!=null) {
			return R.error("用户已存在");
		}

		kaoshengxinxi.setId(new Date().getTime());
        kaoshengxinxiService.insert(kaoshengxinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody KaoshengxinxiEntity kaoshengxinxi, HttpServletRequest request){
    	kaoshengxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(kaoshengxinxi);
    	KaoshengxinxiEntity user = kaoshengxinxiService.selectOne(new EntityWrapper<KaoshengxinxiEntity>().eq("kaoshengzhanghao", kaoshengxinxi.getKaoshengzhanghao()));
		if(user!=null) {
			return R.error("用户已存在");
		}

		kaoshengxinxi.setId(new Date().getTime());
        kaoshengxinxiService.insert(kaoshengxinxi);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody KaoshengxinxiEntity kaoshengxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(kaoshengxinxi);
        kaoshengxinxiService.updateById(kaoshengxinxi);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        kaoshengxinxiService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<KaoshengxinxiEntity> wrapper = new EntityWrapper<KaoshengxinxiEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = kaoshengxinxiService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	


}
