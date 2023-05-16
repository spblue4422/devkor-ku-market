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

	public MyProfileResponseDto getMyProfile(String userName) {
		User userData = findUserByUserName(userName);

		return userData.toMyProfileResponseDto();
	}

	public UserProfileResponseDto getOthersProfile(String userName) {
		User userData = findUserByUserName(userName);

		return userData.toUserProfileResponseDto();
	}

	public User findUserByUserId(Long userId) {
		return userRepository.findById(userId).orElseThrow(() -> new RuntimeException());
	}

	public User findUserByUserName(String userName) {
		return userRepository.findByUserNameEqualsAndDeletedAtNull(userName).orElseThrow(() -> new RuntimeException());
	}

	public Boolean isUserExistsByUserName(String userName) {
		return userRepository.existsUserByUserNameEquals(userName);
	}
}
