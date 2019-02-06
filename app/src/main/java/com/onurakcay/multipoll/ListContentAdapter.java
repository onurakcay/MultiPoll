package com.onurakcay.multipoll;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import junit.framework.Test;

import java.util.ArrayList;

/**
 * Created by onura on 27.08.2018.
 */

public class ListContentAdapter extends BaseAdapter {
    ArrayList<JsonModel> list = new ArrayList<>();
    Context context;
    Activity activity;

    public ListContentAdapter(Context mContext, ArrayList<JsonModel> mList, int counter, Activity mActivty) {
        list = mList;
        context = mContext;
        activity = mActivty;

    }


    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }




    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

      final Holder holder;


        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.adapterlayout, null);
            holder = new Holder();
            holder.question = (TextView) convertView.findViewById(R.id.txtContent);
            holder.cok =  (RadioButton) convertView.findViewById(R.id.radio1);
            holder.birazcok = (RadioButton) convertView.findViewById(R.id.radio2);
            holder.birazaz = (RadioButton) convertView.findViewById(R.id.radio3);
            holder.az = (RadioButton) convertView.findViewById(R.id.radio4);
            convertView.setTag(holder);

        }
        else {
            holder = (Holder) convertView.getTag();
        }

        //Toast.makeText(context, ""+position, Toast.LENGTH_SHORT).show();
        Log.e("asdasd",""+(convertView.getTag(position)));
        Log.e("asdasd",""+(parent));


        holder.question.setText(list.get(position).getContent());


        holder.cok.setTag(position);
        holder.birazcok.setTag(position);
        holder.birazaz.setTag(position);
        holder.az.setTag(position);


        Log.e("asdasd",""+(holder.cok).getId());




        holder.cok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });


        holder.birazcok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });

        holder.birazaz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });

        holder.az.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });


        return convertView;
    }


}
