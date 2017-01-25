package io.pivotal;

import static org.springframework.web.bind.annotation.RequestMethod.PUT;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.pivotal.model.UserLoginCheck;
import io.pivotal.model.UserLoginCheckResult;
import io.pivotal.model.UserLoginCheckStatus;
import io.pivotal.model.UserLoginCheckV1;

@RestController
public class LoginController {
	
	private static final String USER_LOGIN_JSON = "application/json";

	@RequestMapping(
			value = "/userlogin",
			method = PUT,
			consumes = USER_LOGIN_JSON,
			produces = USER_LOGIN_JSON)
	public UserLoginCheckResult userLoginCheck(@RequestBody UserLoginCheck userLoginCheck) {

		if (passwordMatch(userLoginCheck)) {
			return new UserLoginCheckResult(UserLoginCheckStatus.OK, "NO_REASON");
		}
		
		return new UserLoginCheckResult(UserLoginCheckStatus.NOT_OKAY, "INCORRECT_PASSWORD");
	
	}

	private boolean passwordMatch(UserLoginCheck userLoginCheck) {
		return userLoginCheck.getPassword().matches("123");
	}

	@RequestMapping(
			value = "/userlogin/v1",
			method = PUT,
			consumes = USER_LOGIN_JSON,
			produces = USER_LOGIN_JSON)
	public UserLoginCheckResult userLoginCheckV1(@RequestBody UserLoginCheckV1 userLoginCheckV1) {

		if (passwordMatch(userLoginCheckV1)) {
			return new UserLoginCheckResult(UserLoginCheckStatus.OK, "NO_REASON");
		}
		
		return new UserLoginCheckResult(UserLoginCheckStatus.NOT_OKAY, "INCORRECT_PASSWORD");
	
	}

	private boolean passwordMatch(UserLoginCheckV1 userLoginCheckV1) {
		return userLoginCheckV1.getPassword().matches("123");
	}


}
