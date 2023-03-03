package com.example.slicecontainerjava;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setItemIconSize(150);
        bottomNavigationView.setItemIconTintList(null);
//        Menu menu = bottomNavigationView.getMenu();
//        menu.findItem(R.id.lobby).setIcon(R.drawable.lobby_m);
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout_users,new LobbyFragment()).commit();
        bottomMenu();

    }

    private void bottomMenu() {
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;
                switch (item.getItemId()) {
                    case R.id.lobby:
                        fragment = new LobbyFragment();
                        item.setIcon(R.drawable.lobby);
                        break;
                    case R.id.notification:
                        fragment = new NotificationFragment();
                        break;
                    case R.id.chat:
                        fragment = new ChatFragment();
                        break;
                    case R.id.assigment:
                        fragment = new AssigmentFragment();
                        break;
                    case R.id.profile:
                        fragment = new ProfileFragment();
                        break;
                }
                assert fragment != null;
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout_users,fragment).commit();
                return false;
            }
        });
//        bottomNavigationView.setOnNavigationItemSelectedListener(
//            new BottomNavigationView.OnNavigationItemSelectedListener() {
//                @Override
//                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                    Fragment fragment = null;
//                    switch (item.getItemId()) {
//                        case R.id.lobby:
//                            fragment = new LobbyFragment();
//                            break;
//                        case R.id.notification:
//                            fragment = new NotificationFragment();
//                            item.setIcon(R.drawable.notifikasi);
//                            break;
//                        case R.id.chat:
//                            fragment = new ChatFragment();
//                            item.setIcon(R.drawable.chat);
//                            break;
//                        case R.id.assigment:
//                            fragment = new AssigmentFragment();
//                            item.setIcon(R.drawable.assignment);
//                            break;
//                        case R.id.profile:
//                            fragment = new ProfileFragment();
//                            item.setIcon(R.drawable.profile);
//                            break;
//                    }
//                    assert fragment != null;
//                    getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout_users,fragment).commit();
//                    return false;
//                }
//            });

    }
}