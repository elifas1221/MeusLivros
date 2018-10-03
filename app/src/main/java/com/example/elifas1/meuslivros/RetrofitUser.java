package com.example.elifas1.meuslivros;

import com.example.elifas1.meuslivros.Models.Usuario;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface RetrofitUser {
    @FormUrlEncoded
    @POST("api/usuarios")

    Call<Usuario> cadastrarUsuario(
                                   @Field("nome") String nome,
                                   @Field("login") String login,
                                   @Field("senha") String senha);
}
