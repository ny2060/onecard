package com.example.one_card;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{

    private BottomNavigationView bottomNavigationView;
    private FragmentManager fragmentManager;
    private FragmentTransaction ft;
    private FragHome frag1 = new FragHome();
    private FragSort frag2 = new FragSort();
    private FragCafe frag3 = new FragCafe();
    private FragMyPage frag4 = new FragMyPage();
    ArrayList<String> userPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        bottomNavigationView = findViewById(R.id.bottomNavi);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener()
        {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem)
            {
                switch (menuItem.getItemId())
                {
                    case R.id.home:
                        setFrag(0);
                        break;
                    case R.id.sort:
                        setFrag(1);
                        break;
                    case R.id.cafe:
                        setFrag(2);
                        break;
                    case R.id.myPage:

                        // Fragment 생성
                        Bundle bundle = new Bundle();
                        Intent intent=getIntent();
                        String userid=intent.getStringExtra("userID");
                      //  String username=intent.getStringExtra("username");

                        bundle.putString("userID", userid);
                      //  bundle.putString("username", username);
                        // Key, Value fragment.setArguments(bundle);
                        frag4.setArguments(bundle);
                        setFrag(3);
                        break;
                }
                return true;
            }
        });

        frag1=new FragHome();
        frag2=new FragSort();
        frag3=new FragCafe();
        frag4=new FragMyPage();
        setFrag(0); // 첫 프래그먼트 화면 지정

    }

    // 프레그먼트 교체
    private void setFrag(int n)
    {
        fragmentManager = getSupportFragmentManager();
        ft= fragmentManager.beginTransaction();
        switch (n)
        {
            case 0:
                ft.replace(R.id.Main_Frame,frag1);
                ft.commit();
                break;

            case 1:
                ft.replace(R.id.Main_Frame,frag2);
                ft.commit();
                break;

            case 2:
                ft.replace(R.id.Main_Frame,frag3);
                ft.commit();
                break;

            case 3:

                ft.replace(R.id.Main_Frame,frag4);
                ft.commit();
                break;
        }
    }

}
