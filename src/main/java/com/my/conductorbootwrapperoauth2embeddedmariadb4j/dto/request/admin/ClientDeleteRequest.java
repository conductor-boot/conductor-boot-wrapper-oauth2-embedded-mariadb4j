package com.my.conductorbootwrapperoauth2embeddedmariadb4j.dto.request.admin;

public class ClientDeleteRequest {
	
	private String clientId;

	public ClientDeleteRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ClientDeleteRequest(String clientId) {
		super();
		this.clientId = clientId;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	@Override
	public String toString() {
		return "ClientInputDeleteDTO [clientId=" + clientId + "]";
	}
}
