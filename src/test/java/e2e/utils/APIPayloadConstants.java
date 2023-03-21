package e2e.utils;

import org.json.JSONObject;

public class APIPayloadConstants {

    public static String signUp(String userName,String userLastName,String userEmail,String userPhoneNumber,String userPassword,String userGender, String userImage){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("userFirstName",userName);
        jsonObject.put("userLastName",userLastName);
        jsonObject.put("userEmail",userEmail);
        jsonObject.put("userPhoneNumber",userPhoneNumber);
        jsonObject.put("userPassword",userPassword);
        jsonObject.put("userGender",userGender);
        jsonObject.put("userImage",userImage);

        return jsonObject.toString();
    }

    public static String login(String userEmail, String userPassword){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("userEmail",userEmail);
        jsonObject.put("userPassword",userPassword);
        return jsonObject.toString();
    }





}
