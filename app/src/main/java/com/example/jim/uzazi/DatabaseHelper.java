package com.example.jim.uzazi;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String WEEK1= "WEEK1";
    public static final String WEEK2= "WEEK2";
    public static final String WEEK3= "WEEK3";
    public static final String WEEK4= "WEEK4";
    public static final String WEEK5= "WEEK5";
    public static final String WEEK6= "WEEK6";
    public static final String WEEK7= "WEEK7";
    public static final String DATABASENAME = "SAMPLE.db";
    public static final int DATABASE_VERSION = 1;

    public static final String COL_BABY_HEALTH_ACTUAL_ARTICLE_WEEK_1 ="Baby_Actual_Article";
    public static final String COL_BABAY_HEALTH_HEADING_WEEK_1 = "Baby_Article_Heading";
    public static final String COL_BABY_HEALTH_IMGURL_WEEK_1="Baby_Article_Img_Url";

    public static final String COL_ACTUAL_MOTHER_ARTICLES_WEEK_1 = "Mother_Actual_Article";
    public static final String COL_MOTHER_ARTICLE_HEADING_WEEK_1 = "Mother_Article_Heading";
    public static final String COL_MOTHER_ARTICLE_IMGURL_WEEK_1="Mother_Article_Img_Url";

    public static final String COL_NUTRITION_TITLE = "Nutrition_Title";
    public static final String COL_NUTRITION_IMG_URL = "Nutrition_IMG";
    public static final String COL_NUTRITION_ARTICLE = "NUTRITION_ARTICLE";


    SQLiteDatabase db;
    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASENAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + WEEK1);
        db.execSQL("DROP TABLE IF EXISTS " + WEEK2);
        db.execSQL("DROP TABLE IF EXISTS " + WEEK3);
        db.execSQL("DROP TABLE IF EXISTS " + WEEK4);
        db.execSQL("DROP TABLE IF EXISTS " + WEEK5);
        db.execSQL("DROP TABLE IF EXISTS " + WEEK6);
        db.execSQL("DROP TABLE IF EXISTS " + WEEK7);

    }

    //    public void CREATE_TABLE_WEEK_1(){
