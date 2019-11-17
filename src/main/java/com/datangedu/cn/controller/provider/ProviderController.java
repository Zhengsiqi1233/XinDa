package com.datangedu.cn.controller.provider;



	

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.datangedu.cn.dao.mapper.MemberMapper;
import com.datangedu.cn.dao.mapper.ProviderMapper;
import com.datangedu.cn.dao.mapper.RegionMapper;
import com.datangedu.cn.model.sysUser.Member;
import com.datangedu.cn.model.sysUser.Provider;
import com.datangedu.cn.model.sysUser.Region;
import com.datangedu.cn.model.sysUser.RegionExample;
import com.datangedu.cn.service.MemberService;
import com.datangedu.cn.service.ProviderService;

@RestController
@RequestMapping("provider")
public class ProviderController {
	@Resource
	ProviderService providerService;
	@Resource
	RegionMapper regionMapper;
	@Resource
	ProviderMapper providerMapper;
	/*
	 * 服务商登陆
	 */
	@RequestMapping(value = "providerlogin", method = RequestMethod.POST)
	public Map<String,Object> login(HttpServletRequest request){
		HttpSession session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<Provider> list = providerService.login(request);
		if(request.getParameter("cellphone").length() == 0) {
			map.put("mem", "手机号不能为空");
		}else if(request.getParameter("cellphone").length() == 0) {
			map.put("mem", "密码不能为空");
		}else if(list == null) {
			map.put("mem", "请输入正确的手机号或密码");
		}else if(request.getParameter("inputCode").length() == 0) {
			map.put("mem", "验证码不能为空");
		}else if(!request.getParameter("inputCode").equalsIgnoreCase((String) session.getAttribute("code"))) {
			map.put("mem", "请输入正确的验证码 ");
		}else {	
			map.put("providerid", list.get(0).getId());
			map.put("providername", list.get(0).getName());
			System.out.println(list.get(0).getName());
			map.put("provider", list.get(0));
			map.put("mem", "登陆成功");
		}
		
		return map;
	}
	/*
	 * 服务商找回密码
	 */
	@RequestMapping(value = "paroviderfind", method = RequestMethod.POST)
	public Map<String, Object> findPassword(HttpServletRequest request){
		System.out.println("findpassword start");
		HttpSession session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		List<Provider> list = providerService.findPassword(request);
		 if(request.getParameter("cellphone").length() == 0) {
			map.put("mem", "手机号不能为空");
		}else if(request.getParameter("password").length() == 0) {
			map.put("mem", "密码不能为空");
		}else if(request.getParameter("inputCode").length() == 0) {
			map.put("mem", "验证码不能为空");
		}else if(request.getParameter("queren_password").length() == 0) {
			map.put("mem", "确认密码不能为空");
		}else if(!request.getParameter("inputCode").equalsIgnoreCase((String) session.getAttribute("code"))) {
			map.put("mem", "请输入正确的验证码 ");
		}else {
			// 调用接口看用户是否存在，不存在直接提示， 存在重置密码
			if(list == null) {
				map.put("mem","请输入正确的手机号");
			}else {
				Provider provider = new Provider();
				provider.setPassword(request.getParameter("password"));
				provider.setCellphone(request.getParameter("cellphone"));
				providerMapper.updateByExample1(provider);
				map.put("mem", "修改密码成功");
				
			}		
		}
		return map;	
	}
	/*
	 * 服务商注册
	 */
	@RequestMapping(value = "providerregister", method = RequestMethod.POST)
	public Map<String,Object> userRegister(HttpServletRequest request){
		System.out.println("userRegion start");
		HttpSession session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		int providerList = providerService.providerRegion(request);
		if(request.getParameter("name").length() == 0) {
				map.put("mem", "姓名不能为空");
			}
		else if(request.getParameter("cellphone").length() == 0) {
			map.put("mem", "手机号不能为空");
		}else if(request.getParameter("password").length() == 0) {
				map.put("mem", "密码不能为空");
			}else if(request.getParameter("inputCode").length() == 0) {
				map.put("mem", "验证码不能为空");
			}else if(!request.getParameter("inputCode").equalsIgnoreCase((String) session.getAttribute("code"))) {
				map.put("mem", "请输入正确的验证码 ");
			}else if(request.getParameter("province").length() == 0) {
				map.put("mem", "省不能为空");
			}else if(request.getParameter("city").length() == 0) {
				map.put("mem", "城市不能为空");
			}else if(request.getParameter("area").length() == 0) {
				map.put("mem", "城市不能为空");
			}else {
				map.put("mem", "注册成功");
			}
		
		return map;
	}
	/*
	 * 获取服务商信息
	 */

