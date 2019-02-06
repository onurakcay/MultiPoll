package com.onurakcay.multipoll;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by onura on 15.08.2018.
 */

public class PollRequest extends StringRequest {

    private static final String POLL_REQUEST_URL="https://onurakcay.000webhostapp.com/viewQuestions.php";
    private Map<String,String> params;

    public PollRequest( Response.Listener<String> listener){
        super(Method.POST,POLL_REQUEST_URL,listener,null);
        params = new HashMap<>();




    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }


}
