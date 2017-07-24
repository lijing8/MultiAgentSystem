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
 * ����Ϊ�û�����Controller��,��ע��@Controller ����ʶ������MVC�ܹ��еĿ����ࡣ
 * ����·����@RequestMapping(value="/information")����������˵��
 * @author hanyuping
 *
 */

@Controller
@RequestMapping(value="/agentsim")
public class UserController {
//	��ע���������Զ���ResultService������Զ�������ʵ����
	@Autowired
	private UserService userService;

	//��ҳ�棬����·��@RequestMapping(value="/index.html")������
	@RequestMapping(value="/index.html")
	public String pleaselog()throws ControllerException{
		return "/index";
	}

	/**
	 * ���û�ID��ѯ 
	 * @param request ҳ���������
	 * @param userID �û�ID
	 * @param password �û�����
	 * @return ������ͼ
	 * @throws Exception
	 */
	@SuppressWarnings("unused")
	@RequestMapping(value="getuser")	
	public ModelAndView getUser(HttpServletRequest request,String userID,
			 String password ) throws Exception{
//		���û�IDת��ΪUTF8�����ʽ
		userID = new String(userID.getBytes("iso8859-1"),"UTF-8");
		System.out.println(userID+":"+password);
//		������ͼ���󣬲�����ͼ���������ͼ
		ModelAndView mav=new ModelAndView();
//		���������Ϣ
		String error;
//�ж��û�ID�Ƿ�Ϊ��
		if (userID!=null) {
//			����UserEntity���󣬵���userService��Ա����������û�ʵ��
			UserEntity user=userService.getUserByUsername(userID);		
//			�жϲ�ѯ����Ƿ�Ϊ��
			if (user!=null) {
//				���û������еĿո�ȥ��
				String string=user.getUserPassword().replaceAll(" ", "");
//				�ж������Ƿ������ݿ�������һ��
				if (string.equals(password)) {
					//������ȷ��ת���������
					mav.setViewName("/simulationmain");
					mav.addObject("userID",userID);
					mav.addObject("user",user);
					return mav;
				} else {
					System.out.println(user.getUserPassword()+"___"+password);
					error="���벻��ȷ����";
//					���벻��ȷ���ش�����ͼ
					mav.addObject("error", error);
					mav.setViewName("/index");
					return mav;		
				}
			} else {
				error="�û������ڣ�����ע��";
				mav.addObject("error", error);
				mav.setViewName("/index");
				return mav;	
			}
		}else {
//			��Ϣ����Ϊ�գ�������ͼ�����ύ
			error="����Ϊ��";
			mav.addObject("error", error);
			mav.setViewName("/index");
			return mav;	
		}



	}
	/**
	 * ��ȡ�����û�������·����	@RequestMapping(value="getalluser"
	 * @return
	 */
	@RequestMapping(value="getalluser")
	public ModelAndView getAllUser(@RequestParam(value="userID" ,required=false)String userID) {	
//		����UseEntity�����б�����userService��getAllUser������������ȡ�����û��б�
		List<UserEntity> rst = userService.getAllUser();
//		������ͼ���󣬲�����ͼ���������ͼ
		ModelAndView ma = new ModelAndView();
//		������ͼ
		ma.addObject("userID", userID);
		ma.setViewName("/alluserlist");//�����޸� by lijing
//		����ͼ��Ӳ���
		ma.addObject("result", rst);
//		������ͼ
		return ma;
	}

	/**
	 * ����û� ����·��Ϊ	@RequestMapping(value="/toadduser")
	 * @return ������ͼ
	 */
	@RequestMapping(value="/toadduser")
	public ModelAndView toadduser(){
//		������ͼ���󣬲�����ͼ���������ͼ
		ModelAndView ma = new ModelAndView();
//		������ͼ����
		ma.setViewName("/registerUser");
		return ma;
	}
	
	/**
	 * �û�ע�ᣬ����·����@RequestMapping(value="/adduser")����
	 * @param UserID �û��˺�
	 * @param UserName �û�����
	 * @param password �û�����
	 * @param UserRole ��ɫ
	 * @return ������ͼ����
	 */
	@RequestMapping(value="/adduser")
	public ModelAndView adduser(String UserID,String UserName,String password ,String UserRole ){
//		�ж�ǰ̨�ύ�����Ƿ�Ϊ��
		if(UserID==null || UserID.trim().length()==0||password==null || password.trim().length()==0){
//			������ͼ���󣬲�����ͼ���������ͼ
			ModelAndView ma = new ModelAndView();
//			���ǰ̨����ؼ����ݣ����û�������д
			ma.setViewName("/registerUser");
			ma.addObject("error", "ע����Ϣ����Ϊ��");
			ma.addObject("UserID",UserID);
			ma.addObject("password",password);
			return ma;
		}
//		����userService�е�userService
		userService.addUser(UserID, UserName, password, UserRole);
//		������ͼ���󣬲�����ͼ���������ͼ
		ModelAndView mav = new ModelAndView();
		String error="ע��ɹ�����ӭ��½";
//		����ͼ��Ӳ���
		mav.addObject("error", error);
//		������ͼ����
		mav.setViewName("/index");
//		������ͼ
		return mav;
	}
	
	/**
	 * ɾ���û�
	 */
	@RequestMapping(value="/delUser")
	public ModelAndView delUser(HttpServletRequest request,@RequestParam(value="userID" ,required=false)String userID){
		userService.delUser(userID);
		return getAllUser(userID);
	}
	
	
	/**
	 * �޸��û����� ��ͨ��@RequestMapping("/getEditUser")���÷���·��
	 * @param request ҳ������
	 * @param userID �û�ID
	 * @return ������ͼ
	 */
	@RequestMapping("/getEditUser")
	public ModelAndView getEditUser(HttpServletRequest request,@RequestParam(value="userID" ,required=false)String userID){
//		����UserEntity�����ȡ��Ҫ�޸ĵ��û�ʵ������
		UserEntity user = userService.getUser(userID);
//		�����������
		request.setAttribute("user", user);
//		������ͼ���󣬲�����ͼ���������ͼ
		ModelAndView mav = new ModelAndView();
//		������ͼ����
		mav.setViewName("/editUser");
//		����ͼ��Ӳ���
		mav.addObject("userID",userID);
		return mav;
	}
	
	
	/**
	 * �޸��û�����
	 * @param request ҳ���������
	 * @param user �û�����
	 * @return ������ͼ
	 */
	@RequestMapping(value="/updateUser")
	public ModelAndView updateUser(HttpServletRequest request, UserEntity user,@RequestParam(value="userID" ,required=false)String userID){
//		������ͼ���󣬲�����ͼ���������ͼ
		ModelAndView mav = new ModelAndView();
//		�ж��ǹ��������
		if(userService.updateUser(user)){  
			user = userService.getUser(user.getUserID());  
			request.setAttribute("user", user); 
			mav.addObject("userID",userID);
//			������ͼ����
			mav.setViewName("/editUser");
			return mav ;  
		}else{ 
			mav.addObject("error", "��Ϣ�޸�����");
//			������ͼ����
			mav.setViewName("/editUser");
			mav.addObject("userID",userID);
			return mav;

		}  
	}

	

}
