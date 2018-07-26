package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) throws JSONException {

        /* Sandwich information. Each sandwich information is an element of the passed json string */
        final String SWC_NAME = "name";

        final String SWC_MAIN_NAME = "mainName";

        final String SWC_ALSO_KNOWN_AS = "alsoKnownAs";

        final String SWC_PLACE_OF_ORIGIN = "placeOfOrigin";

        final String SWC_DESCRIPTION = "description";

        final String SWC_IMAGE = "image";

        final String SWC_INGREDIENTS = "ingredients";
        
        JSONObject sandwichJSON = new JSONObject(json);

        /* Get the JSON object representing name */
        JSONObject name = sandwichJSON.getJSONObject(SWC_NAME);

        /* Get the string representing the sandwich's main name */
        String mainName = name.getString(SWC_MAIN_NAME);

        /* Get the string list representing the names the sandwich is also known as */
        JSONArray alsoKnownAsJSONArray = name.getJSONArray(SWC_ALSO_KNOWN_AS);

        List<String> alsoKnownAs = new ArrayList<>();
        for (int i = 0; i <alsoKnownAsJSONArray.length(); i++) {
            String aka = alsoKnownAsJSONArray.getString(i);
            alsoKnownAs.add(aka);
        }

        /* Get the string representing the sandwich's place of origin */
        String placeOfOrigin = sandwichJSON.getString(SWC_PLACE_OF_ORIGIN);

        /* Get the string representing the sandwich's description */
        String description = sandwichJSON.getString(SWC_DESCRIPTION);

        /* Get the string representing the url of the sandwich's image */
        String image = sandwichJSON.getString(SWC_IMAGE);

        /* Get the string list representing the sandwich's ingredients */
        JSONArray ingredientsJSONArray = sandwichJSON.getJSONArray(SWC_INGREDIENTS);

        List<String> ingredients = new ArrayList<>();
        for (int i = 0; i <ingredientsJSONArray.length(); i++) {
            String igd = ingredientsJSONArray.getString(i);
            ingredients.add(igd);
        }

        return new Sandwich(mainName, alsoKnownAs,
                placeOfOrigin, description,
                image, ingredients);
    }
}
