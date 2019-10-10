package com.example.ventas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.lista_pedidos);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://172.23.8.85/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ServicioVentas servicioVentas = retrofit.create(ServicioVentas.class);
        Call<VentaDia> llamada = servicioVentas.obtenerVentaDia();
        llamada.enqueue(new Callback<VentaDia>() {
            @Override
            public void onResponse(Call<VentaDia> call, Response<VentaDia> response) {
               // ArrayAdapter<Pedidos> adapter=
               //         new ArrayAdapter<>(MainActivity.this,
               //                 android.R.layout.simple_list_item_1, response.body().getPedidos());
                AdaptadorVentas adapter = new AdaptadorVentas(
                        MainActivity.this,
                        R.layout.pedido_item,
                        response.body().getPedidos(),
                        response.body().getClientes());
                listView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<VentaDia> call, Throwable t) {
                Log.e("ErrorServicio", t.toString());
            }
        });

    }
}
