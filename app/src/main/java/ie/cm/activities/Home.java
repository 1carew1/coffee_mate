package ie.cm.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;

import ie.cm.R;
import ie.cm.bundle.CoffeeBundle;
import ie.cm.models.Coffee;

import static ie.cm.R.layout.add;

public class Home extends Base {

    private static final String TAG = "HomeActivity";

    TextView recentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setLogo(R.drawable.ic_launcher1);

        recentList = (TextView) findViewById(R.id.recentlyAddedListEmpty);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Information", Snackbar.LENGTH_LONG)
                        .setAction("More Info...", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                openInfoDialog(Home.this);
                            }
                        }).show();
            }
        });


        // Get the coffee from the bundle
        Bundle bundle = getIntent().getExtras();
        String coffeeListKey = getString(R.string.coffeeListKey);
        CoffeeBundle coffeeBundle = new CoffeeBundle(bundle);
        coffeeList = coffeeBundle.retrieveCoffeListFromBundle(coffeeListKey);


        //Bootstrap some coffe
        coffeeList.add(new Coffee("name", "shop", 1, 1, false));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.menu_help) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void add(View v) {
        String coffeeListKey = getString(R.string.coffeeListKey);
        Bundle bundle = new Bundle();
        bundle.putSerializable(coffeeListKey, coffeeList);
        goToActivity(this, Add.class, bundle);
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (!coffeeList.isEmpty()) {
            recentList.setText(coffeeList.toString());
        } else {
            recentList.setText(getString(R.string.recentlyViewedListEmptyMessage));
        }
    }

}
