package com.marek.foodtracker;

/**
 * Created by Newton on 11/20/16.
 */

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;
import android.content.Context;
import android.content.ContentValues;
import android.provider.Settings;

public class MyDbHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "meals.db";
    public static final String TABLE_MEALS = "meals";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_MEALNAME = "mealname";
    public static final String COLUMN_MEALDESCRIPTION = "mealdescription";


    public MyDbHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_MEALS + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_MEALNAME + " TEXT, " + COLUMN_MEALDESCRIPTION + " TEXT" +
                ");";

        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP_TABLE IF EXISTS " + TABLE_MEALS);
        onCreate(db);

        System.out.println("on upgrade");
    }

    /* add meal to the database */
    public void addMeal(Meals meal) {
        System.out.println("adding meal");

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(COLUMN_MEALNAME, meal.get_mealname());
        values.put(COLUMN_MEALDESCRIPTION, meal.get_mealdescription());

        db.insert(TABLE_MEALS, null, values);
        db.close();
    }

    /* delete stuff from database */
    public void deleteMeal(String mealname) {
        SQLiteDatabase db = getWritableDatabase();

        db.execSQL("DELETE FROM " + TABLE_MEALS + " WHERE " + COLUMN_MEALNAME +  "=\"" + mealname +
                "\";");
    }

    public String databaseToString(){
        String dbString = "";
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_MEALS;

        Cursor recordSet = db.rawQuery(query, null);
        recordSet.moveToFirst();

        System.out.println("database to string");

        while (!recordSet.isAfterLast()) {

            System.out.println("in while loop");

            if (recordSet.getString(recordSet.getColumnIndex("mealname")) != null) {
                dbString += recordSet.getString(recordSet.getColumnIndex("mealname"));
                dbString += "\n";
                System.out.println(dbString);
            }
            recordSet.moveToNext();
        }

        db.close();

        System.out.println("the string is " + dbString);
        return dbString;
    }


    public Cursor getMeals() {
        Cursor cursor = getReadableDatabase().query(TABLE_MEALS, new String[]
                {COLUMN_ID, COLUMN_MEALNAME, COLUMN_MEALDESCRIPTION}, null, null, null, null, null);

        return cursor;
    }


}
