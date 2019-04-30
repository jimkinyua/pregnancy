package com.example.jim.uzazi;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MotherFragmentArrayAdapter extends ArrayAdapter<ContentfromDb> {
    public MotherFragmentArrayAdapter(Context context, ArrayList<ContentfromDb> FragmentMotherItems) {
        super(context, 0,FragmentMotherItems);


    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ContentfromDb ItemsFromBdForMother = getItem(position);

        //Check if View is Set
        if(convertView==null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_layout_for_mother, parent, false);
            TextView Articlemother  =  convertView.findViewById(R.id.ContentMotherFragment);
            TextView headingmother = convertView.findViewById(R.id.TitleMotherFragment);
            CardView cardViewmother = convertView.findViewById(R.id.CardviewMotherFragment);
            ImageView imageViewmother = (ImageView) convertView.findViewById(R.id.ImageviewMother);

            Articlemother.setText(ItemsFromBdForMother.getActual_Mother_Artcle());
            headingmother.setText(ItemsFromBdForMother.getMother_Article_Heading());
            String Babyurl = ItemsFromBdForMother.getMother_Article_Img_Url();

            try {
                Picasso.get()
                        .load(Babyurl)
                        .placeholder(R.drawable.progress_animation)
                        .into(imageViewmother);
            }catch (Exception e){

            }


//            String PACKAGE_NAME = getContext().getPackageName();
//            int ImgRes = getContext().getResources().getIdentifier(PACKAGE_NAME+":/drawable/"+imagename,null,null);
//imageViewmother.setImageBitmap(BitmapFactory.decodeResource(getContext().getResources(),ImgRes));




        }

        return convertView;

    }


}
