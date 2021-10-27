package vn.edu.usth.weather;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;


import com.google.android.material.tabs.TabLayout;

public class WeatherActivity extends AppCompatActivity {
    private static final String TAG = "WeatherActivity";
    private TabLayout tab;
    private ViewPager pager;
    private ProgressBar progressBar;
//    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

//        toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        tab = findViewById(R.id.tab_layout);
        pager = findViewById(R.id.view_pager);

        PagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        pager.setAdapter(adapter);
        pager.setOffscreenPageLimit(3);
        tab.setupWithViewPager(pager);
        progressBar = findViewById(R.id.progress_bar);
        Log.i(TAG, "onCreate");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.usth_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_refresh:
//                Toast.makeText(this, "Refreshing", Toast.LENGTH_SHORT).show();
//                Thread t = new Thread(new Runnable() {
//                    @Override
//                    public void run() {
//                        try {
//                            Thread.sleep(3000);
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                        Bundle bundle = new Bundle();
//                        bundle.putString("server_response", "Refreshing");
//                        Message msg = handler.obtainMessage();
//                        msg.setData(bundle);
//                        handler.sendMessage(msg);
//                    }
//                });
//                t.start();
                refreshAsyncTask(progressBar);
                return true;
            case R.id.action_setting:
                openPreActivity();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

//    final Handler handler = new Handler(Looper.getMainLooper()) {
//        @Override
//        public void handleMessage(@NonNull Message msg) {
//            String content = msg.getData().getString("server_response");
//            Toast.makeText(WeatherActivity.this, content, Toast.LENGTH_SHORT).show();
//        }
//    };


    public void refreshAsyncTask(View v) {
        AsyncTask task = new AsyncTask();
        task.execute(5);
    }

    private class AsyncTask extends android.os.AsyncTask<Integer,Integer, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            progressBar.setVisibility(View.VISIBLE);
        }
        @Override
        protected String doInBackground(Integer... integers) {
            for (int i = 0; i < integers[0]; i++){
                publishProgress((i * 100)/integers[0]);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return "Finish Refreshing!";
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);

            progressBar.setProgress(values[0]);
        }
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            Toast.makeText(WeatherActivity.this, s, Toast.LENGTH_SHORT).show();
            progressBar.setVisibility(View.INVISIBLE);
        }
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

    public void openPreActivity() {
        Intent intent = new Intent(this, PrefActivity.class);
        startActivity(intent);
    }
}