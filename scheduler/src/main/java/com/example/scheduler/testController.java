package com.example.scheduler;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class testController {

	@GetMapping
	public void test() {
		log.info(" =================== API =================== {}", Thread.currentThread().getName());
	}
}
