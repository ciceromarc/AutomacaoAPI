package utils;
import java.util.LinkedHashMap;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
public class RestUtils {
	public static String url;
	public static Response response;
	public static String endpoint;

	public static String getEndpoint() {
		return endpoint;
	}
	public static void setEndpoint(String endpoint) {
		RestUtils.endpoint = endpoint;
	}
	public static String getUrl() {
		return url;
	}
	public static void setUrl(String url) {
		RestUtils.url = url;
		RestAssured.baseURI = url;
	}
	public static Response getResponse() {
		return response;
	}
	public static String getBody() {
		return response.getBody().asString();
	}

	public static Integer getBodytext() {
		return response.getStatusCode();
	}

	public static void setResponse(Response response) {
		RestUtils.response = response;
	}
	public static RequestSpecification initRequest(ContentType contentType) {
		return RestAssured.given()
				.relaxedHTTPSValidation()
				.contentType(contentType);
	}

	public static void post(Object json) {
		response = initRequest(ContentType.JSON)
				.body(json)
				.when().post(endpoint)
				.then()
				.extract().response();
	}

	public static void post(Object json, LinkedHashMap<String, String> header) {
		response = initRequest(ContentType.JSON)
				.headers(header)
				.body(json)
				.when().post(endpoint)
				.then()
				.extract().response();
	}

	public static void put(Object json, LinkedHashMap<String, String> header) {
		response = initRequest(ContentType.JSON)
				.headers(header)
				.body(json)
				.when().put(endpoint)
				.then()
				.extract().response();
	}

	public static void postUrlEncoded(LinkedHashMap<String, String> json) {
		response = initRequest(ContentType.URLENC)
				.formParams(json)
				.when().post(endpoint)
				.then()
				.extract().response();
	}

	public static void postUrlEncoded(LinkedHashMap<String, String> json, LinkedHashMap<String, String> header) {
		response = initRequest(ContentType.URLENC)
				.formParams(json)
				.headers(header)
				.when().post(endpoint)
				.then()
				.extract().response();
	}

	public static void get() {
		Response response = initRequest(ContentType.JSON)
				.when().get(endpoint)
				.then()
				.extract().response();
		setResponse(response);
	}

	public static void get(LinkedHashMap<String, String> header) {
		Response response = RestUtils.initRequest(ContentType.JSON)
				.headers(header)
				.when()
				.get(endpoint)
				.then()
				.extract()
				.response();
		setResponse(response);
	}

	public static void getParams(LinkedHashMap<String, String> param) {
		Response response = RestUtils.initRequest(ContentType.JSON)
				.params(param)
				.when()
				.get(endpoint)
				.then()
				.extract()
				.response();
		setResponse(response);
	}

	public static void getParams(LinkedHashMap<String, String> param,
								 LinkedHashMap<String, String> header) {
		Response response = RestUtils.initRequest(ContentType.JSON)
				.params(param)
				.headers(header)
				.when()
				.get(endpoint)
				.then()
				.extract()
				.response();
		setResponse(response);
	}

	public static Object getValue(String key) {
		JsonPath json = getResponse().getBody().jsonPath();
		return json.get(key);
	}

	public static int getStatusCode() {
		return getResponse().statusCode();
	}

	public static void delete(LinkedHashMap<String, String> header) {
		Response response = RestUtils.initRequest(ContentType.JSON)
				.headers(header)
				.when()
				.delete(endpoint)
				.then()
				.extract()
				.response();
		setResponse(response);
	}
}