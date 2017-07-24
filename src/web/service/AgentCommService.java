package web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.dao.AgentCommDAO;
import web.entity.AgentCommEntity;


@Service
public class AgentCommService {
	@Autowired
	private AgentCommDAO agentCommDAO = new AgentCommDAO();
	public List<AgentCommEntity> getAllAgentComm() {
		return agentCommDAO.getAllAgentComm();
	}
}
