package com.my.conductorbootwrapperoauth2embeddedmariadb4j.dto.response;

public class AutogeneratedPasswordResponseDTO extends BaseResponseDTO {

	private String autoGeneratedPassword;

	public AutogeneratedPasswordResponseDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AutogeneratedPasswordResponseDTO(boolean status, String message) {
		super(status, message);
		// TODO Auto-generated constructor stub
	}

	public AutogeneratedPasswordResponseDTO(String autoGeneratedPassword) {
		super();
		this.autoGeneratedPassword = autoGeneratedPassword;
	}

	public String getAutoGeneratedPassword() {
		return autoGeneratedPassword;
	}

	public void setAutoGeneratedPassword(String autoGeneratedPassword) {
		this.autoGeneratedPassword = autoGeneratedPassword;
	}

	@Override
	public String toString() {
		return "NewUserResponseDTO [autoGeneratedPassword=" + autoGeneratedPassword + "]";
	}
}
