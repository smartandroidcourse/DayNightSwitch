package colorsfx.smart.android.courses.daynightswitch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private DayNightSwitch day_night_switch;
    public static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final View background_view = findViewById(R.id.background_view);

        day_night_switch = (DayNightSwitch)findViewById(R.id.day_night_switch);
        day_night_switch.setDuration(450);

        day_night_switch.setListener(new DayNightSwitchListener() {
            @Override
            public void onSwitch(boolean is_night) {
                Log.d(TAG, "onSwitch() called with: is_night = [" + is_night + "]");
                if (is_night)
                    background_view.setAlpha(1f);

            }
        });

        day_night_switch.setAnimListener(new DayNightSwitchAnimListener() {
            @Override
            public void onAnimStart() {
                Log.d(TAG, "onAnimStart() called");
            }

            @Override
            public void onAnimEnd() {
                Log.d(TAG, "onAnimEnd() called");
            }

            @Override
            public void onAnimValueChanged(float value) {
                background_view.setAlpha(value);
                Log.d(TAG, "onAnimValueChanged() called with: value = [" + value + "]");
            }
        });

    }


}