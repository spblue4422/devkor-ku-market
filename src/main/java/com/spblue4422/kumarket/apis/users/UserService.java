package com.spblue4422.kumarket.apis.users;

import com.spblue4422.kumarket.dto.users.MyProfileResponseDto;
import com.spblue4422.kumarket.dto.users.UserProfileResponseDto;
import com.spblue4422.kumarket.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	private final UserRepository userRepository;

	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public MyProfileResponseDto findMyProfile(Long userId) {
		User userData = userRepository.findById(userId).orElseThrow(() -> new RuntimeException());

		return userData.toMyProfileResponseDto();
	}

	public UserProfileResponseDto findOthersProfile(Long userId) {
		User userData = userRepository.findById(userId).orElseThrow(() -> new RuntimeException());

		return userData.toUserProfileResponseDto();
	}
}
