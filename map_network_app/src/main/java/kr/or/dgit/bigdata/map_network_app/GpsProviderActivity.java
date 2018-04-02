package kr.or.dgit.bigdata.map_network_app;

import android.location.Criteria;
import android.location.LocationManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class GpsProviderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gps_provider);

        LocationManager LocMan = (LocationManager) getSystemService(LOCATION_SERVICE);

        List<String> arProvider = LocMan.getAllProviders();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < arProvider.size(); i++){
            sb.append("Provider " + i + " : " + arProvider.get(i) + "\n");
        }

        Criteria crit = new Criteria();
        crit.setAccuracy(Criteria.NO_REQUIREMENT);
        crit.setPowerRequirement(Criteria.NO_REQUIREMENT);
        crit.setAltitudeRequired(false);
        crit.setCostAllowed(false);

        String best = LocMan.getBestProvider(crit, true);
        sb.append("\nbest provider : " + best + "\n\n");
        sb.append(LocationManager.GPS_PROVIDER + " : " +
            LocMan.isProviderEnabled(LocationManager.GPS_PROVIDER) + "\n");
        sb.append(LocationManager.PASSIVE_PROVIDER + " : " +
                LocMan.isProviderEnabled(LocationManager.GPS_PROVIDER) + "\n");
        sb.append(LocationManager.NETWORK_PROVIDER + " : " +
                LocMan.isProviderEnabled(LocationManager.NETWORK_PROVIDER) + "\n");

        TextView EditResult = (TextView) findViewById(R.id.result);
        EditResult.setText(sb.toString());

    }
}
