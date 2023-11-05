package es.unizar.eina.notepad.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import es.unizar.eina.notepad.R;

public class ListarPlatos extends AppCompatActivity implements IntentInterface {

    ViewPagerAdapter mAdapter;
    ViewPager2 viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listarplatos);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // --- TAB LAYOUT & PAGER SETUP ---
        viewPager = findViewById(R.id.pager);
        mAdapter = new ViewPagerAdapter(getSupportFragmentManager(), getLifecycle());
        CategoriaFragment primeros = CategoriaFragment.create("@string/PRIMEROS");
        mAdapter.addFragment(primeros);
        mAdapter.addFragment(new CategoriaFragment());
        mAdapter.addFragment(new CategoriaFragment());

        viewPager.setAdapter(mAdapter);

        TabLayout tabLayout = findViewById(R.id.tab_layout);

        new TabLayoutMediator(tabLayout, viewPager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch(position) {
                    case 0:
                        tab.setText("PRIMEROS");
                        break;
                    case 1:
                        tab.setText("SEGUNDOS");
                        break;
                    case 2:
                        tab.setText("POSTRES");
                        break;
                    default:
                        break;
                }
            }
        }).attach();
    }

    @Override
    public void startMyIntent(Intent i) {
        startActivity(i);
    }
}
