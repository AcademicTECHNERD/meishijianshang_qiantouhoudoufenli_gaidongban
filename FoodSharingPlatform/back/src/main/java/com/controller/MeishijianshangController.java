package com.controller;

import com.annotation.IgnoreAuth;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.MeishijianshangEntity;
import com.entity.view.MeishijianshangView;
import com.service.MeishijianshangService;
import com.utils.MPUtil;
import com.utils.PageUtils;
import com.utils.R;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * 美食鉴赏
 * 后端接口
 * @author 
 * @email 
 * @date 2021-03-12 20:57:00
 */
@RestController
@RequestMapping("/meishijianshang")
public class MeishijianshangController {
    @Autowired
    private MeishijianshangService meishijianshangService;
    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,MeishijianshangEntity meishijianshang,
		@RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Date fabushijianstart, 
    		@RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Date fabushijianend,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			meishijianshang.setYonghuming((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<MeishijianshangEntity> ew = new EntityWrapper<MeishijianshangEntity>();
		if(fabushijianstart!=null) ew.ge("fabushijian", fabushijianstart);
        	if(fabushijianend!=null) ew.le("fabushijian", fabushijianend);
		PageUtils page = meishijianshangService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, meishijianshang), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,MeishijianshangEntity meishijianshang, HttpServletRequest request){
        EntityWrapper<MeishijianshangEntity> ew = new EntityWrapper<MeishijianshangEntity>();
		PageUtils page = meishijianshangService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, meishijianshang), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( MeishijianshangEntity meishijianshang){
       	EntityWrapper<MeishijianshangEntity> ew = new EntityWrapper<MeishijianshangEntity>();
      	ew.allEq(MPUtil.allEQMapPre( meishijianshang, "meishijianshang")); 
        return R.ok().put("data", meishijianshangService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(MeishijianshangEntity meishijianshang){
        EntityWrapper< MeishijianshangEntity> ew = new EntityWrapper< MeishijianshangEntity>();
 		ew.allEq(MPUtil.allEQMapPre( meishijianshang, "meishijianshang")); 
		MeishijianshangView meishijianshangView =  meishijianshangService.selectView(ew);
		return R.ok("查询美食鉴赏成功").put("data", meishijianshangView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        MeishijianshangEntity meishijianshang = meishijianshangService.selectById(id);
		meishijianshang.setClicknum(meishijianshang.getClicknum()+1);
		meishijianshang.setClicktime(new Date());
		meishijianshangService.updateById(meishijianshang);
        return R.ok().put("data", meishijianshang);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        MeishijianshangEntity meishijianshang = meishijianshangService.selectById(id);
		meishijianshang.setClicknum(meishijianshang.getClicknum()+1);
		meishijianshang.setClicktime(new Date());
		meishijianshangService.updateById(meishijianshang);
        return R.ok().put("data", meishijianshang);
    }
    


    /**
     * 赞或踩
     */
    @RequestMapping("/thumbsup/{id}")
    public R vote(@PathVariable("id") String id,String type){
        MeishijianshangEntity meishijianshang = meishijianshangService.selectById(id);
        if(type.equals("1")) {
        	meishijianshang.setThumbsupnum(meishijianshang.getThumbsupnum()+1);
        } else {
        	meishijianshang.setCrazilynum(meishijianshang.getCrazilynum()+1);
        }
        meishijianshangService.updateById(meishijianshang);
        return R.ok("投票成功");
    }

    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody MeishijianshangEntity meishijianshang, HttpServletRequest request){
    	meishijianshang.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(meishijianshang);
        meishijianshangService.insert(meishijianshang);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody MeishijianshangEntity meishijianshang, HttpServletRequest request){
    	meishijianshang.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(meishijianshang);
        meishijianshangService.insert(meishijianshang);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody MeishijianshangEntity meishijianshang, HttpServletRequest request){
        //ValidatorUtils.validateEntity(meishijianshang);
        meishijianshangService.updateById(meishijianshang);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        meishijianshangService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<MeishijianshangEntity> wrapper = new EntityWrapper<MeishijianshangEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			wrapper.eq("yonghuming", (String)request.getSession().getAttribute("username"));
		}

		int count = meishijianshangService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,MeishijianshangEntity meishijianshang, HttpServletRequest request,String pre){
        EntityWrapper<MeishijianshangEntity> ew = new EntityWrapper<MeishijianshangEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clicknum");
        params.put("order", "desc");
		PageUtils page = meishijianshangService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, meishijianshang), params), params));
        return R.ok().put("data", page);
    }


}
