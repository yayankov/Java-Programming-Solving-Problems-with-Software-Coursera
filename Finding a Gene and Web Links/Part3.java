
/**
 * Write a description of Part3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part3 {
    public String lastPart(String strA, String strB) {
        int startIndex = strB.indexOf(strA);
        if (startIndex == -1) {
            return strB;
        } else {
            return strB.substring(startIndex + strA.length());
        }
    }
    public boolean twoOccurrences(String stringA, String stringB) {
        int startIndex = stringB.indexOf(stringA);
        if (startIndex == -1) {
            return false;
        }
        int startIndex2 = stringB.indexOf(stringA,startIndex + stringA.length());
        if(startIndex2 == -1) {
            return false;
        } else {
            return true;
        }
    }
    public void testing() {
        System.out.println(twoOccurrences("by", "A story by Abby Long"));
        System.out.println(twoOccurrences("a", "banana"));
        System.out.println(twoOccurrences("atg", "ctgtatgta"));
        System.out.println(twoOccurrences("q", "A story by Abby Long"));
        System.out.println(lastPart("an", "banana"));
        System.out.println(lastPart("q", "A story by Abby Long"));
    }
}
