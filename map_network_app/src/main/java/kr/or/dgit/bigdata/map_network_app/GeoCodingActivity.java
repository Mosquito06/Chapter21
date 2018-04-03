package kr.or.dgit.bigdata.map_network_app;

import android.location.Address;
import android.location.Geocoder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;
import java.util.List;

public class GeoCodingActivity extends AppCompatActivity {
    private Geocoder mCoder;
    private TextView mResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geo_coding);

        mResult = (TextView) findViewById(R.id.result);
        mCoder = new Geocoder(this);

    }

    public void mConvertLocToAddr(View view) {
        List<Address> addr;
        String slat = ((EditText) findViewById(R.id.lat)).getText().toString();
        String slon = ((EditText) findViewById(R.id.lon)).getText().toString();

        try{
            addr = mCoder.getFromLocation(Double.parseDouble(slat), Double.parseDouble(slon), 5);

        }catch(IOException e){
            mResult.setText("IO error : " + e.getMessage());
            return;
        }

        if(addr == null){
            mResult.setText("no result");
            return;
        }

        mResult.setText("개수 = " + addr.size() + "\n" + addr.get(0).toString());
    }

    public void mConvertAddrToLoc(View view) {
        List<Address> addr;
        String saddr = ((EditText) findViewById(R.id.address)).getText().toString();

        try{
            addr = mCoder.getFromLocationName(saddr, 5);

        }catch(IOException e){
            mResult.setText("IO error : " + e.getMessage());
            return;
        }

        if(addr == null){
            mResult.setText("no result");
            return;
        }

        mResult.setText("개수 = " + addr.size() + "\n" + addr.get(0).toString());

    }
}
