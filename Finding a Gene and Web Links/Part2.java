
/**
 * Write a description of Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part2 {
   /* public String toUpperCase(String dna) {
        
    }
    public String toLowerCase(String dna) {
        
    }*/
    public String findSimpleGene(String dna, String startCodon, String stopCodon) {
        int start = dna.indexOf(startCodon);
        if(start == -1) {
            return "";
        }
        int stop = dna.indexOf(stopCodon,start + 3);
        if(stop == -1) {
            return "";
        }
        String result = dna.substring(start, stop + 3);
        
        if(result.length() % 3 == 0) {
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
        String dna6 = "agatgagtgatagataagat";
        System.out.println(findSimpleGene(dna1,"ATG","TAA"));
        System.out.println(findSimpleGene(dna2,"ATG","TAA"));
        System.out.println(findSimpleGene(dna3,"ATG","TAA"));
        System.out.println(findSimpleGene(dna4,"ATG","TAA"));
        System.out.println(findSimpleGene(dna5,"ATG","TAA"));
        System.out.println(findSimpleGene(dna1.toLowerCase(),"atg","taa"));
    }
}
