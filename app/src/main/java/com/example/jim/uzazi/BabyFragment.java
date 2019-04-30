package com.example.jim.uzazi;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class BabyFragment extends Fragment {
    private static final String ARG_SECTION_NUMBER = "section_number";
    private ListView listView;
    private ArrayList<ContentfromDb> motherlistitems;
    private int weekpreg;

    public static BabyFragment newInstance(int sectionNumber){

        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, sectionNumber);
        bundle.putInt("weekfromactivity2",Main2Activity_Drawer.Week_Inside_Activity_2);
        BabyFragment fragment = new BabyFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        DatabaseHelper helperBaby = new DatabaseHelper(
                getContext()
                , null
                , null
                , 1);


        View rootView = inflater.inflate(R.layout.listview_for_fragments, container, false);
        listView = rootView.findViewById(R.id.list_view_main);

        weekpreg = getArguments().getInt("weekfromactivity2");

        motherlistitems = helperBaby.GET_EVERYTHING(weekpreg);
        BabyFragmentAdapter babyFragmentAdapter = new BabyFragmentAdapter(getContext(),motherlistitems);
        listView.setAdapter(babyFragmentAdapter);



        return rootView;
    }
}
