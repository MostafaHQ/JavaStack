package com.mostafa.dojoninja.services;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.mostafa.dojoninja.models.Dojo;
import com.mostafa.dojoninja.repositories.DojoRepository;


@Service
public class DojoService {

	private final DojoRepository dojoRepository;

	public DojoService(DojoRepository dojoRepository) {
		this.dojoRepository = dojoRepository;
	}
	
	public List<Dojo> allDojo(){
		return dojoRepository.findAll();
	}	
	
	public Dojo createDojo(Dojo dojo) {
        return dojoRepository.save(dojo);
    
	}
	
	public Dojo findDojo(Long id) {
		Optional<Dojo> optionalDojo = dojoRepository.findById(id);
        if(optionalDojo.isPresent()) {
            return optionalDojo.get();
        } else {
            return null;
        }
    }
}
