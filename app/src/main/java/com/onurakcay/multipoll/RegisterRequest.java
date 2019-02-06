package com.onurakcay.multipoll;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by onura on 14.08.2018.
 */

public class RegisterRequest extends StringRequest{
        private static final String REGISTER_REQUEST_URL="https://onurakcay.000webhostapp.com/multipoll/Registerbackendmobile.php";
        private Map<String,String>params;

        public RegisterRequest(String name, String password,String password2, Response.Listener<String> listener){
            super(Method.POST,REGISTER_REQUEST_URL,listener,null);
            params = new HashMap<>();
            params.put("name",name);

            params.put("password",password);
            params.put("password2",password2);

        }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
