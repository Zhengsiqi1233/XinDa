package com.datangedu.cn.service.Impl;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.datangedu.cn.util.MD5Util;
import com.datangedu.cn.controller.id.IdGen;
import com.datangedu.cn.controller.id.Sequence;
import com.datangedu.cn.dao.mapper.MemberMapper;
import com.datangedu.cn.model.sysUser.Member;
import com.datangedu.cn.model.sysUser.MemberExample;
import com.datangedu.cn.model.sysUser.Region;
import com.datangedu.cn.service.CartService;
import com.datangedu.cn.service.MemberService;
import com.datangedu.cn.service.RegionService;

@Service
public class MemberServiceImpl implements MemberService {
	@Resource
	MemberMapper memberMapper;
	@Resource
	RegionService rService;
	@Resource
	CartService cartService;

<<<<<<< HEAD
	/*
	 * 会员登陆
	 */

=======

	/*
	 * 会员登陆
	 */
>>>>>>> ac7810fbdfc531926d55c23bf71380f621c03f9b
	@Override
	public List<Member> login(HttpServletRequest request) {
		String cellphone = request.getParameter("cellphone");
		String password = MD5Util.getMD5(request.getParameter("password").getBytes());
		String inputCode = request.getParameter("inputCode");
<<<<<<< HEAD

		System.out.println("cellphone :" + cellphone + "password" + password);

		MemberExample memberExample = new MemberExample();
=======
System.out.println("cellphone :" + cellphone + "password" + password);
		System.out.println("cellphone : " + cellphone + "password : " +  MD5Util.getMD5(request.getParameter("password").getBytes()));
	
		MemberExample memberExample = new MemberExample(); 
>>>>>>> ac7810fbdfc531926d55c23bf71380f621c03f9b
		MemberExample.Criteria criteria = memberExample.createCriteria();
		criteria.andCellphoneEqualTo(cellphone);
		criteria.andPasswordEqualTo(MD5Util.getMD5(request.getParameter("password").getBytes()));

		return memberMapper.selectByExample(memberExample);
	}

<<<<<<< HEAD
=======

>>>>>>> ac7810fbdfc531926d55c23bf71380f621c03f9b
	/*
	 * 会员找回密码
	 */

<<<<<<< HEAD
=======

>>>>>>> ac7810fbdfc531926d55c23bf71380f621c03f9b
	@Override
	public List<Member> findPassword(HttpServletRequest request) {
		String cellphone = request.getParameter("cellphone");
		String inputCode = request.getParameter("inputCode");
		String password = MD5Util.getMD5(request.getParameter("password").getBytes());
		System.out.println(request.getParameter("cellphone"));
		System.out.println(request.getParameter("inputCode"));
		System.out.println(request.getParameter("password"));
		MemberExample memberExample = new MemberExample();
		MemberExample.Criteria criteria = memberExample.createCriteria();
		criteria.andCellphoneEqualTo(cellphone);

<<<<<<< HEAD
		return memberMapper.selectByExample(memberExample);

	}

=======
	}

>>>>>>> ac7810fbdfc531926d55c23bf71380f621c03f9b
	/*
	 * 会员注册
	 */

	@Override
	public int userRegion(HttpServletRequest request) {
		String name = request.getParameter("name");
		String cellphone = request.getParameter("cellphone");
		String password = MD5Util.getMD5(request.getParameter("password").getBytes());
		String province = request.getParameter("province");
		String city = request.getParameter("city");
		String area = request.getParameter("area");
		System.out.println(name + "," + cellphone + "，" + password + "," + province + "," + city + "," + area);
<<<<<<< HEAD

		Member member = new Member();
		member.setId(Sequence.nextId());
		member.setName(name);
		member.setCellphone(cellphone);
		member.setPassword(password);

		member.setProvince(province);
		member.setCity(city);
		member.setArea(area);

		return memberMapper.insert(member);
	}

=======
	   
	    Member member = new Member();
	    member.setId(Sequence.nextId());
	    member.setName(name);
	    member.setCellphone(cellphone);
	    member.setPassword(password);

		/*
		 * member.setProvince(province); member.setCity(city); member.setArea(area);
		 */


	    member.setProvince(province);
	    member.setCity(city);
	    member.setArea(area);

	    
		return memberMapper.insert(member);
	    }
>>>>>>> ac7810fbdfc531926d55c23bf71380f621c03f9b
	@Override
	public List<Member> getMemberList(HttpServletRequest request) {
		MemberExample memberExample = new MemberExample();
		MemberExample.Criteria criteria = memberExample.createCriteria();
		memberExample.setPageNum(Integer.parseInt(request.getParameter("pagenum")));
		memberExample.setPageSize(Integer.parseInt(request.getParameter("pagesize")));
		return memberMapper.selectByExample(memberExample);
	}

	@Override
	public List<Member> getMemberPage(HttpServletRequest request) {
		MemberExample memberExample = new MemberExample();
		memberExample.setLikeName(request.getParameter("name"));
		memberExample.setPageNum(Integer.parseInt(request.getParameter("pagenum")));
		memberExample.setPageSize(Integer.parseInt(request.getParameter("pagesize")));
		List<Member> memberPage = memberMapper.selectByLike(memberExample);
		return memberPage;
	}

	/*
	 * 购物车列表
	 */
	@Override
	public List<Member> getMemberCart(String memberid) {
		System.out.println("getMemberCart start");
		MemberExample memberExample = new MemberExample();
		MemberExample.Criteria criteria = memberExample.createCriteria();
		criteria.andIdEqualTo(memberid);
		return memberMapper.selectByExample(memberExample);
	}

	/*
	 * 会员头像
	 */
	@Override
	public Member getMemberImg(String id) {

		return memberMapper.selectByPrimaryKey(id);

	}

	@Override
	public int getMemberChange(HttpServletRequest request, MultipartFile file) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int saveMember(Member member,  MultipartFile file,HttpServletRequest request,String memberid,String name, String email,String sex,String id) throws Exception {
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
		
	
		
		member.setId(id);
		member.setGender(Integer.parseInt(sex));
		member.setName(name);
		member.setEmail(email);
		member.setHeadImg(data);
		System.out.println("name" + member.getName());
		return  memberMapper.updateMember(member);
} catch (Exception e) {
			
			return 1;
		 }		

		
	}
/*
 * 修改密码获取旧密码
 */
	@Override
	public List<Member> getChangeMima(HttpServletRequest request, String memberid) {
		MemberExample memberExample = new MemberExample();
		MemberExample.Criteria criteria = memberExample.createCriteria();
		criteria.andIdEqualTo(memberid);
		return memberMapper.selectByExample(memberExample);
	}
/*
 * 修改密码，改变密码
 */
	@Override
	public int doChangeMima(HttpServletRequest request, String memberid) {
		Member member = new Member();
		String newPassword = MD5Util.getMD5(request.getParameter("newPassword").getBytes());
		member.setPassword(newPassword);
		member.setId(memberid);
		return memberMapper.updateByPrimaryKeySelective(member);
	}


}
