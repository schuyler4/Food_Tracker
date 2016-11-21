package com.marek.foodtracker;

/**
 * Created by Newton on 11/20/16.
 */

/* this class is used to create meals to store in data */
public class Meals {

    private int _id;
    private String _mealname;
    private String _mealdescription;

    public Meals() {
    }

    public Meals(String mealname, String mealdescription) {
        this._mealname = mealname;
        this._mealdescription = mealdescription;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public void set_mealname(String _mealname) {
        this._mealname = _mealname;
    }

    public void set_mealdescription(String _mealdescription) {
        this._mealdescription = _mealdescription;
    }

    public int get_id() {
        return _id;
    }

    public String get_mealname() {
        return _mealname;
    }

    public String get_mealdescription() {
        return _mealdescription;
    }
}
