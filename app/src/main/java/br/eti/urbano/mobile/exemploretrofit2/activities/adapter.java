package br.eti.urbano.mobile.exemploretrofit2.activities;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import br.eti.urbano.mobile.exemploretrofit2.R;
import br.eti.urbano.mobile.exemploretrofit2.model.Post;
import retrofit2.Callback;

public class adapter extends BaseAdapter {

    private final List<Post> posts;
    private final Activity activity;

    public adapter(List<Post> posts, Activity activity) {
        this.posts = posts;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return posts.size();
    }

    @Override
    public Object getItem(int position) {
        return posts.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = activity.getLayoutInflater()
                .inflate(R.layout.activity_post, parent, false);
        Post post = posts.get(position);

        TextView usuarioId = (TextView) view.findViewById(R.id.lista_curso_personalizada_idUsu);
        TextView Id = (TextView) view.findViewById(R.id.lista_curso_personalizada_id);
        TextView title = (TextView) view.findViewById(R.id.lista_curso_personalizada_title);
        TextView body = (TextView) view.findViewById(R.id.lista_curso_personalizada_body);

        usuarioId.setText(post.getUserId());
        Id.setText(post.getId());
        title.setText(post.getTitle());
        body.setText(post.getBody());

        return view;
    }
}
