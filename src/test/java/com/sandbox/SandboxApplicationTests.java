package com.sandbox;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = { TestConfig.class })
@Tag("integration")
class SandboxApplicationTests {

	@Test
	void contextLoads() {
	}

}
