package com.home;

import org.springframework.boot.SpringApplication;

public class TestUserSpringBoot3X1000Application {

	public static void main(String[] args) {
		SpringApplication.from(UserSpringBoot3X1000Application::main).with(TestcontainersConfiguration.class).run(args);
	}

}
