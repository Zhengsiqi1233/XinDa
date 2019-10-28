package com.datangedu.cn.controller.region;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.datangedu.cn.model.sysUser.Region;
import com.datangedu.cn.service.RegionService;
@RestController
@RequestMapping("region")

public class RegionController {
	@Resource
	RegionService rService;
	
	@ResponseBody		//得到省
	@RequestMapping(value="/register",method = RequestMethod.POST)
	public Map<String,Object> getsheng(HttpServletRequest request) {
		System.out.println("province start");
		Map<String,Object> map = new HashMap<String,Object>();
		List<Region> province = rService.getLevel((short) 1);
		map.put("province", province);
		System.out.println("省id=="+province.get(0).getId());
		return map;
	}
	
	@ResponseBody		//得到市
	@RequestMapping(value="/city",method = RequestMethod.POST)
	public Map<String,Object> getshi(HttpServletRequest request) {
		System.out.println("city start");
		
		Map<String,Object> map = new HashMap<String,Object>();
		
		System.out.println("省"+request.getParameter("provinceId"));
		List<Region> city = rService.getshi(request.getParameter("provinceId"));
		map.put("city", city);
		
		System.out.println("市id=="+city.get(0).getId());
		return map;
	}
	
	
	@ResponseBody		//得到区
	@RequestMapping(value="/area",method = RequestMethod.POST)
	public Map<String,Object> getqu(HttpServletRequest request) {
		System.out.println("area  start");
		Map<String,Object> map = new HashMap<String,Object>();
		
		List<Region> area = rService.getshi(request.getParameter("cityId"));
		map.put("area", area);
		System.out.println("区id=="+area.get(0).getId());
		return map;
	}
	
	


}
