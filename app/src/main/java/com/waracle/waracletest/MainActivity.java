package com.waracle.waracletest;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.waracle.waracletest.app.DefaultActivity;
import com.waracle.waracletest.app.cake.CakeFragment;

public class MainActivity extends DefaultActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.main_activity_root, new CakeFragment())
                    .commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.action_refresh) {
            CakeFragment cakeFragment = (CakeFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.main_activity_root);

            cakeFragment.refresh();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}