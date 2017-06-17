package org.tmdb.api.genre;


import static org.testng.Assert.*;

import org.json.JSONObject;
import org.testng.annotations.Test;
import org.tmdb.api.utility.*;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.net.URL;


/**
 * Created by flora on 6/15/2017.]
 *
 * TC1: All required valid Parameters returns result set with success return code
 * TC2: Missing devKey returns 401 Unauthorized
 * TC3: Invalid devKey returns 401 Unauthorized
 * TC4: Invalid endpoint extension of genre returns 404 - Not Found
 * TC5: Missing optional language parameter will returns result set with success return code
 * TC6: All Genre Categories are present
 * TC7: Genre Categories are returned in Alphabetical order
 * TC8: Genre Categories do not contain duplicates
 * TC9: language french will returns result set with success return code
 * TC10: language korean will returns result set with success return code
 * TC11: invalid language - will return 500 or defined Error - this is missing from the API specification
 * TC12: invalid parameter - will return 500 or defined Error - this is missing from the API specification
 *
 */


public class GenreTest {

    private String apiDevKey = System.getProperty("apiKey", null);

    /**
     * TC1: All required valid Parameters returns result set with success return code
     */
    @Test
    public void genreValidRequest()throws IOException {
        assertNotNull(apiDevKey, "API Key was not provided");

        //Build URL with expected parameters and make request
        URL url = new URLBuilder(API.GENRE.getFullURL()).addParameter("api_key=" + apiDevKey).addParameter("language=en-US").build();
        HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
        connection.setRequestMethod(RequestType.GET.toString());

        assertEquals(connection.getResponseCode(), ResponseCode.SUCCESS.getValue(), "Response code not found " + ResponseCode.SUCCESS);
        String response = ResponseReader.getResponseString(connection);

        JSONObject jsonObject = new JSONObject(response);

        assertEquals(JSONParser.getListItemNameById(jsonObject.get("genres"), 28), Genre.ACTION.getEnglish(), "Genre Mismatch");

        //...Verify all Genres
    }

    /**
     * TC2: Missing devKey returns 401 Unauthorized
     */
    @Test
    public void genreMissingApiKey()throws IOException {

        //Build URL with expected parameters and make request
        URL url = new URLBuilder(API.GENRE.getFullURL()).addParameter("language=en").build();
        HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
        connection.setRequestMethod(RequestType.GET.toString());


        String response = ResponseReader.getResponseString(connection);
        assertEquals(connection.getResponseCode(), ResponseCode.UNAUTHORIZED.getValue(),
                "Response code not found " + ResponseCode.UNAUTHORIZED + " Actual Response: " + response);
    }

    /**
     * TC3: Invalid devKey returns 401 Unauthorized
     */
    @Test
    public void genreInvalidApiKey()throws IOException {
        //Build URL with expected parameters and make request
        final String invalidKey = "007";
        URL url = new URLBuilder(API.GENRE.getFullURL()).addParameter("api_key=" + invalidKey).addParameter("language=en").build();
        HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
        connection.setRequestMethod(RequestType.GET.toString());

        String response = ResponseReader.getResponseString(connection);
        assertEquals(connection.getResponseCode(), ResponseCode.UNAUTHORIZED.getValue(),
                "Response code not found " + ResponseCode.UNAUTHORIZED + " with invalid API Key: " + invalidKey + "  Actual Response: " + response);
    }

    /**
     * TC4: Invalid endpoint extension of genre returns 404 - Not Found
     */
    @Test
    public void genreInvalidEndpoint()throws IOException {
        assertNotNull(apiDevKey, "API Key was not provided");
        //Build URL with expected parameters and make request
        URL url = new URLBuilder(API.GENRE.getFullURL() + "/invalid").addParameter("api_key=" + apiDevKey).addParameter("language=en").build();
        HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
        connection.setRequestMethod(RequestType.GET.toString());

        String response = ResponseReader.getResponseString(connection);
        assertEquals(connection.getResponseCode(), ResponseCode.NOT_FOUND.getValue(), "Response code not found " + ResponseCode.NOT_FOUND);
    }

    /**
     * TC8: Genre Categories do not contain duplicates
     */
    @Test(enabled = false)
    public void genreListedOnce()throws IOException {
        assertNotNull(apiDevKey, "API Key was not provided");

        //Build URL with expected parameters and make request
        URL url = new URLBuilder(API.GENRE.getFullURL()).addParameter("api_key=" + apiDevKey).addParameter("language=en").build();
        HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
        connection.setRequestMethod(RequestType.GET.toString());

        assertEquals(connection.getResponseCode(), ResponseCode.SUCCESS.getValue(), "Response code not found " + ResponseCode.SUCCESS);
        String response = ResponseReader.getResponseString(connection);

        JSONObject jsonObject = new JSONObject(response);

        //TODO: Get size of genre list
        //TODO: Put list into Set to isolate unique values
        //TODO: Verify that Set size is equal to the returned genre list
    }
    /**
     * TC9: language french will returns result set with success return code
     */
    @Test
    public void genreLanguageFrench()throws IOException {
        assertNotNull(apiDevKey, "API Key was not provided");

        //Build URL with expected parameters and make request
        URL url = new URLBuilder(API.GENRE.getFullURL()).addParameter("api_key=" + apiDevKey).addParameter("language=fr").build();
        HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
        connection.setRequestMethod(RequestType.GET.toString());

        assertEquals(connection.getResponseCode(), ResponseCode.SUCCESS.getValue(), "Response code not found " + ResponseCode.SUCCESS);
        String response = ResponseReader.getResponseString(connection);

        JSONObject jsonObject = new JSONObject(response);
        assertEquals(JSONParser.getListItemNameById(jsonObject.get(Keys.GENRES), 28), Genre.ACTION.getFrench(), "Genre Mismatch");

        //...Verify all Genres
    }

    /**
     * TC10: language korean will returns result set with success return code
     */
    @Test
    public void genreLanguageKorean()throws IOException {
        assertNotNull(apiDevKey, "API Key was not provided");

        //Build URL with expected parameters and make request
        URL url = new URLBuilder(API.GENRE.getFullURL()).addParameter("api_key=" + apiDevKey).addParameter("language=ko").build();
        HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
        connection.setRequestMethod(RequestType.GET.toString());

        assertEquals(connection.getResponseCode(), ResponseCode.SUCCESS.getValue(), "Response code not found " + ResponseCode.SUCCESS);
        String response = ResponseReader.getResponseString(connection);

        JSONObject jsonObject = new JSONObject(response);
        assertEquals(JSONParser.getListItemNameById(jsonObject.get(Keys.GENRES), 28), Genre.ACTION.getKorean(), "Genre Mismatch");

        //...Verify all Genres

    }
    /**
     * TC11: invalid language - Expect Defined ERROR Code (This is actually a bug with the genre endpoint)
     * If you look at the response on the failure message - the API returns null values when an invalid language is
     * provided
     */
    @Test
    public void genreLanguageInvalid()throws IOException {
        assertNotNull(apiDevKey, "API Key was not provided");

        //Build URL with expected parameters and make request
        URL url = new URLBuilder(API.GENRE.getFullURL()).addParameter("api_key=" + apiDevKey).addParameter("language=tkdko").build();
        HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
        connection.setRequestMethod(RequestType.GET.toString());


        String response = ResponseReader.getResponseString(connection);
        assertEquals(connection.getResponseCode(), ResponseCode.INTERNAL_SERVER_ERROR.getValue(),
                "Response code not found " + ResponseCode.INTERNAL_SERVER_ERROR + " Actual Response: " + response);


    }




}