	@ResponseBody
	@RequestMapping(value = "/providermessage",method = RequestMethod.GET)
	public Map<String,Object> providerMessage(HttpServletRequest request, String providerid, MultipartFile file){
		System.out.println("providerMessage start");
	
		HttpSession session =  request.getSession();
		session.setAttribute("providerid", providerid);
		System.out.println(providerid);
		Map<String,Object> map = new HashMap<String,Object>();
		List<Provider> providerList = providerService.getProviderMessage(providerid);
		Region region = new Region();
		RegionExample regionExample = new RegionExample();
		RegionExample.Criteria criteria = regionExample.createCriteria();
		criteria.andIdEqualTo(providerList.get(0).getProvince());
		map.put("providerProvince", regionMapper.selectByExample(regionExample));
		
		RegionExample regionExample1 = new RegionExample();
		RegionExample.Criteria criteria1 = regionExample1.createCriteria();
		criteria1.andIdEqualTo(providerList.get(0).getCity());
		map.put("providerCity", regionMapper.selectByExample(regionExample1));
		RegionExample regionExample2 = new RegionExample();
		RegionExample.Criteria criteria2 = regionExample2.createCriteria();
		criteria2.andIdEqualTo(providerList.get(0).getArea());
		map.put("providerArea", regionMapper.selectByExample(regionExample2));
				
		map.put("providerList", providerList);
		return map;
	}
	
	
	
/*
 * 服务商正常
 */
	@RequestMapping(value="/providerlist",method=RequestMethod.GET)	
	public Map<String,Object> ProviderList(HttpServletRequest request){
		HttpSession session = request.getSession();
		Map<String,Object> map=new HashMap<String,Object>();
		List<Provider> providerList=providerService.getProviderList(request);
		map.put("providerList", providerList);
		return map;
	}
	
	@RequestMapping(value="/providerpage",method=RequestMethod.GET)	
	public Map<String,Object> ProviderPage(HttpServletRequest request){
		Map<String,Object> map=new HashMap<String,Object>();
		List<Provider> providerPage=providerService.getProviderPage(request);
		map.put("providerPage", providerPage);
		map.put("code", 1);
		return map;
	}
	/*
	 * 服务商停用
	 */
	@RequestMapping(value="/providerstop",method=RequestMethod.GET)	
	public Map<String,Object> ProviderStop(HttpServletRequest request){
		HttpSession session = request.getSession();
		Map<String,Object> map=new HashMap<String,Object>();
		List<Provider> providerStop=providerService.getProviderStop(request);
		map.put("providerStop", providerStop);
		return map;
	}
	/*
	 * 店铺信息
	 */
	@RequestMapping(value="/providerstore",method=RequestMethod.GET)
	public Map<String, Object> providerStore(String providerid){
		System.out.println("providerStore start");
		Map<String,Object> map=new HashMap<String,Object>();
		List<Provider> list = providerService.getProviderStore( providerid);
		map.put("providerStore", list);
		return map;
		
	}
	
	@RequestMapping("/saveUserImg")
	public String saveUserImg(MultipartFile file,String providerid) {
		System.out.println("id==="+providerid);
		Map<Object,Object> result = new HashMap<Object,Object>();
		try {
		// 获取客户端传图图片的输入流
		InputStream ins = file.getInputStream();
		byte[] buffer=new byte[1024];//bit---byte---1k---1m
		int len=0;
		 // 字节输出流
		 ByteArrayOutputStream bos=new ByteArrayOutputStream();
		while((len=ins.read(buffer))!=-1){
			bos.write(buffer,0,len);
		 }
		 bos.flush();
		byte data[] = bos.toByteArray();
		// 调用接口对图片进行存储
		Provider provider =  new Provider();
		System.out.println("providerid  : " + providerid);
		provider.setId(providerid);
		provider.setProviderImg(data);
		providerService.saveUserImg(provider);		            
		result.put("code",1);
			result.put("msg", "保存头像成功");
		} catch (Exception e) {
			result.put("code",0);
			result.put("msg", "保存头像失败");
			return "uploaderror";
		 }				
		return "index";	
	}
	@RequestMapping(value = "/headImg", produces = MediaType.IMAGE_PNG_VALUE)
	public ResponseEntity<byte[]> headImg( String providerid) throws Exception{

		byte[] imageContent ;
		// 根据id获取当前用户的信息
		List<Provider> provider = providerService.getProviderStore(providerid);
				        
		imageContent = provider.get(0).getProviderImg();
		System.out.println("图片==="+provider.get(0).getProviderImg());
				        
		// 设置http头部信息
		final HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.IMAGE_PNG);
		// 返回响应实体
		return new ResponseEntity<byte[]>(imageContent, headers, HttpStatus.OK);
	}





}
