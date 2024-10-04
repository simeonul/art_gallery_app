package com.example.server.models;


import com.example.server.models.enums.ArtForm;

public class ArtPiece extends Prototype {
    private int id;
    private String title;
    private int artistId;
    private ArtForm artForm;
    private int year;
    private float price;
    private boolean isSold;

    public ArtPiece(int id, String title, int artistId, ArtForm artForm, int year, float price, boolean isSold) {
        this.id = id;
        this.title = title;
        this.artistId = artistId;
        this.artForm = artForm;
        this.year = year;
        this.price = price;
        this.isSold = isSold;
    }

    public ArtPiece(String title, int artistId, ArtForm artForm, int year, float price, boolean isSold) {
        this.title = title;
        this.artistId = artistId;
        this.artForm = artForm;
        this.year = year;
        this.price = price;
        this.isSold = isSold;
    }

    public ArtPiece() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getArtistId() {
        return artistId;
    }

    public void setArtistId(int artistId) {
        this.artistId = artistId;
    }

    public ArtForm getArtForm() {
        return artForm;
    }

    public void setArtForm(ArtForm artForm) {
        this.artForm = artForm;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public boolean isSold() {
        return isSold;
    }

    public void setSold(boolean sold) {
        isSold = sold;
    }

    @Override
    public String toString() {
        return "ArtPiece{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", artistId=" + artistId +
                ", artForm=" + artForm +
                ", year=" + year +
                ", price=" + price +
                ", isSold=" + isSold +
                '}';
    }

    public String toQueryString() {
        return "(" + "'" + title + "','" + artistId + "','" + artForm + "','" + year + "','" + price + "', " + isSold +")";
    }

    public String toUpdateQueryString() {
        return "title='" + title + "', artist_id=" + artistId + ", art_form='" + artForm +
                "', year=" + year + ", price=" + price + ", is_sold=" + isSold;
    }

    @Override
    public Prototype clone() {
        return new ArtPiece(this.title, this.artistId, this.artForm, this.year, this.price, this.isSold);
    }
}

