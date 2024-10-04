package com.example.server.controllers;


import com.example.server.facades.ArtPieceArtistFacade;
import com.example.server.models.ArtPiece;
import com.example.server.models.ArtPieceArtist;
import com.example.server.models.Artist;
import com.example.server.models.Users;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/artgallery/artpiece")
@RestController
public class ArtPieceArtistController {

    private final ArtPieceArtistFacade artPieceArtistFacade;


    public ArtPieceArtistController(ArtPieceArtistFacade artPieceArtistFacade) {
        this.artPieceArtistFacade = artPieceArtistFacade;
    }

    @GetMapping
    public ResponseEntity<List<ArtPieceArtist>> getAllArtPieceArtist() {
        return new ResponseEntity<>(artPieceArtistFacade.getAllArtPieceArtist(), HttpStatus.OK);
    }

    @GetMapping("/not-sold")
    public ResponseEntity<List<ArtPieceArtist>> getNotSoldArtPieceArtist() {
        return new ResponseEntity<>(artPieceArtistFacade.getNotSoldPieceArtist(), HttpStatus.OK);
    }

    @PostMapping("/filter")
    public ResponseEntity<List<ArtPieceArtist>> filterArtPieceArtist(@RequestParam HashMap<String, String> filters) {
        return new ResponseEntity<>(artPieceArtistFacade.filterArtPieceArtist(filters), HttpStatus.OK);
    }

    @PostMapping("/not-sold/filter")
    public ResponseEntity<List<ArtPieceArtist>> filterNotSoldArtPieceArtist(@RequestParam Map<String, String> filters) {
        return new ResponseEntity<>(artPieceArtistFacade.filterNotSoldArtPieceArtist(filters), HttpStatus.OK);
    }

    @GetMapping("/sort")
    public ResponseEntity<List<ArtPieceArtist>> sortArtPieceArtist() {
        return new ResponseEntity<>(artPieceArtistFacade.sortArtPieceArtist(), HttpStatus.OK);
    }

    @GetMapping("/not-sold/sort")
    public ResponseEntity<List<ArtPieceArtist>> sortNotSoldArtPieceArtist() {
        return new ResponseEntity<>(artPieceArtistFacade.sortNotSoldArtPieceArtist(), HttpStatus.OK);
    }

    @GetMapping("/artist")
    public ResponseEntity<List<Artist>> getAllArtist() {
        return new ResponseEntity<>(artPieceArtistFacade.getAllArtists(), HttpStatus.OK);
    }

    @PostMapping("/artist")
    public ResponseEntity addArtist(@RequestBody Artist artist) {
        artPieceArtistFacade.addArtist(artist);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/artist/{id}")
    public ResponseEntity updateArtist(@PathVariable int id, @RequestBody Artist artist) {
        artPieceArtistFacade.updateArtist(id, artist);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/artist/{id}")
    public ResponseEntity deleteArtist(@PathVariable int id) {
        artPieceArtistFacade.deleteArtist(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity addArtPiece(@RequestBody ArtPiece artPiece) {
        artPieceArtistFacade.addArtPiece(artPiece);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateArtPiece(@PathVariable int id, @RequestBody ArtPiece artPiece) {
        artPieceArtistFacade.updateArtPiece(id, artPiece);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteArtPiece(@PathVariable int id) {
        artPieceArtistFacade.deleteArtPiece(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("sell/{id}")
    public ResponseEntity sellArtPiece(@PathVariable int id) {
        artPieceArtistFacade.sellArtPiece(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @GetMapping("/export/{type}")
    public ResponseEntity<String> export(@PathVariable String type) {
        artPieceArtistFacade.export(type);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
