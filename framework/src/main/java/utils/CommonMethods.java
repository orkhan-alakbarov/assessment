package utils;

import io.restassured.response.Response;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static io.restassured.RestAssured.given;

public class CommonMethods {
	public Properties property;
	public CommonMethods() {
		try {
			property = new Properties();
			String path = "src/main/api-config.properties";
			File file = new File(path);
			FileInputStream fis = new FileInputStream(file);			
			property.load(fis);
		} catch (IOException e) {				
			e.printStackTrace();
		}
	}

	public Response submitGetRequest (String url, String metaData, String filePath) {
		Response getResponse = given()
				.accept("application/json")
				.contentType("multipart/form-data")
				.header("additionalMetadata", metaData)
				.multiPart(new File(filePath))
				.when()
				.post(property.getProperty(url));

		return getResponse;
	}


}