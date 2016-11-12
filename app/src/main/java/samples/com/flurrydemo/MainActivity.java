package samples.com.flurrydemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.flurry.android.FlurryAgent;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        FlurryAgent.onStartSession(this, "HP56VH8K5BSYN2XXRTFQ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        FlurryAgent.onEndSession(this);
    }

    public void doMagic(View view) {
        FlurryAgent.onEvent("click button: doMagic");
        // Capture author info & user status
        Map<String, String> articleParams = new HashMap<String, String>();

//param keys and values have to be of String type
        articleParams.put("Author", "John Q");
        articleParams.put("User_Status", "Registered");

//up to 10 params can be logged with each event
        FlurryAgent.logEvent("Article_Read", articleParams);
        simulateCrashEvent();
    }

    private String m_strName = null;
    public void simulateCrashEvent(){
        try {
            m_strName.concat("This will result in null pointer exception");
        }catch(Exception ex){
            ex.printStackTrace();
            FlurryAgent.onError("error", "Error occurred on click of button", ex);
        }
        FlurryAgent.logEvent("print button clicked: simulateCrashEvent");
    }
}