//        String TABLE_NAME = "WEEk_1";
//        final String CREATE_TABLE_WEEK_1 = "CREATE TABLE "+TABLE_NAME + "(Col_Id integer primary key autoincrement not null,"+ COL_IMAGE_FOOD+"BLOB not null,"+ COL_IMAGE_PERSON+"BLOB not null,"+ COL_ARTICLE+"text not null);";
//    }

    public void CREATE_TABLE_WEEK_1(){
        db = getWritableDatabase();

        try {
            String sql=  "CREATE TABLE WEEK1"+ "(Col_Id integer primary key autoincrement not null, "
                    +DatabaseHelper.COL_MOTHER_ARTICLE_HEADING_WEEK_1+" text not null,"
                    +DatabaseHelper.COL_MOTHER_ARTICLE_IMGURL_WEEK_1 +" text not null,"
                    + DatabaseHelper.COL_ACTUAL_MOTHER_ARTICLES_WEEK_1+" text not null,"

                    + DatabaseHelper.COL_BABAY_HEALTH_HEADING_WEEK_1+" text not null,"
                    + DatabaseHelper.COL_BABY_HEALTH_IMGURL_WEEK_1+" text not null,"
                    + DatabaseHelper.COL_BABY_HEALTH_ACTUAL_ARTICLE_WEEK_1+ " text not null,"

                    + DatabaseHelper.COL_NUTRITION_TITLE+ "text not null,"
                    + DatabaseHelper.COL_NUTRITION_IMG_URL+ "text not null,"
                    + DatabaseHelper.COL_NUTRITION_ARTICLE+"text not null)";
            db.execSQL(sql);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void INSERT_DATA_T0_WEEK1(String MortherArticle_Header, String MotherArticleImgUrl, String ActualMotherArticle, String ChildArticleHeader, String ChildArticleImgUrl, String ActualChildArticle, String NutrtionTitle, String NutritionImgUrl, String NutritionArticle ){
        db = getWritableDatabase();
        String sql =  "INSERT INTO WEEK1 VALUES (NULL,?,?,?,?,?,?,?,?,?)";
        SQLiteStatement sqLiteStatement = db.compileStatement(sql);
        sqLiteStatement.clearBindings();

        sqLiteStatement.bindString(1,MortherArticle_Header);
        sqLiteStatement.bindString(2,MotherArticleImgUrl);
        sqLiteStatement.bindString(3,ActualMotherArticle);
        sqLiteStatement.bindString(4,ChildArticleHeader);
        sqLiteStatement.bindString(5,ChildArticleImgUrl);
        sqLiteStatement.bindString(6,ActualChildArticle);
        sqLiteStatement.bindString(7,NutrtionTitle);
        sqLiteStatement.bindString(8,NutritionImgUrl);
        sqLiteStatement.bindString(9,NutritionArticle);

        sqLiteStatement.executeInsert();

    }

    public void CREATE_TABLE_WEEK_2(){
        db = getWritableDatabase();

        try {
            String sql=   "CREATE TABLE WEEK2"+ "(Col_Id integer primary key autoincrement not null, "
                    +DatabaseHelper.COL_MOTHER_ARTICLE_HEADING_WEEK_1+" text not null,"
                    +DatabaseHelper.COL_MOTHER_ARTICLE_IMGURL_WEEK_1 +" text not null,"
                    + DatabaseHelper.COL_ACTUAL_MOTHER_ARTICLES_WEEK_1+" text not null,"

                    + DatabaseHelper.COL_BABAY_HEALTH_HEADING_WEEK_1+" text not null,"
                    + DatabaseHelper.COL_BABY_HEALTH_IMGURL_WEEK_1+" text not null,"
                    + DatabaseHelper.COL_BABY_HEALTH_ACTUAL_ARTICLE_WEEK_1+ " text not null," +

                    DatabaseHelper.COL_NUTRITION_TITLE+ "text not null," +
                    DatabaseHelper.COL_NUTRITION_IMG_URL +"text not null,"+
                    DatabaseHelper.COL_NUTRITION_ARTICLE+ "text not null)";
            db.execSQL(sql);


        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public void INSERT_DATA_T0_WEEK2(String MortherArticle_Header, String MotherArticleImgUrl, String ActualMotherArticle, String ChildArticleHeader, String ChildArticleImgUrl, String ActualChildArticle, String NutritionTitle, String Nutrition_IMG_Url, String Nutrition_Article){
        db = getWritableDatabase();
        String sql =  "INSERT INTO WEEK2 VALUES (NULL,?,?,?,?,?,?,?,?,?)";
        SQLiteStatement sqLiteStatement = db.compileStatement(sql);
        sqLiteStatement.clearBindings();

        sqLiteStatement.bindString(1,MortherArticle_Header);
        sqLiteStatement.bindString(2,MotherArticleImgUrl);
        sqLiteStatement.bindString(3,ActualMotherArticle);
        sqLiteStatement.bindString(4,ChildArticleHeader);
        sqLiteStatement.bindString(5,ChildArticleImgUrl);
        sqLiteStatement.bindString(6,ActualChildArticle);

        sqLiteStatement.bindString(7,NutritionTitle);
        sqLiteStatement.bindString(8,Nutrition_IMG_Url);
        sqLiteStatement.bindString(9,Nutrition_Article);

        sqLiteStatement.executeInsert();

    }


    public void CREATE_TABLE_WEEK3(){

        try {
            String sql=   "CREATE TABLE WEEK3"+ "(Col_Id integer primary key autoincrement not null, "
                    +DatabaseHelper.COL_MOTHER_ARTICLE_HEADING_WEEK_1+" text not null,"
                    +DatabaseHelper.COL_MOTHER_ARTICLE_IMGURL_WEEK_1 +" text not null,"
                    + DatabaseHelper.COL_ACTUAL_MOTHER_ARTICLES_WEEK_1+" text not null,"

                    + DatabaseHelper.COL_BABAY_HEALTH_HEADING_WEEK_1+" text not null,"
                    + DatabaseHelper.COL_BABY_HEALTH_IMGURL_WEEK_1+" text not null,"
                    + DatabaseHelper.COL_BABY_HEALTH_ACTUAL_ARTICLE_WEEK_1+ " text not null,"

                    +DatabaseHelper.COL_NUTRITION_TITLE+ "text not null,"
                    +DatabaseHelper.COL_NUTRITION_IMG_URL+ "text not null,"
                    +DatabaseHelper.COL_NUTRITION_ARTICLE+ "text not null)";

            db.execSQL(sql);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void INSERT_DATA_T0_WEEK3 (String MortherArticle_Header, String MotherArticleImgUrl, String ActualMotherArticle, String ChildArticleHeader, String ChildArticleImgUrl, String ActualChildArticle, String NutritionTitle, String NutritionImg_Url, String NutritionArticle){

        db = getWritableDatabase();
        String sql =  "INSERT INTO WEEK3 VALUES (NULL,?,?,?,?,?,?,?,?,?)";
        SQLiteStatement sqLiteStatement = db.compileStatement(sql);
        sqLiteStatement.clearBindings();

        sqLiteStatement.bindString(1,MortherArticle_Header);
        sqLiteStatement.bindString(2,MotherArticleImgUrl);
        sqLiteStatement.bindString(3,ActualMotherArticle);

        sqLiteStatement.bindString(4,ChildArticleHeader);
        sqLiteStatement.bindString(5,ChildArticleImgUrl);
        sqLiteStatement.bindString(6,ActualChildArticle);

        sqLiteStatement.bindString(7,NutritionTitle);
        sqLiteStatement.bindString(8, NutritionImg_Url);
        sqLiteStatement.bindString(9,NutritionArticle);

        sqLiteStatement.executeInsert();
    }


    public void CREATE_TABLE_WEEK4(){

        try {
            String sql=   "CREATE TABLE WEEK4"+ "(Col_Id integer primary key autoincrement not null, "
                    +DatabaseHelper.COL_MOTHER_ARTICLE_HEADING_WEEK_1+" text not null,"
                    +DatabaseHelper.COL_MOTHER_ARTICLE_IMGURL_WEEK_1 +" text not null,"
                    + DatabaseHelper.COL_ACTUAL_MOTHER_ARTICLES_WEEK_1+" text not null,"

                    + DatabaseHelper.COL_BABAY_HEALTH_HEADING_WEEK_1+" text not null,"
                    + DatabaseHelper.COL_BABY_HEALTH_IMGURL_WEEK_1+" text not null,"
                    + DatabaseHelper.COL_BABY_HEALTH_ACTUAL_ARTICLE_WEEK_1+ " text not null,"

                    +DatabaseHelper.COL_NUTRITION_TITLE+ "text not null,"
                    +DatabaseHelper.COL_NUTRITION_IMG_URL+ "text not null,"
                    +DatabaseHelper.COL_NUTRITION_ARTICLE+ "text not null)";

            db.execSQL(sql);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void INSERT_DATA_T0_WEEK4 (String MortherArticle_Header, String MotherArticleImgUrl, String ActualMotherArticle, String ChildArticleHeader, String ChildArticleImgUrl, String ActualChildArticle, String NutritionTitle, String NutritionImg_Url, String NutritionArticle){

        db = getWritableDatabase();
        String sql =  "INSERT INTO WEEK4 VALUES (NULL,?,?,?,?,?,?,?,?,?)";
        SQLiteStatement sqLiteStatement = db.compileStatement(sql);
        sqLiteStatement.clearBindings();

        sqLiteStatement.bindString(1,MortherArticle_Header);
        sqLiteStatement.bindString(2,MotherArticleImgUrl);
        sqLiteStatement.bindString(3,ActualMotherArticle);

        sqLiteStatement.bindString(4,ChildArticleHeader);
        sqLiteStatement.bindString(5,ChildArticleImgUrl);
        sqLiteStatement.bindString(6,ActualChildArticle);

        sqLiteStatement.bindString(7,NutritionTitle);
        sqLiteStatement.bindString(8, NutritionImg_Url);
        sqLiteStatement.bindString(9,NutritionArticle);

        sqLiteStatement.executeInsert();
    }

    public void CREATE_TABLE_WEEK5(){

        try {
            String sql=   "CREATE TABLE WEEK5"+ "(Col_Id integer primary key autoincrement not null, "
                    +DatabaseHelper.COL_MOTHER_ARTICLE_HEADING_WEEK_1+" text not null,"
                    +DatabaseHelper.COL_MOTHER_ARTICLE_IMGURL_WEEK_1 +" text not null,"
                    + DatabaseHelper.COL_ACTUAL_MOTHER_ARTICLES_WEEK_1+" text not null,"

                    + DatabaseHelper.COL_BABAY_HEALTH_HEADING_WEEK_1+" text not null,"
                    + DatabaseHelper.COL_BABY_HEALTH_IMGURL_WEEK_1+" text not null,"
                    + DatabaseHelper.COL_BABY_HEALTH_ACTUAL_ARTICLE_WEEK_1+ " text not null,"

                    +DatabaseHelper.COL_NUTRITION_TITLE+ "text not null,"
                    +DatabaseHelper.COL_NUTRITION_IMG_URL+ "text not null,"
                    +DatabaseHelper.COL_NUTRITION_ARTICLE+ "text not null)";

            db.execSQL(sql);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void INSERT_DATA_T0_WEEK5 (String MortherArticle_Header,
                                      String MotherArticleImgUrl,
                                      String ActualMotherArticle,
                                      String ChildArticleHeader,
                                      String ChildArticleImgUrl,
                                      String ActualChildArticle,
                                      String NutritionTitle,
                                      String NutritionImg_Url,
                                      String NutritionArticle) {

        db = getWritableDatabase();
        String sql =  "INSERT INTO WEEK5 VALUES (NULL,?,?,?,?,?,?,?,?,?)";
        SQLiteStatement sqLiteStatement = db.compileStatement(sql);
        sqLiteStatement.clearBindings();

        sqLiteStatement.bindString(1,MortherArticle_Header);
        sqLiteStatement.bindString(2,MotherArticleImgUrl);
        sqLiteStatement.bindString(3,ActualMotherArticle);

        sqLiteStatement.bindString(4,ChildArticleHeader);
        sqLiteStatement.bindString(5,ChildArticleImgUrl);
        sqLiteStatement.bindString(6,ActualChildArticle);

        sqLiteStatement.bindString(7,NutritionTitle);
        sqLiteStatement.bindString(8, NutritionImg_Url);
        sqLiteStatement.bindString(9,NutritionArticle);

        sqLiteStatement.executeInsert();
    }

    public void CREATE_TABLE_WEEK6(){

        try {
            String sql=   "CREATE TABLE WEEK6"+ "(Col_Id integer primary key autoincrement not null, "
                    +DatabaseHelper.COL_MOTHER_ARTICLE_HEADING_WEEK_1+" text not null,"
                    +DatabaseHelper.COL_MOTHER_ARTICLE_IMGURL_WEEK_1 +" text not null,"
                    + DatabaseHelper.COL_ACTUAL_MOTHER_ARTICLES_WEEK_1+" text not null,"

                    + DatabaseHelper.COL_BABAY_HEALTH_HEADING_WEEK_1+" text not null,"
                    + DatabaseHelper.COL_BABY_HEALTH_IMGURL_WEEK_1+" text not null,"
                    + DatabaseHelper.COL_BABY_HEALTH_ACTUAL_ARTICLE_WEEK_1+ " text not null,"

                    +DatabaseHelper.COL_NUTRITION_TITLE+ "text not null,"
                    +DatabaseHelper.COL_NUTRITION_IMG_URL+ "text not null,"
                    +DatabaseHelper.COL_NUTRITION_ARTICLE+ "text not null)";

            db.execSQL(sql);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void INSERT_DATA_T0_WEEK6 (String MortherArticle_Header,
                                      String MotherArticleImgUrl,
                                      String ActualMotherArticle,
                                      String ChildArticleHeader,
                                      String ChildArticleImgUrl,
                                      String ActualChildArticle,
                                      String NutritionTitle,
                                      String NutritionImg_Url,
                                      String NutritionArticle) {

        db = getWritableDatabase();
        String sql =  "INSERT INTO WEEK6 VALUES (NULL,?,?,?,?,?,?,?,?,?)";
        SQLiteStatement sqLiteStatement = db.compileStatement(sql);
        sqLiteStatement.clearBindings();

        sqLiteStatement.bindString(1,MortherArticle_Header);
        sqLiteStatement.bindString(2,MotherArticleImgUrl);
        sqLiteStatement.bindString(3,ActualMotherArticle);

        sqLiteStatement.bindString(4,ChildArticleHeader);
        sqLiteStatement.bindString(5,ChildArticleImgUrl);
        sqLiteStatement.bindString(6,ActualChildArticle);

        sqLiteStatement.bindString(7,NutritionTitle);
        sqLiteStatement.bindString(8, NutritionImg_Url);
        sqLiteStatement.bindString(9,NutritionArticle);

        sqLiteStatement.executeInsert();
    }

    public void CREATE_TABLE_WEEK7(){

        try {
            String sql=   "CREATE TABLE WEEK7"+ "(Col_Id integer primary key autoincrement not null, "
                    +DatabaseHelper.COL_MOTHER_ARTICLE_HEADING_WEEK_1+" text not null,"
                    +DatabaseHelper.COL_MOTHER_ARTICLE_IMGURL_WEEK_1 +" text not null,"
                    + DatabaseHelper.COL_ACTUAL_MOTHER_ARTICLES_WEEK_1+" text not null,"

                    + DatabaseHelper.COL_BABAY_HEALTH_HEADING_WEEK_1+" text not null,"
                    + DatabaseHelper.COL_BABY_HEALTH_IMGURL_WEEK_1+" text not null,"
                    + DatabaseHelper.COL_BABY_HEALTH_ACTUAL_ARTICLE_WEEK_1+ " text not null,"

                    +DatabaseHelper.COL_NUTRITION_TITLE+ "text not null,"
                    +DatabaseHelper.COL_NUTRITION_IMG_URL+ "text not null,"
                    +DatabaseHelper.COL_NUTRITION_ARTICLE+ "text not null)";

            db.execSQL(sql);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void INSERT_DATA_T0_WEEK7 (String MortherArticle_Header,
                                      String MotherArticleImgUrl,
                                      String ActualMotherArticle,
                                      String ChildArticleHeader,
                                      String ChildArticleImgUrl,
                                      String ActualChildArticle,
                                      String NutritionTitle,
                                      String NutritionImg_Url,
                                      String NutritionArticle) {

        db = getWritableDatabase();
        String sql =  "INSERT INTO WEEK7 VALUES (NULL,?,?,?,?,?,?,?,?,?)";
        SQLiteStatement sqLiteStatement = db.compileStatement(sql);
        sqLiteStatement.clearBindings();

        sqLiteStatement.bindString(1,MortherArticle_Header);
        sqLiteStatement.bindString(2,MotherArticleImgUrl);
        sqLiteStatement.bindString(3,ActualMotherArticle);

        sqLiteStatement.bindString(4,ChildArticleHeader);
        sqLiteStatement.bindString(5,ChildArticleImgUrl);
        sqLiteStatement.bindString(6,ActualChildArticle);

        sqLiteStatement.bindString(7,NutritionTitle);
        sqLiteStatement.bindString(8, NutritionImg_Url);
        sqLiteStatement.bindString(9,NutritionArticle);

        sqLiteStatement.executeInsert();
    }

    public void CREATE_TABLE_WEEK8(){

        try {
            String sql=   "CREATE TABLE WEEK8"+ "(Col_Id integer primary key autoincrement not null, "
                    +DatabaseHelper.COL_MOTHER_ARTICLE_HEADING_WEEK_1+" text not null,"
                    +DatabaseHelper.COL_MOTHER_ARTICLE_IMGURL_WEEK_1 +" text not null,"
                    + DatabaseHelper.COL_ACTUAL_MOTHER_ARTICLES_WEEK_1+" text not null,"

                    + DatabaseHelper.COL_BABAY_HEALTH_HEADING_WEEK_1+" text not null,"
                    + DatabaseHelper.COL_BABY_HEALTH_IMGURL_WEEK_1+" text not null,"
                    + DatabaseHelper.COL_BABY_HEALTH_ACTUAL_ARTICLE_WEEK_1+ " text not null,"

                    +DatabaseHelper.COL_NUTRITION_TITLE+ "text not null,"
                    +DatabaseHelper.COL_NUTRITION_IMG_URL+ "text not null,"
                    +DatabaseHelper.COL_NUTRITION_ARTICLE+ "text not null)";

            db.execSQL(sql);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void INSERT_DATA_T0_WEEK8 (String MortherArticle_Header,
                                      String MotherArticleImgUrl,
                                      String ActualMotherArticle,
                                      String ChildArticleHeader,
                                      String ChildArticleImgUrl,
                                      String ActualChildArticle,
                                      String NutritionTitle,
                                      String NutritionImg_Url,
                                      String NutritionArticle) {

        db = getWritableDatabase();
        String sql =  "INSERT INTO WEEK8 VALUES (NULL,?,?,?,?,?,?,?,?,?)";
        SQLiteStatement sqLiteStatement = db.compileStatement(sql);
        sqLiteStatement.clearBindings();

        sqLiteStatement.bindString(1,MortherArticle_Header);
        sqLiteStatement.bindString(2,MotherArticleImgUrl);
        sqLiteStatement.bindString(3,ActualMotherArticle);

        sqLiteStatement.bindString(4,ChildArticleHeader);
        sqLiteStatement.bindString(5,ChildArticleImgUrl);
        sqLiteStatement.bindString(6,ActualChildArticle);

        sqLiteStatement.bindString(7,NutritionTitle);
        sqLiteStatement.bindString(8, NutritionImg_Url);
        sqLiteStatement.bindString(9,NutritionArticle);

        sqLiteStatement.executeInsert();
    }


    public void CREATE_TABLE_WEEK9(){

        try {
            String sql=   "CREATE TABLE WEEK9"+ "(Col_Id integer primary key autoincrement not null, "
                    +DatabaseHelper.COL_MOTHER_ARTICLE_HEADING_WEEK_1+" text not null,"
                    +DatabaseHelper.COL_MOTHER_ARTICLE_IMGURL_WEEK_1 +" text not null,"
                    + DatabaseHelper.COL_ACTUAL_MOTHER_ARTICLES_WEEK_1+" text not null,"

                    + DatabaseHelper.COL_BABAY_HEALTH_HEADING_WEEK_1+" text not null,"
                    + DatabaseHelper.COL_BABY_HEALTH_IMGURL_WEEK_1+" text not null,"
                    + DatabaseHelper.COL_BABY_HEALTH_ACTUAL_ARTICLE_WEEK_1+ " text not null,"

                    +DatabaseHelper.COL_NUTRITION_TITLE+ "text not null,"
                    +DatabaseHelper.COL_NUTRITION_IMG_URL+ "text not null,"
                    +DatabaseHelper.COL_NUTRITION_ARTICLE+ "text not null)";

            db.execSQL(sql);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void INSERT_DATA_T0_WEEK9 (String MortherArticle_Header,
                                      String MotherArticleImgUrl,
                                      String ActualMotherArticle,
                                      String ChildArticleHeader,
                                      String ChildArticleImgUrl,
                                      String ActualChildArticle,
                                      String NutritionTitle,
                                      String NutritionImg_Url,
                                      String NutritionArticle) {

        db = getWritableDatabase();
        String sql =  "INSERT INTO WEEK9 VALUES (NULL,?,?,?,?,?,?,?,?,?)";
        SQLiteStatement sqLiteStatement = db.compileStatement(sql);
        sqLiteStatement.clearBindings();

        sqLiteStatement.bindString(1,MortherArticle_Header);
        sqLiteStatement.bindString(2,MotherArticleImgUrl);
        sqLiteStatement.bindString(3,ActualMotherArticle);

        sqLiteStatement.bindString(4,ChildArticleHeader);
        sqLiteStatement.bindString(5,ChildArticleImgUrl);
        sqLiteStatement.bindString(6,ActualChildArticle);

        sqLiteStatement.bindString(7,NutritionTitle);
        sqLiteStatement.bindString(8, NutritionImg_Url);
        sqLiteStatement.bindString(9,NutritionArticle);

        sqLiteStatement.executeInsert();
    }

    public void CREATE_TABLE_WEEK10(){

        try {
            String sql=   "CREATE TABLE WEEK10"+ "(Col_Id integer primary key autoincrement not null, "
                    +DatabaseHelper.COL_MOTHER_ARTICLE_HEADING_WEEK_1+" text not null,"
                    +DatabaseHelper.COL_MOTHER_ARTICLE_IMGURL_WEEK_1 +" text not null,"
                    + DatabaseHelper.COL_ACTUAL_MOTHER_ARTICLES_WEEK_1+" text not null,"

                    + DatabaseHelper.COL_BABAY_HEALTH_HEADING_WEEK_1+" text not null,"
                    + DatabaseHelper.COL_BABY_HEALTH_IMGURL_WEEK_1+" text not null,"
                    + DatabaseHelper.COL_BABY_HEALTH_ACTUAL_ARTICLE_WEEK_1+ " text not null,"

                    +DatabaseHelper.COL_NUTRITION_TITLE+ "text not null,"
                    +DatabaseHelper.COL_NUTRITION_IMG_URL+ "text not null,"
                    +DatabaseHelper.COL_NUTRITION_ARTICLE+ "text not null)";

            db.execSQL(sql);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void INSERT_DATA_T0_WEEK10 (String MortherArticle_Header,
                                       String MotherArticleImgUrl,
                                       String ActualMotherArticle,
                                       String ChildArticleHeader,
                                       String ChildArticleImgUrl,
                                       String ActualChildArticle,
                                       String NutritionTitle,
                                       String NutritionImg_Url,
                                       String NutritionArticle) {

        db = getWritableDatabase();
        String sql =  "INSERT INTO WEEK10 VALUES (NULL,?,?,?,?,?,?,?,?,?)";
        SQLiteStatement sqLiteStatement = db.compileStatement(sql);
        sqLiteStatement.clearBindings();

        sqLiteStatement.bindString(1,MortherArticle_Header);
        sqLiteStatement.bindString(2,MotherArticleImgUrl);
        sqLiteStatement.bindString(3,ActualMotherArticle);

        sqLiteStatement.bindString(4,ChildArticleHeader);
        sqLiteStatement.bindString(5,ChildArticleImgUrl);
        sqLiteStatement.bindString(6,ActualChildArticle);

        sqLiteStatement.bindString(7,NutritionTitle);
        sqLiteStatement.bindString(8, NutritionImg_Url);
        sqLiteStatement.bindString(9,NutritionArticle);

        sqLiteStatement.executeInsert();
    }

    public void CREATE_TABLE_WEEK11(){

        try {
            String sql=   "CREATE TABLE WEEK11"+ "(Col_Id integer primary key autoincrement not null, "
                    +DatabaseHelper.COL_MOTHER_ARTICLE_HEADING_WEEK_1+" text not null,"
                    +DatabaseHelper.COL_MOTHER_ARTICLE_IMGURL_WEEK_1 +" text not null,"
                    + DatabaseHelper.COL_ACTUAL_MOTHER_ARTICLES_WEEK_1+" text not null,"

                    + DatabaseHelper.COL_BABAY_HEALTH_HEADING_WEEK_1+" text not null,"
                    + DatabaseHelper.COL_BABY_HEALTH_IMGURL_WEEK_1+" text not null,"
                    + DatabaseHelper.COL_BABY_HEALTH_ACTUAL_ARTICLE_WEEK_1+ " text not null,"

                    +DatabaseHelper.COL_NUTRITION_TITLE+ "text not null,"
                    +DatabaseHelper.COL_NUTRITION_IMG_URL+ "text not null,"
                    +DatabaseHelper.COL_NUTRITION_ARTICLE+ "text not null)";

            db.execSQL(sql);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void INSERT_DATA_T0_WEEK11 (String MortherArticle_Header,
                                       String MotherArticleImgUrl,
                                       String ActualMotherArticle,
                                       String ChildArticleHeader,
                                       String ChildArticleImgUrl,
                                       String ActualChildArticle,
                                       String NutritionTitle,
                                       String NutritionImg_Url,
                                       String NutritionArticle) {

        db = getWritableDatabase();
        String sql =  "INSERT INTO WEEK11 VALUES (NULL,?,?,?,?,?,?,?,?,?)";
        SQLiteStatement sqLiteStatement = db.compileStatement(sql);
        sqLiteStatement.clearBindings();

        sqLiteStatement.bindString(1,MortherArticle_Header);
        sqLiteStatement.bindString(2,MotherArticleImgUrl);
        sqLiteStatement.bindString(3,ActualMotherArticle);

        sqLiteStatement.bindString(4,ChildArticleHeader);
        sqLiteStatement.bindString(5,ChildArticleImgUrl);
        sqLiteStatement.bindString(6,ActualChildArticle);

        sqLiteStatement.bindString(7,NutritionTitle);
        sqLiteStatement.bindString(8, NutritionImg_Url);
        sqLiteStatement.bindString(9,NutritionArticle);

        sqLiteStatement.executeInsert();
    }

    public void CREATE_TABLE_WEEK12(){

        try {
            String sql=   "CREATE TABLE WEEK12"+ "(Col_Id integer primary key autoincrement not null, "
                    +DatabaseHelper.COL_MOTHER_ARTICLE_HEADING_WEEK_1+" text not null,"
                    +DatabaseHelper.COL_MOTHER_ARTICLE_IMGURL_WEEK_1 +" text not null,"
                    + DatabaseHelper.COL_ACTUAL_MOTHER_ARTICLES_WEEK_1+" text not null,"

                    + DatabaseHelper.COL_BABAY_HEALTH_HEADING_WEEK_1+" text not null,"
                    + DatabaseHelper.COL_BABY_HEALTH_IMGURL_WEEK_1+" text not null,"
                    + DatabaseHelper.COL_BABY_HEALTH_ACTUAL_ARTICLE_WEEK_1+ " text not null,"

                    +DatabaseHelper.COL_NUTRITION_TITLE+ "text not null,"
                    +DatabaseHelper.COL_NUTRITION_IMG_URL+ "text not null,"
                    +DatabaseHelper.COL_NUTRITION_ARTICLE+ "text not null)";

            db.execSQL(sql);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void INSERT_DATA_T0_WEEK12 (String MortherArticle_Header,
                                       String MotherArticleImgUrl,
                                       String ActualMotherArticle,
                                       String ChildArticleHeader,
                                       String ChildArticleImgUrl,
                                       String ActualChildArticle,
                                       String NutritionTitle,
                                       String NutritionImg_Url,
                                       String NutritionArticle) {

        db = getWritableDatabase();
        String sql =  "INSERT INTO WEEK12 VALUES (NULL,?,?,?,?,?,?,?,?,?)";
        SQLiteStatement sqLiteStatement = db.compileStatement(sql);
        sqLiteStatement.clearBindings();

        sqLiteStatement.bindString(1,MortherArticle_Header);
        sqLiteStatement.bindString(2,MotherArticleImgUrl);
        sqLiteStatement.bindString(3,ActualMotherArticle);

        sqLiteStatement.bindString(4,ChildArticleHeader);
        sqLiteStatement.bindString(5,ChildArticleImgUrl);
        sqLiteStatement.bindString(6,ActualChildArticle);

        sqLiteStatement.bindString(7,NutritionTitle);
        sqLiteStatement.bindString(8, NutritionImg_Url);
        sqLiteStatement.bindString(9,NutritionArticle);

        sqLiteStatement.executeInsert();
    }

    public void CREATE_TABLE_WEEK13(){

        try {
            String sql=   "CREATE TABLE WEEK13"+ "(Col_Id integer primary key autoincrement not null, "
                    +DatabaseHelper.COL_MOTHER_ARTICLE_HEADING_WEEK_1+" text not null,"
                    +DatabaseHelper.COL_MOTHER_ARTICLE_IMGURL_WEEK_1 +" text not null,"
                    + DatabaseHelper.COL_ACTUAL_MOTHER_ARTICLES_WEEK_1+" text not null,"

                    + DatabaseHelper.COL_BABAY_HEALTH_HEADING_WEEK_1+" text not null,"
                    + DatabaseHelper.COL_BABY_HEALTH_IMGURL_WEEK_1+" text not null,"
                    + DatabaseHelper.COL_BABY_HEALTH_ACTUAL_ARTICLE_WEEK_1+ " text not null,"

                    +DatabaseHelper.COL_NUTRITION_TITLE+ "text not null,"
                    +DatabaseHelper.COL_NUTRITION_IMG_URL+ "text not null,"
                    +DatabaseHelper.COL_NUTRITION_ARTICLE+ "text not null)";

            db.execSQL(sql);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void INSERT_DATA_T0_WEEK13 (String MortherArticle_Header,
                                       String MotherArticleImgUrl,
                                       String ActualMotherArticle,
                                       String ChildArticleHeader,
                                       String ChildArticleImgUrl,
                                       String ActualChildArticle,
                                       String NutritionTitle,
                                       String NutritionImg_Url,
                                       String NutritionArticle) {

        db = getWritableDatabase();
        String sql =  "INSERT INTO WEEK13 VALUES (NULL,?,?,?,?,?,?,?,?,?)";
        SQLiteStatement sqLiteStatement = db.compileStatement(sql);
        sqLiteStatement.clearBindings();

        sqLiteStatement.bindString(1,MortherArticle_Header);
        sqLiteStatement.bindString(2,MotherArticleImgUrl);
        sqLiteStatement.bindString(3,ActualMotherArticle);

        sqLiteStatement.bindString(4,ChildArticleHeader);
        sqLiteStatement.bindString(5,ChildArticleImgUrl);
        sqLiteStatement.bindString(6,ActualChildArticle);

        sqLiteStatement.bindString(7,NutritionTitle);
        sqLiteStatement.bindString(8, NutritionImg_Url);
        sqLiteStatement.bindString(9,NutritionArticle);

        sqLiteStatement.executeInsert();
    }


    public void CREATE_TABLE_WEEK14(){

        try {
            String sql=   "CREATE TABLE WEEK14"+ "(Col_Id integer primary key autoincrement not null, "
                    +DatabaseHelper.COL_MOTHER_ARTICLE_HEADING_WEEK_1+" text not null,"
                    +DatabaseHelper.COL_MOTHER_ARTICLE_IMGURL_WEEK_1 +" text not null,"
                    + DatabaseHelper.COL_ACTUAL_MOTHER_ARTICLES_WEEK_1+" text not null,"

                    + DatabaseHelper.COL_BABAY_HEALTH_HEADING_WEEK_1+" text not null,"
                    + DatabaseHelper.COL_BABY_HEALTH_IMGURL_WEEK_1+" text not null,"
                    + DatabaseHelper.COL_BABY_HEALTH_ACTUAL_ARTICLE_WEEK_1+ " text not null,"

                    +DatabaseHelper.COL_NUTRITION_TITLE+ "text not null,"
                    +DatabaseHelper.COL_NUTRITION_IMG_URL+ "text not null,"
                    +DatabaseHelper.COL_NUTRITION_ARTICLE+ "text not null)";

            db.execSQL(sql);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void INSERT_DATA_T0_WEEK14 (String MortherArticle_Header,
                                       String MotherArticleImgUrl,
                                       String ActualMotherArticle,
                                       String ChildArticleHeader,
                                       String ChildArticleImgUrl,
                                       String ActualChildArticle,
                                       String NutritionTitle,
                                       String NutritionImg_Url,
                                       String NutritionArticle) {

        db = getWritableDatabase();
        String sql =  "INSERT INTO WEEK14 VALUES (NULL,?,?,?,?,?,?,?,?,?)";
        SQLiteStatement sqLiteStatement = db.compileStatement(sql);
        sqLiteStatement.clearBindings();

        sqLiteStatement.bindString(1,MortherArticle_Header);
        sqLiteStatement.bindString(2,MotherArticleImgUrl);
        sqLiteStatement.bindString(3,ActualMotherArticle);

        sqLiteStatement.bindString(4,ChildArticleHeader);
        sqLiteStatement.bindString(5,ChildArticleImgUrl);
        sqLiteStatement.bindString(6,ActualChildArticle);

        sqLiteStatement.bindString(7,NutritionTitle);
        sqLiteStatement.bindString(8, NutritionImg_Url);
        sqLiteStatement.bindString(9,NutritionArticle);

        sqLiteStatement.executeInsert();
    }

    public void CREATE_TABLE_WEEK15(){

        try {
            String sql=   "CREATE TABLE WEEK15"+ "(Col_Id integer primary key autoincrement not null, "
                    +DatabaseHelper.COL_MOTHER_ARTICLE_HEADING_WEEK_1+" text not null,"
                    +DatabaseHelper.COL_MOTHER_ARTICLE_IMGURL_WEEK_1 +" text not null,"
                    + DatabaseHelper.COL_ACTUAL_MOTHER_ARTICLES_WEEK_1+" text not null,"

                    + DatabaseHelper.COL_BABAY_HEALTH_HEADING_WEEK_1+" text not null,"
                    + DatabaseHelper.COL_BABY_HEALTH_IMGURL_WEEK_1+" text not null,"
                    + DatabaseHelper.COL_BABY_HEALTH_ACTUAL_ARTICLE_WEEK_1+ " text not null,"

                    +DatabaseHelper.COL_NUTRITION_TITLE+ "text not null,"
                    +DatabaseHelper.COL_NUTRITION_IMG_URL+ "text not null,"
                    +DatabaseHelper.COL_NUTRITION_ARTICLE+ "text not null)";

            db.execSQL(sql);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void INSERT_DATA_T0_WEEK15 (String MortherArticle_Header,
                                       String MotherArticleImgUrl,
                                       String ActualMotherArticle,
                                       String ChildArticleHeader,
                                       String ChildArticleImgUrl,
                                       String ActualChildArticle,
                                       String NutritionTitle,
                                       String NutritionImg_Url,
                                       String NutritionArticle) {

        db = getWritableDatabase();
        String sql =  "INSERT INTO WEEK15 VALUES (NULL,?,?,?,?,?,?,?,?,?)";
        SQLiteStatement sqLiteStatement = db.compileStatement(sql);
        sqLiteStatement.clearBindings();

        sqLiteStatement.bindString(1,MortherArticle_Header);
        sqLiteStatement.bindString(2,MotherArticleImgUrl);
        sqLiteStatement.bindString(3,ActualMotherArticle);

        sqLiteStatement.bindString(4,ChildArticleHeader);
        sqLiteStatement.bindString(5,ChildArticleImgUrl);
        sqLiteStatement.bindString(6,ActualChildArticle);

        sqLiteStatement.bindString(7,NutritionTitle);
        sqLiteStatement.bindString(8, NutritionImg_Url);
        sqLiteStatement.bindString(9,NutritionArticle);

        sqLiteStatement.executeInsert();
    }

    public void CREATE_TABLE_WEEK16(){

        try {
            String sql=   "CREATE TABLE WEEK16"+ "(Col_Id integer primary key autoincrement not null, "
                    +DatabaseHelper.COL_MOTHER_ARTICLE_HEADING_WEEK_1+" text not null,"
                    +DatabaseHelper.COL_MOTHER_ARTICLE_IMGURL_WEEK_1 +" text not null,"
                    + DatabaseHelper.COL_ACTUAL_MOTHER_ARTICLES_WEEK_1+" text not null,"

                    + DatabaseHelper.COL_BABAY_HEALTH_HEADING_WEEK_1+" text not null,"
                    + DatabaseHelper.COL_BABY_HEALTH_IMGURL_WEEK_1+" text not null,"
                    + DatabaseHelper.COL_BABY_HEALTH_ACTUAL_ARTICLE_WEEK_1+ " text not null,"

                    +DatabaseHelper.COL_NUTRITION_TITLE+ "text not null,"
                    +DatabaseHelper.COL_NUTRITION_IMG_URL+ "text not null,"
                    +DatabaseHelper.COL_NUTRITION_ARTICLE+ "text not null)";

            db.execSQL(sql);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void INSERT_DATA_T0_WEEK16 (String MortherArticle_Header,
                                       String MotherArticleImgUrl,
                                       String ActualMotherArticle,
                                       String ChildArticleHeader,
                                       String ChildArticleImgUrl,
                                       String ActualChildArticle,
                                       String NutritionTitle,
                                       String NutritionImg_Url,
                                       String NutritionArticle) {

        db = getWritableDatabase();
        String sql =  "INSERT INTO WEEK16 VALUES (NULL,?,?,?,?,?,?,?,?,?)";
        SQLiteStatement sqLiteStatement = db.compileStatement(sql);
        sqLiteStatement.clearBindings();

        sqLiteStatement.bindString(1,MortherArticle_Header);
        sqLiteStatement.bindString(2,MotherArticleImgUrl);
        sqLiteStatement.bindString(3,ActualMotherArticle);

        sqLiteStatement.bindString(4,ChildArticleHeader);
        sqLiteStatement.bindString(5,ChildArticleImgUrl);
        sqLiteStatement.bindString(6,ActualChildArticle);

        sqLiteStatement.bindString(7,NutritionTitle);
        sqLiteStatement.bindString(8, NutritionImg_Url);
        sqLiteStatement.bindString(9,NutritionArticle);

        sqLiteStatement.executeInsert();
    }

    public void CREATE_TABLE_WEEK17(){

        try {
            String sql=   "CREATE TABLE WEEK17"+ "(Col_Id integer primary key autoincrement not null, "
                    +DatabaseHelper.COL_MOTHER_ARTICLE_HEADING_WEEK_1+" text not null,"
                    +DatabaseHelper.COL_MOTHER_ARTICLE_IMGURL_WEEK_1 +" text not null,"
                    + DatabaseHelper.COL_ACTUAL_MOTHER_ARTICLES_WEEK_1+" text not null,"

                    + DatabaseHelper.COL_BABAY_HEALTH_HEADING_WEEK_1+" text not null,"
                    + DatabaseHelper.COL_BABY_HEALTH_IMGURL_WEEK_1+" text not null,"
                    + DatabaseHelper.COL_BABY_HEALTH_ACTUAL_ARTICLE_WEEK_1+ " text not null,"

                    +DatabaseHelper.COL_NUTRITION_TITLE+ "text not null,"
                    +DatabaseHelper.COL_NUTRITION_IMG_URL+ "text not null,"
                    +DatabaseHelper.COL_NUTRITION_ARTICLE+ "text not null)";

            db.execSQL(sql);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void INSERT_DATA_T0_WEEK17 (String MortherArticle_Header,
                                       String MotherArticleImgUrl,
                                       String ActualMotherArticle,
                                       String ChildArticleHeader,
                                       String ChildArticleImgUrl,
                                       String ActualChildArticle,
                                       String NutritionTitle,
                                       String NutritionImg_Url,
                                       String NutritionArticle) {

        db = getWritableDatabase();
        String sql =  "INSERT INTO WEEK17 VALUES (NULL,?,?,?,?,?,?,?,?,?)";
        SQLiteStatement sqLiteStatement = db.compileStatement(sql);
        sqLiteStatement.clearBindings();

        sqLiteStatement.bindString(1,MortherArticle_Header);
        sqLiteStatement.bindString(2,MotherArticleImgUrl);
        sqLiteStatement.bindString(3,ActualMotherArticle);

        sqLiteStatement.bindString(4,ChildArticleHeader);
        sqLiteStatement.bindString(5,ChildArticleImgUrl);
        sqLiteStatement.bindString(6,ActualChildArticle);

        sqLiteStatement.bindString(7,NutritionTitle);
        sqLiteStatement.bindString(8, NutritionImg_Url);
        sqLiteStatement.bindString(9,NutritionArticle);

        sqLiteStatement.executeInsert();
    }

    public void CREATE_TABLE_WEEK18(){

        try {
            String sql=   "CREATE TABLE WEEK18"+ "(Col_Id integer primary key autoincrement not null, "
                    +DatabaseHelper.COL_MOTHER_ARTICLE_HEADING_WEEK_1+" text not null,"
                    +DatabaseHelper.COL_MOTHER_ARTICLE_IMGURL_WEEK_1 +" text not null,"
                    + DatabaseHelper.COL_ACTUAL_MOTHER_ARTICLES_WEEK_1+" text not null,"

                    + DatabaseHelper.COL_BABAY_HEALTH_HEADING_WEEK_1+" text not null,"
                    + DatabaseHelper.COL_BABY_HEALTH_IMGURL_WEEK_1+" text not null,"
                    + DatabaseHelper.COL_BABY_HEALTH_ACTUAL_ARTICLE_WEEK_1+ " text not null,"

                    +DatabaseHelper.COL_NUTRITION_TITLE+ "text not null,"
                    +DatabaseHelper.COL_NUTRITION_IMG_URL+ "text not null,"
                    +DatabaseHelper.COL_NUTRITION_ARTICLE+ "text not null)";

            db.execSQL(sql);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void INSERT_DATA_T0_WEEK18 (String MortherArticle_Header,
                                       String MotherArticleImgUrl,
                                       String ActualMotherArticle,
                                       String ChildArticleHeader,
                                       String ChildArticleImgUrl,
                                       String ActualChildArticle,
                                       String NutritionTitle,
                                       String NutritionImg_Url,
                                       String NutritionArticle) {

        db = getWritableDatabase();
        String sql =  "INSERT INTO WEEK18 VALUES (NULL,?,?,?,?,?,?,?,?,?)";
        SQLiteStatement sqLiteStatement = db.compileStatement(sql);
        sqLiteStatement.clearBindings();

        sqLiteStatement.bindString(1,MortherArticle_Header);
        sqLiteStatement.bindString(2,MotherArticleImgUrl);
        sqLiteStatement.bindString(3,ActualMotherArticle);

        sqLiteStatement.bindString(4,ChildArticleHeader);
        sqLiteStatement.bindString(5,ChildArticleImgUrl);
        sqLiteStatement.bindString(6,ActualChildArticle);

        sqLiteStatement.bindString(7,NutritionTitle);
        sqLiteStatement.bindString(8, NutritionImg_Url);
        sqLiteStatement.bindString(9,NutritionArticle);

        sqLiteStatement.executeInsert();
    }

    public void CREATE_TABLE_WEEK19(){

        try {
            String sql=   "CREATE TABLE WEEK19"+ "(Col_Id integer primary key autoincrement not null, "
                    +DatabaseHelper.COL_MOTHER_ARTICLE_HEADING_WEEK_1+" text not null,"
                    +DatabaseHelper.COL_MOTHER_ARTICLE_IMGURL_WEEK_1 +" text not null,"
                    + DatabaseHelper.COL_ACTUAL_MOTHER_ARTICLES_WEEK_1+" text not null,"

                    + DatabaseHelper.COL_BABAY_HEALTH_HEADING_WEEK_1+" text not null,"
                    + DatabaseHelper.COL_BABY_HEALTH_IMGURL_WEEK_1+" text not null,"
                    + DatabaseHelper.COL_BABY_HEALTH_ACTUAL_ARTICLE_WEEK_1+ " text not null,"

                    +DatabaseHelper.COL_NUTRITION_TITLE+ "text not null,"
                    +DatabaseHelper.COL_NUTRITION_IMG_URL+ "text not null,"
                    +DatabaseHelper.COL_NUTRITION_ARTICLE+ "text not null)";

            db.execSQL(sql);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void INSERT_DATA_T0_WEEK19 (String MortherArticle_Header,
                                       String MotherArticleImgUrl,
                                       String ActualMotherArticle,
                                       String ChildArticleHeader,
                                       String ChildArticleImgUrl,
                                       String ActualChildArticle,
                                       String NutritionTitle,
                                       String NutritionImg_Url,
                                       String NutritionArticle) {

        db = getWritableDatabase();
        String sql =  "INSERT INTO WEEK19 VALUES (NULL,?,?,?,?,?,?,?,?,?)";
        SQLiteStatement sqLiteStatement = db.compileStatement(sql);
        sqLiteStatement.clearBindings();

        sqLiteStatement.bindString(1,MortherArticle_Header);
        sqLiteStatement.bindString(2,MotherArticleImgUrl);
        sqLiteStatement.bindString(3,ActualMotherArticle);

        sqLiteStatement.bindString(4,ChildArticleHeader);
        sqLiteStatement.bindString(5,ChildArticleImgUrl);
        sqLiteStatement.bindString(6,ActualChildArticle);

        sqLiteStatement.bindString(7,NutritionTitle);
        sqLiteStatement.bindString(8, NutritionImg_Url);
        sqLiteStatement.bindString(9,NutritionArticle);

        sqLiteStatement.executeInsert();
    }

    public void CREATE_TABLE_WEEK20(){

        try {
            String sql=   "CREATE TABLE WEEK20"+ "(Col_Id integer primary key autoincrement not null, "
                    +DatabaseHelper.COL_MOTHER_ARTICLE_HEADING_WEEK_1+" text not null,"
                    +DatabaseHelper.COL_MOTHER_ARTICLE_IMGURL_WEEK_1 +" text not null,"
                    + DatabaseHelper.COL_ACTUAL_MOTHER_ARTICLES_WEEK_1+" text not null,"

                    + DatabaseHelper.COL_BABAY_HEALTH_HEADING_WEEK_1+" text not null,"
                    + DatabaseHelper.COL_BABY_HEALTH_IMGURL_WEEK_1+" text not null,"
                    + DatabaseHelper.COL_BABY_HEALTH_ACTUAL_ARTICLE_WEEK_1+ " text not null,"

                    +DatabaseHelper.COL_NUTRITION_TITLE+ "text not null,"
                    +DatabaseHelper.COL_NUTRITION_IMG_URL+ "text not null,"
                    +DatabaseHelper.COL_NUTRITION_ARTICLE+ "text not null)";

            db.execSQL(sql);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void INSERT_DATA_T0_WEEK20 (String MortherArticle_Header,
                                       String MotherArticleImgUrl,
                                       String ActualMotherArticle,
                                       String ChildArticleHeader,
                                       String ChildArticleImgUrl,
                                       String ActualChildArticle,
                                       String NutritionTitle,
                                       String NutritionImg_Url,
                                       String NutritionArticle) {

        db = getWritableDatabase();
        String sql =  "INSERT INTO WEEK20 VALUES (NULL,?,?,?,?,?,?,?,?,?)";
        SQLiteStatement sqLiteStatement = db.compileStatement(sql);
        sqLiteStatement.clearBindings();

        sqLiteStatement.bindString(1,MortherArticle_Header);
        sqLiteStatement.bindString(2,MotherArticleImgUrl);
        sqLiteStatement.bindString(3,ActualMotherArticle);

        sqLiteStatement.bindString(4,ChildArticleHeader);
        sqLiteStatement.bindString(5,ChildArticleImgUrl);
        sqLiteStatement.bindString(6,ActualChildArticle);

        sqLiteStatement.bindString(7,NutritionTitle);
        sqLiteStatement.bindString(8, NutritionImg_Url);
        sqLiteStatement.bindString(9,NutritionArticle);

        sqLiteStatement.executeInsert();
    }

    public void CREATE_TABLE_WEEK21(){

        try {
            String sql=   "CREATE TABLE WEEK21"+ "(Col_Id integer primary key autoincrement not null, "
                    +DatabaseHelper.COL_MOTHER_ARTICLE_HEADING_WEEK_1+" text not null,"
                    +DatabaseHelper.COL_MOTHER_ARTICLE_IMGURL_WEEK_1 +" text not null,"
                    + DatabaseHelper.COL_ACTUAL_MOTHER_ARTICLES_WEEK_1+" text not null,"

                    + DatabaseHelper.COL_BABAY_HEALTH_HEADING_WEEK_1+" text not null,"
                    + DatabaseHelper.COL_BABY_HEALTH_IMGURL_WEEK_1+" text not null,"
                    + DatabaseHelper.COL_BABY_HEALTH_ACTUAL_ARTICLE_WEEK_1+ " text not null,"

                    +DatabaseHelper.COL_NUTRITION_TITLE+ "text not null,"
                    +DatabaseHelper.COL_NUTRITION_IMG_URL+ "text not null,"
                    +DatabaseHelper.COL_NUTRITION_ARTICLE+ "text not null)";

            db.execSQL(sql);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void INSERT_DATA_T0_WEEK21 (String MortherArticle_Header,
                                       String MotherArticleImgUrl,
                                       String ActualMotherArticle,
                                       String ChildArticleHeader,
                                       String ChildArticleImgUrl,
                                       String ActualChildArticle,
                                       String NutritionTitle,
                                       String NutritionImg_Url,
                                       String NutritionArticle) {

        db = getWritableDatabase();
        String sql =  "INSERT INTO WEEK21 VALUES (NULL,?,?,?,?,?,?,?,?,?)";
        SQLiteStatement sqLiteStatement = db.compileStatement(sql);
        sqLiteStatement.clearBindings();

        sqLiteStatement.bindString(1,MortherArticle_Header);
        sqLiteStatement.bindString(2,MotherArticleImgUrl);
        sqLiteStatement.bindString(3,ActualMotherArticle);

        sqLiteStatement.bindString(4,ChildArticleHeader);
        sqLiteStatement.bindString(5,ChildArticleImgUrl);
        sqLiteStatement.bindString(6,ActualChildArticle);

        sqLiteStatement.bindString(7,NutritionTitle);
        sqLiteStatement.bindString(8, NutritionImg_Url);
        sqLiteStatement.bindString(9,NutritionArticle);

        sqLiteStatement.executeInsert();
    }

    public void CREATE_TABLE_WEEK22(){

        try {
            String sql=   "CREATE TABLE WEEK22"+ "(Col_Id integer primary key autoincrement not null, "
                    +DatabaseHelper.COL_MOTHER_ARTICLE_HEADING_WEEK_1+" text not null,"
                    +DatabaseHelper.COL_MOTHER_ARTICLE_IMGURL_WEEK_1 +" text not null,"
                    + DatabaseHelper.COL_ACTUAL_MOTHER_ARTICLES_WEEK_1+" text not null,"

                    + DatabaseHelper.COL_BABAY_HEALTH_HEADING_WEEK_1+" text not null,"
                    + DatabaseHelper.COL_BABY_HEALTH_IMGURL_WEEK_1+" text not null,"
                    + DatabaseHelper.COL_BABY_HEALTH_ACTUAL_ARTICLE_WEEK_1+ " text not null,"

                    +DatabaseHelper.COL_NUTRITION_TITLE+ "text not null,"
                    +DatabaseHelper.COL_NUTRITION_IMG_URL+ "text not null,"
                    +DatabaseHelper.COL_NUTRITION_ARTICLE+ "text not null)";

            db.execSQL(sql);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void INSERT_DATA_T0_WEEK22 (String MortherArticle_Header,
                                       String MotherArticleImgUrl,
                                       String ActualMotherArticle,
                                       String ChildArticleHeader,
                                       String ChildArticleImgUrl,
                                       String ActualChildArticle,
                                       String NutritionTitle,
                                       String NutritionImg_Url,
                                       String NutritionArticle) {

        db = getWritableDatabase();
        String sql =  "INSERT INTO WEEK22 VALUES (NULL,?,?,?,?,?,?,?,?,?)";
        SQLiteStatement sqLiteStatement = db.compileStatement(sql);
        sqLiteStatement.clearBindings();

        sqLiteStatement.bindString(1,MortherArticle_Header);
        sqLiteStatement.bindString(2,MotherArticleImgUrl);
        sqLiteStatement.bindString(3,ActualMotherArticle);

        sqLiteStatement.bindString(4,ChildArticleHeader);
        sqLiteStatement.bindString(5,ChildArticleImgUrl);
        sqLiteStatement.bindString(6,ActualChildArticle);

        sqLiteStatement.bindString(7,NutritionTitle);
        sqLiteStatement.bindString(8, NutritionImg_Url);
        sqLiteStatement.bindString(9,NutritionArticle);

        sqLiteStatement.executeInsert();
    }

    public void CREATE_TABLE_WEEK23(){

        try {
            String sql=   "CREATE TABLE WEEK23"+ "(Col_Id integer primary key autoincrement not null, "
                    +DatabaseHelper.COL_MOTHER_ARTICLE_HEADING_WEEK_1+" text not null,"
                    +DatabaseHelper.COL_MOTHER_ARTICLE_IMGURL_WEEK_1 +" text not null,"
                    + DatabaseHelper.COL_ACTUAL_MOTHER_ARTICLES_WEEK_1+" text not null,"

                    + DatabaseHelper.COL_BABAY_HEALTH_HEADING_WEEK_1+" text not null,"
                    + DatabaseHelper.COL_BABY_HEALTH_IMGURL_WEEK_1+" text not null,"
                    + DatabaseHelper.COL_BABY_HEALTH_ACTUAL_ARTICLE_WEEK_1+ " text not null,"

                    +DatabaseHelper.COL_NUTRITION_TITLE+ "text not null,"
                    +DatabaseHelper.COL_NUTRITION_IMG_URL+ "text not null,"
                    +DatabaseHelper.COL_NUTRITION_ARTICLE+ "text not null)";

            db.execSQL(sql);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void INSERT_DATA_T0_WEEK23 (String MortherArticle_Header,
                                       String MotherArticleImgUrl,
                                       String ActualMotherArticle,
                                       String ChildArticleHeader,
                                       String ChildArticleImgUrl,
                                       String ActualChildArticle,
                                       String NutritionTitle,
                                       String NutritionImg_Url,
                                       String NutritionArticle) {

        db = getWritableDatabase();
        String sql =  "INSERT INTO WEEK23 VALUES (NULL,?,?,?,?,?,?,?,?,?)";
        SQLiteStatement sqLiteStatement = db.compileStatement(sql);
        sqLiteStatement.clearBindings();

        sqLiteStatement.bindString(1,MortherArticle_Header);
        sqLiteStatement.bindString(2,MotherArticleImgUrl);
        sqLiteStatement.bindString(3,ActualMotherArticle);

        sqLiteStatement.bindString(4,ChildArticleHeader);
        sqLiteStatement.bindString(5,ChildArticleImgUrl);
        sqLiteStatement.bindString(6,ActualChildArticle);

        sqLiteStatement.bindString(7,NutritionTitle);
        sqLiteStatement.bindString(8, NutritionImg_Url);
        sqLiteStatement.bindString(9,NutritionArticle);

        sqLiteStatement.executeInsert();
    }

    public void CREATE_TABLE_WEEK24(){

        try {
            String sql=   "CREATE TABLE WEEK24"+ "(Col_Id integer primary key autoincrement not null, "
                    +DatabaseHelper.COL_MOTHER_ARTICLE_HEADING_WEEK_1+" text not null,"
                    +DatabaseHelper.COL_MOTHER_ARTICLE_IMGURL_WEEK_1 +" text not null,"
                    + DatabaseHelper.COL_ACTUAL_MOTHER_ARTICLES_WEEK_1+" text not null,"

                    + DatabaseHelper.COL_BABAY_HEALTH_HEADING_WEEK_1+" text not null,"
                    + DatabaseHelper.COL_BABY_HEALTH_IMGURL_WEEK_1+" text not null,"
                    + DatabaseHelper.COL_BABY_HEALTH_ACTUAL_ARTICLE_WEEK_1+ " text not null,"

                    +DatabaseHelper.COL_NUTRITION_TITLE+ "text not null,"
                    +DatabaseHelper.COL_NUTRITION_IMG_URL+ "text not null,"
                    +DatabaseHelper.COL_NUTRITION_ARTICLE+ "text not null)";

            db.execSQL(sql);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void INSERT_DATA_T0_WEEK24 (String MortherArticle_Header,
                                       String MotherArticleImgUrl,
                                       String ActualMotherArticle,
                                       String ChildArticleHeader,
                                       String ChildArticleImgUrl,
                                       String ActualChildArticle,
                                       String NutritionTitle,
                                       String NutritionImg_Url,
                                       String NutritionArticle) {

        db = getWritableDatabase();
        String sql =  "INSERT INTO WEEK24 VALUES (NULL,?,?,?,?,?,?,?,?,?)";
        SQLiteStatement sqLiteStatement = db.compileStatement(sql);
        sqLiteStatement.clearBindings();

        sqLiteStatement.bindString(1,MortherArticle_Header);
        sqLiteStatement.bindString(2,MotherArticleImgUrl);
        sqLiteStatement.bindString(3,ActualMotherArticle);

        sqLiteStatement.bindString(4,ChildArticleHeader);
        sqLiteStatement.bindString(5,ChildArticleImgUrl);
        sqLiteStatement.bindString(6,ActualChildArticle);

        sqLiteStatement.bindString(7,NutritionTitle);
        sqLiteStatement.bindString(8, NutritionImg_Url);
        sqLiteStatement.bindString(9,NutritionArticle);

        sqLiteStatement.executeInsert();
    }

    public void CREATE_TABLE_WEEK25(){

        try {
            String sql=   "CREATE TABLE WEEK25"+ "(Col_Id integer primary key autoincrement not null, "
                    +DatabaseHelper.COL_MOTHER_ARTICLE_HEADING_WEEK_1+" text not null,"
                    +DatabaseHelper.COL_MOTHER_ARTICLE_IMGURL_WEEK_1 +" text not null,"
                    + DatabaseHelper.COL_ACTUAL_MOTHER_ARTICLES_WEEK_1+" text not null,"

                    + DatabaseHelper.COL_BABAY_HEALTH_HEADING_WEEK_1+" text not null,"
                    + DatabaseHelper.COL_BABY_HEALTH_IMGURL_WEEK_1+" text not null,"
                    + DatabaseHelper.COL_BABY_HEALTH_ACTUAL_ARTICLE_WEEK_1+ " text not null,"

                    +DatabaseHelper.COL_NUTRITION_TITLE+ "text not null,"
                    +DatabaseHelper.COL_NUTRITION_IMG_URL+ "text not null,"
                    +DatabaseHelper.COL_NUTRITION_ARTICLE+ "text not null)";

            db.execSQL(sql);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void INSERT_DATA_T0_WEEK25 (String MortherArticle_Header,
                                       String MotherArticleImgUrl,
                                       String ActualMotherArticle,
                                       String ChildArticleHeader,
                                       String ChildArticleImgUrl,
                                       String ActualChildArticle,
                                       String NutritionTitle,
                                       String NutritionImg_Url,
                                       String NutritionArticle) {

        db = getWritableDatabase();
        String sql =  "INSERT INTO WEEK25 VALUES (NULL,?,?,?,?,?,?,?,?,?)";
        SQLiteStatement sqLiteStatement = db.compileStatement(sql);
        sqLiteStatement.clearBindings();

        sqLiteStatement.bindString(1,MortherArticle_Header);
        sqLiteStatement.bindString(2,MotherArticleImgUrl);
        sqLiteStatement.bindString(3,ActualMotherArticle);

        sqLiteStatement.bindString(4,ChildArticleHeader);
        sqLiteStatement.bindString(5,ChildArticleImgUrl);
        sqLiteStatement.bindString(6,ActualChildArticle);

        sqLiteStatement.bindString(7,NutritionTitle);
        sqLiteStatement.bindString(8, NutritionImg_Url);
        sqLiteStatement.bindString(9,NutritionArticle);

        sqLiteStatement.executeInsert();
    }

    public void CREATE_TABLE_WEEK26(){

        try {
            String sql=   "CREATE TABLE WEEK26"+ "(Col_Id integer primary key autoincrement not null, "
                    +DatabaseHelper.COL_MOTHER_ARTICLE_HEADING_WEEK_1+" text not null,"
                    +DatabaseHelper.COL_MOTHER_ARTICLE_IMGURL_WEEK_1 +" text not null,"
                    + DatabaseHelper.COL_ACTUAL_MOTHER_ARTICLES_WEEK_1+" text not null,"

                    + DatabaseHelper.COL_BABAY_HEALTH_HEADING_WEEK_1+" text not null,"
                    + DatabaseHelper.COL_BABY_HEALTH_IMGURL_WEEK_1+" text not null,"
                    + DatabaseHelper.COL_BABY_HEALTH_ACTUAL_ARTICLE_WEEK_1+ " text not null,"

                    +DatabaseHelper.COL_NUTRITION_TITLE+ "text not null,"
                    +DatabaseHelper.COL_NUTRITION_IMG_URL+ "text not null,"
                    +DatabaseHelper.COL_NUTRITION_ARTICLE+ "text not null)";

            db.execSQL(sql);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void INSERT_DATA_T0_WEEK26 (String MortherArticle_Header,
                                       String MotherArticleImgUrl,
                                       String ActualMotherArticle,
                                       String ChildArticleHeader,
                                       String ChildArticleImgUrl,
                                       String ActualChildArticle,
                                       String NutritionTitle,
                                       String NutritionImg_Url,
                                       String NutritionArticle) {

        db = getWritableDatabase();
        String sql =  "INSERT INTO WEEK26 VALUES (NULL,?,?,?,?,?,?,?,?,?)";
        SQLiteStatement sqLiteStatement = db.compileStatement(sql);
        sqLiteStatement.clearBindings();

        sqLiteStatement.bindString(1,MortherArticle_Header);
        sqLiteStatement.bindString(2,MotherArticleImgUrl);
        sqLiteStatement.bindString(3,ActualMotherArticle);

        sqLiteStatement.bindString(4,ChildArticleHeader);
        sqLiteStatement.bindString(5,ChildArticleImgUrl);
        sqLiteStatement.bindString(6,ActualChildArticle);

        sqLiteStatement.bindString(7,NutritionTitle);
        sqLiteStatement.bindString(8, NutritionImg_Url);
        sqLiteStatement.bindString(9,NutritionArticle);

        sqLiteStatement.executeInsert();
    }

    public void CREATE_TABLE_WEEK27(){

        try {
            String sql=   "CREATE TABLE WEEK27"+ "(Col_Id integer primary key autoincrement not null, "
                    +DatabaseHelper.COL_MOTHER_ARTICLE_HEADING_WEEK_1+" text not null,"
                    +DatabaseHelper.COL_MOTHER_ARTICLE_IMGURL_WEEK_1 +" text not null,"
                    + DatabaseHelper.COL_ACTUAL_MOTHER_ARTICLES_WEEK_1+" text not null,"

                    + DatabaseHelper.COL_BABAY_HEALTH_HEADING_WEEK_1+" text not null,"
                    + DatabaseHelper.COL_BABY_HEALTH_IMGURL_WEEK_1+" text not null,"
                    + DatabaseHelper.COL_BABY_HEALTH_ACTUAL_ARTICLE_WEEK_1+ " text not null,"

                    +DatabaseHelper.COL_NUTRITION_TITLE+ "text not null,"
                    +DatabaseHelper.COL_NUTRITION_IMG_URL+ "text not null,"
                    +DatabaseHelper.COL_NUTRITION_ARTICLE+ "text not null)";

            db.execSQL(sql);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void INSERT_DATA_T0_WEEK27 (String MortherArticle_Header,
                                       String MotherArticleImgUrl,
                                       String ActualMotherArticle,
                                       String ChildArticleHeader,
                                       String ChildArticleImgUrl,
                                       String ActualChildArticle,
                                       String NutritionTitle,
                                       String NutritionImg_Url,
                                       String NutritionArticle) {

        db = getWritableDatabase();
        String sql =  "INSERT INTO WEEK27 VALUES (NULL,?,?,?,?,?,?,?,?,?)";
        SQLiteStatement sqLiteStatement = db.compileStatement(sql);
        sqLiteStatement.clearBindings();

        sqLiteStatement.bindString(1,MortherArticle_Header);
        sqLiteStatement.bindString(2,MotherArticleImgUrl);
        sqLiteStatement.bindString(3,ActualMotherArticle);

        sqLiteStatement.bindString(4,ChildArticleHeader);
        sqLiteStatement.bindString(5,ChildArticleImgUrl);
        sqLiteStatement.bindString(6,ActualChildArticle);

        sqLiteStatement.bindString(7,NutritionTitle);
        sqLiteStatement.bindString(8, NutritionImg_Url);
        sqLiteStatement.bindString(9,NutritionArticle);

        sqLiteStatement.executeInsert();
    }

    public void CREATE_TABLE_WEEK28(){

        try {
            String sql=   "CREATE TABLE WEEK28"+ "(Col_Id integer primary key autoincrement not null, "
                    +DatabaseHelper.COL_MOTHER_ARTICLE_HEADING_WEEK_1+" text not null,"
                    +DatabaseHelper.COL_MOTHER_ARTICLE_IMGURL_WEEK_1 +" text not null,"
                    + DatabaseHelper.COL_ACTUAL_MOTHER_ARTICLES_WEEK_1+" text not null,"

                    + DatabaseHelper.COL_BABAY_HEALTH_HEADING_WEEK_1+" text not null,"
                    + DatabaseHelper.COL_BABY_HEALTH_IMGURL_WEEK_1+" text not null,"
                    + DatabaseHelper.COL_BABY_HEALTH_ACTUAL_ARTICLE_WEEK_1+ " text not null,"

                    +DatabaseHelper.COL_NUTRITION_TITLE+ "text not null,"
                    +DatabaseHelper.COL_NUTRITION_IMG_URL+ "text not null,"
                    +DatabaseHelper.COL_NUTRITION_ARTICLE+ "text not null)";

            db.execSQL(sql);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void INSERT_DATA_T0_WEEK28 (String MortherArticle_Header,
                                       String MotherArticleImgUrl,
                                       String ActualMotherArticle,
                                       String ChildArticleHeader,
                                       String ChildArticleImgUrl,
                                       String ActualChildArticle,
                                       String NutritionTitle,
                                       String NutritionImg_Url,
                                       String NutritionArticle) {

        db = getWritableDatabase();
        String sql =  "INSERT INTO WEEK28 VALUES (NULL,?,?,?,?,?,?,?,?,?)";
        SQLiteStatement sqLiteStatement = db.compileStatement(sql);
        sqLiteStatement.clearBindings();

        sqLiteStatement.bindString(1,MortherArticle_Header);
        sqLiteStatement.bindString(2,MotherArticleImgUrl);
        sqLiteStatement.bindString(3,ActualMotherArticle);

        sqLiteStatement.bindString(4,ChildArticleHeader);
        sqLiteStatement.bindString(5,ChildArticleImgUrl);
        sqLiteStatement.bindString(6,ActualChildArticle);

        sqLiteStatement.bindString(7,NutritionTitle);
        sqLiteStatement.bindString(8, NutritionImg_Url);
        sqLiteStatement.bindString(9,NutritionArticle);

        sqLiteStatement.executeInsert();
    }

    public void CREATE_TABLE_WEEK29(){

        try {
            String sql=   "CREATE TABLE WEEK29"+ "(Col_Id integer primary key autoincrement not null, "
                    +DatabaseHelper.COL_MOTHER_ARTICLE_HEADING_WEEK_1+" text not null,"
                    +DatabaseHelper.COL_MOTHER_ARTICLE_IMGURL_WEEK_1 +" text not null,"
                    + DatabaseHelper.COL_ACTUAL_MOTHER_ARTICLES_WEEK_1+" text not null,"

                    + DatabaseHelper.COL_BABAY_HEALTH_HEADING_WEEK_1+" text not null,"
                    + DatabaseHelper.COL_BABY_HEALTH_IMGURL_WEEK_1+" text not null,"
                    + DatabaseHelper.COL_BABY_HEALTH_ACTUAL_ARTICLE_WEEK_1+ " text not null,"

                    +DatabaseHelper.COL_NUTRITION_TITLE+ "text not null,"
                    +DatabaseHelper.COL_NUTRITION_IMG_URL+ "text not null,"
                    +DatabaseHelper.COL_NUTRITION_ARTICLE+ "text not null)";

            db.execSQL(sql);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void INSERT_DATA_T0_WEEK29 (String MortherArticle_Header,
                                       String MotherArticleImgUrl,
                                       String ActualMotherArticle,
                                       String ChildArticleHeader,
                                       String ChildArticleImgUrl,
                                       String ActualChildArticle,
                                       String NutritionTitle,
                                       String NutritionImg_Url,
                                       String NutritionArticle) {

        db = getWritableDatabase();
        String sql =  "INSERT INTO WEEK29 VALUES (NULL,?,?,?,?,?,?,?,?,?)";
        SQLiteStatement sqLiteStatement = db.compileStatement(sql);
        sqLiteStatement.clearBindings();

        sqLiteStatement.bindString(1,MortherArticle_Header);
        sqLiteStatement.bindString(2,MotherArticleImgUrl);
        sqLiteStatement.bindString(3,ActualMotherArticle);

        sqLiteStatement.bindString(4,ChildArticleHeader);
        sqLiteStatement.bindString(5,ChildArticleImgUrl);
        sqLiteStatement.bindString(6,ActualChildArticle);

        sqLiteStatement.bindString(7,NutritionTitle);
        sqLiteStatement.bindString(8, NutritionImg_Url);
        sqLiteStatement.bindString(9,NutritionArticle);

        sqLiteStatement.executeInsert();
    }

    public void CREATE_TABLE_WEEK30(){

        try {
            String sql=   "CREATE TABLE WEEK30"+ "(Col_Id integer primary key autoincrement not null, "
                    +DatabaseHelper.COL_MOTHER_ARTICLE_HEADING_WEEK_1+" text not null,"
                    +DatabaseHelper.COL_MOTHER_ARTICLE_IMGURL_WEEK_1 +" text not null,"
                    + DatabaseHelper.COL_ACTUAL_MOTHER_ARTICLES_WEEK_1+" text not null,"

                    + DatabaseHelper.COL_BABAY_HEALTH_HEADING_WEEK_1+" text not null,"
                    + DatabaseHelper.COL_BABY_HEALTH_IMGURL_WEEK_1+" text not null,"
                    + DatabaseHelper.COL_BABY_HEALTH_ACTUAL_ARTICLE_WEEK_1+ " text not null,"

                    +DatabaseHelper.COL_NUTRITION_TITLE+ "text not null,"
                    +DatabaseHelper.COL_NUTRITION_IMG_URL+ "text not null,"
                    +DatabaseHelper.COL_NUTRITION_ARTICLE+ "text not null)";

            db.execSQL(sql);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void INSERT_DATA_T0_WEEK30 (String MortherArticle_Header,
                                       String MotherArticleImgUrl,
                                       String ActualMotherArticle,
                                       String ChildArticleHeader,
                                       String ChildArticleImgUrl,
                                       String ActualChildArticle,
                                       String NutritionTitle,
                                       String NutritionImg_Url,
                                       String NutritionArticle) {

        db = getWritableDatabase();
        String sql =  "INSERT INTO WEEK30 VALUES (NULL,?,?,?,?,?,?,?,?,?)";
        SQLiteStatement sqLiteStatement = db.compileStatement(sql);
        sqLiteStatement.clearBindings();

        sqLiteStatement.bindString(1,MortherArticle_Header);
        sqLiteStatement.bindString(2,MotherArticleImgUrl);
        sqLiteStatement.bindString(3,ActualMotherArticle);

        sqLiteStatement.bindString(4,ChildArticleHeader);
        sqLiteStatement.bindString(5,ChildArticleImgUrl);
        sqLiteStatement.bindString(6,ActualChildArticle);

        sqLiteStatement.bindString(7,NutritionTitle);
        sqLiteStatement.bindString(8, NutritionImg_Url);
        sqLiteStatement.bindString(9,NutritionArticle);

        sqLiteStatement.executeInsert();
    }

    public void CREATE_TABLE_WEEK31(){

        try {
            String sql=   "CREATE TABLE WEEK31"+ "(Col_Id integer primary key autoincrement not null, "
                    +DatabaseHelper.COL_MOTHER_ARTICLE_HEADING_WEEK_1+" text not null,"
                    +DatabaseHelper.COL_MOTHER_ARTICLE_IMGURL_WEEK_1 +" text not null,"
                    + DatabaseHelper.COL_ACTUAL_MOTHER_ARTICLES_WEEK_1+" text not null,"

                    + DatabaseHelper.COL_BABAY_HEALTH_HEADING_WEEK_1+" text not null,"
                    + DatabaseHelper.COL_BABY_HEALTH_IMGURL_WEEK_1+" text not null,"
                    + DatabaseHelper.COL_BABY_HEALTH_ACTUAL_ARTICLE_WEEK_1+ " text not null,"

                    +DatabaseHelper.COL_NUTRITION_TITLE+ "text not null,"
                    +DatabaseHelper.COL_NUTRITION_IMG_URL+ "text not null,"
                    +DatabaseHelper.COL_NUTRITION_ARTICLE+ "text not null)";

            db.execSQL(sql);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void INSERT_DATA_T0_WEEK31 (String MortherArticle_Header,
                                       String MotherArticleImgUrl,
                                       String ActualMotherArticle,
                                       String ChildArticleHeader,
                                       String ChildArticleImgUrl,
                                       String ActualChildArticle,
                                       String NutritionTitle,
                                       String NutritionImg_Url,
                                       String NutritionArticle) {

        db = getWritableDatabase();
        String sql =  "INSERT INTO WEEK31 VALUES (NULL,?,?,?,?,?,?,?,?,?)";
        SQLiteStatement sqLiteStatement = db.compileStatement(sql);
        sqLiteStatement.clearBindings();

        sqLiteStatement.bindString(1,MortherArticle_Header);
        sqLiteStatement.bindString(2,MotherArticleImgUrl);
        sqLiteStatement.bindString(3,ActualMotherArticle);

        sqLiteStatement.bindString(4,ChildArticleHeader);
        sqLiteStatement.bindString(5,ChildArticleImgUrl);
        sqLiteStatement.bindString(6,ActualChildArticle);

        sqLiteStatement.bindString(7,NutritionTitle);
        sqLiteStatement.bindString(8, NutritionImg_Url);
        sqLiteStatement.bindString(9,NutritionArticle);

        sqLiteStatement.executeInsert();
    }

    public void CREATE_TABLE_WEEK32(){

        try {
            String sql=   "CREATE TABLE WEEK32"+ "(Col_Id integer primary key autoincrement not null, "
                    +DatabaseHelper.COL_MOTHER_ARTICLE_HEADING_WEEK_1+" text not null,"
                    +DatabaseHelper.COL_MOTHER_ARTICLE_IMGURL_WEEK_1 +" text not null,"
                    + DatabaseHelper.COL_ACTUAL_MOTHER_ARTICLES_WEEK_1+" text not null,"

                    + DatabaseHelper.COL_BABAY_HEALTH_HEADING_WEEK_1+" text not null,"
                    + DatabaseHelper.COL_BABY_HEALTH_IMGURL_WEEK_1+" text not null,"
                    + DatabaseHelper.COL_BABY_HEALTH_ACTUAL_ARTICLE_WEEK_1+ " text not null,"

                    +DatabaseHelper.COL_NUTRITION_TITLE+ "text not null,"
                    +DatabaseHelper.COL_NUTRITION_IMG_URL+ "text not null,"
                    +DatabaseHelper.COL_NUTRITION_ARTICLE+ "text not null)";

            db.execSQL(sql);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void INSERT_DATA_T0_WEEK32 (String MortherArticle_Header,
                                       String MotherArticleImgUrl,
                                       String ActualMotherArticle,
                                       String ChildArticleHeader,
                                       String ChildArticleImgUrl,
                                       String ActualChildArticle,
                                       String NutritionTitle,
                                       String NutritionImg_Url,
                                       String NutritionArticle) {

        db = getWritableDatabase();
        String sql =  "INSERT INTO WEEK32 VALUES (NULL,?,?,?,?,?,?,?,?,?)";
        SQLiteStatement sqLiteStatement = db.compileStatement(sql);
        sqLiteStatement.clearBindings();

        sqLiteStatement.bindString(1,MortherArticle_Header);
        sqLiteStatement.bindString(2,MotherArticleImgUrl);
        sqLiteStatement.bindString(3,ActualMotherArticle);

        sqLiteStatement.bindString(4,ChildArticleHeader);
        sqLiteStatement.bindString(5,ChildArticleImgUrl);
        sqLiteStatement.bindString(6,ActualChildArticle);

        sqLiteStatement.bindString(7,NutritionTitle);
        sqLiteStatement.bindString(8, NutritionImg_Url);
        sqLiteStatement.bindString(9,NutritionArticle);
//
//        sqLiteStatement.executeInsert();
    }

    public void CREATE_TABLE_WEEK33(){

        try {
            String sql=   "CREATE TABLE WEEK33"+ "(Col_Id integer primary key autoincrement not null, "
                    +DatabaseHelper.COL_MOTHER_ARTICLE_HEADING_WEEK_1+" text not null,"
                    +DatabaseHelper.COL_MOTHER_ARTICLE_IMGURL_WEEK_1 +" text not null,"
                    + DatabaseHelper.COL_ACTUAL_MOTHER_ARTICLES_WEEK_1+" text not null,"

                    + DatabaseHelper.COL_BABAY_HEALTH_HEADING_WEEK_1+" text not null,"
                    + DatabaseHelper.COL_BABY_HEALTH_IMGURL_WEEK_1+" text not null,"
                    + DatabaseHelper.COL_BABY_HEALTH_ACTUAL_ARTICLE_WEEK_1+ " text not null,"

                    +DatabaseHelper.COL_NUTRITION_TITLE+ "text not null,"
                    +DatabaseHelper.COL_NUTRITION_IMG_URL+ "text not null,"
                    +DatabaseHelper.COL_NUTRITION_ARTICLE+ "text not null)";

            db.execSQL(sql);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void INSERT_DATA_T0_WEEK33 (String MortherArticle_Header,
                                       String MotherArticleImgUrl,
                                       String ActualMotherArticle,
                                       String ChildArticleHeader,
                                       String ChildArticleImgUrl,
                                       String ActualChildArticle,
                                       String NutritionTitle,
                                       String NutritionImg_Url,
                                       String NutritionArticle) {

        db = getWritableDatabase();
        String sql =  "INSERT INTO WEEK33 VALUES (NULL,?,?,?,?,?,?,?,?,?)";
        SQLiteStatement sqLiteStatement = db.compileStatement(sql);
        sqLiteStatement.clearBindings();

        sqLiteStatement.bindString(1,MortherArticle_Header);
        sqLiteStatement.bindString(2,MotherArticleImgUrl);
        sqLiteStatement.bindString(3,ActualMotherArticle);

        sqLiteStatement.bindString(4,ChildArticleHeader);
        sqLiteStatement.bindString(5,ChildArticleImgUrl);
        sqLiteStatement.bindString(6,ActualChildArticle);

        sqLiteStatement.bindString(7,NutritionTitle);
        sqLiteStatement.bindString(8, NutritionImg_Url);
        sqLiteStatement.bindString(9,NutritionArticle);

        sqLiteStatement.executeInsert();
    }

    public void CREATE_TABLE_WEEK34(){

        try {
            String sql=   "CREATE TABLE WEEK34"+ "(Col_Id integer primary key autoincrement not null, "
                    +DatabaseHelper.COL_MOTHER_ARTICLE_HEADING_WEEK_1+" text not null,"
                    +DatabaseHelper.COL_MOTHER_ARTICLE_IMGURL_WEEK_1 +" text not null,"
                    + DatabaseHelper.COL_ACTUAL_MOTHER_ARTICLES_WEEK_1+" text not null,"

                    + DatabaseHelper.COL_BABAY_HEALTH_HEADING_WEEK_1+" text not null,"
                    + DatabaseHelper.COL_BABY_HEALTH_IMGURL_WEEK_1+" text not null,"
                    + DatabaseHelper.COL_BABY_HEALTH_ACTUAL_ARTICLE_WEEK_1+ " text not null,"

                    +DatabaseHelper.COL_NUTRITION_TITLE+ "text not null,"
                    +DatabaseHelper.COL_NUTRITION_IMG_URL+ "text not null,"
                    +DatabaseHelper.COL_NUTRITION_ARTICLE+ "text not null)";

            db.execSQL(sql);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void INSERT_DATA_T0_WEEK34 (String MortherArticle_Header,
                                       String MotherArticleImgUrl,
                                       String ActualMotherArticle,
                                       String ChildArticleHeader,
                                       String ChildArticleImgUrl,
                                       String ActualChildArticle,
                                       String NutritionTitle,
                                       String NutritionImg_Url,
                                       String NutritionArticle) {

        db = getWritableDatabase();
        String sql =  "INSERT INTO WEEK34 VALUES (NULL,?,?,?,?,?,?,?,?,?)";
        SQLiteStatement sqLiteStatement = db.compileStatement(sql);
        sqLiteStatement.clearBindings();

        sqLiteStatement.bindString(1,MortherArticle_Header);
        sqLiteStatement.bindString(2,MotherArticleImgUrl);
        sqLiteStatement.bindString(3,ActualMotherArticle);

        sqLiteStatement.bindString(4,ChildArticleHeader);
        sqLiteStatement.bindString(5,ChildArticleImgUrl);
        sqLiteStatement.bindString(6,ActualChildArticle);

        sqLiteStatement.bindString(7,NutritionTitle);
        sqLiteStatement.bindString(8, NutritionImg_Url);
        sqLiteStatement.bindString(9,NutritionArticle);

        sqLiteStatement.executeInsert();
    }

    public void CREATE_TABLE_WEEK35(){

        try {
            String sql=   "CREATE TABLE WEEK35"+ "(Col_Id integer primary key autoincrement not null, "
                    +DatabaseHelper.COL_MOTHER_ARTICLE_HEADING_WEEK_1+" text not null,"
                    +DatabaseHelper.COL_MOTHER_ARTICLE_IMGURL_WEEK_1 +" text not null,"
                    + DatabaseHelper.COL_ACTUAL_MOTHER_ARTICLES_WEEK_1+" text not null,"

                    + DatabaseHelper.COL_BABAY_HEALTH_HEADING_WEEK_1+" text not null,"
                    + DatabaseHelper.COL_BABY_HEALTH_IMGURL_WEEK_1+" text not null,"
                    + DatabaseHelper.COL_BABY_HEALTH_ACTUAL_ARTICLE_WEEK_1+ " text not null,"

                    +DatabaseHelper.COL_NUTRITION_TITLE+ "text not null,"
                    +DatabaseHelper.COL_NUTRITION_IMG_URL+ "text not null,"
                    +DatabaseHelper.COL_NUTRITION_ARTICLE+ "text not null)";

            db.execSQL(sql);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void INSERT_DATA_T0_WEEK35 (String MortherArticle_Header,
                                       String MotherArticleImgUrl,
                                       String ActualMotherArticle,
                                       String ChildArticleHeader,
                                       String ChildArticleImgUrl,
                                       String ActualChildArticle,
                                       String NutritionTitle,
                                       String NutritionImg_Url,
                                       String NutritionArticle) {

        db = getWritableDatabase();
        String sql =  "INSERT INTO WEEK35 VALUES (NULL,?,?,?,?,?,?,?,?,?)";
        SQLiteStatement sqLiteStatement = db.compileStatement(sql);
        sqLiteStatement.clearBindings();

        sqLiteStatement.bindString(1,MortherArticle_Header);
        sqLiteStatement.bindString(2,MotherArticleImgUrl);
        sqLiteStatement.bindString(3,ActualMotherArticle);

        sqLiteStatement.bindString(4,ChildArticleHeader);
        sqLiteStatement.bindString(5,ChildArticleImgUrl);
        sqLiteStatement.bindString(6,ActualChildArticle);

        sqLiteStatement.bindString(7,NutritionTitle);
        sqLiteStatement.bindString(8, NutritionImg_Url);
        sqLiteStatement.bindString(9,NutritionArticle);

        sqLiteStatement.executeInsert();
    }

    public void CREATE_TABLE_WEEK36(){

        try {
            String sql=   "CREATE TABLE WEEK36"+ "(Col_Id integer primary key autoincrement not null, "
                    +DatabaseHelper.COL_MOTHER_ARTICLE_HEADING_WEEK_1+" text not null,"
                    +DatabaseHelper.COL_MOTHER_ARTICLE_IMGURL_WEEK_1 +" text not null,"
                    + DatabaseHelper.COL_ACTUAL_MOTHER_ARTICLES_WEEK_1+" text not null,"

                    + DatabaseHelper.COL_BABAY_HEALTH_HEADING_WEEK_1+" text not null,"
                    + DatabaseHelper.COL_BABY_HEALTH_IMGURL_WEEK_1+" text not null,"
                    + DatabaseHelper.COL_BABY_HEALTH_ACTUAL_ARTICLE_WEEK_1+ " text not null,"

                    +DatabaseHelper.COL_NUTRITION_TITLE+ "text not null,"
                    +DatabaseHelper.COL_NUTRITION_IMG_URL+ "text not null,"
                    +DatabaseHelper.COL_NUTRITION_ARTICLE+ "text not null)";

            db.execSQL(sql);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void INSERT_DATA_T0_WEEK36 (String MortherArticle_Header,
                                       String MotherArticleImgUrl,
                                       String ActualMotherArticle,
                                       String ChildArticleHeader,
                                       String ChildArticleImgUrl,
                                       String ActualChildArticle,
                                       String NutritionTitle,
                                       String NutritionImg_Url,
                                       String NutritionArticle) {

        db = getWritableDatabase();
        String sql =  "INSERT INTO WEEK36 VALUES (NULL,?,?,?,?,?,?,?,?,?)";
        SQLiteStatement sqLiteStatement = db.compileStatement(sql);
        sqLiteStatement.clearBindings();

        sqLiteStatement.bindString(1,MortherArticle_Header);
        sqLiteStatement.bindString(2,MotherArticleImgUrl);
        sqLiteStatement.bindString(3,ActualMotherArticle);

        sqLiteStatement.bindString(4,ChildArticleHeader);
        sqLiteStatement.bindString(5,ChildArticleImgUrl);
        sqLiteStatement.bindString(6,ActualChildArticle);

        sqLiteStatement.bindString(7,NutritionTitle);
        sqLiteStatement.bindString(8, NutritionImg_Url);
        sqLiteStatement.bindString(9,NutritionArticle);

        sqLiteStatement.executeInsert();
    }

    public void CREATE_TABLE_WEEK37(){

        try {
            String sql=   "CREATE TABLE WEEK37"+ "(Col_Id integer primary key autoincrement not null, "
                    +DatabaseHelper.COL_MOTHER_ARTICLE_HEADING_WEEK_1+" text not null,"
                    +DatabaseHelper.COL_MOTHER_ARTICLE_IMGURL_WEEK_1 +" text not null,"
                    + DatabaseHelper.COL_ACTUAL_MOTHER_ARTICLES_WEEK_1+" text not null,"

                    + DatabaseHelper.COL_BABAY_HEALTH_HEADING_WEEK_1+" text not null,"
                    + DatabaseHelper.COL_BABY_HEALTH_IMGURL_WEEK_1+" text not null,"
                    + DatabaseHelper.COL_BABY_HEALTH_ACTUAL_ARTICLE_WEEK_1+ " text not null,"

                    +DatabaseHelper.COL_NUTRITION_TITLE+ "text not null,"
                    +DatabaseHelper.COL_NUTRITION_IMG_URL+ "text not null,"
                    +DatabaseHelper.COL_NUTRITION_ARTICLE+ "text not null)";

            db.execSQL(sql);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void INSERT_DATA_T0_WEEK37 (String MortherArticle_Header,
                                       String MotherArticleImgUrl,
                                       String ActualMotherArticle,
                                       String ChildArticleHeader,
                                       String ChildArticleImgUrl,
                                       String ActualChildArticle,
                                       String NutritionTitle,
                                       String NutritionImg_Url,
                                       String NutritionArticle) {

        db = getWritableDatabase();
        String sql =  "INSERT INTO WEEK37 VALUES (NULL,?,?,?,?,?,?,?,?,?)";
        SQLiteStatement sqLiteStatement = db.compileStatement(sql);
        sqLiteStatement.clearBindings();

        sqLiteStatement.bindString(1,MortherArticle_Header);
        sqLiteStatement.bindString(2,MotherArticleImgUrl);
        sqLiteStatement.bindString(3,ActualMotherArticle);

        sqLiteStatement.bindString(4,ChildArticleHeader);
        sqLiteStatement.bindString(5,ChildArticleImgUrl);
        sqLiteStatement.bindString(6,ActualChildArticle);

        sqLiteStatement.bindString(7,NutritionTitle);
        sqLiteStatement.bindString(8, NutritionImg_Url);
        sqLiteStatement.bindString(9,NutritionArticle);

        sqLiteStatement.executeInsert();
    }

    public void CREATE_TABLE_WEEK38(){

        try {
            String sql=   "CREATE TABLE WEEK38"+ "(Col_Id integer primary key autoincrement not null, "
                    +DatabaseHelper.COL_MOTHER_ARTICLE_HEADING_WEEK_1+" text not null,"
                    +DatabaseHelper.COL_MOTHER_ARTICLE_IMGURL_WEEK_1 +" text not null,"
                    + DatabaseHelper.COL_ACTUAL_MOTHER_ARTICLES_WEEK_1+" text not null,"

                    + DatabaseHelper.COL_BABAY_HEALTH_HEADING_WEEK_1+" text not null,"
                    + DatabaseHelper.COL_BABY_HEALTH_IMGURL_WEEK_1+" text not null,"
                    + DatabaseHelper.COL_BABY_HEALTH_ACTUAL_ARTICLE_WEEK_1+ " text not null,"

                    +DatabaseHelper.COL_NUTRITION_TITLE+ "text not null,"
                    +DatabaseHelper.COL_NUTRITION_IMG_URL+ "text not null,"
                    +DatabaseHelper.COL_NUTRITION_ARTICLE+ "text not null)";

            db.execSQL(sql);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void INSERT_DATA_T0_WEEK38 (String MortherArticle_Header,
                                       String MotherArticleImgUrl,
                                       String ActualMotherArticle,
                                       String ChildArticleHeader,
                                       String ChildArticleImgUrl,
                                       String ActualChildArticle,
                                       String NutritionTitle,
                                       String NutritionImg_Url,
                                       String NutritionArticle) {

        db = getWritableDatabase();
        String sql =  "INSERT INTO WEEK38 VALUES (NULL,?,?,?,?,?,?,?,?,?)";
        SQLiteStatement sqLiteStatement = db.compileStatement(sql);
        sqLiteStatement.clearBindings();

        sqLiteStatement.bindString(1,MortherArticle_Header);
        sqLiteStatement.bindString(2,MotherArticleImgUrl);
        sqLiteStatement.bindString(3,ActualMotherArticle);

        sqLiteStatement.bindString(4,ChildArticleHeader);
        sqLiteStatement.bindString(5,ChildArticleImgUrl);
        sqLiteStatement.bindString(6,ActualChildArticle);

        sqLiteStatement.bindString(7,NutritionTitle);
        sqLiteStatement.bindString(8, NutritionImg_Url);
        sqLiteStatement.bindString(9,NutritionArticle);

        sqLiteStatement.executeInsert();
    }
    public void CREATE_TABLE_WEEK39(){

        try {
            String sql=   "CREATE TABLE WEEK39"+ "(Col_Id integer primary key autoincrement not null, "
                    +DatabaseHelper.COL_MOTHER_ARTICLE_HEADING_WEEK_1+" text not null,"
                    +DatabaseHelper.COL_MOTHER_ARTICLE_IMGURL_WEEK_1 +" text not null,"
                    + DatabaseHelper.COL_ACTUAL_MOTHER_ARTICLES_WEEK_1+" text not null,"

                    + DatabaseHelper.COL_BABAY_HEALTH_HEADING_WEEK_1+" text not null,"
                    + DatabaseHelper.COL_BABY_HEALTH_IMGURL_WEEK_1+" text not null,"
                    + DatabaseHelper.COL_BABY_HEALTH_ACTUAL_ARTICLE_WEEK_1+ " text not null,"

                    +DatabaseHelper.COL_NUTRITION_TITLE+ "text not null,"
                    +DatabaseHelper.COL_NUTRITION_IMG_URL+ "text not null,"
                    +DatabaseHelper.COL_NUTRITION_ARTICLE+ "text not null)";

            db.execSQL(sql);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void INSERT_DATA_T0_WEEK39 (String MortherArticle_Header,
                                       String MotherArticleImgUrl,
                                       String ActualMotherArticle,
                                       String ChildArticleHeader,
                                       String ChildArticleImgUrl,
                                       String ActualChildArticle,
                                       String NutritionTitle,
                                       String NutritionImg_Url,
                                       String NutritionArticle) {

        db = getWritableDatabase();
        String sql =  "INSERT INTO WEEK39 VALUES (NULL,?,?,?,?,?,?,?,?,?)";
        SQLiteStatement sqLiteStatement = db.compileStatement(sql);
        sqLiteStatement.clearBindings();

        sqLiteStatement.bindString(1,MortherArticle_Header);
        sqLiteStatement.bindString(2,MotherArticleImgUrl);
        sqLiteStatement.bindString(3,ActualMotherArticle);

        sqLiteStatement.bindString(4,ChildArticleHeader);
        sqLiteStatement.bindString(5,ChildArticleImgUrl);
        sqLiteStatement.bindString(6,ActualChildArticle);

        sqLiteStatement.bindString(7,NutritionTitle);
        sqLiteStatement.bindString(8, NutritionImg_Url);
        sqLiteStatement.bindString(9,NutritionArticle);

        sqLiteStatement.executeInsert();
    }
    public void CREATE_TABLE_WEEK40(){

        try {
            String sql=   "CREATE TABLE WEEK40"+ "(Col_Id integer primary key autoincrement not null, "
                    +DatabaseHelper.COL_MOTHER_ARTICLE_HEADING_WEEK_1+" text not null,"
                    +DatabaseHelper.COL_MOTHER_ARTICLE_IMGURL_WEEK_1 +" text not null,"
                    + DatabaseHelper.COL_ACTUAL_MOTHER_ARTICLES_WEEK_1+" text not null,"

                    + DatabaseHelper.COL_BABAY_HEALTH_HEADING_WEEK_1+" text not null,"
                    + DatabaseHelper.COL_BABY_HEALTH_IMGURL_WEEK_1+" text not null,"
                    + DatabaseHelper.COL_BABY_HEALTH_ACTUAL_ARTICLE_WEEK_1+ " text not null,"

                    +DatabaseHelper.COL_NUTRITION_TITLE+ "text not null,"
                    +DatabaseHelper.COL_NUTRITION_IMG_URL+ "text not null,"
                    +DatabaseHelper.COL_NUTRITION_ARTICLE+ "text not null)";

            db.execSQL(sql);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void INSERT_DATA_T0_WEEK40 (String MortherArticle_Header,
                                       String MotherArticleImgUrl,
                                       String ActualMotherArticle,
                                       String ChildArticleHeader,
                                       String ChildArticleImgUrl,
                                       String ActualChildArticle,
                                       String NutritionTitle,
                                       String NutritionImg_Url,
                                       String NutritionArticle) {

        db = getWritableDatabase();
        String sql =  "INSERT INTO WEEK40 VALUES (NULL,?,?,?,?,?,?,?,?,?)";
        SQLiteStatement sqLiteStatement = db.compileStatement(sql);
        sqLiteStatement.clearBindings();

        sqLiteStatement.bindString(1,MortherArticle_Header);
        sqLiteStatement.bindString(2,MotherArticleImgUrl);
        sqLiteStatement.bindString(3,ActualMotherArticle);

        sqLiteStatement.bindString(4,ChildArticleHeader);
        sqLiteStatement.bindString(5,ChildArticleImgUrl);
        sqLiteStatement.bindString(6,ActualChildArticle);

        sqLiteStatement.bindString(7,NutritionTitle);
        sqLiteStatement.bindString(8, NutritionImg_Url);
        sqLiteStatement.bindString(9,NutritionArticle);

        sqLiteStatement.executeInsert();
    }

    public void CREATE_TABLE_WEEK41(){

        try {
            String sql=   "CREATE TABLE WEEK41"+ "(Col_Id integer primary key autoincrement not null, "
                    +DatabaseHelper.COL_MOTHER_ARTICLE_HEADING_WEEK_1+" text not null,"
                    +DatabaseHelper.COL_MOTHER_ARTICLE_IMGURL_WEEK_1 +" text not null,"
                    + DatabaseHelper.COL_ACTUAL_MOTHER_ARTICLES_WEEK_1+" text not null,"

                    + DatabaseHelper.COL_BABAY_HEALTH_HEADING_WEEK_1+" text not null,"
                    + DatabaseHelper.COL_BABY_HEALTH_IMGURL_WEEK_1+" text not null,"
                    + DatabaseHelper.COL_BABY_HEALTH_ACTUAL_ARTICLE_WEEK_1+ " text not null,"

                    +DatabaseHelper.COL_NUTRITION_TITLE+ "text not null,"
                    +DatabaseHelper.COL_NUTRITION_IMG_URL+ "text not null,"
                    +DatabaseHelper.COL_NUTRITION_ARTICLE+ "text not null)";

            db.execSQL(sql);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void INSERT_DATA_T0_WEEK41 (String MortherArticle_Header,
                                       String MotherArticleImgUrl,
                                       String ActualMotherArticle,
                                       String ChildArticleHeader,
                                       String ChildArticleImgUrl,
                                       String ActualChildArticle,
                                       String NutritionTitle,
                                       String NutritionImg_Url,
                                       String NutritionArticle) {

        db = getWritableDatabase();
        String sql =  "INSERT INTO WEEK41 VALUES (NULL,?,?,?,?,?,?,?,?,?)";
        SQLiteStatement sqLiteStatement = db.compileStatement(sql);
        sqLiteStatement.clearBindings();

        sqLiteStatement.bindString(1,MortherArticle_Header);
        sqLiteStatement.bindString(2,MotherArticleImgUrl);
        sqLiteStatement.bindString(3,ActualMotherArticle);

        sqLiteStatement.bindString(4,ChildArticleHeader);
        sqLiteStatement.bindString(5,ChildArticleImgUrl);
        sqLiteStatement.bindString(6,ActualChildArticle);

        sqLiteStatement.bindString(7,NutritionTitle);
        sqLiteStatement.bindString(8, NutritionImg_Url);
        sqLiteStatement.bindString(9,NutritionArticle);

        sqLiteStatement.executeInsert();
    }

    public void CREATE_TABLE_WEEK42(){

        try {
            String sql=   "CREATE TABLE WEEK42"+ "(Col_Id integer primary key autoincrement not null, "
                    +DatabaseHelper.COL_MOTHER_ARTICLE_HEADING_WEEK_1+" text not null,"
                    +DatabaseHelper.COL_MOTHER_ARTICLE_IMGURL_WEEK_1 +" text not null,"
                    + DatabaseHelper.COL_ACTUAL_MOTHER_ARTICLES_WEEK_1+" text not null,"

                    + DatabaseHelper.COL_BABAY_HEALTH_HEADING_WEEK_1+" text not null,"
                    + DatabaseHelper.COL_BABY_HEALTH_IMGURL_WEEK_1+" text not null,"
                    + DatabaseHelper.COL_BABY_HEALTH_ACTUAL_ARTICLE_WEEK_1+ " text not null,"

                    +DatabaseHelper.COL_NUTRITION_TITLE+ "text not null,"
                    +DatabaseHelper.COL_NUTRITION_IMG_URL+ "text not null,"
                    +DatabaseHelper.COL_NUTRITION_ARTICLE+ "text not null)";

            db.execSQL(sql);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void INSERT_DATA_T0_WEEK42 (String MortherArticle_Header,
                                       String MotherArticleImgUrl,
                                       String ActualMotherArticle,
                                       String ChildArticleHeader,
                                       String ChildArticleImgUrl,
                                       String ActualChildArticle,
                                       String NutritionTitle,
                                       String NutritionImg_Url,
                                       String NutritionArticle) {

        db = getWritableDatabase();
        String sql =  "INSERT INTO WEEK42 VALUES (NULL,?,?,?,?,?,?,?,?,?)";
        SQLiteStatement sqLiteStatement = db.compileStatement(sql);
        sqLiteStatement.clearBindings();

        sqLiteStatement.bindString(1,MortherArticle_Header);
        sqLiteStatement.bindString(2,MotherArticleImgUrl);
        sqLiteStatement.bindString(3,ActualMotherArticle);

        sqLiteStatement.bindString(4,ChildArticleHeader);
        sqLiteStatement.bindString(5,ChildArticleImgUrl);
        sqLiteStatement.bindString(6,ActualChildArticle);

        sqLiteStatement.bindString(7,NutritionTitle);
        sqLiteStatement.bindString(8, NutritionImg_Url);
        sqLiteStatement.bindString(9,NutritionArticle);

        sqLiteStatement.executeInsert();
    }



    public ArrayList<ContentfromDb> GET_EVERYTHING(int week){
        ArrayList<ContentfromDb> listitems = new ArrayList();
        db = getWritableDatabase();
        String sql = "SELECT * FROM WEEK"+week;

        Cursor c = db.rawQuery(sql,null);
        if (c.moveToFirst()){
            do{
                ContentfromDb content = new ContentfromDb();
                content.setMother_Article_Heading(c.getString(1));
                content.setMother_Article_Img_Url(c.getString(2));
                content.setActual_Mother_Artcle(c.getString(3));

                content.setChild_Article_Heading(c.getString(4));
                content.setChild_Article_Img_Url(c.getString(5));
                content.setActual_Child_Article(c.getString(6));

                content.setNutrition_Article_Heading(c.getString(7));
                content.setNutrition_IMG_URL(c.getString(8));
                content.setActual_Nutrition_Artcle(c.getString(9));

                listitems.add(content);
            }while (c.moveToNext());
        }
        return listitems;
    }
}
