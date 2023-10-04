package com.example.tasknavigation;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;

public class MainActivity extends AppCompatActivity {
    MeowBottomNavigation bottomNavigation;
    private homeFragment homeFragment;
    private infoFragment infoFragment;
    private shareFragment shareFragment;
    private SettingFragment settingFragment ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigation = findViewById(R.id.bottomNavigation);
        bottomNavigation.show(1, true);

        homeFragment = new homeFragment();
        infoFragment = new infoFragment();
        shareFragment = new shareFragment();
        settingFragment = new SettingFragment();
        setFragment(homeFragment);

        // add your bottom navigation icon here
        bottomNavigation.add(new MeowBottomNavigation.Model(1, R.drawable.baseline_home_24));
        bottomNavigation.add(new MeowBottomNavigation.Model(2, R.drawable.baseline_info_24));
        bottomNavigation.add(new MeowBottomNavigation.Model(3, R.drawable.baseline_ios_share_24));
        bottomNavigation.add(new MeowBottomNavigation.Model(4, R.drawable.baseline_settings_24));

        bottomNavigation.setOnClickMenuListener(model -> {
            Fragment selectedFragment = null;

            switch (model.getId()) {
                case 1:
                    selectedFragment = homeFragment;
                    break;
                case 2:
                    selectedFragment = infoFragment;
                    break;
                case 3:
                    selectedFragment = shareFragment;
                    break;
                case 4:
                    selectedFragment = settingFragment;
                    break;
            }

            if (selectedFragment != null) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragmentContainer, selectedFragment)
                        .commit();
            }
            return null;
        });
    }
    private void setFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainer, fragment)
                .commit();
    }
}