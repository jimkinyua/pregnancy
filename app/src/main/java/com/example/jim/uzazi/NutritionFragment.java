package com.example.jim.uzazi;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class NutritionFragment extends Fragment {
    private static final String ARG_SECTION_NUMBER = "section_number";

    private ListView listView;
    private ArrayList<ContentfromDb> Nutritionlistitems;
    private int weekpreg;


    public NutritionFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static NutritionFragment newInstance(int sectionNumber) {
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        args.putInt("weekfromactivity2",Main2Activity_Drawer.Week_Inside_Activity_2);
        NutritionFragment fragment = new NutritionFragment( );
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {

        DatabaseHelper helperNutrition = new DatabaseHelper(
                getContext()
                , null
                , null
                , 1);

        View rootview = inflater.inflate(R.layout.listview_for_fragments, container, false);
        listView = rootview.findViewById(R.id.list_view_main);

        weekpreg = getArguments().getInt("weekfromactivity2");
        Nutritionlistitems = helperNutrition.GET_EVERYTHING(weekpreg);

        NutritionFragmentAdapter nutritionFragmentAdapter  = new NutritionFragmentAdapter(
                getContext(),
                Nutritionlistitems);

        listView.setAdapter(nutritionFragmentAdapter);

        return rootview;
    }

}
