package br.eti.urbano.mobile.exemploretrofit2.activities;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
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
    private final Context activity;

    public adapter(List<Post> posts, Context activity) {
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

          if (convertView == null) {
              convertView  = LayoutInflater.from(activity)
                      .inflate(R.layout.activity_list, parent, false);
          }
        Post post = posts.get(position);

        TextView usuarioId = (TextView) convertView.findViewById(R.id.lista_curso_personalizada_idUsu);
        TextView Id = (TextView) convertView.findViewById(R.id.lista_curso_personalizada_id);
        TextView title = (TextView) convertView.findViewById(R.id.lista_curso_personalizada_title);
        TextView body = (TextView) convertView.findViewById(R.id.lista_curso_personalizada_body);

        usuarioId.setText(post.getUserId());
        Id.setText(post.getId());
        title.setText(post.getTitle());
        body.setText(post.getBody());

        return convertView;
    }
}
