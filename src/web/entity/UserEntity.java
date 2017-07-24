package web.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * ����Ϊ�û�ʵ���࣬ʵ�����Լ�set��get����
 * ʵ�ֹ�ϵ���ݿ���ʵ�����ӳ�䡣��@entity ����ʶ
 * ��@Table(name="t_user")��ʶ��֮��Ӧ�Ĺ�ϵ���ݿ��еı�������ݿ���û�д˱�
 * ����һ��nameָ���ı�
 * @author hanyuping
 *
 */

@Entity
@Table(name="t_user")
public class UserEntity {
//	�������Ա�����������ݿ���е��������Ӧ����ָ���ó�Ա����Ϊ����
	
	@Id
	@Column(name="UserID")
	private String userID;
	
//	�������Ա�����������ݿ���е��������Ӧ
	
	@Column(name="UserName")
	private String userName;
	
//	�������Ա�����������ݿ���е��������Ӧ
	@Column(name="UserPassword")
	private String userPassword;
	
//	�������Ա�����������ݿ���е��������Ӧ
	@Column(name="UserRole")
	private String userRole;

	//ʹ��Set��get�����Գ�Ա������������
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
