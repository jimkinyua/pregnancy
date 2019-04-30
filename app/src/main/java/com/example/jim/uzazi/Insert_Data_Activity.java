package com.example.jim.uzazi;


import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.LocalDate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Insert_Data_Activity extends AppCompatActivity implements View.OnClickListener {

    public  static DatabaseHelper databaseHelper;


    //home/jim/AndroidStudioProjects/PopDown_Sample/app/src/main/res/drawable/Week1
    EditText Duedate;
    EditText LastPeriod;

    final Calendar calendar = Calendar.getInstance();
    DatePickerDialog.OnDateSetListener date;
    Button register;
    TextView numweek;
    String content;
    String imagelocation;
    int NUMBER_OF_WEEKS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        init();
        CREATE_TABLE_WEEK_1();
        INSERT_INTO_TABLE_WEEK_1();

        CREATE_TABLE_WEEK_2();;
        INSERT_INTO_TABLE_WEEK2();

        CREATE_TABLE_WEEK3();
        INSERT_INTO_TABLE_WEEK3();

        CREATE_TABLE_WEEK4();
        INSERT_INTO_TABLE_WEK4();

        CREATE_TABLE_WEEK5();
        INSERT_INTO_TABLE_WEK5();

        CREATE_TABLE_WEEK6();
        INSERT_INTO_TABLE_WEK6();

        CREATE_TABLE_WEEK7();
        INSERT_INTO_TABLE_WEK7();

        CREATE_TABLE_WEEK8();
        INSERT_INTO_TABLE_WEK8();


        CREATE_TABLE_WEEK9();
        INSERT_INTO_TABLE_WEK9();

        CREATE_TABLE_WEEK10();
        INSERT_INTO_TABLE_WEK10();

        CREATE_TABLE_WEEK11();
        INSERT_INTO_TABLE_WEK11();

        CREATE_TABLE_WEEK12();
        INSERT_INTO_TABLE_WEK12();

        CREATE_TABLE_WEEK13();
        INSERT_INTO_TABLE_WEK13();

        CREATE_TABLE_WEEK14();
        INSERT_INTO_TABLE_WEK14();

        CREATE_TABLE_WEEK15();
        INSERT_INTO_TABLE_WEK15();

        CREATE_TABLE_WEEK16();
        INSERT_INTO_TABLE_WEK16();

        CREATE_TABLE_WEEK17();
        INSERT_INTO_TABLE_WEK17();

        CREATE_TABLE_WEEK18();
        INSERT_INTO_TABLE_WEK18();

        CREATE_TABLE_WEEK19();
        INSERT_INTO_TABLE_WEK19();

        CREATE_TABLE_WEEK20();
        INSERT_INTO_TABLE_WEK20();

        CREATE_TABLE_WEEK21();
        INSERT_INTO_TABLE_WEK21();

        CREATE_TABLE_WEEK22();
        INSERT_INTO_TABLE_WEK22();

        CREATE_TABLE_WEEK23();
        INSERT_INTO_TABLE_WEK23();

        CREATE_TABLE_WEEK24();
        INSERT_INTO_TABLE_WEK24();

        CREATE_TABLE_WEEK25();
        INSERT_INTO_TABLE_WEK25();

        CREATE_TABLE_WEEK26();
        INSERT_INTO_TABLE_WEK26();

        CREATE_TABLE_WEEK27();
        INSERT_INTO_TABLE_WEK27();

        CREATE_TABLE_WEEK28();
        INSERT_INTO_TABLE_WEK28();

        CREATE_TABLE_WEEK29();
        INSERT_INTO_TABLE_WEK29();

        CREATE_TABLE_WEEK30();
        INSERT_INTO_TABLE_WEK30();

        CREATE_TABLE_WEEK31();
        INSERT_INTO_TABLE_WEK31();

        CREATE_TABLE_WEEK32();
        INSERT_INTO_TABLE_WEK32();

        CREATE_TABLE_WEEK33();
        INSERT_INTO_TABLE_WEK33();

        CREATE_TABLE_WEEK34();
        INSERT_INTO_TABLE_WEK34();

        CREATE_TABLE_WEEK35();
        INSERT_INTO_TABLE_WEK35();

        CREATE_TABLE_WEEK36();
        INSERT_INTO_TABLE_WEK36();

        CREATE_TABLE_WEEK37();
        INSERT_INTO_TABLE_WEK37();

        CREATE_TABLE_WEEK38();
        INSERT_INTO_TABLE_WEK38();

        CREATE_TABLE_WEEK39();
        CREATE_TABLE_WEEK39();

        CREATE_TABLE_WEEK40();
        INSERT_INTO_TABLE_WEK40();

        CREATE_TABLE_WEEK41();
        INSERT_INTO_TABLE_WEK41();
    }



    @Override
    public void onClick(View v) {

        switch(v.getId()){

            case R.id.Duedate:

                DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        calendar.set(Calendar.YEAR, year);
                        calendar.set(Calendar.MONTH, month);
                        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                        String myFormat = "dd/MMMM/yyyy";
                        SimpleDateFormat sdf = new SimpleDateFormat( myFormat);
                        Duedate.setText(sdf.format(calendar.getTime()));

                        calendar.add(Calendar.DATE,-280);
                        LastPeriod.setText(sdf.format(calendar.getTime()));
                        calendar.add(Calendar.DATE,280);
                    }

                };
                DatePickerDialog picker = new  DatePickerDialog(Insert_Data_Activity.this,date,calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH));
                picker.show();

                break;

            case R.id.Last_period:
                date = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        view.setMinDate(System.currentTimeMillis());
                        calendar.set(Calendar.YEAR, year);
                        calendar.set(Calendar.MONTH, month);
                        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                        String myFormat = "dd/MMMM/yyyy";
                        SimpleDateFormat sdf = new SimpleDateFormat( myFormat);
                        LastPeriod.setText(sdf.format(calendar.getTime()));



                        calendar.add(Calendar.DATE,280);
