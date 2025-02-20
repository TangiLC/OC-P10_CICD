package com.openclassrooms.bobapp;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class BobappApplicationTests {

  @Autowired
  private ApplicationContext context;

  @Test
  void contextLoads() {
    assertNotNull(context, "App context should not be null");
  }

  @Test
  void testMain() {
    BobappApplication.main(new String[] {});
    assertNotNull(context, "App context should not be null after start");
  }
}
