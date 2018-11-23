package com.gaming.football.gaming;



import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GamingApplicationTests {

	@Test
	public void contextLoads() {
		assertEquals("Passes", 10, 10);
	}

}
