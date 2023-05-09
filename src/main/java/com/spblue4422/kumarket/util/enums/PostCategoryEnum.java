package com.spblue4422.kumarket.util.enums;

public enum PostCategoryEnum {
	HOMEAPP("가전제품"),
	FASHION("의류"),
	GAME("게임"),
	BOOK("책");

	private String categoryKr;

	PostCategoryEnum(String category) {
		this.categoryKr = category;
	}

	public String getCategoryKr() {
		return categoryKr;
	}
}
