
/**
 * Write a description of Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part2 {
    public int howMany(String stringA,String stringB) {
        int startIndex = 0;
        int cnt = 0;
        startIndex = stringB.indexOf(stringA);
        while(startIndex != -1) {
            cnt++;
            startIndex = stringB.indexOf(stringA,startIndex + stringA.length());
        }
        return cnt;
    }
    
    public void testHowMany() {
        System.out.println(howMany("GAA", "ATGAACGAATTGAATC"));
                System.out.println(howMany("AA", "ATAAAA"));
    }
}
