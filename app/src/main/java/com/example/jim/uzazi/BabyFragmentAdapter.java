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

public class BabyFragmentAdapter extends ArrayAdapter<ContentfromDb> {
    public BabyFragmentAdapter(Context context, ArrayList<ContentfromDb> values){

        super(context,0,values);

    }

    // Get rowlayout and set the text view . It will happen to each and every row in the List view.
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {



        // Check if an existing view is being reused, otherwise inflate the view
        ContentfromDb data = getItem(position);
        if (convertView == null) {

            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_layout_for_baby, parent, false);
        }
        TextView Article  =  convertView.findViewById(R.id.ContentCardview);
        TextView heading = convertView.findViewById(R.id.TitleCardview);
        CardView cardView = convertView.findViewById(R.id.CardviewBabyFragment);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.ImageviewCardview);

        Article.setText(data.getActual_Child_Article());
        heading.setText(data.getChild_Article_Heading());
        String bayurl = data.getChild_Article_Img_Url();

        try {
            Picasso.get()
                    .load(bayurl)
                    .placeholder(R.drawable.progress_animation)
                    .into(imageView);
        }catch (Exception e){

        }


        //Decode The Image to Bitmap
//        File file = new File(imagepath);
//        if(file.exists()){
//            Bitmap myBitmap = BitmapFactory.decodeFile(imagepath);
//            imageView.setImageBitmap(myBitmap);
//        }





        return convertView;
    }
}
