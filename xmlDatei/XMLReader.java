import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class XMLReader {

    public static void main(String[] args) {
        try {
            // Pfad zur XML-Datei
            File inputFile = new File("testdaten.xml");
            
            // Dokumenten-Builder-Factory initialisieren
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            
            // Dokument parsen
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            
            // Liste der <entry> Elemente abrufen
            NodeList entryList = doc.getElementsByTagName("entry");
            
            // Schleife durch die <entry> Elemente
            for (int i = 0; i < entryList.getLength(); i++) {
                Node entryNode = entryList.item(i);

                // Cast Node zu Element, damit die getElementsByTagName benutzt wird
                Element entryElement = (Element) entryNode;
                
                // Schlüssel und Wert extrahieren
                String key = entryElement.getElementsByTagName("key").item(0).getTextContent();
                String value = entryElement.getElementsByTagName("value").item(0).getTextContent();
                
                // Ausgabe des Schlüssel-Wert-Paares
                System.out.println(  key + " : " + value);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
