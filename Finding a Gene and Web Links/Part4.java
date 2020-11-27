import edu.duke.URLResource;

/**
 * Write a description of Part4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part4 {
    public static void main (String[] args) {
        URLResource ur = new URLResource("http://www.dukelearntoprogram.com/course2/data/manylinks.html");
        for (String word : ur.words()) {
            word = word.toLowerCase();
            int start = word.indexOf("youtube.com");
            if(start != -1) {
                int startFirstQuote = word.lastIndexOf("\"",start);
                int startSecondQuote = word.indexOf("\"", start + 1);
                String url = word.substring(startFirstQuote + 1, startSecondQuote);
                System.out.println(url);
            }
        }
    }
}
