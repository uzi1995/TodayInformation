package com.example.todayinformation.main.hangzhou;

import androidx.viewpager.widget.ViewPager;

import com.example.todayinformation.R;
import com.example.todayinformation.base.BaseFragment;
import com.example.todayinformation.base.Viewinject;
import com.example.todayinformation.main.hangzhou.adapter.HangZhouViewPagerAdapter;
import com.google.android.material.tabs.TabLayout;

import butterknife.BindView;

@Viewinject(mainlayoutid = R.layout.fragment_hangzhou)
public class HangZhouFragment extends BaseFragment {
    @BindView(R.id.tl_tablayout)
    TabLayout tlTablayout;
    @BindView(R.id.vp_viewpager)
    ViewPager vpViewpager;

    @Override
    public void afterBindView() {
        tlTablayout.setupWithViewPager(vpViewpager);

        vpViewpager.setAdapter( new HangZhouViewPagerAdapter(getChildFragmentManager()));
    }
}
