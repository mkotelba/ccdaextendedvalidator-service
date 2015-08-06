package org.sitenv.service.ccda.extendedvalidator.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class ValueSetValidationResultJsonView {
	
	private ValueSetValidationRequestJsonView request;

	private List<String> valueSetNames = new ArrayList<String>();
	
	private Set<String> expectedDescriptionsForCode = new TreeSet<String>();
	private Set<String> expectedCodeSystemNamesForOid = new TreeSet<String>();
	private Set<String> expectedOidsForCodeSystemName = new TreeSet<String>();
	private Set<String> expectedCodesForDescription = new TreeSet<String>();
	private Set<String> expectedCodeSystemsForCode = new TreeSet<String>();
	private Set<String> expectedCodeSystemsForValueSet = new TreeSet<String>();
	
	private Boolean codeExistsInValueSet = false;
	private Boolean codeExistsInCodeSystem = false;

	private Boolean descriptionExistsInValueSet = false;
	private Boolean descriptionExistsInCodeSystem = false;
	private Boolean descriptionMatchesCode = false;
	
	private Boolean codeSystemAndNameMatch = false;
	private Boolean codeSystemExistsInValueSet = false;
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((codeExistsInCodeSystem == null) ? 0
						: codeExistsInCodeSystem.hashCode());
		result = prime
				* result
				+ ((codeExistsInValueSet == null) ? 0 : codeExistsInValueSet
						.hashCode());
		result = prime
				* result
				+ ((codeSystemAndNameMatch == null) ? 0
						: codeSystemAndNameMatch.hashCode());
		result = prime
				* result
				+ ((codeSystemExistsInValueSet == null) ? 0
						: codeSystemExistsInValueSet.hashCode());
		result = prime
				* result
				+ ((descriptionExistsInCodeSystem == null) ? 0
						: descriptionExistsInCodeSystem.hashCode());
		result = prime
				* result
				+ ((descriptionExistsInValueSet == null) ? 0
						: descriptionExistsInValueSet.hashCode());
		result = prime
				* result
				+ ((descriptionMatchesCode == null) ? 0
						: descriptionMatchesCode.hashCode());
		result = prime
				* result
				+ ((expectedCodeSystemNamesForOid == null) ? 0
						: expectedCodeSystemNamesForOid.hashCode());
		result = prime
				* result
				+ ((expectedCodeSystemsForCode == null) ? 0
						: expectedCodeSystemsForCode.hashCode());
		result = prime
				* result
				+ ((expectedCodeSystemsForValueSet == null) ? 0
						: expectedCodeSystemsForValueSet.hashCode());
		result = prime
				* result
				+ ((expectedCodesForDescription == null) ? 0
						: expectedCodesForDescription.hashCode());
		result = prime
				* result
				+ ((expectedDescriptionsForCode == null) ? 0
						: expectedDescriptionsForCode.hashCode());
		result = prime
				* result
				+ ((expectedOidsForCodeSystemName == null) ? 0
						: expectedOidsForCodeSystemName.hashCode());
		result = prime * result + ((request == null) ? 0 : request.hashCode());
		result = prime * result
				+ ((valueSetNames == null) ? 0 : valueSetNames.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ValueSetValidationResultJsonView other = (ValueSetValidationResultJsonView) obj;
		if (codeExistsInCodeSystem == null) {
			if (other.codeExistsInCodeSystem != null)
				return false;
		} else if (!codeExistsInCodeSystem.equals(other.codeExistsInCodeSystem))
			return false;
		if (codeExistsInValueSet == null) {
			if (other.codeExistsInValueSet != null)
				return false;
		} else if (!codeExistsInValueSet.equals(other.codeExistsInValueSet))
			return false;
		if (codeSystemAndNameMatch == null) {
			if (other.codeSystemAndNameMatch != null)
				return false;
		} else if (!codeSystemAndNameMatch.equals(other.codeSystemAndNameMatch))
			return false;
		if (codeSystemExistsInValueSet == null) {
			if (other.codeSystemExistsInValueSet != null)
				return false;
		} else if (!codeSystemExistsInValueSet
				.equals(other.codeSystemExistsInValueSet))
			return false;
		if (descriptionExistsInCodeSystem == null) {
			if (other.descriptionExistsInCodeSystem != null)
				return false;
		} else if (!descriptionExistsInCodeSystem
				.equals(other.descriptionExistsInCodeSystem))
			return false;
		if (descriptionExistsInValueSet == null) {
			if (other.descriptionExistsInValueSet != null)
				return false;
		} else if (!descriptionExistsInValueSet
				.equals(other.descriptionExistsInValueSet))
			return false;
		if (descriptionMatchesCode == null) {
			if (other.descriptionMatchesCode != null)
				return false;
		} else if (!descriptionMatchesCode.equals(other.descriptionMatchesCode))
			return false;
		if (expectedCodeSystemNamesForOid == null) {
			if (other.expectedCodeSystemNamesForOid != null)
				return false;
		} else if (!expectedCodeSystemNamesForOid
				.equals(other.expectedCodeSystemNamesForOid))
			return false;
		if (expectedCodeSystemsForCode == null) {
			if (other.expectedCodeSystemsForCode != null)
				return false;
		} else if (!expectedCodeSystemsForCode
				.equals(other.expectedCodeSystemsForCode))
			return false;
		if (expectedCodeSystemsForValueSet == null) {
			if (other.expectedCodeSystemsForValueSet != null)
				return false;
		} else if (!expectedCodeSystemsForValueSet
				.equals(other.expectedCodeSystemsForValueSet))
			return false;
		if (expectedCodesForDescription == null) {
			if (other.expectedCodesForDescription != null)
				return false;
		} else if (!expectedCodesForDescription
				.equals(other.expectedCodesForDescription))
			return false;
		if (expectedDescriptionsForCode == null) {
			if (other.expectedDescriptionsForCode != null)
				return false;
		} else if (!expectedDescriptionsForCode
				.equals(other.expectedDescriptionsForCode))
			return false;
		if (expectedOidsForCodeSystemName == null) {
			if (other.expectedOidsForCodeSystemName != null)
				return false;
		} else if (!expectedOidsForCodeSystemName
				.equals(other.expectedOidsForCodeSystemName))
			return false;
		if (request == null) {
			if (other.request != null)
				return false;
		} else if (!request.equals(other.request))
			return false;
		if (valueSetNames == null) {
			if (other.valueSetNames != null)
				return false;
		} else if (!valueSetNames.equals(other.valueSetNames))
			return false;
		return true;
	}
	public ValueSetValidationRequestJsonView getRequest() {
		return request;
	}
	public void setRequest(ValueSetValidationRequestJsonView request) {
		this.request = request;
	}
	public List<String> getValueSetNames() {
		return valueSetNames;
	}
	public void setValueSetNames(List<String> valueSetNames) {
		this.valueSetNames = valueSetNames;
	}
	public Set<String> getExpectedDescriptionsForCode() {
		return expectedDescriptionsForCode;
	}
	public void setExpectedDescriptionsForCode(
			Set<String> expectedDescriptionsForCode) {
		this.expectedDescriptionsForCode = expectedDescriptionsForCode;
	}
	public Set<String> getExpectedCodeSystemNamesForOid() {
		return expectedCodeSystemNamesForOid;
	}
	public void setExpectedCodeSystemNamesForOid(
			Set<String> expectedCodeSystemNamesForOid) {
		this.expectedCodeSystemNamesForOid = expectedCodeSystemNamesForOid;
	}
	public Set<String> getExpectedOidsForCodeSystemName() {
		return expectedOidsForCodeSystemName;
	}
	public void setExpectedOidsForCodeSystemName(
			Set<String> expectedOidsForCodeSystemName) {
		this.expectedOidsForCodeSystemName = expectedOidsForCodeSystemName;
	}
	public Set<String> getExpectedCodesForDescription() {
		return expectedCodesForDescription;
	}
	public void setExpectedCodesForDescription(
			Set<String> expectedCodesForDescription) {
		this.expectedCodesForDescription = expectedCodesForDescription;
	}
	public Set<String> getExpectedCodeSystemsForCode() {
		return expectedCodeSystemsForCode;
	}
	public void setExpectedCodeSystemsForCode(Set<String> expectedCodeSystemsForCode) {
		this.expectedCodeSystemsForCode = expectedCodeSystemsForCode;
	}
	public Set<String> getExpectedCodeSystemsForValueSet() {
		return expectedCodeSystemsForValueSet;
	}
	public void setExpectedCodeSystemsForValueSet(
			Set<String> expectedCodeSystemsForValueSet) {
		this.expectedCodeSystemsForValueSet = expectedCodeSystemsForValueSet;
	}
	public Boolean getCodeExistsInValueSet() {
		return codeExistsInValueSet;
	}
	public void setCodeExistsInValueSet(Boolean codeExistsInValueSet) {
		this.codeExistsInValueSet = codeExistsInValueSet;
	}
	public Boolean getCodeExistsInCodeSystem() {
		return codeExistsInCodeSystem;
	}
	public void setCodeExistsInCodeSystem(Boolean codeExistsInCodeSystem) {
		this.codeExistsInCodeSystem = codeExistsInCodeSystem;
	}
	public Boolean getDescriptionExistsInValueSet() {
		return descriptionExistsInValueSet;
	}
	public void setDescriptionExistsInValueSet(Boolean descriptionExistsInValueSet) {
		this.descriptionExistsInValueSet = descriptionExistsInValueSet;
	}
	public Boolean getDescriptionExistsInCodeSystem() {
		return descriptionExistsInCodeSystem;
	}
	public void setDescriptionExistsInCodeSystem(
			Boolean descriptionExistsInCodeSystem) {
		this.descriptionExistsInCodeSystem = descriptionExistsInCodeSystem;
	}
	public Boolean getDescriptionMatchesCode() {
		return descriptionMatchesCode;
	}
	public void setDescriptionMatchesCode(Boolean descriptionMatchesCode) {
		this.descriptionMatchesCode = descriptionMatchesCode;
	}
	public Boolean getCodeSystemAndNameMatch() {
		return codeSystemAndNameMatch;
	}
	public void setCodeSystemAndNameMatch(Boolean codeSystemAndNameMatch) {
		this.codeSystemAndNameMatch = codeSystemAndNameMatch;
	}
	public Boolean getCodeSystemExistsInValueSet() {
		return codeSystemExistsInValueSet;
	}
	public void setCodeSystemExistsInValueSet(Boolean codeSystemExistsInValueSet) {
		this.codeSystemExistsInValueSet = codeSystemExistsInValueSet;
	}
	
	
	
	
	
	
	
}
