package com.example.nasa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nasa.models.Nasa;
import com.example.nasa.network.ApiClient;
import com.example.nasa.network.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
  static  ApiInterface apiInterface;
  TextView t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
t1=findViewById(R.id.text);
        apiInterface=ApiClient.getApiClient().create(ApiInterface.class);

        Call<Nasa> nasaCall=apiInterface.NASA_CALL("apod?api_key=NNKOjkoul8n1CH18TWA9gwngW1s1SmjESPjNoUFo");
nasaCall.enqueue(new Callback<Nasa>() {
    @Override
    public void onResponse(Call<Nasa> call, Response<Nasa> response) {
        if(response.isSuccessful()){
            t1.setText(response.body().getExplanation());
            Toast.makeText(MainActivity.this,response.body().getTitle(),Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onFailure(Call<Nasa> call, Throwable t) {

    }
});
    }
}
