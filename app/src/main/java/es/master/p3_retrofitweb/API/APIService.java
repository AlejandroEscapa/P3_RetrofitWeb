package es.master.p3_retrofitweb.API;

import es.master.p3_retrofitweb.hotel.HotelsList;
import es.master.p3_retrofitweb.usuario.User;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface APIService {

    @POST("login")
    Call<User> conectarUsuario(@Query("usuario") String user
            , @Query("password") String pass);

    @GET("listHotels")
    Call<HotelsList> getHoteles();
}
