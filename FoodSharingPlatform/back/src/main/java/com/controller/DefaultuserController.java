package com.controller;

import com.annotation.IgnoreAuth;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.DefaultuserEntity;
import com.entity.view.DefaultuserView;
import com.service.DefaultuserService;
import com.service.TokenService;
import com.utils.MPUtil;
import com.utils.PageUtils;
import com.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;


/**
 * 注册用户
 * 后端接口
 * @author 
 * @email 
 * @date 2021-03-12 20:57:00
 */
@RestController
@RequestMapping("/defaultuser")
public class DefaultuserController {
    @Autowired
    private DefaultuserService defaultuserService;
    
	@Autowired
	private TokenService tokenService;
	
	/**
	 * 登录
	 */
	@IgnoreAuth
	@RequestMapping(value = "/login")
	public R login(String username, String password, String captcha, HttpServletRequest request) {
		DefaultuserEntity user = defaultuserService.selectOne(new EntityWrapper<DefaultuserEntity>().eq("username", username));
		if(user==null || !user.getMima().equals(password)) {
			return R.error("账号或密码不正确");
		}
		
		String token = tokenService.generateToken(user.getId(), username,"defaultuser",  "注册用户" );
		return R.ok().put("token", token);
	}
	
	/**
     * 注册
     */
	@IgnoreAuth
    @RequestMapping("/register")
    public R register(@RequestBody DefaultuserEntity defaultuser){
    	//ValidatorUtils.validateEntity(defaultuser);
    	DefaultuserEntity user = defaultuserService.selectOne(new EntityWrapper<DefaultuserEntity>().eq("username", defaultuser.getUsername()));
		if(user!=null) {
			return R.error("注册用户已存在");
		}
		Long uId = new Date().getTime();
		defaultuser.setId(uId);
        defaultuserService.insert(defaultuser);
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
        DefaultuserEntity user = defaultuserService.selectById(id);
        return R.ok().put("data", user);
    }
    
    /**
     * 密码重置
     */
    @IgnoreAuth
	@RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request){
    	DefaultuserEntity user = defaultuserService.selectOne(new EntityWrapper<DefaultuserEntity>().eq("username", username));
    	if(user==null) {
    		return R.error("账号不存在");
    	}
        user.setMima("123456");
        defaultuserService.updateById(user);
        return R.ok("密码已重置为：123456");
    }


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DefaultuserEntity defaultuser,
		HttpServletRequest request){
        EntityWrapper<DefaultuserEntity> ew = new EntityWrapper<DefaultuserEntity>();
		PageUtils page = defaultuserService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, defaultuser), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DefaultuserEntity defaultuser, HttpServletRequest request){
        EntityWrapper<DefaultuserEntity> ew = new EntityWrapper<DefaultuserEntity>();
		PageUtils page = defaultuserService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, defaultuser), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DefaultuserEntity defaultuser){
       	EntityWrapper<DefaultuserEntity> ew = new EntityWrapper<DefaultuserEntity>();
      	ew.allEq(MPUtil.allEQMapPre( defaultuser, "defaultuser")); 
        return R.ok().put("data", defaultuserService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DefaultuserEntity defaultuser){
        EntityWrapper< DefaultuserEntity> ew = new EntityWrapper< DefaultuserEntity>();
 		ew.allEq(MPUtil.allEQMapPre( defaultuser, "defaultuser")); 
		DefaultuserView defaultuserView =  defaultuserService.selectView(ew);
		return R.ok("查询注册用户成功").put("data", defaultuserView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DefaultuserEntity defaultuser = defaultuserService.selectById(id);
        return R.ok().put("data", defaultuser);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DefaultuserEntity defaultuser = defaultuserService.selectById(id);
        return R.ok().put("data", defaultuser);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DefaultuserEntity defaultuser, HttpServletRequest request){
    	defaultuser.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(defaultuser);
    	DefaultuserEntity user = defaultuserService.selectOne(new EntityWrapper<DefaultuserEntity>().eq("username", defaultuser.getUsername()));
		if(user!=null) {
			return R.error("用户已存在");
		}
		defaultuser.setId(new Date().getTime());
        defaultuserService.insert(defaultuser);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DefaultuserEntity defaultuser, HttpServletRequest request){
    	defaultuser.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(defaultuser);
    	DefaultuserEntity user = defaultuserService.selectOne(new EntityWrapper<DefaultuserEntity>().eq("username", defaultuser.getUsername()));
		if(user!=null) {
			return R.error("用户已存在");
		}
		defaultuser.setId(new Date().getTime());
        defaultuserService.insert(defaultuser);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody DefaultuserEntity defaultuser, HttpServletRequest request){
        //ValidatorUtils.validateEntity(defaultuser);
        defaultuserService.updateById(defaultuser);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        defaultuserService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<DefaultuserEntity> wrapper = new EntityWrapper<DefaultuserEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = defaultuserService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	


}
