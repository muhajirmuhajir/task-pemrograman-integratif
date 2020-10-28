package com.example.latihan2;

import com.example.latihan2.models.Mahasiswa;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public interface ApiService {

    @GET("index.php")
    Call<ArrayList<Mahasiswa>> getAllMahasiswa();

    class Api {
        private static final String BASE_URL = "http://10.0.2.2:3000/";

        public static ApiService getService() {
            return getRetrofitClient().create(ApiService.class);
        }

        public static Retrofit getRetrofitClient() {
            return new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
    }
}
