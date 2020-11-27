
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part1 {
    public int findStopCodon(String dna, int startIndex, String stopCodon) {
        int index = dna.indexOf(stopCodon,startIndex + 3); 
        while(index != -1) {
            if((index - startIndex)%3 == 0) {
                return index;
            }
            else {
                index = dna.indexOf(stopCodon,index + 1);
            }
        }
        return dna.length();
    }
    public String findGene(String dna, int whereStart) {
        int indexATG = dna.indexOf("ATG",whereStart);
        if (indexATG == -1) {
            return "";
        }
        int indexTAA = findStopCodon(dna, indexATG, "TAA");
        int indexTAG = findStopCodon(dna, indexATG, "TAG");        
        int indexTGA = findStopCodon(dna, indexATG, "TGA");
        int minEndCodon = Math.min(indexTAA, Math.min(indexTAG, indexTGA));
        if (minEndCodon == dna.length()) {
            return "";
        }
        return dna.substring(indexATG,minEndCodon + 3);
    }
    public void printAllGenes(String dna) {
        int indexATG = 0;
        while ( true ) {
            String gene = findGene(dna,indexATG);
            if(gene.isEmpty()) {
                break;
            }
            System.out.println(gene);
            indexATG = dna.indexOf(gene) + gene.length();
        }
    }
    public void testFindStopCodon() {
        String dna = "ACGATGTAAATGCATGCTAGCTAAACTACTATGACGATATAGAC";
        printAllGenes(dna);
    }
}
