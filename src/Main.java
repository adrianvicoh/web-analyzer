import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.FlowLayout;

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

            // Crear la ventana
            JFrame frame = new JFrame("Mi Aplicación Swing");

            // Configurar la ventana
            frame.setSize(300, 200); // Establecer el tamaño de la ventana
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cerrar al hacer clic en la X
            frame.setLayout(new FlowLayout()); // Usar un layout sencillo (FlowLayout)

            // Crear un botón y una etiqueta
            JButton button = new JButton("Haz clic aquí");
            JLabel label = new JLabel("Hola, bienvenido a Swing!");

            // Añadir el botón y la etiqueta a la ventana
            frame.add(button);
            frame.add(label);

            // Hacer visible la ventana
            frame.setVisible(true);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}