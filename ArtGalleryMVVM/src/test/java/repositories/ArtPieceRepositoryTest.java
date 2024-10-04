package repositories;

import models.model.ArtPiece;
import models.model.enums.ArtForm;
import models.repositories.ArtPieceRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

class ArtPieceRepositoryTest {
    @Test
    void testAddArtPiece(){
        ArtPieceRepository artPieceRepository = new ArtPieceRepository();
        ArtPiece artPiece = new ArtPiece("M",  1, ArtForm.PAINTING, 1512, 2300000, false);
        artPieceRepository.addArtPiece(artPiece);
        Optional<ArtPiece> foundArtPiece = artPieceRepository.getArtPieceById(1);
        Assertions.assertTrue(foundArtPiece.get().getTitle().equals("M"));
    }

    @Test
    void testUpdateArtPiece(){
        ArtPieceRepository artPieceRepository = new ArtPieceRepository();
        ArtPiece updatedArtPiece = new ArtPiece("The Creation of Adam",  1, ArtForm.PAINTING, 1512, 2300000, false);
        Optional<ArtPiece> foundArtPiece =  artPieceRepository.getArtPieceById(1);
        artPieceRepository.updateArtPiece(foundArtPiece.get().getId(), updatedArtPiece);
        Optional<ArtPiece> querried =  artPieceRepository.getArtPieceById(1);
        Assertions.assertTrue(querried.get().getTitle().equals("The Creation of Adam"));
    }

    @Test
    void testGetAllArtPiece(){
        ArtPieceRepository artPieceRepository = new ArtPieceRepository();
        ArtPiece artPiece1 = new ArtPiece("1",  1, ArtForm.PAINTING, 1, 1, false);
        ArtPiece artPiece2 = new ArtPiece("2",  1, ArtForm.PAINTING, 2, 2, false);
        ArtPiece artPiece3 = new ArtPiece("3",  1, ArtForm.PAINTING, 3, 3, false);
        artPieceRepository.addArtPiece(artPiece1);
        artPieceRepository.addArtPiece(artPiece2);
        artPieceRepository.addArtPiece(artPiece3);
        List<ArtPiece> artPieces = artPieceRepository.getAllArtPieces();
        Assertions.assertEquals(artPieces.size(), 4);
        artPieceRepository.deleteArtPiece(2);
        artPieceRepository.deleteArtPiece(3);
        artPieceRepository.deleteArtPiece(4);
    }


}