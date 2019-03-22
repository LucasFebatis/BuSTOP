package com.febatis.bustop.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.febatis.bustop.R;
import com.febatis.bustop.fragment.FavoritoFragment;
import com.febatis.bustop.fragment.HistoricoFragment;
import com.febatis.bustop.fragment.MapaFragment;

public class MainActivity extends AppCompatActivity
        implements BottomNavigationView.OnNavigationItemSelectedListener {

    private BottomNavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigationView = findViewById(R.id.navigationView);
        navigationView.setOnNavigationItemSelectedListener(this);

        Fragment mapaFragment = MapaFragment.newInstance();
        openFragment(mapaFragment);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        switch (menuItem.getItemId()) {
            case R.id.favorito:

                Fragment favoritoFragment = FavoritoFragment.newInstance();
                openFragment(favoritoFragment);

                break;
            case R.id.mapa:

                Fragment mapaFragment = MapaFragment.newInstance();
                openFragment(mapaFragment);

                break;
            case R.id.historico:

                Fragment historicoFragment = HistoricoFragment.newInstance();
                openFragment(historicoFragment);

                break;
        }

        return true;
    }

    private void openFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
