package models.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVWriter;
import models.model.ArtPieceArtist;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExportService {
    private ArtService artService;
    private static final String CSV_FILE_PATH = "src/main/resources/exports/csv_export.csv";
    private static final String JSON_FILE_PATH = "src/main/resources/exports/json_export.json";
    private static final String XML_FILE_PATH = "src/main/resources/exports/xml_export.xml";
    private static final String TXT_FILE_PATH = "src/main/resources/exports/txt_export.txt";

    public ExportService() {
        artService = new ArtService();
    }

    private String[] toStringArray(ArtPieceArtist artPieceArtist) {
        String[] data = new String[]{String.valueOf(artPieceArtist.getId()), artPieceArtist.getTitle(),
                String.valueOf(artPieceArtist.getArtistId()), artPieceArtist.getArtistName(),
                String.valueOf(artPieceArtist.getArtForm()), String.valueOf(artPieceArtist.getYear()),
                String.valueOf(artPieceArtist.getPrice()), String.valueOf(artPieceArtist.isSold())};
        return data;
    }

    private String toTxtString(ArtPieceArtist artPieceArtist) {
        StringBuilder data = new StringBuilder();
        data.append("Id");
        data.append(": ");
        data.append(artPieceArtist.getId());
        data.append(", ");

        data.append("Title");
        data.append(": ");
        data.append(artPieceArtist.getTitle());
        data.append(", ");

        data.append("ArtistId");
        data.append(": ");
        data.append(artPieceArtist.getArtistId());
        data.append(", ");

        data.append("ArtistName");
        data.append(": ");
        data.append(artPieceArtist.getArtistName());
        data.append(", ");

        data.append("ArtForm");
        data.append(": ");
        data.append(artPieceArtist.getArtForm());
        data.append(", ");

        data.append("Year");
        data.append(": ");
        data.append(artPieceArtist.getYear());
        data.append(", ");

        data.append("Price");
        data.append(": ");
        data.append(artPieceArtist.getPrice());
        data.append(", ");

        data.append("IsSold");
        data.append(": ");
        data.append(artPieceArtist.isSold());
        data.append(";");

        return data.toString();
    }

    public void writeToCsv() {
        List<ArtPieceArtist> artPieceArtistList = artService.getAllArtPieceArtist();
        try {
            FileWriter outputfile = new FileWriter(CSV_FILE_PATH);
            CSVWriter writer = new CSVWriter(outputfile, ',',
                    CSVWriter.NO_QUOTE_CHARACTER,
                    CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                    CSVWriter.DEFAULT_LINE_END);

            List<String[]> data = new ArrayList<String[]>();
            String[] header = new String[]{"Id", "Title", "Artist Id", "Artist Name", "Art Form", "Year", "Price", "Is Sold"};
            data.add(header);
            for (ArtPieceArtist artPieceArtist : artPieceArtistList) {
                data.add(toStringArray(artPieceArtist));
            }
            writer.writeAll(data);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeToJson() {
        List<ArtPieceArtist> artPieceArtistList = artService.getAllArtPieceArtist();
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File(JSON_FILE_PATH), artPieceArtistList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeToXml(){
        List<ArtPieceArtist> artPieceArtistList = artService.getAllArtPieceArtist();
        try{
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.newDocument();

            Element root = doc.createElement("artPieceArtistList");
            doc.appendChild(root);

            for (ArtPieceArtist artPieceArtist : artPieceArtistList) {
                Element element = doc.createElement("artPieceArtist");
                root.appendChild(element);

                Element id = doc.createElement("Id");
                id.appendChild(doc.createTextNode(String.valueOf(artPieceArtist.getId())));
                element.appendChild(id);

                Element title = doc.createElement("Title");
                title.appendChild(doc.createTextNode(String.valueOf(artPieceArtist.getTitle())));
                element.appendChild(title);

                Element artistId = doc.createElement("ArtistId");
                artistId.appendChild(doc.createTextNode(String.valueOf(artPieceArtist.getArtistId())));
                element.appendChild(artistId);

                Element artistName = doc.createElement("ArtistName");
                artistName.appendChild(doc.createTextNode(String.valueOf(artPieceArtist.getArtistName())));
                element.appendChild(artistName);

                Element artForm = doc.createElement("ArtForm");
                artForm.appendChild(doc.createTextNode(String.valueOf(artPieceArtist.getArtForm())));
                element.appendChild(artForm);

                Element year = doc.createElement("Year");
                year.appendChild(doc.createTextNode(String.valueOf(artPieceArtist.getYear())));
                element.appendChild(year);

                Element price = doc.createElement("Price");
                price.appendChild(doc.createTextNode(String.valueOf(artPieceArtist.getPrice())));
                element.appendChild(price);

                Element isSold = doc.createElement("IsSold");
                isSold.appendChild(doc.createTextNode(String.valueOf(artPieceArtist.isSold())));
                element.appendChild(isSold);
            }

            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer();
            transformer.setOutputProperty("indent", "yes");

            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(XML_FILE_PATH));
            transformer.transform(source, result);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }

    public void writeToTxt() {
        List<ArtPieceArtist> artPieceArtistList = artService.getAllArtPieceArtist();
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(TXT_FILE_PATH));
            for (ArtPieceArtist artPieceArtist : artPieceArtistList) {
                writer.write(toTxtString(artPieceArtist));
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
