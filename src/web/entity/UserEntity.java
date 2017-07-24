package web.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * 此类为用户实体类，实体属性及set和get方法
 * 实现关系数据库向实体类的映射。用@entity 来标识
 * 用@Table(name="t_user")标识与之对应的关系数据库中的表，如果数据库中没有此表，
 * 创建一个name指定的表
 * @author hanyuping
 *
 */

@Entity
@Table(name="t_user")
public class UserEntity {
//	定义类成员变量并与数据库表中的属性相对应，并指定该成员变量为主键
	
	@Id
	@Column(name="UserID")
	private String userID;
	
//	定义类成员变量并与数据库表中的属性相对应
	
	@Column(name="UserName")
	private String userName;
	
//	定义类成员变量并与数据库表中的属性相对应
	@Column(name="UserPassword")
	private String userPassword;
	
//	定义类成员变量并与数据库表中的属性相对应
	@Column(name="UserRole")
	private String userRole;

	//使用Set和get函数对成员变量进行设置
	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	


	
}
