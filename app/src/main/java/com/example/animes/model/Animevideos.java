package com.example.animes.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Animevideos implements Parcelable {
    private int id;
    private String episode;
    private String url;
    private String image;

    public Animevideos() {
    }

    protected Animevideos(Parcel in) {
        id = in.readInt();
        episode = in.readString();
        url = in.readString();
        image = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(episode);
        dest.writeString(url);
        dest.writeString(image);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Animevideos> CREATOR = new Creator<Animevideos>() {
        @Override
        public Animevideos createFromParcel(Parcel in) {
            return new Animevideos(in);
        }

        @Override
        public Animevideos[] newArray(int size) {
            return new Animevideos[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEpisode() {
        return episode;
    }

    public void setEpisode(String episode) {
        this.episode = episode;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
