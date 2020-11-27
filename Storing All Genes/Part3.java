import edu.duke.*;
/**
 * Write a description of Part3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part3 {
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
    public double CGratio(String dna) {
        double countCG = 0;
        int start = 0;
        while (true) {
            int pos = dna.indexOf("C",start);
            if (pos == -1) {
                break;
            }
            countCG++;
            start = pos + 1;
        }
        int start2 = 0;
        while (true) {
            int pos2 = dna.indexOf("G",start2);
            if (pos2 == -1) {
                break;
            }
            countCG++;
            start2 = pos2 + 1;
        }
        return countCG/dna.length();
    }
    public StorageResource getAllGenes(String dna)  {
        StorageResource geneList = new StorageResource();
        int indexATG = 0;
        while ( true ) {
            String gene = findGene(dna,indexATG);
            if(gene.isEmpty()) {
                break;
            }
            geneList.add(gene);
            indexATG = dna.indexOf(gene,indexATG) + gene.length();
        }
        return geneList;
    }
    public void processGenes(StorageResource sr) {
        int cnt9 = 0;
        int cntCG = 0;
        int cntAll = 0;
        int maxLenGene = 0;
        for(String item : sr.data()) {
            cntAll++;
            if (item.length() > 60) {
                cnt9++;
                System.out.println("Longer than 9: " + item);
            }
            if(CGratio(item) > 0.35) {
                System.out.println("Higher than 0.35 ratioCG: " + item);
                cntCG++;
            }
            if(maxLenGene < item.length()) {
                maxLenGene = item.length();
            }
        }
        System.out.println("Count of ratioCG > 0,35: " + cntCG);
        System.out.println("Count of gene length > 60: " + cnt9);
        System.out.println("The longest gene in sr is: " + maxLenGene);
        System.out.println("The count of genes is: " + cntAll);        
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
    public void testProcessGenes() {
        FileResource fr = new FileResource("file1.fa");
        String dna = fr.asString();
        //dna = dna.toUpperCase();
        StorageResource sr = getAllGenes(dna);
        processGenes(sr);
        System.out.println("Count of CTG: " + countCTG(dna));
    }
}
