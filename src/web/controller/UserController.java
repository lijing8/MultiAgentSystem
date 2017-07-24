package web.controller;

import jade.wrapper.ControllerException;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import multiagent.utility.AgentStarter.Start;
import multiagent.utility.AgentStarter.StartCloud;
import multiagent.utility.AgentStarter.StartManu;
import multiagent.utility.AgentStarter.StartSale;
import multiagent.utility.AgentStarter.StartSupply;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import web.entity.UserEntity;
import web.service.UserService;
/**
 * 此类为用户管理Controller类,用注解@Controller 来标识该类是MVC架构中的控制类。
 * 访问路径用@RequestMapping(value="/information")来进行设置说明
 * @author hanyuping
 *
 */

@Controller
@RequestMapping(value="/agentsim")
public class UserController {
//	用注解来声明自定义ResultService类对象，自动将该类实例化
	@Autowired
	private UserService userService;

	//主页面，访问路径@RequestMapping(value="/index.html")来设置
	@RequestMapping(value="/index.html")
	public String pleaselog()throws ControllerException{
		return "/index";
	}

	/**
	 * 按用户ID查询 
	 * @param request 页面请求对象
	 * @param userID 用户ID
	 * @param password 用户密码
	 * @return 返回视图
	 * @throws Exception
	 */
	@SuppressWarnings("unused")
	@RequestMapping(value="getuser")	
	public ModelAndView getUser(HttpServletRequest request,String userID,
			 String password ) throws Exception{
//		将用户ID转换为UTF8编码格式
		userID = new String(userID.getBytes("iso8859-1"),"UTF-8");
		System.out.println(userID+":"+password);
//		声明视图对象，并对视图对象添加视图
		ModelAndView mav=new ModelAndView();
//		定义错误信息
		String error;
//判断用户ID是否为空
		if (userID!=null) {
//			声明UserEntity对象，调用userService成员方法，获得用户实体
			UserEntity user=userService.getUserByUsername(userID);		
//			判断查询结果是否为空
			if (user!=null) {
//				将用户密码中的空格去除
				String string=user.getUserPassword().replaceAll(" ", "");
//				判断密码是否与数据库总密码一致
				if (string.equals(password)) {
					//密码正确跳转到仿真界面
					mav.setViewName("/simulationmain");
					mav.addObject("userID",userID);
					mav.addObject("user",user);
					return mav;
				} else {
					System.out.println(user.getUserPassword()+"___"+password);
					error="密码不正确！！";
//					密码不正确返回错误视图
					mav.addObject("error", error);
					mav.setViewName("/index");
					return mav;		
				}
			} else {
				error="用户不存在！！请注册";
				mav.addObject("error", error);
				mav.setViewName("/index");
				return mav;	
			}
		}else {
//			信息不能为空，返回视图重新提交
			error="不能为空";
			mav.addObject("error", error);
			mav.setViewName("/index");
			return mav;	
		}



	}
	/**
	 * 获取所有用户，访问路径是	@RequestMapping(value="getalluser"
	 * @return
	 */
	@RequestMapping(value="getalluser")
	public ModelAndView getAllUser(@RequestParam(value="userID" ,required=false)String userID) {	
//		定义UseEntity对象列表，调用userService的getAllUser（）方法，获取所有用户列表
		List<UserEntity> rst = userService.getAllUser();
//		声明视图对象，并对视图对象添加视图
		ModelAndView ma = new ModelAndView();
//		设置视图
		ma.addObject("userID", userID);
		ma.setViewName("/alluserlist");//做了修改 by lijing
//		向视图添加参数
		ma.addObject("result", rst);
//		返回视图
		return ma;
	}

	/**
	 * 添加用户 访问路径为	@RequestMapping(value="/toadduser")
	 * @return 返回视图
	 */
	@RequestMapping(value="/toadduser")
	public ModelAndView toadduser(){
//		声明视图对象，并对视图对象添加视图
		ModelAndView ma = new ModelAndView();
//		设置视图对象
		ma.setViewName("/registerUser");
		return ma;
	}
	
	/**
	 * 用户注册，访问路径用@RequestMapping(value="/adduser")设置
	 * @param UserID 用户账号
	 * @param UserName 用户名称
	 * @param password 用户密码
	 * @param UserRole 角色
	 * @return 返回视图对象
	 */
	@RequestMapping(value="/adduser")
	public ModelAndView adduser(String UserID,String UserName,String password ,String UserRole ){
//		判断前台提交数据是否为空
		if(UserID==null || UserID.trim().length()==0||password==null || password.trim().length()==0){
//			声明视图对象，并对视图对象添加视图
			ModelAndView ma = new ModelAndView();
//			清空前台界面控件内容，让用户重新填写
			ma.setViewName("/registerUser");
			ma.addObject("error", "注册信息不能为空");
			ma.addObject("UserID",UserID);
			ma.addObject("password",password);
			return ma;
		}
//		调用userService中的userService
		userService.addUser(UserID, UserName, password, UserRole);
//		声明视图对象，并对视图对象添加视图
		ModelAndView mav = new ModelAndView();
		String error="注册成功，欢迎登陆";
//		向视图添加参数
		mav.addObject("error", error);
//		设置视图对象
		mav.setViewName("/index");
//		返回视图
		return mav;
	}
	
	/**
	 * 删除用户
	 */
	@RequestMapping(value="/delUser")
	public ModelAndView delUser(HttpServletRequest request,@RequestParam(value="userID" ,required=false)String userID){
		userService.delUser(userID);
		return getAllUser(userID);
	}
	
	
	/**
	 * 修改用户数据 ，通过@RequestMapping("/getEditUser")设置访问路径
	 * @param request 页面请求
	 * @param userID 用户ID
	 * @return 返回视图
	 */
	@RequestMapping("/getEditUser")
	public ModelAndView getEditUser(HttpServletRequest request,@RequestParam(value="userID" ,required=false)String userID){
//		声明UserEntity对象获取需要修改的用户实体数据
		UserEntity user = userService.getUser(userID);
//		设置请求参数
		request.setAttribute("user", user);
//		声明视图对象，并对视图对象添加视图
		ModelAndView mav = new ModelAndView();
//		设置视图对象
		mav.setViewName("/editUser");
//		向视图添加参数
		mav.addObject("userID",userID);
		return mav;
	}
	
	
	/**
	 * 修改用户数据
	 * @param request 页面请求对象
	 * @param user 用户对象
	 * @return 返回视图
	 */
	@RequestMapping(value="/updateUser")
	public ModelAndView updateUser(HttpServletRequest request, UserEntity user,@RequestParam(value="userID" ,required=false)String userID){
//		声明视图对象，并对视图对象添加视图
		ModelAndView mav = new ModelAndView();
//		判断是够更改完成
		if(userService.updateUser(user)){  
			user = userService.getUser(user.getUserID());  
			request.setAttribute("user", user); 
			mav.addObject("userID",userID);
//			设置视图对象
			mav.setViewName("/editUser");
			return mav ;  
		}else{ 
			mav.addObject("error", "信息修改有误");
//			设置视图对象
			mav.setViewName("/editUser");
			mav.addObject("userID",userID);
			return mav;

		}  
	}

	

}
