package org.sitenv.service.ccda.extendedvalidator.view;

import java.io.Serializable;

public class VocabularyValidationRequestJsonView implements Serializable{

	private String codeSystem;
	private String codeSystemName;
	private String code;
	private String displayName;
	
	
	
	
	
	public VocabularyValidationRequestJsonView() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public VocabularyValidationRequestJsonView(String codeSystem,
			String codeSystemName, String code, String displayName) {
		super();
		this.codeSystem = codeSystem;
		this.codeSystemName = codeSystemName;
		this.code = code;
		this.displayName = displayName;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result
				+ ((codeSystem == null) ? 0 : codeSystem.hashCode());
		result = prime * result
				+ ((codeSystemName == null) ? 0 : codeSystemName.hashCode());
		result = prime * result
				+ ((displayName == null) ? 0 : displayName.hashCode());
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
		VocabularyValidationRequestJsonView other = (VocabularyValidationRequestJsonView) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (codeSystem == null) {
			if (other.codeSystem != null)
				return false;
		} else if (!codeSystem.equals(other.codeSystem))
			return false;
		if (codeSystemName == null) {
			if (other.codeSystemName != null)
				return false;
		} else if (!codeSystemName.equals(other.codeSystemName))
			return false;
		if (displayName == null) {
			if (other.displayName != null)
				return false;
		} else if (!displayName.equals(other.displayName))
			return false;
		return true;
	}
	
	public String getCodeSystem() {
		return codeSystem;
	}
	public void setCodeSystem(String codeSystem) {
		this.codeSystem = codeSystem;
	}
	public String getCodeSystemName() {
		return codeSystemName;
	}
	public void setCodeSystemName(String codeSystemName) {
		this.codeSystemName = codeSystemName;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	
	
}
