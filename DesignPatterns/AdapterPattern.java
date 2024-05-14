import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URLEncoder;
import java.util.Scanner;

class Translator {

    public String translate(String langFrom, String langTo, String text) throws Exception {
        
        String urlStr = "https://script.google.com/macros/s/AKfycbz8fWdPI7ZlzzNMMbllbtW74u668ID4ryCgoqK2xd4z50BZgfFbeyYES9hQoVPH8qf1ww/exec" +
                "?q=" + URLEncoder.encode(text, "UTF-8") +
                "&target=" + langTo +
                "&source=" + langFrom;
        URI uri = new URI(urlStr);
        StringBuilder response = new StringBuilder();
        HttpURLConnection con = (HttpURLConnection) uri.toURL().openConnection();
        con.setRequestProperty("User-Agent", "Mozilla/5.0");
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        return response.toString();
    }

}


// Adaptee: Represents the German text
class GermanText {
    private String text;

    public GermanText(String text) {
        this.text = text;
    }

    public String getGermanText() {
        return text;
    }
}

// Target interface: Represents the English text
interface EnglishText {
    String getEnglishText();
}

// Adapter: Converts German text to English
class GermanToEnglishAdapter implements EnglishText {
    private GermanText germanText;
    private Translator translator;

    public GermanToEnglishAdapter(GermanText germanText) {

        this.germanText = germanText;
    }

    @Override
    public String getEnglishText() {
        this.translator = new Translator();
        String englishText;
        try {
            englishText = this.translator.translate("de", "en", this.germanText.getGermanText());
        } catch (Exception e) {
            
            System.err.println("Fehler beim Übersetzen: " + e.getMessage());
            e.printStackTrace();
            englishText = "Translation failed";
        }
        return englishText;
    }
}

public class AdapterPattern {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Deutsch Text: ");
        String userGermanText = scanner.nextLine();
        // Create an instance of the Adaptee (German text)
        GermanText germanText = new GermanText(userGermanText);

        // Create an adapter to translate German to English
        EnglishText englishText = new GermanToEnglishAdapter(germanText);

        // Get the translated English text
        System.out.println("Translated text: " + englishText.getEnglishText());
        scanner.close();
    }
}

