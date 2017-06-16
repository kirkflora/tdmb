package org.tmdb.api.utility;

/**
 * Created by flora on 6/15/2017.
 */
public enum ResponseCode {

    SUCCESS(200),
    INTERNAL_SERVER_ERROR(500),
    UNAUTHORIZED(401),
    NOT_FOUND(404);


    int code;
    int id;

    ResponseCode(int codeIn) {
        code = codeIn;
    }

    public int getValue() {
        return code;
    }



}

