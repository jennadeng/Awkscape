package hackny.awkscape;

/**
 * Created by jennadeng on 2015-09-27.
 */
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.PowerManager.WakeLock;
import android.util.Log;
import android.widget.Toast;

import java.util.Timer;


/**
 * Created by Aditya on 12/14/2014.
 */
public class AlarmReceiver extends BroadcastReceiver
{

    @Override
    public void onReceive(Context context, Intent intent)
    {
        Log.e("SirKit","HELLO");
        Intent newIntent = new Intent(context,AlarmActivity.class);
        newIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        final Intent emptyIntent = new Intent();
//        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, emptyIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        //Context context1 = pendingIntent
        context.startActivity(newIntent);
        //Toast.makeText(context,"HEY",Toast.LENGTH_SHORT);
    }

}