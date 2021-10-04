package vn.edu.usth.weather;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ForecastFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        LinearLayout ll = new LinearLayout(getActivity());
        ll.setBackgroundColor(Color.GREEN);
        ll.setOrientation(LinearLayout.VERTICAL);

        TextView thursday = new TextView(getActivity());
        thursday.setText("Thursday");

        ImageView imageView = new ImageView(getActivity());
        imageView.setImageResource(R.drawable.cloudy);

        ll.addView(thursday);
        ll.addView(imageView);

        return ll ;
    }

}