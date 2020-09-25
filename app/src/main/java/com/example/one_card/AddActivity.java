package com.example.one_card;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class AddActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent=getIntent();
        int position=intent.getIntExtra("position", 0);

        if(position==0){
            setContentView(R.layout.add_cafe); setTitle("카페등록");
            String[] values = new String[] {"사업자 등록", "카페 정보 등록"};
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, values);

            ListView lv=findViewById(R.id.listview_add_seller);
            lv.setAdapter(adapter);
        }
        else{setContentView(R.layout.add_user); setTitle("회원가입");
        }

    }



}
