package com.spblue4422.kumarket.util.enums;

public enum PostStateEnum {
	ONSALE("판매중"),
	DEALING("거래예정"),
	COMPLETED("판매완료");

	private String stateKr;

	PostStateEnum(String state) {
		this.stateKr = state;
	}

	public String getStateKr() {
		return stateKr;
	}
}
