package samples.com.flurrydemo;


import android.app.Application;

import com.flurry.android.FlurryAgent;

/**
 * Created by raul on 12/11/2016.
 */

public class DemoApplication extends Application {
    public void onCreate() {
        super.onCreate();
        // configure Flurry
        FlurryAgent.setLogEnabled(true);
        //set log events
        FlurryAgent.setLogEvents(true);
        // init Flurry API_KEY: HP56VH8K5BSYN2XXRTFQ
        FlurryAgent.init(this, "HP56VH8K5BSYN2XXRTFQ");
    }
}
