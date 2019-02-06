package com.onurakcay.multipoll;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by onura on 15.08.2018.
 */

public class QuestionRequest  extends StringRequest {

    private static final String POLL_REQUEST_URL="https://onurakcay.000webhostapp.com/AddQuestion.php";
    private Map<String,String> params;

        public QuestionRequest(String title, String question, Response.Listener<String> listener){
        super(Method.POST,POLL_REQUEST_URL,listener,null);
        params = new HashMap<>();
        params.put("title",title);
        params.put("question",question);



    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }


}
