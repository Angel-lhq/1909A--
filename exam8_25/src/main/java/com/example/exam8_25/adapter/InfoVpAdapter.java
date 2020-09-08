package com.example.exam8_25.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

public class InfoVpAdapter extends FragmentPagerAdapter {
    private List<Fragment> list;
    String[] titles = new String[]{"关注","推荐","广场","视频","摄影","知识文章"};

    public InfoVpAdapter(@NonNull FragmentManager fm, List<Fragment> list) {
        super(fm);
        this.list = list;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if (list.size()>0){
            return titles[position];
        }else {
            return super.getPageTitle(position);
        }
    }
}
