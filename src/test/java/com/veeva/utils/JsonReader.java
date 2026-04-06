package com.veeva.utils;

import java.io.InputStreamReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonReader {

    public static JSONObject testData;

    static {
        try {
            JSONParser parser = new JSONParser();

            InputStreamReader reader =
                    new InputStreamReader(
                            JsonReader.class.getClassLoader()
                                    .getResourceAsStream("testdata/userdata.json")
                    );

            testData = (JSONObject) parser.parse(reader);

            reader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getValue(String userType, String key) {
        try {
            JSONObject user = (JSONObject) testData.get(userType);
            return user.get(key).toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}