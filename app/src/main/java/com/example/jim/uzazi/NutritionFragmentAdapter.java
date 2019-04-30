package com.example.jim.uzazi;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class NutritionFragmentAdapter extends ArrayAdapter<ContentfromDb>  {
    public NutritionFragmentAdapter(Context context, ArrayList<ContentfromDb> FragmentNutritionItems) {
        super(context, 0,FragmentNutritionItems);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ContentfromDb ItemsFromDbForNutrition = getItem(position);
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_layout_for_nutrition,parent,false);

            TextView ArticleNutrition  =  convertView.findViewById(R.id.ContentNutritionFragment);
            TextView headingNutrition = convertView.findViewById(R.id.TitleNutritionFragment);
            CardView cardViewNutrition = convertView.findViewById(R.id.CardviewNutritionFragment);
            ImageView imageViewNutrition = (ImageView) convertView.findViewById(R.id.ImageviewNutrition);

            ArticleNutrition.setText(ItemsFromDbForNutrition.getActual_Nutrition_Artcle());
            headingNutrition.setText(ItemsFromDbForNutrition.getNutrition_Article_Heading());
            String Nuturl = ItemsFromDbForNutrition.getNutrition_IMG_URL();

            try {
                Picasso.get()
                        .load(Nuturl)
                        .placeholder(R.drawable.progress_animation)
                        .into(imageViewNutrition);
            }catch (Exception e){

            }

        }
        return convertView;
    }
}
