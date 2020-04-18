import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileWriter;

public class Main {

    final static String BASE_URL = "https://www.imdb.com/chart/top/?ref_=nv_mv_250";

    public static void main(String[] args) {

        try {
            File top_movies = new File("C:\\Users\\wrathbull\\Desktop\\movies.txt");
            FileWriter fileWriter = new FileWriter(top_movies);
            Document document = Jsoup.connect(BASE_URL).get();
            Elements rating = document.select("td.ratingColumn.imdbRating strong");
            Elements movies = document.select("td.titleColumn a");
            for (int i = 0; i < 50; i++) {
                fileWriter.write((i + 1) + ". " + movies.select("a").get(i).text() + " - "
                + rating.select("strong").get(i).text() + "\n");
            }
            fileWriter.close();
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}