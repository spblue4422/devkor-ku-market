package com.spblue4422.kumarket.apis.users;

import com.spblue4422.kumarket.dto.BasicResponseDto;
import com.spblue4422.kumarket.dto.users.MyProfileResponseDto;
import com.spblue4422.kumarket.dto.users.UserProfileResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<?> getMyProfile(Long userId) {
		try {
			MyProfileResponseDto resData = userService.getMyProfile(userId);

			return ResponseEntity.ok().body(resData);
		} catch	(Exception ex) {
			return ResponseEntity.internalServerError().body(ex.getMessage());
		}
	}

	@GetMapping("/{userId}")
	public ResponseEntity<?> getOthersProfile(@RequestParam("userId") Long userId) {
		try {
			UserProfileResponseDto resData = userService.getOthersProfile(userId);

			return ResponseEntity.ok().body(resData);
		} catch	(Exception ex) {
			return ResponseEntity.internalServerError().body(ex.getMessage());
		}
	}
}
