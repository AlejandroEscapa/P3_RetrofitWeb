package es.master.p3_retrofitweb;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import es.master.p3_retrofitweb.API.API;
import es.master.p3_retrofitweb.API.APIService;
import es.master.p3_retrofitweb.databinding.ActivityHomeBinding;
import es.master.p3_retrofitweb.hotel.Hotel;
import es.master.p3_retrofitweb.hotel.HotelAdapter;
import es.master.p3_retrofitweb.hotel.HotelsList;
import es.master.p3_retrofitweb.usuario.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends AppCompatActivity {

    ActivityHomeBinding homeBinding;
    private APIService apiHotel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        homeBinding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(homeBinding.getRoot());

        recuperarUsuario();

        homeBinding.btnHoteles.setOnClickListener(view -> {
            apiHotel = API.getService();
            apiHotel.getHoteles().enqueue(new Callback<HotelsList>() {
                @Override
                public void onResponse(@NonNull Call<HotelsList> call, @NonNull Response<HotelsList> response) {
                    //Comprobamos que la respuesta es correcta
                    if (response.isSuccessful() && response.code() == 200) {
                        //Obtenemos la lista de hoteles
                        HotelsList hotelsList = response.body();
                        if (hotelsList != null) {
                            List<Hotel> hotels = hotelsList.getHotels();
                            hotels.forEach(hotel -> {
                                Log.d("depurando", hotel.thumbUrl.getImageURL());
                            });
                            //Mostramos la lista de hoteles en el RecyclerView
                            homeBinding.listHoteles.setAdapter(new HotelAdapter(hotels));
                        }
                    }
                }

                @Override
                public void onFailure(@NonNull Call<HotelsList> call, @NonNull Throwable t) {
                    Toast.makeText(HomeActivity.this, "Error: " + t.getMessage(),
                            Toast.LENGTH_SHORT).show();
                }
            });
        });
    }

    private void recuperarUsuario() {
        //Recuperamos el usuario de la actividad anterior
        Bundle bundleUsuario = getIntent().getExtras();
        if (bundleUsuario != null) {
            User user = bundleUsuario.getParcelable("Usuario", User.class);
            if (user != null) {
                Toast.makeText(HomeActivity.this, "Bienvenido " + user.getNombre(),
                        Toast.LENGTH_LONG).show();
            }
        }
    }
}