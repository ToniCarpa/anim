/*
package com.example.animes.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.animejson.R;
import com.example.animejson.model.Animevideos;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.util.List;

public class AdapterVideo extends RecyclerView.Adapter<AdapterVideo.VideoViewHolder> {
    private Context context;
    private List<Animevideos> animes;

    public AdapterVideo(Context context, List<Animevideos> animes) {
        this.context = context;
        this.animes = animes;
    }


    @NonNull
    @Override
    public VideoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.row_video, parent, false);
        return new VideoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VideoViewHolder holder, int position) {
        holder.textView.setText(animes.get(position).getEpisode());
        WebView webView = new WebView(context);
        for (Animevideos a : animes) {
            Picasso.get()
                    .load(a.getUrl())
                    .fit()
                    .centerCrop()
                    .into((Target) webView);
        }
    }

    @Override
    public int getItemCount() {
        return animes.size();
    }

    public class VideoViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        WebView webView;
        ConstraintLayout constraintLayout;

        public VideoViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.rowVideoTitTxt);
            webView = itemView.findViewById(R.id.webView2);
        }
    }
}
*/
