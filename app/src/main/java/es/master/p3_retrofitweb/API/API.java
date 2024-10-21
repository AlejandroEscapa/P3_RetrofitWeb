package es.master.p3_retrofitweb.API;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class API {

    // URL base de la API
    private static final String BASE_URL = "https://01394d44-8918-4a1d-8059-629c50c25e87.mock.pstmn.io/";

    // Instancia única de Retrofit
    private static volatile Retrofit retrofitInstance = null;

    // Instancia única del servicio API
    private static APIService apiService = null;

    // Método para obtener la instancia de Retrofit (Singleton)
    private static Retrofit getRetrofit(String url) {
        if (retrofitInstance == null) {
            synchronized (API.class) { // Bloque synchronized
                if (retrofitInstance == null) { // Verificación doble para evitar instanciación múltiple
                    retrofitInstance = new Retrofit.Builder()
                            .baseUrl(url)
                            .addConverterFactory(GsonConverterFactory.create()) // Conversor JSON a POJO
                            .build();
                }
            }
        }
        return retrofitInstance;
    }

    // Método para obtener la instancia del servicio API
    public static APIService getService() {
        if (apiService == null) {
            apiService = getRetrofit(BASE_URL).create(APIService.class);
        }
        return apiService;
    }

    // Constructor privado para prevenir la creación directa de objetos
    private API() {}
}
