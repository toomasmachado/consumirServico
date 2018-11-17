package br.eti.urbano.mobile.exemploretrofit2.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.List;

import br.eti.urbano.mobile.exemploretrofit2.R;
import br.eti.urbano.mobile.exemploretrofit2.boostrap.APIClient;
import br.eti.urbano.mobile.exemploretrofit2.model.Post;
import br.eti.urbano.mobile.exemploretrofit2.resource.PostResource;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class PostActivity extends AppCompatActivity {

    private ListView listPost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);


        /*Pega a referencia do ENDPOINT e do converter(gson)
        * */
        Retrofit retrofit = APIClient.getClient();

        //Faz o 'bind' da instância do retrofit com interface
        //que contém as operações (GET,POST,PUT,DELETE)
        PostResource postResource = retrofit.create(PostResource.class);

        //Faz a chamada do serviço
        Call<List<Post>> get = postResource.get();

        get.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                //Se deu certo executa este método
                List<Post> posts = response.body();
                posts.forEach(p-> Log.i  ("fasam",p.toString()));
                posts.addAll(response.body());

                //ArrayAdapter<Post> adapter = new ArrayAdapter<Post>(getApplicationContext(), android.R.layout.simple_list_item_1 , posts);
                //ListView lv = listPost;
                //lv.setAdapter(adapter);
                adapter adapter = new adapter(posts, PostActivity.this);

                ListView listView = findViewById(R.id.listPost);
                listView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                //Houve erro é executado este método.
            }
        });



    }
}
