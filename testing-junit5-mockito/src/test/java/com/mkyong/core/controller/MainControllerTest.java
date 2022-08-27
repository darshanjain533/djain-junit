package com.mkyong.core.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import java.net.URL;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class MainControllerTest {

    // bind the above RANDOM_PORT
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    @DisplayName("Check1")
    public void check1() throws Exception {
        ResponseEntity<String> response = restTemplate.getForEntity(new URL("http://localhost:" + port + "/").toString(), String.class);
        assertThat("Hello Controller").isEqualTo(response.getBody());

    }
    
    @Test
    @DisplayName("Check2")
    public void check2() throws Exception{
    	ResponseEntity<String> response = restTemplate.getForEntity(new URL("http://localhost:" + port + "/").toString(), String.class);
        assertEquals("Hello Controller", response.getBody());
    }
    
}



/* https://rieckpil.de/guide-to-springboottest-for-spring-boot-integration-tests/
 * 
*	@SpringBootTest(
	  webEnvironment = WebEnvironment.DEFINED_PORT,
	  properties = {
	    "server.port=8042",
	    "management.server.port=9042"
	  })
	  // or define the properties in application-junitTest.properties and use @ActiveProfiles("junitTest")
	class ApplicationDefinedPortIT {
	 
	  @LocalServerPort
	  private Integer port;
	 
	  @LocalManagementPort
	  private Integer managementPort;
	 
	  @Test
	  void printPortsInUse() {
	    System.out.println(port); // 8042
	    System.out.println(managementPort); // 9042
	  }
	}

*
*
*/


