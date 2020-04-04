package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void fetchApi(View view) {
        RequestQueue queue = Volley.newRequestQueue(this);
        final TextView textView = (TextView) findViewById(R.id.response);
        final EditText site  = (EditText) findViewById(R.id.site);
        String url = String.valueOf(site.getText());
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        textView.setText(""+ response.substring(0,1000));
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                textView.setText("Error");
            }
        });

// Add the request to the RequestQueue.
        queue.add(stringRequest);

    }
}
