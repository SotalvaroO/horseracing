/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bet.horserisingsun.horseracing.controller;

import bet.horserisingsun.horseracing.model.HorseEntity;
import bet.horserisingsun.horseracing.util.JsonReaderUtil;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


public class HorseController {
    
    private JsonReaderUtil jsonReaderUtil = new JsonReaderUtil();
    private String filePath = "src/horses.json";
    
    
    
    public HorseEntity getHorse(Object obj)throws Exception{
        HorseEntity horse = new HorseEntity();
        JSONObject jsonObj = jsonReaderUtil.toJsonObject(obj);
        horse.setId(Integer.valueOf(jsonObj.get("id").toString()));
        horse.setName(jsonObj.get("name").toString());
        return horse;
    }
    
    public ArrayList<HorseEntity> getHorses()throws Exception{
        Object obj = jsonReaderUtil.fileToObject(filePath);
        JSONObject jsonObj = jsonReaderUtil.toJsonObject(obj);
        JSONArray jsonArr = jsonReaderUtil.toJsonObjectArray(jsonObj, "horses");
        ArrayList<HorseEntity> horses = new ArrayList<>();
        HorseEntity horse = new HorseEntity();
        for(Object arrObj: jsonArr){
             horse = getHorse(arrObj);
            horses.add(horse);
        }
        return horses;
    }
    
}
