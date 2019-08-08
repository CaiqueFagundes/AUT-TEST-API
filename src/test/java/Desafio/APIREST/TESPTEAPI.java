package Desafio.APIREST;
import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import static org.hamcrest.Matchers.*;
import org.junit.Test;


public class TESPTEAPI {

	@Test
	public void Teste() {
		
		String uriBase = "https://reqres.in/api/users?page=2";
			given()
			.relaxedHTTPSValidation()
			.param("page", "2")
			.param("id", "4","email","eve.holt@reqres.in","first_name","Eve","last_name","Holt","avatar","https://s3.amazonaws.com/uifaces/faces/twitter/marcoramires/128.jpg")
			.when()
			.get(uriBase)
			.then()
			.statusCode(200) // O status http retornado foi 200
			.contentType(ContentType.JSON) // O response foi retornado no formato JSON
			.body("headers.host", is("postman-echo.com")) // A chave “host” possui exatamente o valor “postman-echo.com”
			.body("args.foo1", containsString("bar")); //A chave “foo1” contém o valor “bar”				
	}	
}
