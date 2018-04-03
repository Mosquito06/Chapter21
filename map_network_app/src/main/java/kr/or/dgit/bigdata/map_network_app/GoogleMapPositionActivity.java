package kr.or.dgit.bigdata.map_network_app;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class GoogleMapPositionActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google_map_position);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        UiSettings settings = mMap.getUiSettings();
        settings.setAllGesturesEnabled(true);
        settings.setCompassEnabled(true);
        settings.setZoomControlsEnabled(true);
        settings.setMapToolbarEnabled(true);
    }

    public void mOnClick(View view) {
        String title = ((TextView)view).getText().toString();
        switch (view.getId()){
            case R.id. btnLotte :
                setMapPosition(35.875966, 128.596181, 14, title, "롯데 백화점입니다.");
                break;
            case R.id. btnPost :
                setMapPosition(35.850705,128.590947, 14, title, "여기는 남대구 우체국");
                break;
            case R.id. btnDgit :
                setMapPosition(35.852975, 128.590899, 16, title, "우리가 공부하는 곳");
                break;
            case R.id. btnHyundai :
                setMapPosition(35.866710, 128.590581, 14, title, "현대 백화점 입니다.");
                break;
        }
    }

    private void setMapPosition(double lat, double lng, int zlevel, String title, String description) {
        LatLng pt = new LatLng(lat, lng);
        CameraPosition cp = new CameraPosition.Builder().target(pt).zoom(zlevel).build();
        mMap.animateCamera(CameraUpdateFactory. newCameraPosition (cp));
        MarkerOptions marker = new MarkerOptions().position(pt).title(title).snippet(description);
        mMap.addMarker(marker);
    }
}
