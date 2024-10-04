package com.example.server.facades;

import com.example.server.models.ArtPiece;
import com.example.server.models.ArtPieceArtist;
import com.example.server.models.Artist;
import com.example.server.services.ArtService;
import com.example.server.services.ExportService;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ArtPieceArtistFacade {

    private ArtService artService;
    private ExportService exportService;

    public ArtPieceArtistFacade(ArtService artService, ExportService exportService) {
        this.artService = artService;
        this.exportService = exportService;
    }


    public List<ArtPieceArtist> getAllArtPieceArtist() {
        return artService.getAllArtPieceArtist();
    }

    public List<ArtPieceArtist> getNotSoldPieceArtist() {
        return artService.getNotSoldArtPieceArtist();
    }

    public List<ArtPieceArtist> filterArtPieceArtist(HashMap<String, String> filters) {
        return artService.filterArtPieceArtist(filters);
    }

    public List<ArtPieceArtist> filterNotSoldArtPieceArtist(Map<String, String> filters) {
        return artService.filterNotSoldArtPieceArtist(filters);
    }

    public List<ArtPieceArtist> sortNotSoldArtPieceArtist() {
        return artService.sortNotSoldArtPieceArtistByYear();
    }

    public List<Artist> getAllArtists() {
        return artService.getAllArtists();
    }

    public void addArtist(Artist artist) {
        artService.addArtist(artist);
    }

    public void deleteArtist(int id) {
        artService.deleteArtist(id);
    }

    public void updateArtist(int id, Artist updatedArtist) {
        artService.updateArtist(id, updatedArtist);
    }

    public void addArtPiece(ArtPiece artPiece) {
        artService.addArtPiece(artPiece);
    }

    public void deleteArtPiece(int id) {
        artService.deleteArtPiece(id);
    }

    public void updateArtPiece(int id, ArtPiece updatedArtPiece) {
        artService.updateArtPiece(id, updatedArtPiece);
    }

    public void sellArtPiece(int id) {
        artService.sellArtPiece(id);
    }

    public List<ArtPieceArtist> sortArtPieceArtist() {
        return artService.sortArtPieceArtistByYear();
    }

    public void export(String type) {
        if (type.equalsIgnoreCase("XML")) {
            exportService.writeToXml();
        } else if (type.equalsIgnoreCase("TXT")) {
            exportService.writeToTxt();
        } else if (type.equalsIgnoreCase("JSON")) {
            exportService.writeToJson();
        } else if (type.equalsIgnoreCase("CSV")) {
            exportService.writeToCsv();
        }
    }
}
