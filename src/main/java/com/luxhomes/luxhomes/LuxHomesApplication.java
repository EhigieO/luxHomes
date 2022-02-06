package com.luxhomes.luxhomes;

import com.luxhomes.luxhomes.models.LuxUser;
import com.luxhomes.luxhomes.services.LuxUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static com.luxhomes.luxhomes.models.LuxUserRole.LANDLORD;
import static com.luxhomes.luxhomes.models.LuxUserRole.CLIENT;

@SpringBootApplication
public class LuxHomesApplication implements CommandLineRunner {

	private final LuxUserService userService;

	@Autowired
	public LuxHomesApplication(LuxUserService userService) {

		this.userService = userService;
	}

	public static void main(String[] args) {
		SpringApplication.run(LuxHomesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		LuxUser luxUser = LuxUser.builder()
				.firstName("Bassey")
				.lastName("Edet")
				.email("Ediebass@gmail.com")
				.phoneNumber("0709545210")
				.password("dizzy1234")
				.luxUserRole(LANDLORD)
				.build();
		userService.signUpUser(luxUser);
		LuxUser uxUser = LuxUser.builder()
				.firstName("Ehis")
				.lastName("Ikpea")
				.email("Ehi@gmail.com")
				.phoneNumber("0709455210")
				.password("ehi1234")
				.luxUserRole(CLIENT)
				.build();
		userService.signUpUser(uxUser);
	}
}
