
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part1 {
    
    public String findSimpleGene(String dna) {
        int start = dna.indexOf("ATG");
        if(start == -1) {
            return "";
        }
        int end = dna.indexOf("TAA",start + 3);
        if(end == -1) {
            return "";
        }
        String result = dna.substring(start, end + 3);
        int length = result.length();
        if(length % 3 == 0) {
            return result;
        }
        else {
            return "";
        }
    }
    public void testSimpleGene() {
        String dna1 = "TTGATGATTTAGTAAFAGTAFG";
        String dna2 = "TTGATGATTATAGTAAFAGTAFG";
        String dna3 = "TATTATAGAGATGA";
        String dna4 = "TAGATGGTAGTTAG";
        String dna5 = "ATATAGAGAGTGAT";
        System.out.println(findSimpleGene(dna1));
        System.out.println(findSimpleGene(dna2));
        System.out.println(findSimpleGene(dna3));
        System.out.println(findSimpleGene(dna4));
        System.out.println(findSimpleGene(dna5));
    }
}





