package hackny.awkscape;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;



import watch.nudge.phonegesturelibrary.AbstractPhoneGestureActivity;

public class MainActivity extends AbstractPhoneGestureActivity {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Override these functions to make your app respond to gestures.
    private AlarmManager alarmMgr;
    private PendingIntent alarmIntent;


    @Override
    public void onSnap() {
        Toast.makeText(this, "Feeling snappy!", Toast.LENGTH_LONG).show();

        alarmMgr = (AlarmManager) getApplicationContext().getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(getApplicationContext(), AlarmReceiver.class);
        alarmIntent = PendingIntent.getBroadcast(getApplicationContext(), 1, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        alarmMgr.set(AlarmManager.RTC_WAKEUP,
                System.currentTimeMillis() + 5 * 1000, alarmIntent);
    }

    @Override
    public void onFlick() {
        Toast.makeText(this,"Flick that thang!",Toast.LENGTH_LONG).show();


    }

    @Override
    public void onTwist() {
        Toast.makeText(this,"Twistin' the night away",Toast.LENGTH_LONG).show();
    }

//These functions won't be called until you subscribe to the appropriate gestures
//in a class that extends AbstractGestureClientActivity in a wear app.

    @Override
    public void onTiltX(float x) {
        throw new IllegalStateException("This function should not be called unless subscribed to TILT_X.");
    }

    @Override
    public void onTilt(float x, float y, float z) {
        throw new IllegalStateException("This function should not be called unless subscribed to TILT.");
    }

    @Override
    public void onWindowClosed() {
        Log.e("MainActivity", "This function should not be called unless windowed gesture detection is enabled.");
    }

}

