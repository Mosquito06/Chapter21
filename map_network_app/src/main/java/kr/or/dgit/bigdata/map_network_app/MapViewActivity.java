package kr.or.dgit.bigdata.map_network_app;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MapViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_view);
    }

    public void mViewLocation(View view) {
        double latitude = 5.853131;
        double longtitude = 128.5916963;
        String pos = String.format("geo:%f,%f?z = 18", latitude, longtitude);
        Uri uri = Uri.parse(pos);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);


    }
}
