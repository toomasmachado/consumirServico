package br.eti.urbano.mobile.exemploretrofit2.resource;

import java.util.List;

import br.eti.urbano.mobile.exemploretrofit2.model.Post;
import retrofit2.Call;
import retrofit2.http.GET;

public interface PostResource {

    @GET("/posts")
    Call<List<Post>> get();

    @GET("/posts/{id}")
    Call<List<Post>> get(Integer id);
}