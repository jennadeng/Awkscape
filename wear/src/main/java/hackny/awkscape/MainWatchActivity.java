package hackny.awkscape;

import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.wearable.view.BoxInsetLayout;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import watch.nudge.gesturelibrary.AbstractGestureClientActivity;
import watch.nudge.gesturelibrary.GestureConstants;

public class MainWatchActivity extends AbstractGestureClientActivity {

    private static final SimpleDateFormat AMBIENT_DATE_FORMAT =
            new SimpleDateFormat("HH:mm", Locale.US);

    private BoxInsetLayout mContainerView;
    private TextView mTextView;
    private TextView mClockView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_watch);
        setAmbientEnabled();
        setSubscribeWindowEvents(true);
        mContainerView = (BoxInsetLayout) findViewById(R.id.container);
        mTextView = (TextView) findViewById(R.id.text);
        mClockView = (TextView) findViewById(R.id.clock);
    }

    //Subscribe to gestures.

    @Override
    public ArrayList<GestureConstants.SubscriptionGesture> getGestureSubscpitionList() {
        ArrayList<GestureConstants.SubscriptionGesture> gestures = new ArrayList<GestureConstants.SubscriptionGesture>();
        gestures.add(GestureConstants.SubscriptionGesture.FLICK);
        gestures.add(GestureConstants.SubscriptionGesture.SNAP);
        gestures.add(GestureConstants.SubscriptionGesture.TWIST);
        return gestures;
    }

    //State whether your app will automatically deliver gesture events to the phone.

    @Override
    public boolean sendsGestureToPhone() {
        return true;
    }


    //Override these functions to make your app respond to gesture.

    @Override
    public void onSnap() {
        Vibrator vibration2 = (Vibrator)this.getSystemService(Context.VIBRATOR_SERVICE);
        vibration2.vibrate(5000);
        Toast.makeText(this,"Snap it up",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFlick() {
        Vibrator vibration3 = (Vibrator)this.getSystemService(Context.VIBRATOR_SERVICE);
        vibration3.vibrate(2500);
        Toast.makeText(this,"It's a flick!",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onTwist() {
        Vibrator vibration1 = (Vibrator)this.getSystemService(Context.VIBRATOR_SERVICE);
        vibration1.vibrate(200);
        Toast.makeText(this,"Just twist it",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onGestureWindowClosed() {
        //Toast.makeText(this,"Gesture window closed.", Toast.LENGTH_LONG).show();
    }

    //These functions won't be called until you subscribe to the appropriate gestures.
    @Override
    public void onTiltX(float v) {
        Toast.makeText(this,"TiltX", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onTilt(float v, float v1, float v2) {
        throw new IllegalStateException("This function should not be called unless subscribed to TILT.");
    }

    @Override
    public void onEnterAmbient(Bundle ambientDetails) {
        super.onEnterAmbient(ambientDetails);
        updateDisplay();
    }

    @Override
    public void onUpdateAmbient() {
        super.onUpdateAmbient();
        updateDisplay();
    }

    @Override
    public void onExitAmbient() {
        updateDisplay();
        super.onExitAmbient();
    }

    private void updateDisplay() {
        if (isAmbient()) {
            mContainerView.setBackgroundColor(getResources().getColor(android.R.color.black));
            mTextView.setTextColor(getResources().getColor(android.R.color.white));
            mClockView.setVisibility(View.VISIBLE);

            mClockView.setText(AMBIENT_DATE_FORMAT.format(new Date()));
        } else {
            mContainerView.setBackground(null);
            mTextView.setTextColor(getResources().getColor(android.R.color.black));
            mClockView.setVisibility(View.GONE);
        }
    }
}
