package org.mytestlab.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.mytestlab.domain.GenericNode;
import org.mytestlab.domain.Transition;

public class GenericNodeMapper {

	public static GenericNodeDto map(GenericNode node) {
		GenericNodeDto dto = new GenericNodeDto();
		
		
		System.out.println("in map()");
		
		
		dto.setId(node.getId());
		dto.setDescription(node.getDescription());
		dto.setName(node.getName());
		//dto.setIncomingRelationships(node.getTransitionlationship());
		
		Set<Transition> rels = node.getIncomingRelationship();
		List<String> newRels = new ArrayList<String>();
		if (rels.size() > 0){
			for (Transition tra: rels){
				newRels.add(tra.getName());
			}
			
			System.out.println("Incoming relationship is not empty.");
			
			dto.setIncomingRelationships(newRels);
		}
		if (node.getOutgoingRelationship() != null){
			
			System.out.println("Outgoing relationship is not empty.");
			
			dto.setOutgoingRelationship(node.getOutgoingRelationship().getName());
		}
		System.out.println("out map()");
		
		return dto;
}

public static List<GenericNodeDto> map(List<GenericNode> nodes) {
	List<GenericNodeDto> dtos = new ArrayList<GenericNodeDto>();
	for (GenericNode node: nodes) {
		dtos.add(map(node));
	}
	return dtos;
}
}
