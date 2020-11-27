import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part1 {
    
  public CSVRecord ColdestHourInFile(CSVParser parser) {
        CSVRecord coldestSoFar = null;
        for(CSVRecord currRec : parser) {
            if(coldestSoFar == null) {
                coldestSoFar = currRec;
            } 
            else {
                double currTemp = Double.parseDouble(currRec.get("TemperatureF"));
                double coldestTemp = Double.parseDouble(coldestSoFar.get("TemperatureF"));
                if (coldestTemp > currTemp) {
                    coldestSoFar = currRec;
                }
            }
        }
        return coldestSoFar;
    }
  public void testColdestHourInFile() {
       FileResource fr = new FileResource();
       CSVParser parser = fr.getCSVParser();
       CSVRecord coldest = ColdestHourInFile(parser);
       System.out.println(coldest.get("TemperatureF"));
        
  }
  public File fileWithColdestTemperature() {
      DirectoryResource dr = new DirectoryResource();
      CSVRecord coldestSoFar = null;
      File coldest = null;
      for( File f : dr.selectedFiles()) {
          FileResource fr = new FileResource(f);
          CSVParser parser = fr.getCSVParser();
          CSVRecord currRec = ColdestHourInFile(parser);
          if(coldestSoFar == null) {
                coldestSoFar = currRec;
                coldest = f;
          } 
          else {
                if(!currRec.get("TemperatureF").equals("-9999")) {
                    double currTemp = Double.parseDouble(currRec.get("TemperatureF"));                    
                    double coldestTemp = Double.parseDouble(coldestSoFar.get("TemperatureF"));
                    if (coldestTemp > currTemp) {
                        coldestSoFar = currRec;
                        coldest = f;
                    }
                }
          }
      }
      //System.out.println(coldestSoFar.get("Humidity")+" " +coldestSoFar.get("DateUTC"));
      return coldest;
  }
  public void testFileWithColdestTemperature() {
      File coldestFile = fileWithColdestTemperature();
      FileResource fr = new FileResource(coldestFile);
      CSVParser parser = fr.getCSVParser();
      CSVRecord coldestRec = ColdestHourInFile(parser);
      System.out.println("Coldest day was in file: " + coldestFile.getName());
      System.out.println("Coldest temperature on that day was " + coldestRec.get("TemperatureF"));
      CSVParser parser2 = fr.getCSVParser();
      for(CSVRecord record : parser2) {
          System.out.println(record.get("DateUTC")+"All the Temperatures on the coldest day were: " + record.get("TemperatureF"));
      }
  }
  public double averageTemperatureInFile(CSVParser parser) {
      double ave = 0;
      double sum = 0;
      double num = 0;
      for(CSVRecord rec : parser) {
          sum += Double.parseDouble(rec.get("TemperatureF"));
          num++;
      }
      ave = sum/num;
      return ave;
  }
  public void testAverageTemperatureInFile() {
      FileResource fr = new FileResource();
       CSVParser parser = fr.getCSVParser();
       double average = averageTemperatureInFile(parser);
       System.out.println("Average temperature in file is: "+ average);
       
  }
}




