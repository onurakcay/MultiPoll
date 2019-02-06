package com.onurakcay.multipoll;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by onura on 15.08.2018.
 */

public class MainRequest extends StringRequest{
    private static final String MAIN_REQUEST_URL="https://onurakcay.000webhostapp.com/ActivePolls.php";
    private Map<String,String> params;

    public MainRequest(Response.Listener<String> listener){
        super(Method.POST,MAIN_REQUEST_URL,listener,null);
        params = new HashMap<>();



    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
