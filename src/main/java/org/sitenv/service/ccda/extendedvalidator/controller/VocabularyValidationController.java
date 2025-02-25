package org.sitenv.service.ccda.extendedvalidator.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.sitenv.service.ccda.extendedvalidator.view.CodeValidationRequestJsonView;
import org.sitenv.service.ccda.extendedvalidator.view.CodeValidationResultJsonView;
import org.sitenv.service.ccda.extendedvalidator.view.ValidationResponse;
import org.sitenv.service.ccda.extendedvalidator.view.ValueSetValidationRequestJsonView;
import org.sitenv.service.ccda.extendedvalidator.view.ValueSetValidationResultJsonView;
import org.sitenv.vocabularies.data.DisplayNameValidationResult;
import org.sitenv.vocabularies.data.ValueSetValidationResult;
import org.sitenv.vocabularies.engine.ValidationEngine;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VocabularyValidationController {
	
	private static Logger logger = Logger.getLogger(VocabularyValidationController.class);

	@RequestMapping(value = "/validateCode/{vocabulary}/{code}", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public ValidationResponse validateCode(@PathVariable String vocabulary, @PathVariable String code) {
		return new ValidationResponse(ValidationEngine.validateCode(vocabulary, code));
		// return "result: " + ValidationEngine.validateCode(vocabulary, code);
	}

	@RequestMapping(value = "/validateCodeByCodeSystemName/{vocabulary}/{code}", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public ValidationResponse validateCodeByCodeSystemName(@PathVariable String vocabulary, @PathVariable String code) {

		return new ValidationResponse(ValidationEngine.validateCodeByCodeSystemName(vocabulary, code));
	}

	@RequestMapping(value = "/validateName/{vocabulary}/{displayName}", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public ValidationResponse validateDisplayName(@PathVariable String vocabulary, @PathVariable String displayName) {

		return new ValidationResponse(ValidationEngine.validateDisplayName(vocabulary, displayName));
	}

	@RequestMapping(value = "/validateNameByCodeSystemName/{vocabulary}/{displayName}", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public ValidationResponse validateDisplayNameByCodeSystemName(@PathVariable String vocabulary,
			@PathVariable String displayName) {
		return new ValidationResponse(ValidationEngine.validateDisplayNameByCodeSystemName(vocabulary, displayName));
	}
	
	@RequestMapping(value="/validateValueSetCode/{valueSet}/{code}", method= RequestMethod.GET, produces="application/json; charset=utf-8")
	public String validateValueSetCode(@PathVariable String valueSet, @PathVariable String code) {
		
		return "result: " + ValidationEngine.validateValueSetCode(valueSet, code);
	}
	
	@RequestMapping(value="/validateValueSetCodeForCodeSystem/{valueSet}/{codeSystem}/{code}", method= RequestMethod.GET, produces="application/json; charset=utf-8")
	public String validateValueSetCodeForCodeSystem(@PathVariable String valueSet, @PathVariable String codeSystem, @PathVariable String code) {
		
		return "result: " + ValidationEngine.validateValueSetCodeForCodeSystem(valueSet, code, codeSystem);
	}
	
	@RequestMapping(value="/validateCodeList", method= RequestMethod.POST, produces="application/json; charset=utf-8")
	public @ResponseBody List<CodeValidationResultJsonView> validateCodeList(@RequestBody List<CodeValidationRequestJsonView> list, HttpServletRequest request, HttpServletResponse response) throws IOException {
	
		List<CodeValidationResultJsonView> results = new ArrayList<CodeValidationResultJsonView>();
		
		try
		{
	
			
			for (CodeValidationRequestJsonView vocabRequest : list) 
			{
				
				CodeValidationResultJsonView result = new CodeValidationResultJsonView();
				
				result.setRequest(vocabRequest);
				
				if (vocabRequest.getCodeSystem() != null && !vocabRequest.getCodeSystem().trim().equalsIgnoreCase(""))
				{
					if (vocabRequest.getCode() != null)
					{
						result.setCodeExists(ValidationEngine.validateCode(vocabRequest.getCodeSystem(), vocabRequest.getCode()));
					}
					if (vocabRequest.getDisplayName() != null)
					{
						result.setDisplayNameExists(ValidationEngine.validateDisplayName(vocabRequest.getCodeSystem(), vocabRequest.getDisplayName()));
					}
					if (vocabRequest.getCode() != null && vocabRequest.getDisplayName() != null)
					{
						DisplayNameValidationResult valResult = ValidationEngine.validateDisplayNameForCode(vocabRequest.getCodeSystem(), vocabRequest.getDisplayName(), vocabRequest.getCode());
						result.setDisplayNameMatchForCode(valResult.isResult());
						result.setDisplayNamesForCode(valResult.getActualDisplayName());
					}
				}
				else
				{
					if (vocabRequest.getCode() != null)
					{
						result.setCodeExists(ValidationEngine.validateCodeByCodeSystemName(vocabRequest.getCodeSystemName(), vocabRequest.getCode()));
					}
					if (vocabRequest.getDisplayName() != null)
					{
						result.setDisplayNameExists(ValidationEngine.validateDisplayNameByCodeSystemName(vocabRequest.getCodeSystemName(), vocabRequest.getDisplayName()));
					}
					if (vocabRequest.getCode() != null && vocabRequest.getDisplayName() != null)
					{
						DisplayNameValidationResult valResult = ValidationEngine.validateDisplayNameForCodeByCodeSystemName(vocabRequest.getCodeSystemName(), vocabRequest.getDisplayName(), vocabRequest.getCode());
						result.setDisplayNameMatchForCode(valResult.isResult());
						result.setDisplayNamesForCode(valResult.getActualDisplayName());}
				}
				
				results.add(result);
			}
		}
		catch (Exception e)
		{
			response.sendError(500);
		}
		return results;

	}

	
	@RequestMapping(value="/validateValueSetList", method= RequestMethod.POST, produces="application/json; charset=utf-8")
	public @ResponseBody List<ValueSetValidationResultJsonView> validateValueSetList(@RequestBody List<ValueSetValidationRequestJsonView> list, HttpServletRequest request, HttpServletResponse response) throws IOException {
	
		List<ValueSetValidationResultJsonView> results = new ArrayList<ValueSetValidationResultJsonView>();
		
		try
		{
	
			
			for (ValueSetValidationRequestJsonView vocabRequest : list) 
			{
				
				ValueSetValidationResultJsonView result = new ValueSetValidationResultJsonView();
				
				result.setRequest(vocabRequest);
				
				ValueSetValidationResult valResult = ValidationEngine.validateValueSetCode(vocabRequest.getValueSet(), vocabRequest.getCodeSystem(), vocabRequest.getCodeSystemName(), vocabRequest.getCode(), vocabRequest.getDisplayName());
				
				if (valResult != null)
				{
					result.setCodeExistsInCodeSystem(valResult.getCodeExistsInCodeSystem());
					result.setCodeExistsInValueSet(valResult.getCodeExistsInValueSet());
					result.setCodeSystemAndNameMatch(valResult.getCodeSystemAndNameMatch());
					result.setCodeSystemExistsInValueSet(valResult.getCodeSystemExistsInValueSet());
					result.setDescriptionExistsInCodeSystem(valResult.getDescriptionExistsInCodeSystem());
					result.setDescriptionExistsInValueSet(valResult.getDescriptionExistsInValueSet());
					result.setDescriptionMatchesCode(valResult.getDescriptionMatchesCode());
					result.setExpectedCodesForDescription(valResult.getExpectedCodesForDescription());
					result.setExpectedCodeSystemNamesForOid(valResult.getExpectedCodeSystemNamesForOid());
					result.setExpectedCodeSystemsForCode(valResult.getExpectedCodeSystemsForCode());
					result.setExpectedCodeSystemsForValueSet(valResult.getExpectedCodeSystemsForValueSet());
					result.setExpectedDescriptionsForCode(valResult.getExpectedDescriptionsForCode());
					result.setExpectedOidsForCodeSystemName(valResult.getExpectedOidsForCodeSystemName());
					result.setValueSetNames(valResult.getValueSetNames());
				}
				
				results.add(result);
			}
		}
		catch (Exception e)
		{
			response.sendError(500);
		}
		return results;

	}

	
}
