/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bet.horserisingsun.horseracing.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author Santiago
 */
public class JsonWriterUtil {

    
    private JSONParser parser;

    public JsonWriterUtil() {
        this.parser = new JSONParser();
    }

    public JSONObject arrayToJsonObject(JSONArray arr, String key) {

        JSONObject obj = new JSONObject();
        obj.put(key, arr);
        return obj;
    }

    public Object jsonObjectToObject(JSONObject jsonObj) {
        Object obj = (Object) jsonObj;
        return obj;
    }
    
    public void flushFile(String path){
        FileWriter file;
        try {
            file = new FileWriter(path);
            file.flush();
            file.close();
        } catch (Exception e) {
        }
    }

    public JSONObject readFile(String path, String key, JSONObject jsonObject) {

        JSONObject jsonObj =new JSONObject();
        JSONArray jsonArr = new JSONArray();
        FileWriter file;
        try {
            int value = new FileReader(path).read();
            Object obj = new Object();

            if (/*obj.equals(null) || obj.toString().isEmpty()||*/ value == -1) {
                
                jsonArr.add(jsonObject);
                jsonObj.put(key, jsonArr);

                file = new FileWriter(path);
                file.write(jsonObj.toJSONString());
                file.close();
            } else {
                obj = this.parser.parse(new FileReader(path));
                jsonObj = (JSONObject) obj;
                jsonArr = (JSONArray) jsonObj.get(key);
                jsonArr.add(jsonObject);
                file = new FileWriter(path);
                file.write(jsonObj.toJSONString());
                file.close();

            }
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return jsonObj;

    }

}
