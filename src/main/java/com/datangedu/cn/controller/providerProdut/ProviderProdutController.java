package com.datangedu.cn.controller.providerProdut;



import java.io.InputStream;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import com.datangedu.cn.model.sysUser.Provider;
import com.datangedu.cn.model.sysUser.ProviderProdut;



import org.springframework.web.multipart.MultipartFile;

import com.datangedu.cn.dao.mapper.ProviderProdutMapper;
import com.datangedu.cn.dao.mapper.RegionMapper;
import com.datangedu.cn.model.sysUser.BusinessOrder;
import com.datangedu.cn.model.sysUser.Provider;
import com.datangedu.cn.model.sysUser.ProviderProdut;
import com.datangedu.cn.model.sysUser.Region;
import com.datangedu.cn.model.sysUser.RegionExample;
import com.datangedu.cn.service.ProviderProdutService;
import com.datangedu.cn.service.ProviderService;
import com.datangedu.cn.service.Impl.ProviderProdutServiceImpl;



@Controller
@RequestMapping("/providerProdut")
public class ProviderProdutController {
<<<<<<< HEAD
	
=======
	@Resource
	ProviderProdutService providerProdutService ;
	@Resource
	ProviderProdutMapper providerProdutMapper;
	@Resource
	ProviderService providerService;
	@Resource
	RegionMapper regionMapper;
	/*
	 * 根据服务商id获取服务商产品
	 */
	@ResponseBody
	@RequestMapping(value = "/providerprodutlistbyid",method = RequestMethod.GET)
	public Map<String,Object> providerProdutListById(HttpServletRequest request, String providerid){
		System.out.println("providerProdutList start");
	
		HttpSession session =  request.getSession();
		session.setAttribute("providerid", providerid);
		System.out.println(providerid);
		Map<String,Object> map = new HashMap<String,Object>();
		List<ProviderProdut> providerProdutList = providerProdutService.getProdutListById(providerid);
		map.put("providerProdutList", providerProdutList);
		return map;
	}
	/*
	 * 产品上线下线
	 */
	@ResponseBody
	@RequestMapping(value = "providerprodutchange", method = RequestMethod.GET)
	public Map<String,Object> providerProdutChange(HttpServletRequest request, String produtid){
		System.out.println("providerprodutchange start");
		Map<String,Object> map = new HashMap<String,Object>();
		List<ProviderProdut> providerProdutChangeList= providerProdutService.getProviderProdutChange(produtid);
		System.out.println("大小：" + providerProdutChangeList.size());
		ProviderProdut providerProdut = new ProviderProdut();
	
		if(providerProdutChangeList.get(0).getStatus() == 1) {
			System.out.println("商品id1：" + providerProdutChangeList.get(0).getId());
			providerProdut.setId(providerProdutChangeList.get(0).getId());
			providerProdut.setStatus(2);
			System.out.println("商品id2：" + providerProdut.getId());
			System.out.println("商品状态： " + providerProdut.getStatus());
			providerProdutMapper.updateByPrimaryKeySelective(providerProdut);
			map.put("mem", "修改状态成功");
			map.put("code", 1);
		}else {
			System.out.println("商品id1：" + providerProdutChangeList.get(0).getId());
			providerProdut.setId(providerProdutChangeList.get(0).getId());
			providerProdut.setStatus(1);
			System.out.println("商品id2：" + providerProdut.getId());
			System.out.println("商品状态： " + providerProdut.getStatus());
		
			providerProdutMapper.updateByPrimaryKeySelective(providerProdut);
			map.put("mem", "修改状态成功");
			map.put("code", 1);
		}
		return map;
	}
	/*
	 * 添加服务产品
	 */
	@RequestMapping("/providerprodutInsert")
	public String providerProdutInsert(HttpServletRequest request, MultipartFile file, String serviceName, String serviceInfo, String price){
		System.out.println("providerprodutInsert start");
		Map<String,Object> map = new HashMap<String,Object>();
		 providerProdutService.produtInsert(request, file, serviceName, serviceInfo, price);
	
		return "service_product";	
	}
	
	@ResponseBody
	@RequestMapping(value="/providerprodutlist",method=RequestMethod.GET)	
	public Map<String,Object> ProviderProdutList(HttpServletRequest request){
		HttpSession session = request.getSession(); 
		Map<String,Object> map=new HashMap<String,Object>();
		List<ProviderProdut> providerProdutList=providerProdutService.getProviderProdutList(request);
		map.put("providerProdutList", providerProdutList);
		return map; 
	}
	@ResponseBody
	@RequestMapping(value="/providerprodutdelete",method=RequestMethod.POST)	
	public Map<String, Object> userDelete(HttpServletRequest request){
		Map<String, Object> map=new HashMap<String, Object>();
		int providerProdutInfo=providerProdutService.setPProviderProdutDelete(request);
		map.put("msg","恭喜删除成功");
		map.put("code", 1);
		return map;			
   }
	@ResponseBody
	@RequestMapping(value="/providerprodutpage",method=RequestMethod.GET)	
	public Map<String,Object> ProviderProdutPage(HttpServletRequest request){
		Map<String,Object> map=new HashMap<String,Object>();
		List<ProviderProdut> providerProdutPage=providerProdutService.getProviderProdutPage(request);
		map.put("providerProdutPage", providerProdutPage);
		map.put("code", 1);
		return map;
	}
<<<<<<< HEAD
	/*
	 * 修改服务商信息
	 */
	@RequestMapping("/providerupdate")
	public String providerUpdate(HttpServletRequest request, MultipartFile file,String name, String province, String city, String area, String cellphone, String wechat, String qq, String email){
		System.out.println("providerprodutUpdate start");
		Map<String,Object> map = new HashMap<String,Object>();
	    providerProdutService.providerUpdate(request, file, name, province, city, area, cellphone, wechat, qq, email);

		return "service_setting";	
	
	}
=======
>>>>>>> 3108f68f89e884fc8d57da4c9bf410ea617eadf8
>>>>>>> b7a05bcfa47b76e291a5e39f9b2feec3440c0dd4

	
}