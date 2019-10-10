package com.example.ventas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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
        Retrofit retrofit =  new Retrofit.Builder()
                .baseUrl("http://172.23.8.161/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ServicioVentas servicioVentas = retrofit.create(ServicioVentas.class);//INterfaz
        Call<VentaDia> llamada = servicioVentas.obtenerVentaDia();
        llamada.enqueue(new Callback<VentaDia>() {
            @Override
            public void onResponse(Call<VentaDia> call, Response<VentaDia> response) {
                //ArrayAdapter<Pedidos> adapter =
                //      new ArrayAdapter<>(MainActivity.this,
                //            android.R.layout.simple_list_item_1, response.body().getPedidos());//adaptador por defecto y se lo pasamos al list view
            AdaptadorVentas adapter = new AdaptadorVentas(MainActivity.this,
                    R.layout.pedido_item,
                    response.body().getPedidos(),
                    response.body().getClientes());
                listView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<VentaDia> call, Throwable t) {

            }
        });
    }
}
