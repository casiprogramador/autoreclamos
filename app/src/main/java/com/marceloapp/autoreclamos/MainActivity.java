package com.marceloapp.autoreclamos;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.marceloapp.autoreclamos.Activities.FormUserActivity;
import com.marceloapp.autoreclamos.Adapters.ViewPagerAdapter;
import com.marceloapp.autoreclamos.Fragments.ContactosFragment;
import com.marceloapp.autoreclamos.Fragments.ReclamosFragment;
import com.marceloapp.autoreclamos.Fragments.SegurosFragment;
import com.marceloapp.autoreclamos.Fragments.ServiciosFragment;


public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager viewPager;
    ViewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar)findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragments(new ReclamosFragment(),"Reclamos");
        viewPagerAdapter.addFragments(new ServiciosFragment(),"Servicios");
        viewPagerAdapter.addFragments(new SegurosFragment(),"Seguros");
        viewPagerAdapter.addFragments(new ContactosFragment(),"Contactos");
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_user) {
            Intent activity = new Intent(this, FormUserActivity.class);
            startActivity(activity);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
