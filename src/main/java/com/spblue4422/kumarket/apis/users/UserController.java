package com.spblue4422.kumarket.apis.users;

import com.spblue4422.kumarket.dto.BasicResponseDto;
import com.spblue4422.kumarket.dto.users.MyProfileResponseDto;
import com.spblue4422.kumarket.dto.users.UserProfileResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("/users")
public class UserController {
	private final UserService userService;
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/my")
	public BasicResponseDto getMyProfile(Long userId) {
		try {
			MyProfileResponseDto resData = userService.findMyProfile(userId);

			return BasicResponseDto.makeRes(resData, 200, "success");
		} catch	(Exception ex) {
			return BasicResponseDto.makeRes(null, 500, ex.getMessage());
		}
	}

	@GetMapping("/:userId")
	public BasicResponseDto getOthersProfile(@RequestParam("userId") Long userId) {
		try {
			UserProfileResponseDto resData = userService.findOthersProfile(userId);

			return BasicResponseDto.makeRes(resData, 200, "success");
		} catch	(Exception ex) {
			return BasicResponseDto.makeRes(null, 500, ex.getMessage());
		}
	}
}
