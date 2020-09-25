package com.example.one_card;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

public class FragMyPage extends Fragment {
    View rootView;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //mInit();
        //listClick();
        rootView = inflater.inflate(R.layout.mypage_frag, container, false);
        TextView textViewid=rootView.findViewById(R.id.textView_id);
        TextView textViewname=rootView.findViewById(R.id.textView_name);
        //textViewid.setText("param1");
        //String userId = savedInstanceState.getString("userId");
        String str;



        if(getArguments() != null){

            Bundle bundle=getArguments();
            String param1 = bundle.getString("userID");
          //  String param2 = bundle.getString("username");
            textViewid.setText(param1);
           // textViewname.setText(param2);

        }; // 전달한 key 값 String param2 = getArguments().getString("param2"); // 전달한 key 값 }



        String[] values = new String[]{"계정관리", "로그아웃", "회원탈퇴"};

        ListView lv = (ListView) rootView.findViewById(R.id.listview);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, values);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), ProfileActivity.class);
                intent.putExtra("position", position);
                if (position == 1) {
                    DialogInterface.OnClickListener mDlgListener = new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            switch (which) {
                                case AlertDialog.BUTTON_POSITIVE://로그아웃
                                    break;
                                case AlertDialog.BUTTON_NEGATIVE:
                                    break;
                            }
                        }
                    };
                    new AlertDialog.Builder(getActivity())
                            .setTitle("로그아웃 하시겠습니까?")
                            .setPositiveButton("예",new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int whichButton) {
                                    Intent i = new Intent(getContext(), LoginActivity.class);
                                    i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_SINGLE_TOP);
                                    startActivity(i);
                                }
                            })


                            .setNegativeButton("취소", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int whichButton) {

                                }
                            })


                            .show();
                }
                else if(position==0){
                    DialogInterface.OnClickListener mDlgListener = new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            switch (which) {
                                case AlertDialog.BUTTON_POSITIVE://로그아웃
                                    break;
                                case AlertDialog.BUTTON_NEGATIVE:
                                    break;
                            }
                        }
                    };
                    new AlertDialog.Builder(getActivity())
                            .setTitle("수정하시겠습니까?")
                            .setPositiveButton("예",new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int whichButton) {

                                }
                            })


                            .setNegativeButton("취소", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int whichButton) {

                                }
                            })

                            .show();

                }

                else {
                    startActivity(intent);
                }
            }
        });
        return rootView;
    }
}

