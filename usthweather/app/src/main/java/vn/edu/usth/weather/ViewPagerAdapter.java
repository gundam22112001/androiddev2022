package vn.edu.usth.weather;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new WeatherFragment();

            case 1:
                return new ForecastFragment();

            case 2:
                return new WeatherAndForecastFragment();

            default:
                return new WeatherFragment();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle (int position){
        String title="";
        switch (position) {
            case 0:
                 title="Weather";
                 break;

            case 1:
                title="Forecast";
                break;

            case 2:
                title="WeatherAndForecast";
                break;
        }
        return title;
    }
}
