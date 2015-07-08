package org.sitenv.service.ccda.extendedvalidator.controller;

import org.sitenv.vocabularies.engine.ValidationEngine;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VocabularyValidationController {
	
	
	
	@RequestMapping(value="/validateCode/{vocabulary}/{code}", method= RequestMethod.GET, produces="application/json; charset=utf-8")
	public String validateCode(@PathVariable String vocabulary, @PathVariable String code) {
		
		return "result: " + ValidationEngine.validateCode(vocabulary, code);
	}
	
	@RequestMapping(value="/validateCodeByCodeSystemName/{vocabulary}/{code}", method= RequestMethod.GET, produces="application/json; charset=utf-8")
	public String validateCodeByCodeSystemName(@PathVariable String vocabulary, @PathVariable String code) {
		
		return "result: " + ValidationEngine.validateCodeByCodeSystemName(vocabulary, code);
	}
	
	@RequestMapping(value="/validateName/{vocabulary}/{displayName}", method= RequestMethod.GET, produces="application/json; charset=utf-8")
	public String validateDisplayName(@PathVariable String vocabulary, @PathVariable String displayName) {
		
		return "result: " + ValidationEngine.validateDisplayName(vocabulary, displayName);
	}
	
	@RequestMapping(value="/validateNameByCodeSystemName/{vocabulary}/{displayName}", method= RequestMethod.GET, produces="application/json; charset=utf-8")
	public String validateDisplayNameByCodeSystemName(@PathVariable String vocabulary, @PathVariable String displayName) {
		
		return "result: " + ValidationEngine.validateDisplayNameByCodeSystemName(vocabulary, displayName);
	}

}
