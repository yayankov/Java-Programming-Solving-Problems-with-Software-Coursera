
/**
 * Write a description of Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part2 {
    public double cgRatio(String dna) {
        double ratio = 0;
        int indexStart = 0;
        for( int i=0; i<dna.length(); i++) {
            if( dna.charAt(i) == 'C' || dna.charAt(i) == 'G') {
                ratio++;
            }
        }
        return ratio/dna.length();
    }
    public int countCTG(String dna) {
        int indexStart = 0;
        int cnt = 0;
        int currIndex = dna.indexOf("CTG",indexStart);
        while (currIndex != -1) {
            cnt++;
            currIndex = dna.indexOf("CTG", currIndex + 3);
        }
        return cnt;
    }
    public void testFindStopCodon() {
        
        String dna2 = "ATGCCATAG";
        System.out.println(cgRatio(dna2));
        String dna = "ATGCTGAGACTGCTG";
        System.out.println(countCTG(dna));
    }
}
