package com.example.server.services;

import com.example.server.models.ArtPiece;
import com.example.server.models.ArtPieceArtist;
import com.example.server.models.Artist;
import com.example.server.repositories.ArtPieceRepository;
import com.example.server.repositories.ArtistRepository;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;


@Component
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

    public List<ArtPieceArtist> filterArtPieceArtist(HashMap<String, String> filters) {
        List<ArtPieceArtist> artPieceArtistList = getAllArtPieceArtist();
        if (filters.containsKey("artist")) {
            artPieceArtistList = artPieceArtistList.stream()
                    .filter(e -> e.getArtistName().toLowerCase().contains(filters.get("artist").toLowerCase()))
                    .collect(Collectors.toList());
        }
        if (filters.containsKey("form")) {
            artPieceArtistList = artPieceArtistList.stream()
                    .filter(e -> e.getArtForm().toString().toLowerCase().contains(filters.get("form").toLowerCase()))
                    .collect(Collectors.toList());
        }
        if (filters.containsKey("title")) {
            artPieceArtistList = artPieceArtistList.stream()
                    .filter(e -> e.getTitle().toLowerCase().contains(filters.get("title").toLowerCase()))
                    .collect(Collectors.toList());
        }
        return artPieceArtistList;
    }

    public List<ArtPieceArtist> filterNotSoldArtPieceArtist(Map<String, String> filters) {
        List<ArtPieceArtist> artPieceArtistList = getNotSoldArtPieceArtist();
        if (filters.containsKey("artist")) {
            artPieceArtistList = artPieceArtistList.stream()
                    .filter(e -> e.getArtistName().toLowerCase().contains(filters.get("artist").toLowerCase()))
                    .collect(Collectors.toList());
        }
        if (filters.containsKey("form")) {
            artPieceArtistList = artPieceArtistList.stream()
                    .filter(e -> e.getArtForm().toString().toLowerCase().contains(filters.get("form").toLowerCase()))
                    .collect(Collectors.toList());
        }
        if (filters.containsKey("title")) {
            artPieceArtistList = artPieceArtistList.stream()
                    .filter(e -> e.getTitle().toLowerCase().contains(filters.get("title").toLowerCase()))
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
        ArtPiece sold = (ArtPiece) notSold.clone();
        sold.setSold(true);
        updateArtPiece(id, sold);
    }
}