//                        String Format0 = "dd/MMMM/yyyy";
//                        SimpleDateFormat sdf1;
//                        sdf1 = new SimpleDateFormat( Format0);
                        Duedate.setText(sdf.format(calendar.getTime()));
                        calendar.add(Calendar.DATE,-280);
                    }

                };
                new  DatePickerDialog(Insert_Data_Activity.this,date,calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH)).show();
                break;
        }

        //Register the Mother after Filling the form.

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Get the set date.
                String LastPeriodString = LastPeriod.getText().toString();

                String dateformat = "dd/MMMM/yyyy";
                SimpleDateFormat sdf2 = new SimpleDateFormat(dateformat);
                try {
                    Date Lastp  = sdf2.parse(LastPeriodString);
                    LocalDate jodaLastPeriod = convertUtilDateToLocalDate(Lastp);

                    LocalDate today = new LocalDate();
                    int days = Days.daysBetween(jodaLastPeriod, today).getDays();
                    NUMBER_OF_WEEKS = (days/7);

                    String  numberofweeksstring = Integer.toString(NUMBER_OF_WEEKS);

                    if(NUMBER_OF_WEEKS<1 || NUMBER_OF_WEEKS>40){
                        numweek.setText("Please, you cannot be more than 40 weeks pregnant or less than 1 week pregnant");
                    }else{

                        numweek.setText("Congratulations You are "+numberofweeksstring+" Weeks Pregnant !");


                        //Launch the activity after 1 seconds to allow user to read the Text
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Intent intent = new Intent(Insert_Data_Activity.this, Main2Activity_Drawer.class);
                                intent.putExtra("week",NUMBER_OF_WEEKS);
//
                                startActivity(intent);
                            }
                        },110);

                    }




                } catch (ParseException e) {
                    e.printStackTrace();
                }

            }
        });

        date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                view.setMinDate(System.currentTimeMillis());

            }
        };

    }


    public void init(){
        Duedate = (EditText) findViewById(R.id.Duedate);
        LastPeriod = (EditText) findViewById(R.id.Last_period);
        register = (Button) findViewById(R.id.button_proceed);
        numweek = (TextView) findViewById(R.id.textView_Pregnancy_week_she_is_in);


        //Set the Edit texts to Listen to Onclick Events.
        Duedate.setOnClickListener(this);
        LastPeriod.setOnClickListener(this);

        //initialise the databasehelper class.
        databaseHelper = new DatabaseHelper(this,null,null,1);

    }


    //Function to convert Java.util.LocalDate to joda Local date object.
    public  LocalDate convertUtilDateToLocalDate(Date date) {
        if(date==null) return null;
        DateTime dt = new DateTime(date);
        return dt.toLocalDate();
    }

    private void CREATE_TABLE_WEEK_1() {
        databaseHelper.CREATE_TABLE_WEEK_1();
    }


    public void INSERT_INTO_TABLE_WEEK_1(){
        DatabaseContent.Week1 Week_1_Content =  new DatabaseContent.Week1();

        try {
            databaseHelper.INSERT_DATA_T0_WEEK1(

                    Week_1_Content.getCOL_MOTHER_ARTICLE_HEADING_WEEK_1(),
                    Week_1_Content.getCOL_MOTHER_ARTICLE_IMGURL_WEEK_1(),
                    Week_1_Content.getCOL_ACTUAL_MOTHER_ARTICLES_WEEK_1(),

                    //Baby Content.
                    Week_1_Content.getCOL_BABAY_HEALTH_HEADING_WEEK_1(),
                    Week_1_Content.getCOL_BABY_HEALTH_IMGURL_WEEK_1(),
                    Week_1_Content.getCOL_BABY_HEALTH_ACTUAL_ARTICLE_WEEK_1(),

                    //Nutrional Content
                    Week_1_Content.getNutrition_Header_WEEK1(),
                    Week_1_Content.getNUTRITION_IMG_URL_WEEK1(),
                    Week_1_Content.getNUTRITION_ARTICLE_WEEK1());
        }catch (Exception e){
            e.printStackTrace();

        }
    }


    public void CREATE_TABLE_WEEK_2(){
        try {
            databaseHelper.CREATE_TABLE_WEEK_2();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void INSERT_INTO_TABLE_WEEK2(){
        DatabaseContent.Week2 Week_2_Content =  new DatabaseContent.Week2();
        try {
            databaseHelper.INSERT_DATA_T0_WEEK2(
                    //Mother Information
                    Week_2_Content.getCOL_MOTHER_ARTICLE_HEADING_WEEK_2(),
                    Week_2_Content.getCOL_MOTHER_ARTICLE_IMGURL_WEEK_2(),
                    Week_2_Content.getCOL_ACTUAL_MOTHER_ARTICLES_WEEK_2(),

                    //Insert Child Data);
                    Week_2_Content.getCOL_BABAY_HEALTH_HEADING_WEEK_2(),
                    Week_2_Content.getCOL_BABY_HEALTH_IMGURL_WEEK_2(),
                    Week_2_Content.getCOL_BABY_HEALTH_ACTUAL_ARTICLE_WEEK_2(),

                    //Nutritional Details

                    Week_2_Content.getNutrition_Header_WEEK2(),
                    Week_2_Content.getNUTRITION_IMG_URL_WEEK2(),
                    Week_2_Content.getNUTRITION_ARTICLE_WEEK2()
            );

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void CREATE_TABLE_WEEK3(){
        try{
            databaseHelper.CREATE_TABLE_WEEK3();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void INSERT_INTO_TABLE_WEEK3(){
        DatabaseContent.Week3 Week3_Content = new DatabaseContent.Week3();
        try{
            databaseHelper.INSERT_DATA_T0_WEEK3(Week3_Content.getCOL_MOTHER_ARTICLE_HEADING_WEEK_3(),
                    Week3_Content.getCOL_MOTHER_ARTICLE_IMGURL_WEEK_3(),
                    Week3_Content.getCOL_ACTUAL_MOTHER_ARTICLES_WEEK_3(),

                    //Child Details
                    Week3_Content.getCOL_BABAY_HEALTH_HEADING_WEEK_3(),
                    Week3_Content.getCOL_BABY_HEALTH_IMGURL_WEEK_3(),
                    Week3_Content.getCOL_BABY_HEALTH_ACTUAL_ARTICLE_WEEK_3(),

                    //Nutritional Details
                    Week3_Content.getNutrition_Header_WEEK3(),
                    Week3_Content.getNUTRITION_IMG_URL_WEEK3(),
                    Week3_Content.getNUTRITION_ARTICLE_WEEK3()
            );

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void CREATE_TABLE_WEEK4() {

        databaseHelper.CREATE_TABLE_WEEK4();

    }

    private void INSERT_INTO_TABLE_WEK4() {
        DatabaseContent.Week4 Week4_Content = new DatabaseContent.Week4();
        databaseHelper.INSERT_DATA_T0_WEEK4(
                //Mother Details
                Week4_Content.getCOL_MOTHER_ARTICLE_HEADING_WEEK_4(),
                Week4_Content.getCOL_MOTHER_ARTICLE_IMGURL_WEEK4(),
                Week4_Content.getCOL_ACTUAL_MOTHER_ARTICLES_WEEK_4(),

                //Child Details

                Week4_Content.getCOL_BABAY_HEALTH_HEADING_WEEK_4(),
                Week4_Content.getCOL_BABY_HEALTH_IMGURL_WEEK_4(),
                Week4_Content.getCOL_BABY_HEALTH_ACTUAL_ARTICLE_WEEK_4(),

                //Nutrition Details

                Week4_Content.getNutrition_Header_WEEK4(),
                Week4_Content.getNUTRITION_IMG_URL_WEEK4(),
                Week4_Content.getNUTRITION_ARTICLE_WEEK4()

        );

    }

    private void CREATE_TABLE_WEEK5() {

        databaseHelper.CREATE_TABLE_WEEK5();

    }

    private void INSERT_INTO_TABLE_WEK5() {
        DatabaseContent.Week5 Week5_Content = new DatabaseContent.Week5();
        databaseHelper.INSERT_DATA_T0_WEEK5(
                //Mother Details
                Week5_Content.getCOL_MOTHER_ARTICLE_HEADING_WEEK_5(),
                Week5_Content.getCOL_MOTHER_ARTICLE_IMGURL_WEEK5(),
                Week5_Content.getCOL_ACTUAL_MOTHER_ARTICLES_WEEK_5(),

                //Child Details

                Week5_Content.getCOL_BABAY_HEALTH_HEADING_WEEK_5(),
                Week5_Content.getCOL_BABY_HEALTH_IMGURL_WEEK_5(),
                Week5_Content.getCOL_BABY_HEALTH_ACTUAL_ARTICLE_WEEK_5(),

                //Nutrition Details

                Week5_Content.getNutrition_Header_WEEK_5(),
                Week5_Content.getNUTRITION_IMG_URL_WEEK_5(),
                Week5_Content.getNUTRITION_ARTICLE_WEEK_5()

        );

    }

    private void CREATE_TABLE_WEEK6() {

        databaseHelper.CREATE_TABLE_WEEK6();

    }

    private void INSERT_INTO_TABLE_WEK6() {
        DatabaseContent.Week6 week6 = new DatabaseContent.Week6();
        databaseHelper.INSERT_DATA_T0_WEEK6(
                //Mother Details
                week6.getCOL_MOTHER_ARTICLE_HEADING_WEEK_6(),
                week6.getCOL_MOTHER_ARTICLE_IMGURL_WEEK6(),
                week6.getCOL_ACTUAL_MOTHER_ARTICLES_WEEK_6(),

                //Child Details

                week6.getCOL_BABAY_HEALTH_HEADING_WEEK_6(),
                week6.getCOL_BABY_HEALTH_IMGURL_WEEK_6(),
                week6.getCOL_BABY_HEALTH_ACTUAL_ARTICLE_WEEK_6(),

                //Nutrition Details

                week6.getNutrition_Header_WEEK6(),
                week6.getNUTRITION_IMG_URL_WEEK6(),
                week6.getNUTRITION_ARTICLE_WEEK6()

        );

    }
    private void CREATE_TABLE_WEEK7() {

        databaseHelper.CREATE_TABLE_WEEK7();

    }

    private void INSERT_INTO_TABLE_WEK7() {
        DatabaseContent.Week7 week7 = new DatabaseContent.Week7();
        databaseHelper.INSERT_DATA_T0_WEEK7(
                //Mother Details
                week7.getCOL_MOTHER_ARTICLE_HEADING_WEEK_7(),
                week7.getCOL_MOTHER_ARTICLE_IMGURL_WEEK7f(),
                week7.getCOL_ACTUAL_MOTHER_ARTICLES_WEEK_7(),

                //Child Details

                week7.getCOL_BABAY_HEALTH_HEADING_WEEK_7(),
                week7.getCOL_BABY_HEALTH_IMGURL_WEEK_7(),
                week7.getCOL_BABY_HEALTH_ACTUAL_ARTICLE_WEEK_7(),

                //Nutrition Details

                week7.getNutrition_Header_WEEK7(),
                week7.getNUTRITION_IMG_URL_WEEK7(),
                week7.getNUTRITION_ARTICLE_WEEK7()

        );

    }
    private void CREATE_TABLE_WEEK8() {

        databaseHelper.CREATE_TABLE_WEEK8();

    }

    private void INSERT_INTO_TABLE_WEK8() {
        DatabaseContent.Week8 week8 = new DatabaseContent.Week8();
        databaseHelper.INSERT_DATA_T0_WEEK8(
                //Mother Details
                week8.getCOL_MOTHER_ARTICLE_HEADING_WEEK_8(),
                week8.getCOL_MOTHER_ARTICLE_IMGURL_WEEK8(),
                week8.getCOL_ACTUAL_MOTHER_ARTICLES_WEEK_8(),

                //Child Details

                week8.getCOL_BABAY_HEALTH_HEADING_WEEK_8(),
                week8.getCOL_BABY_HEALTH_IMGURL_WEEK_8(),
                week8.getCOL_BABY_HEALTH_ACTUAL_ARTICLE_WEEK_8(),

                //Nutrition Details

                week8.getNutrition_Header_WEEK8(),
                week8.getNUTRITION_IMG_URL_WEEK8(),
                week8.getNUTRITION_ARTICLE_WEEK8()

        );

    }


    private void CREATE_TABLE_WEEK9() {

        databaseHelper.CREATE_TABLE_WEEK9();

    }

    private void INSERT_INTO_TABLE_WEK9() {
        DatabaseContent.Week9 week9 = new DatabaseContent.Week9();
        databaseHelper.INSERT_DATA_T0_WEEK9(
                //Mother Details
                week9.getCOL_MOTHER_ARTICLE_HEADING_WEEK_9(),
                week9.getCOL_MOTHER_ARTICLE_IMGURL_WEEK9(),
                week9.getCOL_ACTUAL_MOTHER_ARTICLES_WEEK_9(),

                //Child Details

                week9.getCOL_BABY_HEALTH_HEADING_WEEK_9(),
                week9.getCOL_BABY_HEALTH_IMGURL_WEEK_9(),
                week9.getCOL_BABY_HEALTH_ACTUAL_ARTICLE_WEEK_9(),

                //Nutrition Details

                week9.getNutrition_Header_WEEK9(),
                week9.getNUTRITION_IMG_URL_WEEK9(),
                week9.getNUTRITION_ARTICLE_WEEK9()

        );

    }

    private void CREATE_TABLE_WEEK10() {

        databaseHelper.CREATE_TABLE_WEEK10();

    }

    private void INSERT_INTO_TABLE_WEK10() {
        DatabaseContent.Week10 week10 = new DatabaseContent.Week10();
        databaseHelper.INSERT_DATA_T0_WEEK10(
                //Mother Details
                week10.getCOL_MOTHER_ARTICLE_HEADING_WEEK_10(),
                week10.getCOL_MOTHER_ARTICLE_IMGURL_WEEK10(),
                week10.getCOL_ACTUAL_MOTHER_ARTICLES_WEEK_10(),

                //Child Details

                week10.getCOL_BABY_HEALTH_HEADING_WEEK_10(),
                week10.getCOL_BABY_HEALTH_IMGURL_WEEK_10(),
                week10.getCOL_BABY_HEALTH_ACTUAL_ARTICLE_WEEK_10(),

                //Nutrition Details

                week10.getNutrition_Header_WEEK10(),
                week10.getNUTRITION_IMG_URL_WEEK10(),
                week10.getNUTRITION_ARTICLE_WEEK10()

        );

    }
    private void CREATE_TABLE_WEEK11() {

        databaseHelper.CREATE_TABLE_WEEK11();

    }

    private void INSERT_INTO_TABLE_WEK11() {
        DatabaseContent.Week11 week11 = new DatabaseContent.Week11();
        databaseHelper.INSERT_DATA_T0_WEEK11(
                //Mother Details
                week11.getCOL_MOTHER_ARTICLE_HEADING_WEEK_11(),
                week11.getCOL_MOTHER_ARTICLE_IMGURL_WEEK11(),
                week11.getCOL_ACTUAL_MOTHER_ARTICLES_WEEK_11(),

                //Child Details

                week11.getCOL_BABAY_HEALTH_HEADING_WEEK_11(),
                week11.getCOL_BABY_HEALTH_IMGURL_WEEK_11(),
                week11.getCOL_BABY_HEALTH_ACTUAL_ARTICLE_WEEK_11(),

                //Nutrition Details

                week11.getNutrition_Header_WEEK11(),
                week11.getNUTRITION_IMG_URL_WEEK11(),
                week11.getNUTRITION_ARTICLE_WEEK11()

        );

    }
    private void CREATE_TABLE_WEEK12() {

        databaseHelper.CREATE_TABLE_WEEK12();

    }

    private void INSERT_INTO_TABLE_WEK12() {
        DatabaseContent.Week12 week12 = new DatabaseContent.Week12();
        databaseHelper.INSERT_DATA_T0_WEEK12(
                //Mother Details
                week12.getCOL_MOTHER_ARTICLE_HEADING_WEEK_12(),
                week12.getCOL_MOTHER_ARTICLE_IMGURL_WEEK12(),
                week12.getCOL_ACTUAL_MOTHER_ARTICLES_WEEK_12(),

                //Child Details

                week12.getCOL_BABAY_HEALTH_HEADING_WEEK_12(),
                week12.getCOL_BABY_HEALTH_IMGURL_WEEK_12(),
                week12.getCOL_BABY_HEALTH_ACTUAL_ARTICLE_WEEK_12(),

                //Nutrition Details

                week12.getNutrition_Header_WEEK12(),
                week12.getNUTRITION_IMG_URL_WEEK12(),
                week12.getNUTRITION_ARTICLE_WEEK12()

        );

    }
    private void CREATE_TABLE_WEEK13() {

        databaseHelper.CREATE_TABLE_WEEK13();

    }

    private void INSERT_INTO_TABLE_WEK13() {
        DatabaseContent.Week13 week13 = new DatabaseContent.Week13();
        databaseHelper.INSERT_DATA_T0_WEEK13(
                //Mother Details
                week13.getCOL_MOTHER_ARTICLE_HEADING_WEEK_13(),
                week13.getCOL_MOTHER_ARTICLE_IMGURL_WEEK13(),
                week13.getCOL_ACTUAL_MOTHER_ARTICLES_WEEK_13(),

                //Child Details

                week13.getCOL_BABAY_HEALTH_HEADING_WEEK_13(),
                week13.getCOL_BABY_HEALTH_IMGURL_WEEK_13(),
                week13.getCOL_BABY_HEALTH_ACTUAL_ARTICLE_WEEK_13(),

                //Nutrition Details

                week13.getNutrition_Header_WEEK13(),
                week13.getNUTRITION_IMG_URL_WEEK13(),
                week13.getNUTRITION_ARTICLE_WEEK13()

        );

    }
    private void CREATE_TABLE_WEEK14() {

        databaseHelper.CREATE_TABLE_WEEK14();

    }

    private void INSERT_INTO_TABLE_WEK14() {
        DatabaseContent.Week14 week14 = new DatabaseContent.Week14();
        databaseHelper.INSERT_DATA_T0_WEEK14(
                //Mother Details
                week14.getCOL_MOTHER_ARTICLE_HEADING_WEEK_14(),
                week14.getCOL_MOTHER_ARTICLE_IMGURL_WEEK14(),
                week14.getCOL_ACTUAL_MOTHER_ARTICLES_WEEK_14(),

                //Child Details

                week14.getCOL_BABAY_HEALTH_HEADING_WEEK_14(),
                week14.getCOL_BABY_HEALTH_IMGURL_WEEK_14(),
                week14.getCOL_BABY_HEALTH_ACTUAL_ARTICLE_WEEK_14(),

                //Nutrition Details

                week14.getNutrition_Header_WEEK14(),
                week14.getNUTRITION_IMG_URL_WEEK14(),
                week14.getNUTRITION_ARTICLE_WEEK14()

        );

    }

    private void CREATE_TABLE_WEEK15() {

        databaseHelper.CREATE_TABLE_WEEK15();

    }

    private void INSERT_INTO_TABLE_WEK15() {
        DatabaseContent.Week15 week15 = new DatabaseContent.Week15();
        databaseHelper.INSERT_DATA_T0_WEEK15(
                //Mother Details
                week15.getCOL_MOTHER_ARTICLE_HEADING_WEEK_15(),
                week15.getCOL_MOTHER_ARTICLE_IMGURL_WEEK15(),
                week15.getCOL_ACTUAL_MOTHER_ARTICLES_WEEK_15(),

                //Child Details

                week15.getCOL_BABAY_HEALTH_HEADING_WEEK_15(),
                week15.getCOL_BABY_HEALTH_IMGURL_WEEK_15(),
                week15.getCOL_BABY_HEALTH_ACTUAL_ARTICLE_WEEK_15(),

                //Nutrition Details

                week15.getNutrition_Header_WEEK15(),
                week15.getNUTRITION_IMG_URL_WEEK15(),
                week15.getNUTRITION_ARTICLE_WEEK15()

        );

    }

    private void CREATE_TABLE_WEEK16() {

        databaseHelper.CREATE_TABLE_WEEK16();

    }

    private void INSERT_INTO_TABLE_WEK16() {
        DatabaseContent.Wek16 week16 = new DatabaseContent.Wek16();
        databaseHelper.INSERT_DATA_T0_WEEK16(
                //Mother Details
                week16.getCOL_MOTHER_ARTICLE_HEADING_WEEK_16(),
                week16  .getCOL_MOTHER_ARTICLE_IMGURL_WEEK16(),
                week16.getCOL_ACTUAL_MOTHER_ARTICLES_WEEK_16(),

                //Child Details

                week16.getCOL_BABAY_HEALTH_HEADING_WEEK_16(),
                week16.getCOL_BABY_HEALTH_IMGURL_WEEK_16(),
                week16.getCOL_BABY_HEALTH_ACTUAL_ARTICLE_WEEK_16(),

                //Nutrition Details

                week16.getNutrition_Header_WEEK16(),
                week16.getNUTRITION_IMG_URL_WEEK16(),
                week16.getNUTRITION_ARTICLE_WEEK16()

        );

    }

    private void CREATE_TABLE_WEEK17() {

        databaseHelper.CREATE_TABLE_WEEK17();

    }

    private void INSERT_INTO_TABLE_WEK17() {
        DatabaseContent.Week17 week8 = new DatabaseContent.Week17();
        databaseHelper.INSERT_DATA_T0_WEEK17(
                //Mother Details
                week8.getCOL_MOTHER_ARTICLE_HEADING_WEEK_17(),
                week8.getCOL_MOTHER_ARTICLE_IMGURL_WEEK17(),
                week8.getCOL_ACTUAL_MOTHER_ARTICLES_WEEK_17(),

                //Child Details

                week8.getCOL_BABAY_HEALTH_HEADING_WEEK_17(),
                week8.getCOL_BABY_HEALTH_IMGURL_WEEK_17(),
                week8.getCOL_BABY_HEALTH_ACTUAL_ARTICLE_WEEK_17(),

                //Nutrition Details

                week8.getNutrition_Header_WEEK17(),
                week8.getNUTRITION_IMG_URL_WEEK17(),
                week8.getNUTRITION_ARTICLE_WEEK17()

        );

    }

    private void CREATE_TABLE_WEEK18() {

        databaseHelper.CREATE_TABLE_WEEK18();

    }

    private void INSERT_INTO_TABLE_WEK18() {
        DatabaseContent.Week18 week18 = new DatabaseContent.Week18();
        databaseHelper.INSERT_DATA_T0_WEEK18(
                //Mother Details
                week18.getCOL_MOTHER_ARTICLE_HEADING_WEEK_18(),
                week18.getCOL_MOTHER_ARTICLE_IMGURL_WEEK18(),
                week18.getCOL_ACTUAL_MOTHER_ARTICLES_WEEK_18(),

                //Child Details

                week18.getCOL_BABAY_HEALTH_HEADING_WEEK_18(),
                week18.getCOL_BABY_HEALTH_IMGURL_WEEK_18(),
                week18.getCOL_BABY_HEALTH_ACTUAL_ARTICLE_WEEK_18(),

                //Nutrition Details

                week18.getNutrition_Header_WEEK18(),
                week18.getNUTRITION_IMG_URL_WEEK18(),
                week18.getNUTRITION_ARTICLE_WEEK18()

        );

    }

    private void CREATE_TABLE_WEEK19() {

        databaseHelper.CREATE_TABLE_WEEK19();

    }

    private void INSERT_INTO_TABLE_WEK19() {
        DatabaseContent.Week19 week = new DatabaseContent.Week19();
        databaseHelper.INSERT_DATA_T0_WEEK19(
                //Mother Details
                week.getCOL_MOTHER_ARTICLE_HEADING_WEEK_19(),
                week.getCOL_MOTHER_ARTICLE_IMGURL_WEEK19(),
                week.getCOL_ACTUAL_MOTHER_ARTICLES_WEEK_19(),

                //Child Details

                week.getCOL_BABAY_HEALTH_HEADING_WEEK_19(),
                week.getCOL_BABY_HEALTH_IMGURL_WEEK_19(),
                week.getCOL_BABY_HEALTH_ACTUAL_ARTICLE_WEEK_19(),

                //Nutrition Details

                week.getNutrition_Header_WEEK19(),
                week.getNUTRITION_IMG_URL_WEEK19(),
                week.getNUTRITION_ARTICLE_WEEK19()

        );

    }

    private void CREATE_TABLE_WEEK20() {

        databaseHelper.CREATE_TABLE_WEEK20();

    }

    private void INSERT_INTO_TABLE_WEK20() {
        DatabaseContent.Week20 week = new DatabaseContent.Week20();
        databaseHelper.INSERT_DATA_T0_WEEK20(
                //Mother Details
                week.getCOL_MOTHER_ARTICLE_HEADING_WEEK_20(),
                week.getCOL_MOTHER_ARTICLE_IMGURL_WEEK20(),
                week.getCOL_ACTUAL_MOTHER_ARTICLES_WEEK_20(),

                //Child Details

                week.getCOL_BABAY_HEALTH_HEADING_WEEK_20(),
                week.getCOL_BABY_HEALTH_IMGURL_WEEK_20(),
                week.getCOL_BABY_HEALTH_ACTUAL_ARTICLE_WEEK_20(),

                //Nutrition Details

                week.getNutrition_Header_WEEK20(),
                week.getNUTRITION_IMG_URL_WEEK20(),
                week.getNUTRITION_ARTICLE_WEEK20()

        );

    }

    private void CREATE_TABLE_WEEK21() {

        databaseHelper.CREATE_TABLE_WEEK21();

    }

    private void INSERT_INTO_TABLE_WEK21() {
        DatabaseContent.Wee21 week = new DatabaseContent.Wee21();
        databaseHelper.INSERT_DATA_T0_WEEK21(
                //Mother Details
                week.getCOL_MOTHER_ARTICLE_HEADING_WEEK_21(),
                week.getCOL_MOTHER_ARTICLE_IMGURL_WEEK21(),
                week.getCOL_ACTUAL_MOTHER_ARTICLES_WEEK_21(),

                //Child Details

                week.getCOL_BABAY_HEALTH_HEADING_WEEK_21(),
                week.getCOL_BABY_HEALTH_IMGURL_WEEK_21(),
                week.getCOL_BABY_HEALTH_ACTUAL_ARTICLE_WEEK_21(),

                //Nutrition Details

                week.getNutrition_Header_WEEK21(),
                week.getNUTRITION_IMG_URL_WEEK21(),
                week.getNUTRITION_ARTICLE_WEEK21()

        );

    }

    private void CREATE_TABLE_WEEK22() {

        databaseHelper.CREATE_TABLE_WEEK22();

    }

    private void INSERT_INTO_TABLE_WEK22() {
        DatabaseContent.Wee22 week = new DatabaseContent.Wee22();
        databaseHelper.INSERT_DATA_T0_WEEK22(
                //Mother Details
                week.getCOL_MOTHER_ARTICLE_HEADING_WEEK_20(),
                week.getCOL_MOTHER_ARTICLE_IMGURL_WEEK22(),
                week.getCOL_ACTUAL_MOTHER_ARTICLES_WEEK_20(),

                //Child Details

                week.getCOL_BABAY_HEALTH_HEADING_WEEK_22(),
                week.getCOL_BABY_HEALTH_IMGURL_WEEK_22(),
                week.getCOL_BABY_HEALTH_ACTUAL_ARTICLE_WEEK_22(),

                //Nutrition Details

                week.getNutrition_Header_WEEK22(),
                week.getNUTRITION_IMG_URL_WEEK22(),
                week.getNUTRITION_ARTICLE_WEEK22()

        );

    }


    private void CREATE_TABLE_WEEK23() {

        databaseHelper.CREATE_TABLE_WEEK23();

    }

    private void INSERT_INTO_TABLE_WEK23() {
        DatabaseContent.Wee23 week = new DatabaseContent.Wee23();
        databaseHelper.INSERT_DATA_T0_WEEK23(
                //Mother Details
                week.getCOL_MOTHER_ARTICLE_HEADING_WEEK_23(),
                week.getCOL_MOTHER_ARTICLE_IMGURL_WEEK23(),
                week.getCOL_ACTUAL_MOTHER_ARTICLES_WEEK_23(),

                //Child Details

                week.getCOL_BABAY_HEALTH_HEADING_WEEK_23(),
                week.getCOL_BABY_HEALTH_IMGURL_WEEK_23(),
                week.getCOL_BABY_HEALTH_ACTUAL_ARTICLE_WEEK_23(),

                //Nutrition Details

                week.getNutrition_Header_WEEK23(),
                week.getNUTRITION_IMG_URL_WEEK23(),
                week.getNUTRITION_ARTICLE_WEEK23()

        );

    }


    private void CREATE_TABLE_WEEK24() {

        databaseHelper.CREATE_TABLE_WEEK24();

    }

    private void INSERT_INTO_TABLE_WEK24() {
        DatabaseContent.Wee24 week = new DatabaseContent.Wee24();
        databaseHelper.INSERT_DATA_T0_WEEK24(
                //Mother Details
                week.getCOL_MOTHER_ARTICLE_HEADING_WEEK_24(),
                week.getCOL_MOTHER_ARTICLE_IMGURL_WEEK24(),
                week.getCOL_ACTUAL_MOTHER_ARTICLES_WEEK_24(),

                //Child Details

                week.getCOL_BABAY_HEALTH_HEADING_WEEK_24(),
                week.getCOL_BABY_HEALTH_IMGURL_WEEK_24(),
                week.getCOL_BABY_HEALTH_ACTUAL_ARTICLE_WEEK_24(),

                //Nutrition Details

                week.getNutrition_Header_WEEK24(),
                week.getNUTRITION_IMG_URL_WEEK24(),
                week.getNUTRITION_ARTICLE_WEEK24()

        );

    }

    private void CREATE_TABLE_WEEK25() {

        databaseHelper.CREATE_TABLE_WEEK25();

    }

    private void INSERT_INTO_TABLE_WEK25() {
        DatabaseContent.Wee25 week = new DatabaseContent.Wee25();
        databaseHelper.INSERT_DATA_T0_WEEK25(
                //Mother Details
                week.getCOL_MOTHER_ARTICLE_HEADING_WEEK_25(),
                week.getCOL_MOTHER_ARTICLE_IMGURL_WEEK25(),
                week.getCOL_ACTUAL_MOTHER_ARTICLES_WEEK_25(),

                //Child Details

                week.getCOL_BABAY_HEALTH_HEADING_WEEK_25(),
                week.getCOL_BABY_HEALTH_IMGURL_WEEK_25(),
                week.getCOL_BABY_HEALTH_ACTUAL_ARTICLE_WEEK_25(),

                //Nutrition Details

                week.getNutrition_Header_WEEK25(),
                week.getNUTRITION_IMG_URL_WEEK25(),
                week.getNUTRITION_ARTICLE_WEEK25()

        );

    }


    private void CREATE_TABLE_WEEK26() {

        databaseHelper.CREATE_TABLE_WEEK26();

    }

    private void INSERT_INTO_TABLE_WEK26() {
        DatabaseContent.Wee26 week = new DatabaseContent.Wee26();
        databaseHelper.INSERT_DATA_T0_WEEK26(
                //Mother Details
                week.getCOL_MOTHER_ARTICLE_HEADING_WEEK_26(),
                week.getCOL_MOTHER_ARTICLE_IMGURL_WEEK26(),
                week.getCOL_ACTUAL_MOTHER_ARTICLES_WEEK_26(),

                //Child Details

                week.getCOL_BABAY_HEALTH_HEADING_WEEK_26(),
                week.getCOL_BABY_HEALTH_IMGURL_WEEK_26(),
                week.getCOL_BABY_HEALTH_ACTUAL_ARTICLE_WEEK_26(),

                //Nutrition Details

                week.getNutrition_Header_WEEK26(),
                week.getNUTRITION_IMG_URL_WEEK26(),
                week.getNUTRITION_ARTICLE_WEEK26()

        );

    }


    private void CREATE_TABLE_WEEK27() {

        databaseHelper.CREATE_TABLE_WEEK27();

    }

    private void INSERT_INTO_TABLE_WEK27() {
        DatabaseContent.Wee27 week = new DatabaseContent.Wee27();
        databaseHelper.INSERT_DATA_T0_WEEK27(
                //Mother Details
                week.getCOL_MOTHER_ARTICLE_HEADING_WEEK_27(),
                week.getCOL_MOTHER_ARTICLE_IMGURL_WEEK27(),
                week.getCOL_ACTUAL_MOTHER_ARTICLES_WEEK_27(),

                //Child Details

                week.getCOL_BABAY_HEALTH_HEADING_WEEK_27(),
                week.getCOL_BABY_HEALTH_IMGURL_WEEK_27(),
                week.getCOL_BABY_HEALTH_ACTUAL_ARTICLE_WEEK_27(),

                //Nutrition Details

                week.getNutrition_Header_WEEK27(),
                week.getNUTRITION_IMG_URL_WEEK27(),
                week.getNUTRITION_ARTICLE_WEEK27()

        );

    }


    private void CREATE_TABLE_WEEK28() {

        databaseHelper.CREATE_TABLE_WEEK28();

    }

    private void INSERT_INTO_TABLE_WEK28() {
        DatabaseContent.Wee28 week = new DatabaseContent.Wee28();
        databaseHelper.INSERT_DATA_T0_WEEK28(
                //Mother Details
                week.getCOL_MOTHER_ARTICLE_HEADING_WEEK_28(),
                week.getCOL_MOTHER_ARTICLE_IMGURL_WEEK28(),
                week.getCOL_ACTUAL_MOTHER_ARTICLES_WEEK_28(),

                //Child Details

                week.getCOL_BABAY_HEALTH_HEADING_WEEK_28(),
                week.getCOL_BABY_HEALTH_IMGURL_WEEK_28(),
                week.getCOL_BABY_HEALTH_ACTUAL_ARTICLE_WEEK_28(),

                //Nutrition Details

                week.getNutrition_Header_WEEK28(),
                week.getNUTRITION_IMG_URL_WEEK28(),
                week.getNUTRITION_ARTICLE_WEEK28()

        );

    }

    private void CREATE_TABLE_WEEK29() {

        databaseHelper.CREATE_TABLE_WEEK29();

    }

    private void INSERT_INTO_TABLE_WEK29() {
        DatabaseContent.Wee29 week = new DatabaseContent.Wee29();
        databaseHelper.INSERT_DATA_T0_WEEK29(
                //Mother Details
                week.getCOL_MOTHER_ARTICLE_HEADING_WEEK_29(),
                week.getCOL_MOTHER_ARTICLE_IMGURL_WEEK29(),
                week.getCOL_ACTUAL_MOTHER_ARTICLES_WEEK_29(),

                //Child Details

                week.getCOL_BABAY_HEALTH_HEADING_WEEK_209(),
                week.getCOL_BABY_HEALTH_IMGURL_WEEK_29(),
                week.getCOL_BABY_HEALTH_ACTUAL_ARTICLE_WEEK_29(),

                //Nutrition Details

                week.getNutrition_Header_WEEK29(),
                week.getNUTRITION_IMG_URL_WEEK29(),
                week.getNUTRITION_IMG_URL_WEEK29()

        );

    }

    private void CREATE_TABLE_WEEK30() {

        databaseHelper.CREATE_TABLE_WEEK30();

    }

    private void INSERT_INTO_TABLE_WEK30() {
        DatabaseContent.Week30 week = new DatabaseContent.Week30();
        databaseHelper.INSERT_DATA_T0_WEEK30(
                //Mother Details
                week.getCOL_MOTHER_ARTICLE_HEADING_WEEK_30(),
                week.getCOL_MOTHER_ARTICLE_IMGURL_WEEK30(),
                week.getCOL_ACTUAL_MOTHER_ARTICLES_WEEK_30(),

                //Child Details

                week.getCOL_BABAY_HEALTH_HEADING_WEEK_30(),
                week.getCOL_BABY_HEALTH_IMGURL_WEEK_30(),
                week.getCOL_BABY_HEALTH_ACTUAL_ARTICLE_WEEK_30(),

                //Nutrition Details

                week.getNutrition_Header_WEEK30(),
                week.getNUTRITION_IMG_URL_WEEK30(),
                week.getNUTRITION_ARTICLE_WEEK30()

        );

    }

    private void CREATE_TABLE_WEEK31() {

        databaseHelper.CREATE_TABLE_WEEK31();

    }

    private void INSERT_INTO_TABLE_WEK31() {
        DatabaseContent.Week31 week = new DatabaseContent.Week31();
        databaseHelper.INSERT_DATA_T0_WEEK31(
                //Mother Details
                week.getCOL_MOTHER_ARTICLE_HEADING_WEEK_31(),
                week.getCOL_MOTHER_ARTICLE_IMGURL_WEEK31(),
                week.getCOL_ACTUAL_MOTHER_ARTICLES_WEEK_31(),

                //Child Details

                week.getCOL_BABAY_HEALTH_HEADING_WEEK_31(),
                week.getCOL_BABY_HEALTH_IMGURL_WEEK_31(),
                week.getCOL_BABY_HEALTH_ACTUAL_ARTICLE_WEEK_31(),

                //Nutrition Details

                week.getNutrition_Header_WEEK31(),
                week.getNUTRITION_IMG_URL_WEEK31(),
                week.getNUTRITION_ARTICLE_WEEK31()

        );

    }

    private void CREATE_TABLE_WEEK32() {

        databaseHelper.CREATE_TABLE_WEEK32();

    }

    private void INSERT_INTO_TABLE_WEK32() {
        DatabaseContent.Week32 week = new DatabaseContent.Week32();
        databaseHelper.INSERT_DATA_T0_WEEK32(
                //Mother Details
                week.getCOL_MOTHER_ARTICLE_HEADING_WEEK_32(),
                week.getCOL_MOTHER_ARTICLE_IMGURL_WEEK32(),
                week.getCOL_ACTUAL_MOTHER_ARTICLES_WEEK_32(),

                //Child Details

                week.getCOL_BABAY_HEALTH_HEADING_WEEK_32(),
                week.getCOL_BABY_HEALTH_IMGURL_WEEK_32(),
                week.getCOL_BABY_HEALTH_ACTUAL_ARTICLE_WEEK_32(),

                //Nutrition Details

                week.getNutrition_Header_WEEK32(),
                week.getNUTRITION_IMG_URL_WEEK32(),
                week.getNUTRITION_ARTICLE_WEEK32()

        );

    }
    private void CREATE_TABLE_WEEK33() {

        databaseHelper.CREATE_TABLE_WEEK33();

    }

    private void INSERT_INTO_TABLE_WEK33() {
        DatabaseContent.Week33 week = new DatabaseContent.Week33();
        databaseHelper.INSERT_DATA_T0_WEEK33(
                //Mother Details
                week.getCOL_MOTHER_ARTICLE_HEADING_WEEK_33(),
                week.getCOL_MOTHER_ARTICLE_IMGURL_WEEK33(),
                week.getCOL_ACTUAL_MOTHER_ARTICLES_WEEK_33(),

                //Child Details

                week.getCOL_BABAY_HEALTH_HEADING_WEEK_33(),
                week.getCOL_BABY_HEALTH_IMGURL_WEEK_33(),
                week.getCOL_BABY_HEALTH_ACTUAL_ARTICLE_WEEK_33(),

                //Nutrition Details

                week.getNutrition_Header_WEEK33(),
                week.getNUTRITION_IMG_URL_WEEK33(),
                week.getNUTRITION_ARTICLE_WEEK33()

        );

    }
    private void CREATE_TABLE_WEEK34() {

        databaseHelper.CREATE_TABLE_WEEK34();

    }

    private void INSERT_INTO_TABLE_WEK34() {
        DatabaseContent.Week34 week = new DatabaseContent.Week34();
        databaseHelper.INSERT_DATA_T0_WEEK34(
                //Mother Details
                week.getCOL_MOTHER_ARTICLE_HEADING_WEEK_34(),
                week.getCOL_MOTHER_ARTICLE_IMGURL_WEEK34(),
                week.getCOL_ACTUAL_MOTHER_ARTICLES_WEEK_34(),

                //Child Details

                week.getCOL_BABAY_HEALTH_HEADING_WEEK_34(),
                week.getCOL_BABY_HEALTH_IMGURL_WEEK_34(),
                week.getCOL_BABY_HEALTH_ACTUAL_ARTICLE_WEEK_34(),

                //Nutrition Details

                week.getNutrition_Header_WEEK34(),
                week.getNUTRITION_IMG_URL_WEEK34(),
                week.getNUTRITION_ARTICLE_WEEK34()

        );

    }
    private void CREATE_TABLE_WEEK35() {

        databaseHelper.CREATE_TABLE_WEEK35();

    }

    private void INSERT_INTO_TABLE_WEK35() {
        DatabaseContent.Week35 week = new DatabaseContent.Week35();
        databaseHelper.INSERT_DATA_T0_WEEK35(
                //Mother Details
                week.getCOL_MOTHER_ARTICLE_HEADING_WEEK_35(),
                week.getCOL_MOTHER_ARTICLE_IMGURL_WEEK35(),
                week.getCOL_ACTUAL_MOTHER_ARTICLES_WEEK_35(),

                //Child Details

                week.getCOL_BABAY_HEALTH_HEADING_WEEK_35(),
                week.getCOL_BABY_HEALTH_IMGURL_WEEK_35(),
                week.getCOL_BABY_HEALTH_ACTUAL_ARTICLE_WEEK_35(),

                //Nutrition Details

                week.getNutrition_Header_WEEK35(),
                week.getNUTRITION_IMG_URL_WEEK35(),
                week.getNUTRITION_ARTICLE_WEEK35()

        );

    }

    private void CREATE_TABLE_WEEK36() {

        databaseHelper.CREATE_TABLE_WEEK36();

    }

    private void INSERT_INTO_TABLE_WEK36() {
        DatabaseContent.Week36 week = new DatabaseContent.Week36();
        databaseHelper.INSERT_DATA_T0_WEEK36(
                //Mother Details
                week.getCOL_MOTHER_ARTICLE_HEADING_WEEK_36(),
                week.getCOL_MOTHER_ARTICLE_IMGURL_WEEK36(),
                week.getCOL_ACTUAL_MOTHER_ARTICLES_WEEK_36(),

                //Child Details

                week.getCOL_BABAY_HEALTH_HEADING_WEEK_36(),
                week.getCOL_BABY_HEALTH_IMGURL_WEEK_36(),
                week.getCOL_BABY_HEALTH_ACTUAL_ARTICLE_WEEK_36(),

                //Nutrition Details

                week.getNutrition_Header_WEEK36(),
                week.getNUTRITION_IMG_URL_WEEK36(),
                week.getNUTRITION_ARTICLE_WEEK36()

        );

    }

    private void CREATE_TABLE_WEEK37() {

        databaseHelper.CREATE_TABLE_WEEK37();

    }

    private void INSERT_INTO_TABLE_WEK37() {
        DatabaseContent.Week37 week = new DatabaseContent.Week37();
        databaseHelper.INSERT_DATA_T0_WEEK37(
                //Mother Details
                week.getCOL_MOTHER_ARTICLE_HEADING_WEEK_37(),
                week.getCOL_MOTHER_ARTICLE_IMGURL_WEEK37(),
                week.getCOL_ACTUAL_MOTHER_ARTICLES_WEEK_37(),

                //Child Details

                week.getCOL_BABAY_HEALTH_HEADING_WEEK_37(),
                week.getCOL_BABY_HEALTH_IMGURL_WEEK_37(),
                week.getCOL_BABY_HEALTH_ACTUAL_ARTICLE_WEEK_37(),

                //Nutrition Details

                week.getNutrition_Header_WEEK37(),
                week.getNUTRITION_IMG_URL_WEEK37(),
                week.getNUTRITION_ARTICLE_WEEK37()

        );

    }

    private void CREATE_TABLE_WEEK38() {

        databaseHelper.CREATE_TABLE_WEEK38();

    }

    private void INSERT_INTO_TABLE_WEK38() {
        DatabaseContent.Wee38 week = new DatabaseContent.Wee38();
        databaseHelper.INSERT_DATA_T0_WEEK30(
                //Mother Details
                week.getCOL_MOTHER_ARTICLE_HEADING_WEEK_38(),
                week.getCOL_MOTHER_ARTICLE_IMGURL_WEEK38(),
                week.getCOL_ACTUAL_MOTHER_ARTICLES_WEEK_38(),

                //Child Details

                week.getCOL_BABAY_HEALTH_HEADING_WEEK_38(),
                week.getCOL_BABY_HEALTH_IMGURL_WEEK_38(),
                week.getCOL_BABY_HEALTH_ACTUAL_ARTICLE_WEEK_38(),

                //Nutrition Details

                week.getNutrition_Header_WEEK38(),
                week.getNUTRITION_IMG_URL_WEEK38(),
                week.getNUTRITION_ARTICLE_WEEK38()

        );

    }
    private void CREATE_TABLE_WEEK39() {

        databaseHelper.CREATE_TABLE_WEEK39();

    }

    private void INSERT_INTO_TABLE_WEK39() {
        DatabaseContent.Wee39 week = new DatabaseContent.Wee39();
        databaseHelper.INSERT_DATA_T0_WEEK39(
                //Mother Details
                week.getCOL_MOTHER_ARTICLE_HEADING_WEEK_39(),
                week.getCOL_MOTHER_ARTICLE_IMGURL_WEEK39(),
                week.getCOL_ACTUAL_MOTHER_ARTICLES_WEEK_39(),

                //Child Details

                week.getCOL_BABAY_HEALTH_HEADING_WEEK_39(),
                week.getCOL_BABAY_HEALTH_HEADING_WEEK_39(),
                week.getCOL_BABY_HEALTH_ACTUAL_ARTICLE_WEEK_39(),

                //Nutrition Details

                week.getNutrition_Header_WEEK39(),
                week.getNUTRITION_IMG_URL_WEEK39(),
                week.getNUTRITION_ARTICLE_WEEK39()

        );

    }
    private void CREATE_TABLE_WEEK40() {

        databaseHelper.CREATE_TABLE_WEEK40();

    }

    private void INSERT_INTO_TABLE_WEK40() {
        DatabaseContent.Wee40 week = new DatabaseContent.Wee40();
        databaseHelper.INSERT_DATA_T0_WEEK40(
                //Mother Details
                week.getCOL_MOTHER_ARTICLE_HEADING_WEEK_40(),
                week.getCOL_MOTHER_ARTICLE_IMGURL_WEEK40(),
                week.getCOL_ACTUAL_MOTHER_ARTICLES_WEEK_40(),

                //Child Details

                week.getCOL_BABAY_HEALTH_HEADING_WEEK_40(),
                week.getCOL_BABY_HEALTH_IMGURL_WEEK_40(),
                week.getCOL_BABY_HEALTH_ACTUAL_ARTICLE_WEEK_40(),

                //Nutrition Details

                week.getNutrition_Header_WEEK40(),
                week.getNUTRITION_IMG_URL_WEEK40(),
                week.getNUTRITION_ARTICLE_WEEK40()

        );

    }

    private void CREATE_TABLE_WEEK41() {

        databaseHelper.CREATE_TABLE_WEEK41();

    }

    private void INSERT_INTO_TABLE_WEK41() {
        DatabaseContent.Wee41 week = new DatabaseContent.Wee41();
        databaseHelper.INSERT_DATA_T0_WEEK41(
                //Mother Details
                week.getCOL_MOTHER_ARTICLE_HEADING_WEEK_41(),
                week.getCOL_MOTHER_ARTICLE_IMGURL_WEEK41(),
                week.getCOL_ACTUAL_MOTHER_ARTICLES_WEEK_41(),

                //Child Details

                week.getCOL_BABAY_HEALTH_HEADING_WEEK_41(),
                week.getCOL_BABY_HEALTH_IMGURL_WEEK_41(),
                week.getCOL_BABY_HEALTH_ACTUAL_ARTICLE_WEEK_41(),

                //Nutrition Details

                week.getNutrition_Header_WEEK41(),
                week.getNUTRITION_IMG_URL_WEEK41(),
                week.getNUTRITION_ARTICLE_WEEK41()

        );

    }

}
