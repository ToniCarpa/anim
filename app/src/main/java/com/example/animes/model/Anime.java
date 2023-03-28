package com.example.animes.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class Anime implements Parcelable {
    private int id;
    private String name;
    private String description;
    private String type;
    private int year;
    private String image;
    private String image2;
    private String originalname;
    private String rating;
    private String demography;
    private String genre;
    private Boolean active;
    private String favoriteS;
    private String favorite;

    private List<Animevideos> animeVideos;

    public Anime() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImage2() {
        return image2;
    }

    public void setImage2(String image2) {
        this.image2 = image2;
    }

    public String getOriginalname() {
        return originalname;
    }

    public void setOriginalname(String originalname) {
        this.originalname = originalname;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getDemography() {
        return demography;
    }

    public void setDemography(String demography) {
        this.demography = demography;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getFavoriteS() {
        return favoriteS;
    }

    public void setFavoriteS(String favoriteS) {
        this.favoriteS = favoriteS;
    }

    public String getFavorite() {
        return favorite;
    }

    public void setFavorite(String favorite) {
        this.favorite = favorite;
    }

    public List<Animevideos> getAnimeVideos() {
        return animeVideos;
    }

    public void setAnimeVideos(List<Animevideos> animeVideos) {
        this.animeVideos = animeVideos;
    }

    protected Anime(Parcel in) {
        id = in.readInt();
        name = in.readString();
        description = in.readString();
        type = in.readString();
        year = in.readInt();
        image = in.readString();
        image2 = in.readString();
        originalname = in.readString();
        rating = in.readString();
        demography = in.readString();
        genre = in.readString();
        byte tmpActive = in.readByte();
        active = tmpActive == 0 ? null : tmpActive == 1;
        favoriteS = in.readString();
        favorite = in.readParcelable(Favorite.class.getClassLoader());
        animeVideos = in.createTypedArrayList(Animevideos.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeString(description);
        dest.writeString(type);
        dest.writeInt(year);
        dest.writeString(image);
        dest.writeString(image2);
        dest.writeString(originalname);
        dest.writeString(rating);
        dest.writeString(demography);
        dest.writeString(genre);
        dest.writeByte((byte) (active == null ? 0 : active ? 1 : 2));
        dest.writeString(favoriteS);
        dest.writeTypedList(animeVideos);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Anime> CREATOR = new Creator<Anime>() {
        @Override
        public Anime createFromParcel(Parcel in) {
            return new Anime(in);
        }

        @Override
        public Anime[] newArray(int size) {
            return new Anime[size];
        }
    };
}
