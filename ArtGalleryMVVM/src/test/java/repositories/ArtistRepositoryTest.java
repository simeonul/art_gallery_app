package repositories;

import models.model.Artist;
import models.repositories.ArtistRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;


class ArtistRepositoryTest {

    @Test
    void testAddArtist(){
        ArtistRepository artistRepository = new ArtistRepository();
        Artist artist = new Artist("M",  1475,  "italian");
        artistRepository.addArtist(artist);
        Optional<Artist> foundArtist =  artistRepository.getArtistById(1);
        Assertions.assertTrue(foundArtist.get().getName().equals("M"));
    }

    @Test
    void testUpdateArtist(){
        ArtistRepository artistRepository = new ArtistRepository();
        Artist updatedArtist = new Artist("Michelangelo", 1475,  "italian");
        Optional<Artist> foundArtist =  artistRepository.getArtistById(1);
        artistRepository.updateArtist(foundArtist.get().getId(), updatedArtist);
        Optional<Artist> querried =  artistRepository.getArtistById(1);
        Assertions.assertTrue(querried.get().getName().equals("Michelangelo"));
    }

    @Test
    void testGetAllArtist(){
        ArtistRepository artistRepository = new ArtistRepository();
        Artist artist1 = new Artist("1", 1, "1");
        Artist artist2 = new Artist("1", 1, "1");
        Artist artist3 = new Artist("1", 1, "1");
        artistRepository.addArtist(artist1);
        artistRepository.addArtist(artist2);
        artistRepository.addArtist(artist3);
        List<Artist> artists = artistRepository.getAllArtists();
        Assertions.assertEquals(artists.size(), 4);
        artistRepository.deleteArtist(2);
        artistRepository.deleteArtist(3);
        artistRepository.deleteArtist(4);
    }


}