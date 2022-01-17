/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bet.horserisingsun.horseracing.util;

import java.io.FileReader;
import java.io.FileWriter;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonReaderUtil {

    private JSONParser parser;

    public JsonReaderUtil() {
        this.parser = new JSONParser();
    }

    public Object fileToObject(String path) {
        try {
            Object obj = this.parser.parse(new FileReader(path));
            return obj;
        } catch (Exception e) {
            System.out.println(e.toString());
            return e;
        }
        
    }
    public JSONObject toJsonObject(Object obj){
        JSONObject jsonObject = (JSONObject) obj;
        return jsonObject;
    }
    
    public JSONArray toJsonObjectArray(JSONObject jsonObject, String key){
        JSONArray jsonArray = (JSONArray) jsonObject.get(key);
        return jsonArray;
    }

}
