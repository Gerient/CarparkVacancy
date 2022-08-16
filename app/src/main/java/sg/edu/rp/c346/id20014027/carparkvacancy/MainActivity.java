package sg.edu.rp.c346.id20014027.carparkvacancy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {

    ListView lvVacancy;
    AsyncHttpClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvVacancy = findViewById(R.id.lv);
        client = new AsyncHttpClient();
    }
    @Override
    protected void onResume() {
        super.onResume();

        ArrayList<Carpark> alCarpark = new ArrayList<Carpark>();
        ArrayAdapter<Carpark> aaCarpark = new ArrayAdapter<Carpark>(this, android.R.layout.simple_list_item_1, alCarpark);
        lvVacancy.setAdapter(aaCarpark);

        client.get("https://api.data.gov.sg/v1/transport/carpark-availability", new JsonHttpResponseHandler() {

            String total_lots;
            String lot_type;
            String lots_available;

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                try {
                    JSONArray jsonArrItems = response.getJSONArray("items");
                    JSONObject firstObj = jsonArrItems.getJSONObject(0);
                    JSONArray jsonArrForecasts = firstObj.getJSONArray("carpark_info");
                    for(int i = 0; i < jsonArrForecasts.length(); i++) {
                        JSONObject jsonObjForecast = jsonArrForecasts.getJSONObject(i);
                        total_lots = jsonObjForecast.getString("total_lots");
                        lot_type = jsonObjForecast.getString("lot_type");
                        lots_available = jsonObjForecast.getString("lots_available");
                        Carpark carpark = new Carpark(total_lots, lot_type, lots_available);
                        alCarpark.add(carpark);
                    }
                }
                catch(JSONException e){

                }

                //POINT X – Code to display List View
                aaCarpark.notifyDataSetChanged();


            }//end onSuccess
        });
    }//end onResume

}