import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        try {
            System.out.println("Hola mundo");

            // Conectar a Wikipedia
            Document doc = Jsoup.connect("https://en.wikipedia.org/").get();
            System.out.println(doc.title());

            // Seleccionar los titulares de noticias
            Elements newsHeadlines = doc.select("#mp-itn b a");

            // Iterar sobre los titulares
            for (Element headline : newsHeadlines) {
                System.out.printf("%s\n\t%s\n",
                        headline.attr("title"), headline.absUrl("href"));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}