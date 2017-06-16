package org.tmdb.api.utility;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by flora on 6/15/2017.
 */
public class URLBuilder {
    private StringBuilder urlBuilder;

    public URLBuilder(String baseURL) {
        urlBuilder = new StringBuilder(baseURL);
    }

    public URLBuilder addParameter(String parameter) {
        if (urlBuilder.toString().contains("?")) {
            urlBuilder.append("&" + parameter);
        } else {
            urlBuilder.append("?" + parameter);
        }
        return this;
    }

    public URL build() throws MalformedURLException{
        return new URL(urlBuilder.toString());
    }
}
