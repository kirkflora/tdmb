package org.tmdb.api.genre;


import static org.testng.Assert.*;

import org.json.JSONObject;
import org.testng.annotations.Test;
import org.tmdb.api.*;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.io.OutputStreamWriter;
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
 * TC11: invalid language -
 *
 */


public class GenreTest {

    private String apiDevKey = System.getProperty("apiKey", null);

    /**
     * TC1: All required valid Parameters returns result set with success return code
     */
    @Test
    public void genreIsSorted()throws IOException {
        assertNotNull(apiDevKey, "API Key was not provided");

        //Build URL with expected parameters and make request
        URL url = new URLBuilder(API.GENRE.getFullURL()).addParameter("api_key=" + apiDevKey).addParameter("language=en-US").build();
        HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
        connection.setRequestMethod(RequestType.GET.toString());

        assertEquals(connection.getResponseCode(), ResponseCode.SUCCESS.getValue(), "Response code not found " + ResponseCode.SUCCESS);
        String response = ResponseReader.getResponseString(connection);

        JSONObject jsonObject = new JSONObject(response);
        //jsonObject.get("");

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
        //jsonObject.get("");

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
        //jsonObject.get("");

    }

    /**
     * Verify that there is only one occurrence of each value in the list of Genres returned
     */
    @Test
    public void genreListedOnce(){

    }

    /**
     * Verify unauthorized when api_key is missing
     */
    @Test
    public void genreUnauthorized(){

    }

}
