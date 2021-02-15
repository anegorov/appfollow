package com.appfollow.aftests.api;

import com.appfollow.aftests.before.InitApiTest;
import com.appfollow.aftests.model.Country;
import com.appfollow.aftests.model.Data;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@Tag("api-tests")
@SpringBootTest
class AppsListTests extends InitApiTest {

	@Test
	@DisplayName("Check list of countries")
	void checkAppsList() {
		Response response = calls.get("countries");
		response.prettyPrint();

		assertThat(response.statusCode())
				.isEqualTo(200);

		Data data = response
				.then()
				.extract()
				.as(Data.class);

		assertThat(data.getData())
				.hasSizeGreaterThan(100);

		assertThat(data.getData()).anySatisfy(country ->{
				assertThat(country.getName()).isEqualTo("Armenia");
				assertThat(country.getCode()).isEqualTo("am");
		});

	}

}
