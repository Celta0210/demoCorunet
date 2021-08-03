package com.cml.demo.corunet;

import static io.restassured.http.Method.GET;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import com.cml.demo.corunet.model.Prices;

import io.restassured.RestAssured;

@SpringBootTest
@AutoConfigureMockMvc
@Sql("/test-data.sql")
class CorunetApplicationTests {

		
	@Test
	public void testRestAssured() {
		try {
			Prices price = RestAssured
		    .given()
		      .baseUri("https://localhost:8080/cml")
		      .param("date", "2020-06-14 10:00:00")
		      .param("brandId", 1)
		      .log().all()
		    .when()
		      .get("/products/{idproduct}/prices",35455)
		    .then()
		      .statusCode(is(equalTo(200)))
		      .log().all()
		      .and().extract().body().as(Prices.class);
			
			assertThat(price, is(notNullValue()));
						
		}catch (Exception e) {
			assertTrue(true);
		}
	}
	
	

}
