package hackny.awkscape;

import hackny.awkscape.MainActivity;
import watch.nudge.phonegesturelibrary.AppLaunchReceiverService;

/*
* GestureReceiverService
*
* Service which launches the mobile app when the wear app is launched.
 */

public class GestureReceiverService extends AppLaunchReceiverService {
    public GestureReceiverService() {
    }

    @Override
    protected Class getPhoneActivityClass() {
        return MainActivity.class;
    }

}