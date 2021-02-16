package apiactions;

import io.restassured.response.Response;
import org.json.JSONObject;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class APIMethods
{
    static String rootURL = "http://54.174.86.218/";
    public static Response postMethod(String path, Map<String, String> headerParams, JSONObject bodyParams)
    {
        Response response = null;
        try {
            response = given()
                    .headers(headerParams)
                    .body(bodyParams.toString())
                    .post(rootURL + path)
                    .then()
                    .extract()
                    .response();
        }
            catch (Exception e)
            {
                System.out.println(e.getCause());
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        return response;
    }

    public static Response getMethod(String path, Map<String, String> headerParams)
    {
        Response response = null;
        try {
             response = given()
                    .headers(headerParams)
                    .get(rootURL + path)
                    .then()
                    .extract()
                    .response();
        } catch (Exception e)
        {
            System.out.println(e.getCause());
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return response;
    }

    public static Response putMethod(String path, Map<String, String> headerParams, JSONObject bodyParams)
    {
        Response response = null;
        try {
            response = given()
                    .headers(headerParams)
                    .body(bodyParams.toString())
                    .put(rootURL + path)
                    .then()
                    .extract()
                    .response();
        }
        catch (Exception e)
        {
            System.out.println(e.getCause());
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return response;
    }

    public static Response deleteMethod(String path, Map<String, String> headerParams)
    {
        Response response = null;
        try {
            response = given()
                    .headers(headerParams)
                    .delete(rootURL + path)
                    .then()
                    .extract()
                    .response();
        }
        catch (Exception e)
        {
            System.out.println(e.getCause());
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return response;
    }
}
