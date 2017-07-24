package web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.dao.AgentDAO;
import web.entity.AgentEntity;



@Service
public class AgentService {

	@Autowired
	private AgentDAO agentDAO;
	
	public AgentEntity getAgentByAgentID(String AgentID){
		return agentDAO.getAgentByAgentID(AgentID);
	}
	public List<AgentEntity> getAllAgent() {
		return agentDAO.getAllAgent();
	}
	
	public void addAgent(String agentID,String agentName,String agentRole,String agentAddress){
		AgentEntity agentEntity=new AgentEntity();
		agentEntity.setAgentID(agentID);
		agentEntity.setAgentName(agentName);
		agentEntity.setAgentRole(agentRole);
		agentEntity.setAgentAddress(agentAddress);
		agentDAO.addAgent(agentEntity);
	}
	public boolean delAgent(String agentid){
		return agentDAO.delAgent(agentid);
	}
	public boolean updataAgent(AgentEntity AgentEntity){
		return agentDAO.updataAgent(AgentEntity);
	}
}
