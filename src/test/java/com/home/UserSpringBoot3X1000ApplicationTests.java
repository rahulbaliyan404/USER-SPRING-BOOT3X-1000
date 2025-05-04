package com.home;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
@Import(TestcontainersConfiguration.class)
@SpringBootTest
class UserSpringBoot3X1000ApplicationTests {

//	static MySQLContainer container = new MySQLContainer()
//			.withDatabaseName("mysql_mdb")
//			.withUsername("root")
//			.withPassword("root");
//	void properties() {
//		container.start();
//		System.setProperty("spring.datasource.url", container.getJdbcUrl());
//		System.setProperty("spring.datasource.username", container.getUsername());
//		System.setProperty("spring.datasource.password", container.getPassword());
//	}
//
//	@Test
//	void contextLoads() {
//		System.out.println("contextLoads");
//	}

}
