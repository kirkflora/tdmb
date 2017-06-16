package org.tmdb.api;

/**
 * Created by flora on 6/15/2017.
 */
public enum API {
    
    GENRE("3/genre/movie/list");
    final String baseURL =  "https://api.themoviedb.org";
    String endpoint;
    API(String endpointIn){
        endpoint = endpointIn;
    }

    public String getEndpoint() {
        return endpoint;
    }
    public String getBaseURL(){
        return baseURL;
    }
    public String getFullURL(){
        return getBaseURL() + "/" + getEndpoint();
    }
}
