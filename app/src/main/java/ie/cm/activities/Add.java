package ie.cm.activities;

import ie.cm.bundle.CoffeeBundle;
import ie.cm.models.Coffee;
import ie.cm.R;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

import java.util.ArrayList;

public class Add extends Base implements
        OnClickListener {

    private String coffeeName, coffeeShop;
    private double coffeePrice, ratingValue;
    private EditText name, shop, price;
    private RatingBar ratingBar;

    private static final String TAG = "AddActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.add);

        Bundle bundle = getIntent().getExtras();
        String coffeeListKey = getString(R.string.coffeeListKey);
        CoffeeBundle coffeeBundle = new CoffeeBundle(bundle);
        coffeeList = coffeeBundle.retrieveCoffeListFromBundle(coffeeListKey);

        Button saveButton = (Button) findViewById(R.id.saveCoffeeBtn);
        name = (EditText) findViewById(R.id.nameEditText);
        shop = (EditText) findViewById(R.id.shopEditText);
        price = (EditText) findViewById(R.id.priceEditText);
        ratingBar = (RatingBar) findViewById(R.id.coffeeRatingBar);
        saveButton.setOnClickListener(this);
    }

    public void onClick(View v) {

        coffeeName = name.getText().toString();
        coffeeShop = shop.getText().toString();
        try {
            coffeePrice = Double.parseDouble(price.getText().toString());
        } catch (NumberFormatException e) {
            coffeePrice = 0.0;
        }
        ratingValue = ratingBar.getRating();

        if ((coffeeName.length() > 0) && (coffeeShop.length() > 0)
                && (price.length() > 0)) {
            Coffee coffee = new Coffee(coffeeName, coffeeShop, ratingValue,
                    coffeePrice, false);

            coffeeList.add(coffee);
            Log.v(TAG, "Coffee Added : " + coffee.toString());
            String coffeeListKey = getString(R.string.coffeeListKey);
            Bundle bundle = new Bundle();
            bundle.putSerializable(coffeeListKey, coffeeList);
            goToActivity(this, Home.class, bundle);
        } else {
            String coffeeAddIssue = getString(R.string.coffeAddIssue);
            Toast.makeText(this, coffeeAddIssue, Toast.LENGTH_SHORT).show();
        }
    }
}
