/*
package com.example.animes.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.animejson.model.Animevideos;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.util.List;

public class AdapterRowVideo extends PagerAdapter {
    Context context;
    List<Animevideos> listVideo;

    public AdapterRowVideo(Context context, List<Animevideos> listVideo) {
        this.context = context;
        this.listVideo = listVideo;
    }

    @Override
    public int getCount() {
        return listVideo.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        WebView webView = new WebView(context);
        for (Animevideos a : listVideo) {
            Picasso.get()
                    .load(a.getUrl())
                    .fit()
                    .centerCrop()
                    .into((Target) webView);
            container.addView(webView, 0);
        }
        return webView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((WebView) object);
    }
}
*/
