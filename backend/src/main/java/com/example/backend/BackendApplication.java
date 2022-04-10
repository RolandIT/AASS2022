package com.example.backend;

import com.example.backend.controllers.DatabaseController;
import com.example.backend.data_model.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackendApplication {
	public static DatabaseController dbController;

	public static void main(String[] args) {
		dbController = new DatabaseController();
		SpringApplication.run(BackendApplication.class, args);
	}

}
