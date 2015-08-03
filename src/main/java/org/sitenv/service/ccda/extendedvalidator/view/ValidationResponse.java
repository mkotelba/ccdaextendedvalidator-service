package org.sitenv.service.ccda.extendedvalidator.view;

public class ValidationResponse {
	private boolean result;

	public ValidationResponse(boolean result) {
		super();
		this.result = result;
	}

	public boolean isResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}

}
