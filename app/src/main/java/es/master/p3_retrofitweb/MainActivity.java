package es.master.p3_retrofitweb;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.security.Permission;

import es.master.p3_retrofitweb.databinding.ActivityMainBinding;
import es.master.p3_retrofitweb.API.API;
import es.master.p3_retrofitweb.API.APIService;
import es.master.p3_retrofitweb.usuario.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding mainBinding;
    private APIService apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mainBinding.getRoot());

        mainBinding.btnLogin.setOnClickListener(view -> {

            String user = mainBinding.etName.getText().toString();
            String pass = mainBinding.etPass.getText().toString();

            //Comprobamos que los campos no estén vacíos
            if (user.isEmpty() || pass.isEmpty()) {
                Toast.makeText(MainActivity.this, "Primero rellena todos los campos.",
                        Toast.LENGTH_SHORT).show();
            } else {
                //Llamamos al servicio de Retrofit
                apiService = API.getService();
                //Realizamos la llamada a la API
                apiService.conectarUsuario(user, pass).enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(@NonNull Call<User> call, @NonNull Response<User> response) {
                        if (response.isSuccessful() && response.code() == 200) {
                            User user = response.body();
                            if (user != null) {
                                Log.d("TAG", "onResponse: " + user);
                                abrirHome(user);
                            }
                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<User> call, @NonNull Throwable t) {
                        Toast.makeText(MainActivity.this, "Error: " + t.getMessage(),
                                Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

    private void abrirHome(User user) {
        //Creo el intent y le paso el usuario
        Intent intent = new Intent(MainActivity.this, HomeActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable("Usuario", user);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
