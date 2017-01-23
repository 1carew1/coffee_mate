package ie.cm.bundle;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import ie.cm.models.Coffee;

/**
 * Created by colmcarew on 23/01/2017.
 */

public class CoffeeBundle {
    private static final String TAG = "CoffeeBundle";

    private Bundle bundle;

    public CoffeeBundle(Bundle bundle) {
        this.bundle = bundle;
    }

    public ArrayList<Coffee> retrieveCoffeListFromBundle(String key) {
        ArrayList<Coffee> coffeeList = new ArrayList<>();
        if (bundle != null) {
            Log.v(TAG, "Trying to get coffee list from bundle");
            try {
                coffeeList = (ArrayList<Coffee>) bundle.getSerializable(key);
            } catch (Exception e) {
                Log.e(TAG, "Issue getting Coffee List from bundle", e);
            }
            if (coffeeList == null) {
                coffeeList = new ArrayList<Coffee>();
            } else {
                Log.v(TAG, "Current Coffees");
                for (Coffee coffee : coffeeList) {
                    Log.v(TAG, "Coffee : " + coffee.toString());
                }
            }
        } else {
            Log.v(TAG, "Bundle is null so will not get coffee list");
        }

        return coffeeList;
    }
}
