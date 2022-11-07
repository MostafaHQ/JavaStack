package com.mostafa.languages.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mostafa.languages.models.Language;
import com.mostafa.languages.repositories.LanguageRepository;


@Service
public class LangaugeService {
	
	private final LanguageRepository languageRepository;

	public LangaugeService(LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}
	
	public List<Language> allLanguages(){
		return languageRepository.findAll();
	}
	
	public Language createLanguage(Language language) {
        return languageRepository.save(language);
}
	
	public Language findLanguage(Long id) {
		Optional<Language> optionalLanguage = languageRepository.findById(id);
        if(optionalLanguage.isPresent()) {
            return optionalLanguage.get();
        } else {
            return null;
        }
    }
	
	public Language updateExpense(Language language) {
    	return languageRepository.save(language);
    }
	
	public void delete(Long id) {
		languageRepository.deleteById(id);
	}
}
