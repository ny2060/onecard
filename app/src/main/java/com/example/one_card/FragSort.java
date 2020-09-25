package com.example.one_card;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragSort extends Fragment {
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

       View layout = inflater.inflate(R.layout.sort_frag, container, false);
       /*
       //알람할 때 썼던 부분..
        ListView lv=(ListView)layout.findViewById(R.id.listview_alarm);

        ArrayList<HashMap<String,String>> list = new ArrayList<HashMap<String,String>>();
        HashMap<String,String> item;
        item = new HashMap<String,String>();
        item.put("item 1", "투썸플레이스");
        item.put("item 2", "여름맞이 할인 시작");
        list.add(item);

        SimpleAdapter simpleAdapter = new SimpleAdapter(getActivity(), list, android.R.layout.simple_list_item_2,
                new String[] {"item 1","item 2"},
                new int[] {android.R.id.text1, android.R.id.text2});
        lv.setAdapter(simpleAdapter);*/

        return layout;
    }
}
