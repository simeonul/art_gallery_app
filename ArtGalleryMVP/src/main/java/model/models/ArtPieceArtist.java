package model.models;

import model.models.enums.ArtForm;

public class ArtPieceArtist {
    private int id;
    private String title;
    private int artistId;
    private String artistName;
    private ArtForm artForm;
    private int year;
    private float price;

    public ArtPieceArtist(int id, String title, int artistId, String artistName, ArtForm artForm, int year, float price) {
        this.id = id;
        this.title = title;
        this.artistId = artistId;
        this.artistName = artistName;
        this.artForm = artForm;
        this.year = year;
        this.price = price;
    }

    public ArtPieceArtist(){
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

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
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

    public int getArtistId() {
        return artistId;
    }

    public void setArtistId(int artistId) {
        this.artistId = artistId;
    }

    @Override
    public String toString() {
        return "ArtPieceArtist{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", artistName='" + artistName + '\'' +
                ", artForm=" + artForm +
                ", year=" + year +
                ", price=" + price +
                '}';
    }
}
