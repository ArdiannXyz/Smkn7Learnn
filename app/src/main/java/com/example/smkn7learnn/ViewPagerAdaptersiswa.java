package com.example.smkn7learnn;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewPagerAdaptersiswa extends FragmentStateAdapter {
    public ViewPagerAdaptersiswa(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position == 0) {
            return new DashboardSiswaFragment();
        } else if (position == 1) {
            return new MapelSiswa();
        } else if (position == 2) {
            return new DashProfilSiswa();
        } else {
            return new DashboardSiswaFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
