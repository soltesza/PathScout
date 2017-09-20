package pathscoutapp.com.pathscout;

import android.database.DataSetObserver;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.SimpleAdapter;
import android.widget.Switch;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class SearchActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {
    private RadioGroup activitySelector;
    private SeekBar diff_slider1, diff_slider2, dist_slider1, dist_slider2;

    public void search(View v) {
        SearchParams.Activity activity;
        int minDist, maxDist, minDiff, maxDiff;

        //get activity type
        int id = activitySelector.getCheckedRadioButtonId();
        if(id == R.id.walk_button) {
            activity = SearchParams.Activity.WALK;
        }
        else if(id == R.id.run_button) {
            activity = SearchParams.Activity.BIKE;
        }
        else if(id == R.id.bike_button) {
            activity = SearchParams.Activity.BIKE;
        }
        else {
            Toast activityError = new Toast(getApplicationContext());
            activityError.setText("Error: no activity selected!");
            activityError.setDuration(Toast.LENGTH_SHORT);
            activityError.show();

            return;
        }

        minDist = dist_slider1.getProgress();
        maxDist = dist_slider2.getProgress();

        minDiff = diff_slider1.getProgress();
        maxDiff = diff_slider2.getProgress();

        SearchParams params = new SearchParams(activity, minDiff, maxDiff, minDist, maxDist);
    }

    public void toggleDifficulty(View v) {
        Switch diff_switch = (Switch) v;

        if(diff_switch.isChecked()) {
            diff_slider1.setVisibility(View.VISIBLE);
            diff_slider2.setVisibility(View.VISIBLE);
        }
        else {
            diff_slider1.setVisibility(View.GONE);
            diff_slider2.setVisibility(View.GONE);
        }
    }

    public void toggleDistance(View v) {
        Switch dist_switch = (Switch) v;

        if(dist_switch.isChecked()) {
            dist_slider1.setVisibility(View.VISIBLE);
            dist_slider2.setVisibility(View.VISIBLE);
        }
        else {
            dist_slider1.setVisibility(View.GONE);
            dist_slider2.setVisibility(View.GONE);
        }
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        if(seekBar == diff_slider1) {
            if(diff_slider2.getProgress() < diff_slider1.getProgress()) {
                diff_slider2.setProgress(diff_slider1.getProgress());
            }
        }
        else if(seekBar == diff_slider2) {

        }
        else if(seekBar == dist_slider1) {

        }
        else if(seekBar == dist_slider2) {

        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        if(seekBar == diff_slider1) {
            if(diff_slider2.getProgress() < diff_slider1.getProgress()) {
                diff_slider2.setProgress(diff_slider1.getProgress());
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        //initialize sliders
        diff_slider1 = (SeekBar) findViewById(R.id.diff_slider1);
        diff_slider2 = (SeekBar) findViewById(R.id.diff_slider2);
        dist_slider1 = (SeekBar) findViewById(R.id.dist_slider1);
        dist_slider2 = (SeekBar) findViewById(R.id.dist_slider2);

        //initialize radio group
        activitySelector = (RadioGroup) findViewById(R.id.activity_selector);
    }
}
