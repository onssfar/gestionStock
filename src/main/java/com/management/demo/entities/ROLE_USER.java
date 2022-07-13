package com.management.demo.entities;

public enum ROLE_USER {
	CONSULT(1), EDIT(2), DELETE(66);

	private final int value;

	private ROLE_USER(int value) {
		this.value = value;
	}

	public int getValue() {
		return this.value;
	}
}
