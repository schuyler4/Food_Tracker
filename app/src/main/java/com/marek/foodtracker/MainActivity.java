package com.marek.foodtracker;

import android.content.SharedPreferences;
import android.database.Cursor;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.view.WindowManager;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    TextView mealText;
    MyDbHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mealText = (TextView)findViewById(R.id.textView);
        dbHandler = new MyDbHandler(this, null, null, 1);

        displayMeal();
    }

    public void addMeal(View view) {
        Intent intent = new Intent(this, addMealActivity.class);
        startActivity(intent);
    }

    public void displayMeal() {
        String dbString = dbHandler.databaseToString();
        mealText.setText(dbString);
        System.out.println("panda");
        System.out.println("the string is " + dbString);
        System.out.println("panda");

        /*Cursor AllMeal = dbHandler.getMeals();
        AllMeal.moveToFirst();

        while (!AllMeal.isAfterLast()) {
            String Name = AllMeal.getString(1);
            String Description = AllMeal.getString(2);

            System.out.println("database name" + Name);
            System.out.println("database description" + Description);
            mealText.setText(Name);

            AllMeal.moveToNext();
        }*/

    }
}

