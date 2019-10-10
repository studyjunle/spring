package com.springmvc.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springmvc.domain.User;
import com.springmvc.domain.UserCustomer;
import com.springmvc.service.UserService;

@Controller
// <bean id="userController" class="UserController路径"/>
@RequestMapping("/user")
// 类似命名空间 根路径用来隔离
public class UserController {

	@RequestMapping("/hello")
	// 请求的地址 http://localhost:8083/springmvc/hello.do 默认为get请求和post请求
	/**
	 * @RequestMapping(value="/hello", method=RequestMethod.GET) 指定请求为get方式或者POST	
	 * @RequestMapping(value="/hello", method={RequestMethod.GET, RequestMethod.POST})	同时指定
	 * get请求和post请求的区别：
	 * 	post请求仅在ajax或者表单中或者其他指定的地方中
	 * 	get请求在任意地方，例如url,a标签等等
	 */
	public String myHello() {

		return "hello"; // 返回的逻辑视图名称xxx/hello.jsp
	}

	// 封装参数 springmvc会自动将参数封装

	// 接收int参数 参数名必须一致为id
	@RequestMapping("/receiveInt")
	public String receiveInt(Integer id) {
		System.out.println(id);
		return "hello";
	}

	// 接收String参数
	@RequestMapping("/receiveString")
	public String receiveString(String username) {
		System.out.println(username);
		return "hello";
	}

	// 接收对象POJO javaBean
	@RequestMapping("/receiveUser")
	public String receiveObject(User user) {
		System.out.println(user.getUsername() + "====" + user.getSex());
		return "hello";
	}

	// 接收包装类
	@RequestMapping("/receiveUserCustomer")
	public String receiveUserCustomer(UserCustomer userCustomer) {
		System.out.println(userCustomer);
		return "hello";
	}

	// 接收数组 批量删除等
	@RequestMapping("/receiveArray")
	public String receiveArray(Integer[] ids) {
		System.out.println(Arrays.toString(ids));
		return "hello";
	}

	// 接收list或者map集合的参数，不能直接传，只能利用包装类来传
	@RequestMapping("/receiveList")
	public String receiveList(UserCustomer userCustomer) {
		System.out.println(userCustomer);
		return "hello";
	}

	// 接收list或者map集合的参数，不能直接传，只能利用包装类来传
	@RequestMapping("/receiveMap")
	public String receiveMap(UserCustomer userCustomer) {
		System.out.println(userCustomer);
		return "hello";
	}

	// springmvc使用Model对象，Model对象相当于applicaiton 用el表达式获取

	// 页面回显 使用Model
	@RequestMapping("list")
	public String list(Model model) {
		List<User> findUserList = new ArrayList<User>();

		User u1 = new User();
		u1.setUsername("张三");
		u1.setSex("男");
		u1.setId(1);

		User u2 = new User();
		u2.setUsername("李四");
		u2.setSex("女");
		u2.setId(2);

		User u3 = new User();
		u3.setUsername("王五");
		u3.setSex("男");
		u3.setId(3);

		findUserList.add(u1);
		findUserList.add(u2);
		findUserList.add(u3);

		model.addAttribute("findUserList", findUserList);

		return "hello";

	}

	// url模板映射 Restfull软件架构设计模式：使请求更加简洁，更安全，方便于搜索引擎收录

	// 普通模式修改	// http://localhost:8083/springmvc/user/update1.do/id=1
	@RequestMapping("/update1")	
	public String update1(Integer id) {

		System.out.println(id);

		return "redirect:list.do";
	}

	// Restfull风格架构	暴露到外面 使用没有扩展名 http://localhost:8083/springmvc/rest/user/update/1
	/**
	 * url模板映射的主要功能
	 * 	请求参数映射到${id}
	 * 	${id}通过注解@PathVariable把{id}传递给方法中的id
	 *  利用servlet拦截请求目录的功能，实现无扩展名访问，就是Restfull风格
	 */
	@RequestMapping("/update/{id}")
	public String update(@PathVariable Integer id) {

		System.out.println(id);
		
		// redirect:/user/list.do重定向
		return "redirect:/user/list.do";
	}
	
	// @RequestParam的简单使用	
	// defaultValue当没有在页面传递参数值时默认值为333
	// value表示在页面传递参数的name，也就是别名(写了就不能用id了)
	// required=true表示必须传递
	@RequestMapping("/requestParamInt")
	public String requestParamInt(@RequestParam(defaultValue="333", value="sid", required=true) Integer id) {
		System.out.println(id);
		return "hello";
	}
	
	// 转发和重定向
	/**
	 * 本类转发 return "forward:list.do"
	 * 本类转发 return "forward:/user/list.do"
	 * 
	 * 跨类转发 return "forward:/items/list.do"
	 * 
	 * 重定向与转发一样，将forward改为redirect
	 */
	
	/**
	 * 提供Json数据支持
	 * requestBody 把前台页面传递json格式数据强制转换为JavaBean
	 * reponseBody 在后台把javaBean转换为json格式的数据返回页面
	 * 需要依赖jackson的jar
	 */
	
	// 接收json格式的数据，使用RequestBody把json格式的数据封装到User对象中
	// 返回User对象，使用ResponseBody把User对象转出Json对象
	@RequestMapping("/requestJson")
	public @ResponseBody User requestJson(@RequestBody User user) {
		System.out.println(user);
		return user;
	}
	
	// 请求pojo返回json数据
	@RequestMapping("/requestPojo")
	public @ResponseBody User requestPojo(User user) {
		System.out.println(user);
		return user;
	}
	
	//-------------整合mybatis---------------------
	@Resource
	private UserService userService;
	
	// 查询所有用户
	@RequestMapping("/findAllUser")
	public String findAllUser(Model model) {
		List<User> findAllUserList = userService.findAllUser();
		model.addAttribute("findAllUserList", findAllUserList);
		return "hello";
		
	}
}
