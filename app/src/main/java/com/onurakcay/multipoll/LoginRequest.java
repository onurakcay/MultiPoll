package com.onurakcay.multipoll;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by onura on 15.08.2018.
 */

public class LoginRequest extends StringRequest{
    private static final String LOGIN_REQUEST_URL="https://onurakcay.000webhostapp.com/multipoll/Loginbackendmobil.php";
    private Map<String,String> params;

    public LoginRequest(String name, String password, Response.Listener<String> listener){
        super(Method.POST,LOGIN_REQUEST_URL,listener,null);
        params = new HashMap<>();
        params.put("name",name);
        params.put("password",password);

    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
