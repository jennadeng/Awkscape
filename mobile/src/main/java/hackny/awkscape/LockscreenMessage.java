package hackny.awkscape;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class LockscreenMessage extends AppCompatActivity {

    private Button transparentbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lockscreen_message);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Intent Lockscreenintent = getIntent();

        transparentbutton = (Button) findViewById(R.id.off2);
        transparentbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Unlockedscreen1 = new Intent(LockscreenMessage.this, UnlockedMessage.class);
                startActivity(Unlockedscreen1);
            }
        });

    }

}