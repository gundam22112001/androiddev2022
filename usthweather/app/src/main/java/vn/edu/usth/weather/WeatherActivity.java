package vn.edu.usth.weather;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;

public class WeatherActivity extends AppCompatActivity {
    private static final String TAG = "WeatherActivity";
    private ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        pager = (ViewPager) findViewById(R.id.view_pager);
        PagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        pager.setAdapter(adapter);
        pager.setOffscreenPageLimit(3);
        Log.i(TAG, "onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.i(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.i(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.i(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.i(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.i(TAG, "onDestroy");
    }


}