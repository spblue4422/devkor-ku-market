package com.spblue4422.kumarket.apis.users;

import com.spblue4422.kumarket.dto.users.MyProfileResponseDto;
import com.spblue4422.kumarket.dto.users.UserProfileResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/users")
public class UserController {
	private final UserService userService;
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/my")
	public ResponseEntity<?> getMyProfile() {
		try {
			MyProfileResponseDto resData = userService.getMyProfile("spblue4422");

			return ResponseEntity.ok(resData);
		} catch	(Exception ex) {
			return ResponseEntity.internalServerError().body(ex.getMessage());
		}
	}

	@GetMapping("/{userId}")
	public ResponseEntity<?> getOthersProfile(@PathVariable("userId") String userId) {
		try {
			UserProfileResponseDto resData = userService.getOthersProfile(userId);

			return ResponseEntity.ok().body(resData);
		} catch	(Exception ex) {
			return ResponseEntity.internalServerError().body(ex.getMessage());
		}
	}
}
