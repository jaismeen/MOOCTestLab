package org.mytestlab.service;

import java.util.ArrayList;
import java.util.List;

import org.mytestlab.domain.GenericNode;
import org.mytestlab.domain.Transition;
import org.mytestlab.repository.GenericNodeRepository;
import org.mytestlab.repository.TransitionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.conversion.EndResult;
import org.springframework.stereotype.Service;

@Service
public class GenericNodeService {

	@Autowired
	private GenericNodeRepository genericNodeRepository;
	
	@Autowired
	private TransitionRepository transitionRepository;
	
	public GenericNode create(GenericNode node) {
		GenericNode existingNode = genericNodeRepository.findByName(node.getName());

		if (existingNode != null) {
			throw new RuntimeException("Node Record already exists!");
		}
		
		System.out.println("Before find in transition repository");
		
		Transition existingTrans = transitionRepository.findByName(node.getOutgoingRelationship().getName());

		if (existingTrans != null) { //use existing transition
			
			System.out.println("setOutgoingRelationship");
			
			node.setOutgoingRelationship(existingTrans);
		} else {
			//keep the one we set before.
			
			System.out.println("node.getOutgoingRelationship()");
			
			//Transition trans2 = node.getOutgoingRelationship();
			
			System.out.println("transitionRepository.save");
			
		
		node.getOutgoingRelationship().setStartNode(node);
		
		node.getOutgoingRelationship().setEndNode(node);
		
		for (Transition tra: node.getIncomingRelationship()) {
			tra.setStartNode(node);
			tra.setEndNode(node);
		}

		//transitionRepository.save(node.getOutgoingRelationship());
		}
		System.out.println("Set Start Node "+node.getDescription()+" "+node.getName()+" "+node.getId()+" "+node.getOutgoingRelationship());
		Transition trans3 = node.getOutgoingRelationship();
		System.out.println("Transition properties "+trans3.getName()+" "+trans3.getId()+" "+trans3.getEndNode()+" "+trans3.getStartNode());
		
		return genericNodeRepository.save(node);
		
		//return new GenericNode();
	}
	
	public GenericNode read(GenericNode node) {
		return node;
	}
	
	public List<GenericNode> readAll() {
		List<GenericNode> nodes = new ArrayList<GenericNode>();
		
		EndResult<GenericNode> results = genericNodeRepository.findAll();
		for (GenericNode r: results) {
			nodes.add(r);
		}
		
		return nodes;
	}
	
	public GenericNode update(GenericNode node) {
		GenericNode existingNode = genericNodeRepository.findByName(node.getName());
		
		if (existingNode == null) {
			return null;
		}
		
		existingNode.setDescription(node.getDescription());
		//existingNode.setId(node.getId());
		existingNode.setName(node.getName());
		//existingNode.addIncomingRelationship(node.getIncomingRelationship());
		existingNode.setOutgoingRelationship(node.getOutgoingRelationship());
		
		//for(Transition tran : existingNode.getIncomingRelationship()){
		//	transitionRepository.save(tran);
		//}
		
		transitionRepository.save(existingNode.getOutgoingRelationship());

		return genericNodeRepository.save(existingNode);
	}
	
	public Boolean delete(GenericNode node) {
		GenericNode existingNode = genericNodeRepository.findByName(node.getName());
		
		if (existingNode == null) {
			return false;
		}
		
		genericNodeRepository.delete(existingNode);
		return true;
	}
}
