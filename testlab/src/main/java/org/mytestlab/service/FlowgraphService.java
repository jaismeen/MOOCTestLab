package org.mytestlab.service;

import org.mytestlab.domain.FlowGraph;
import org.mytestlab.repository.FlowGraphRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlowgraphService {
	
	@Autowired
	private FlowGraphRepository flowGraphRepository;
	
	public FlowGraph create(FlowGraph fg) {
		
		return flowGraphRepository.save(fg);
	}
	
	public FlowGraph read(String name) {
		
		return flowGraphRepository.findByName(name);
	}
}
