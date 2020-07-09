package com.example.project1;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Dummy{
    private String Name;
    private String PhoneNum;
    private String Email;

    public Dummy(String Name, String PhoneNum, String Email){
        this.Name = Name;
        this.PhoneNum = PhoneNum;
        this.Email = Email;
    }
    public String getName() {
        return Name;
    }

    public String getPhoneNum() {
        return PhoneNum;
    }

    public String getEmail() {
        return Email;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public void setPhoneNum(String phonenum) {
        this.PhoneNum = phonenum;
    }

    public void setEmail(String email) {
        this.Email = email;
    }
}
//    ArrayList<Dummy> dummylist = new ArrayList<Dummy>();
//    private void jsonParsing(String json)
//    {
//        try{
//            JSONObject jsonObject = new JSONObject(json);
//
//            JSONArray dummyarray = jsonObject.getJSONArray("dummy");
//
//            for(int i=0; i<dummyarray.length(); i++)
//            {
//                JSONObject dummyObject = dummyarray.getJsonObject(i);
//
//                Dummy dummy = new Dummy(dummyObject.getString("name"), dummyObject.getString("phonenum"), dummyObject.getString("email"));
//
//                dummylist.add(dummy);
//            }
//        }catch (JSONException | JSONException e) {
//            e.printStackTrace();
//        }
//    }