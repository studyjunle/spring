package com.springmvc.web;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.springmvc.entity.User;
import com.springmvc.service.UserService;

/**
 * 控制层
 * @author Male
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {
	
	@Resource
	private UserService userService;
	
	/**
	 * 查询所有用户信息
	 * @param model
	 * @return
	 */
	@RequestMapping("/findAllUser")
	public String findAllUser(Model model) {
		List<User> findAllUserList = userService.findAllUser();
		model.addAttribute("userList", findAllUserList);
		return "list";
	}
	
	/**
	 * 通过用户的id查询用户信息
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/findUserById")
	public @ResponseBody Map<String, Object> findUserById(Integer id, Model model) {
		Map<String, Object> result = new HashMap<>();
		User user = userService.findUserById(id);
		result.put("username", user.getUsername());
		return result;
	}
	
	@RequestMapping("/findUserById1")
	public String findUserById1(Integer id, Model model) {
		User user = userService.findUserById(id);
		model.addAttribute("user", user);
		return "list";
	}
	
	/**
	 * 通过用户名模糊查询
	 * @param username
	 * @param model
	 * @return
	 */
	@RequestMapping("/findUserByName")
	public String findUserByName(String username, Model model) {
		List<User> findUserByName = userService.findUserByName(username);
		model.addAttribute("userList", findUserByName);
		return "list";
	}
	
	/**
	 * 添加用户
	 * @param user
	 * 				ajax同步提交json数据
	 * @return
	 * 				返回一个json数据
	 */
	@RequestMapping("/addUser")
	public @ResponseBody Map<String, Object> addUser(@RequestBody User user) {
		int flag = userService.addUser(user);
		Map<String, Object> resultJson = new HashMap<>();
		resultJson.put("addMsg", flag);
		return resultJson;
	}
	
	/**
	 * 更新用户
	 * @param user
	 * 				ajax同步提交json数据
	 * @return
	 * 				返回一个json数据
	 */
	@RequestMapping("/updateUserById")
	public @ResponseBody Map<String, Object> updateUserById(@RequestBody User user) {
		int flag = userService.updateUserById(user);
		Map<String, Object> resultJson = new HashMap<>();
		resultJson.put("updateMsg", flag);
		return resultJson;
	}
	
	/**
	 * 删除用户	使用restfull风格
	 * @param id
	 * @return
	 */
	@RequestMapping("/deleteUserById/{id}")
	public String deleteUserById(@PathVariable Integer id) {
		userService.deleteUserById(id);
		return "redirect:/user/findAllUser.do";
	}
	
	/**
	 * 批量删除用户
	 * @param idArray
	 * @return
	 */
	@RequestMapping("/deleteUserByIdArray")
	public @ResponseBody List<Integer> deleteUserByIdArray(Integer[] idArray) {
		System.out.println(Arrays.toString(idArray));
		List<Integer> result = new ArrayList<>();
		for (int i = 0; i < idArray.length; i++) {
			int deleteUserById = userService.deleteUserById(idArray[i]);
			result.add(deleteUserById);
		}
		return result;
	}
	
	/**
	 * 跳转到更新用户界面并回显数据	使用restfull风格
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/updateUserView/{id}")
	public String updateUserView(@PathVariable Integer id, Model model) {
		User user = userService.findUserById(id);
		model.addAttribute("userList", user);
		return "updateOrAddUserInfo";
	}
	
	/**
	 * 跳转到添加用户界面
	 * @return
	 */
	@RequestMapping("/addUserView")
	public String addUserView() {
		return "updateOrAddUserInfo";
	}
	/**
	 * 批量添加测试数据
	 */
	@RequestMapping("/addUsers")
	public void addUsers() {
		for(int i = 0; i <= 20; i++) {
			User user = new User();
			user.setUsername("李四" + i);
			user.setSex("1");
			user.setBrithday(new Date());
			user.setAddress("广州北京路" + i + "号");
			userService.addUser(user);
			System.out.println("添加用户成功：" + i);
		}
	}
	
	/**
	 * 上传文件---需要导入tomcat包
	 * @return
	 */
	@RequestMapping("/uploadFile")
	public @ResponseBody Map<String, Object> uploadFile(@RequestParam("file") CommonsMultipartFile file, HttpServletRequest request) {
		Map<String, Object> result = new HashMap<>();
		// String basePath = request.getRequestURL().substring(0,request.getRequestURL().indexOf("user")) + "upload";
		String basePath = "E:/upload";
		// 防止文件重名	-- 使用时间戳加毫秒然后再加3个随机数
		String prePath = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss_SSS_").format(new Date());
		Random r = new Random();
		for (int i = 0; i < 3; i++) {
			prePath = prePath + r.nextInt(10);
		}
		File preFile = new File(basePath, prePath);
		if (!preFile.exists()) {
			preFile.mkdirs();
		}
		// 拼接真实路径
		String suffixPath = "/" + prePath + "/" + file.getOriginalFilename();
		String realPath = basePath + suffixPath;
		System.out.println("保存在数据库中的目录+名字" + suffixPath);
		File realFile = new File(realPath);
		try {
			// 通过CommonsMultipartFile的方法直接写文件
			file.transferTo(realFile);
			result.put("filePath", suffixPath);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}
	
}
