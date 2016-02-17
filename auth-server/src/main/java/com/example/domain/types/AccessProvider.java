package com.example.domain.types;

/**
 * Created by hazim on 2/16/16.
 */
public enum AccessProvider {
	FACEBOOK("Facebook");

	private String value;

	AccessProvider(String value){
		this.value = value;
	}

	@Override
	public String toString(){
		return value;
	}
}
