package models.services;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TranslationService extends Subject{
    private String language;

    public TranslationService(String language){
        this.language = language;
    }

    public TranslationService() {
    }

    public List<String> getTranslation(String page) {
        int translationIndex = -1;

        switch (page){
            case "visitor":
                translationIndex = 0;
                break;
            case "employee":
                translationIndex = 1;
                break;
            case "administrator":
                translationIndex = 2;
                break;
            case "sign_up":
                translationIndex = 3;
                break;
            case "log_in":
                translationIndex = 4;
                break;
        }

        List<String> translations = new ArrayList<>();

        try{
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse("client/src/main/resources/translations/translations.xml");
            NodeList list = document.getElementsByTagName(this.language);
            Element element = (Element) list.item(translationIndex);
            NodeList childNodes = element.getChildNodes();
            for (int i = 0; i < childNodes.getLength(); i++) {
                if (childNodes.item(i).getNodeType() == Node.ELEMENT_NODE) {
                    translations.add(childNodes.item(i).getTextContent());
                }
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }

        return translations;
    }


    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
