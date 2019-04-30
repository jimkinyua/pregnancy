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

public class MotherFragment extends Fragment {
    private static final String ARG_SECTION_NUMBER = "section_number";

    private ListView listView;
    private BabyFragmentAdapter databaseContentArrayAdapter;
    private ArrayList<ContentfromDb> motherlistitems;
    private int weekpreg;

    public static MotherFragment newInstance(int sectionNumber){

        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, sectionNumber);
        bundle.putInt("weekfromactivity2",Main2Activity_Drawer.Week_Inside_Activity_2);
        MotherFragment fragment = new MotherFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        DatabaseHelper helperMother = new DatabaseHelper(
                getContext()
                , null
                , null
                , 1);

        View rootView = inflater.inflate(R.layout.listview_for_fragments, container, false);
        listView = rootView.findViewById(R.id.list_view_main);

        weekpreg = getArguments().getInt("weekfromactivity2");

        motherlistitems = helperMother.GET_EVERYTHING(weekpreg);
        MotherFragmentArrayAdapter motherFragmentArrayAdapter = new MotherFragmentArrayAdapter(getContext(),motherlistitems);
        listView.setAdapter(motherFragmentArrayAdapter);

        return rootView;
    }
}
