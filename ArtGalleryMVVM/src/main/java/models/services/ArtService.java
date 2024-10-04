package models.services;


import models.model.ArtPiece;
import models.model.ArtPieceArtist;
import models.model.Artist;
import models.repositories.ArtPieceRepository;
import models.repositories.ArtistRepository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ArtService {
    private ArtPieceRepository artPieceRepository;
    private ArtistRepository artistRepository;
    private List<ArtPiece> artPieceList;

    public ArtService() {
        this.artPieceRepository = new ArtPieceRepository();
        this.artistRepository = new ArtistRepository();
    }

    public List<ArtPieceArtist> getAllArtPieceArtist() {
        List<ArtPieceArtist> artPieceArtistList = new ArrayList<>();
        this.artPieceList = artPieceRepository.getAllArtPieces();
        for (ArtPiece artPiece : this.artPieceList) {
            Artist artist = artistRepository.getArtistById(artPiece.getArtistId()).get();
            artPieceArtistList.add(new ArtPieceArtist(artPiece.getId(), artPiece.getTitle(), artPiece.getArtistId(), artist.getName(),
                    artPiece.getArtForm(), artPiece.getYear(), artPiece.getPrice(), artPiece.isSold()));
        }
        return artPieceArtistList;
    }

    public List<ArtPieceArtist> getAllArtPieceArtist(List<ArtPiece> artPieces) {
        List<ArtPieceArtist> artPieceArtistList = new ArrayList<>();
        for (ArtPiece artPiece : artPieces) {
            Artist artist = artistRepository.getArtistById(artPiece.getArtistId()).get();
            artPieceArtistList.add(new ArtPieceArtist(artPiece.getId(), artPiece.getTitle(), artist.getId(), artist.getName(),
                    artPiece.getArtForm(), artPiece.getYear(), artPiece.getPrice(), artPiece.isSold()));
        }
        return artPieceArtistList;
    }

    public List<ArtPieceArtist> getNotSoldArtPieceArtist() {
        List<ArtPieceArtist> artPieceArtistList = getAllArtPieceArtist().stream().
                filter(artPieceArtist -> !artPieceArtist.isSold()).collect(Collectors.toList());
        return artPieceArtistList;
    }

    public List<ArtPieceArtist> sortArtPieceArtistByYear() {
        List<ArtPieceArtist> artPieceArtistList = getAllArtPieceArtist().stream()
                .sorted(Comparator.comparingInt(ArtPieceArtist::getYear))
                .collect(Collectors.toList());
        return artPieceArtistList;
    }

    public List<ArtPieceArtist> sortNotSoldArtPieceArtistByYear() {
        List<ArtPieceArtist> artPieceArtistList = getNotSoldArtPieceArtist().stream()
                .sorted(Comparator.comparingInt(ArtPieceArtist::getYear))
                .collect(Collectors.toList());
        return artPieceArtistList;
    }

    public List<ArtPieceArtist> filterArtPieceArtistByArtistForm(String artist, String form) {
        List<ArtPieceArtist> artPieceArtistList = getAllArtPieceArtist();
        if (!artist.equals("")) {
            artPieceArtistList = artPieceArtistList.stream()
                    .filter(e -> e.getArtistName().toLowerCase().contains(artist.toLowerCase()))
                    .collect(Collectors.toList());
        }
        if (!form.equals("")) {
            artPieceArtistList = artPieceArtistList.stream()
                    .filter(e -> e.getArtForm().toString().toLowerCase().contains(form.toLowerCase()))
                    .collect(Collectors.toList());
        }
        return artPieceArtistList;
    }

    public List<ArtPieceArtist> filterNotSoldArtPieceArtistByArtistForm(String artist, String form) {
        List<ArtPieceArtist> artPieceArtistList = getNotSoldArtPieceArtist();
        if (!artist.equals("")) {
            artPieceArtistList = artPieceArtistList.stream()
                    .filter(e -> e.getArtistName().toLowerCase().contains(artist.toLowerCase()))
                    .collect(Collectors.toList());
        }
        if (!form.equals("")) {
            artPieceArtistList = artPieceArtistList.stream()
                    .filter(e -> e.getArtForm().toString().toLowerCase().contains(form.toLowerCase()))
                    .collect(Collectors.toList());
        }
        return artPieceArtistList;
    }

    public List<ArtPieceArtist> searchArtPieceArtistByTitle(String title) {
        List<ArtPieceArtist> artPieceArtistList = getAllArtPieceArtist();
        if (!title.equals("")) {
            artPieceArtistList = artPieceArtistList.stream()
                    .filter(e -> e.getTitle().toLowerCase().contains(title.toLowerCase()))
                    .collect(Collectors.toList());
        }
        return artPieceArtistList;
    }

    public List<ArtPieceArtist> searchNotSoldArtPieceArtistByTitle(String title) {
        List<ArtPieceArtist> artPieceArtistList = getNotSoldArtPieceArtist();
        if (!title.equals("")) {
            artPieceArtistList = artPieceArtistList.stream()
                    .filter(e -> e.getTitle().toLowerCase().contains(title.toLowerCase()))
                    .collect(Collectors.toList());
        }
        return artPieceArtistList;
    }

    public List<Artist> getAllArtists() {
        return artistRepository.getAllArtists();
    }

    public void addArtist(Artist artist) {
        artistRepository.addArtist(artist);
    }

    public void deleteArtist(int id) {
        artistRepository.deleteArtist(id);
    }

    public void updateArtist(int id, Artist updatedArtist) {
        artistRepository.updateArtist(id, updatedArtist);
    }

    public void addArtPiece(ArtPiece artPiece) {
        artPieceRepository.addArtPiece(artPiece);
    }

    public void deleteArtPiece(int id) {
        artPieceRepository.deleteArtPiece(id);
    }

    public void updateArtPiece(int id, ArtPiece updatedArtPiece) {
        artPieceRepository.updateArtPiece(id, updatedArtPiece);
    }

    public void sellArtPiece(int id) {
        ArtPiece notSold = artPieceRepository.getArtPieceById(id).get();
        ArtPiece sold = new ArtPiece(notSold.getTitle(), notSold.getArtistId(), notSold.getArtForm(), notSold.getYear(), notSold.getPrice(), true);
        updateArtPiece(id, sold);
    }
}
