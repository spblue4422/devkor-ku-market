package com.spblue4422.kumarket.dto;

import lombok.*;

@Getter
@Builder
public class BasicResponseDto {
	private Object data;
	private int statusCode;
	private String msg;

	public BasicResponseDto(Object data, int statusCode, String msg) {
		this.data = data;
		this.statusCode = statusCode;
		this.msg = msg;
	}

	public static BasicResponseDto makeRes(Object data, int statusCode, String msg) {
		return BasicResponseDto.builder().data(data).statusCode(statusCode).msg(msg).build();
	}
}
