package com.onurakcay.multipoll;

import android.widget.RadioButton;
import android.widget.RadioGroup;

/**
 * Created by onura on 27.08.2018.
 */

public class JsonModel {
    String tittle="";
    String content="";
    int counter;


    public JsonModel(){
        this.content="";
        this.tittle="";
    }

    public JsonModel(String mTittle,String mContent,Integer counter){
        this.content="Q"+(counter+1)+" - "+mContent;
        this.tittle=mTittle;
        this.counter=counter;




    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }



    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


}
