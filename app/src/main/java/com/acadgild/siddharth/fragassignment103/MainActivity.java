package com.acadgild.siddharth.fragassignment103;

import android.content.Context;
import android.os.PersistableBundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ListView mlv;
    String[] str = {"YouTube", "Blogger"};
    String[] det = {"BroadCast Yourself", "Blogger Description"};
    int[] images = {R.drawable.you, R.drawable.unnamed};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mlv = (ListView) findViewById(R.id.lv);
        MyAdapter adapter = new MyAdapter(this, str, det, images);
        mlv.setAdapter(adapter);
    }
}

    class MyAdapter extends ArrayAdapter<String> {
        Context ctx;
        String[] arr, arr2;
        int[] imgg;

        public MyAdapter(@NonNull Context context, String[] name, String[] descr, int[] img) {
            super(context, R.layout.mylayout, R.id.name,name);
            ctx = context;
            arr = name;
            arr2 = descr;
            imgg = img;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater l = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View v = l.inflate(R.layout.mylayout, parent, false);
            TextView mtv1 = (TextView) v.findViewById(R.id.name);
            TextView mtv2 = (TextView) v.findViewById(R.id.desc);
            ImageView iv = (ImageView) v.findViewById(R.id.imageView);
            mtv1.setText(arr[position]);
            mtv2.setText(arr2[position]);
            iv.setImageResource(imgg[position]);
            return v;
        }
    }
