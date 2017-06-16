package org.tmdb.api.utility;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by flora on 6/16/2017.
 */
public class JSONParser {


    public static String getListItemNameById(Object object, int id) throws JSONException{
        JSONArray jsonArray = (JSONArray)object;
        for (Object listItem : jsonArray) {
            JSONObject jsonObject = (JSONObject) listItem;
            if (jsonObject.get(Keys.ID).equals(id)) {
                return (String) jsonObject.get(Keys.NAME);
            }
        }
        return null;
    }
}
