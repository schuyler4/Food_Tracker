package com.marek.foodtracker;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.view.WindowManager;
import android.content.Context;

public class addMealActivity extends AppCompatActivity {

    EditText mealTitleTextArea;
    EditText mealDescriptionTextArea;
    MyDbHandler dbHandler;

    public static final String MyPREFERENCES = "MyPrefs";
    public static final String MealName = "nameKey";
    public static final String MealDescription = "descriptionKey";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_meal);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        mealTitleTextArea = (EditText)findViewById(R.id.mealTitle);
        mealDescriptionTextArea = (EditText)findViewById(R.id.mealDescription);

        dbHandler = new MyDbHandler(this, null, null, 1);
    }

    public void goHome(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public  void submitMeal(View view) {
        String mealName = mealTitleTextArea.getText().toString();
        String mealDescription = mealDescriptionTextArea.getText().toString();

        System.out.println(mealName);
        System.out.println(mealDescription);

        SharedPreferences.Editor editor = getSharedPreferences(MyPREFERENCES, MODE_PRIVATE).edit();

        editor.putString("name", mealName);
        editor.putString("description", mealDescription);

        goHome(view);
    }

}
