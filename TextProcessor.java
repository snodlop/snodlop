import java.io.*;
public class TextProcessor {
   private String fileName;
   private String wholeText;
   
   public TextProcessor(String fName) {
      fileName = fName;
   }
   
   private void processFile() throws FileNotFoundException, IOException {
      File file = new File(fileName);
      
      BufferedReader br = new BufferedReader(new FileReader(fileName));
      try {
         StringBuilder sb = new StringBuilder();
         String line = br.readLine();

         while (line != null) {
            sb.append(line);
            sb.append(System.lineSeparator());
            line = br.readLine();
         }
      wholeText = sb.toString();
      }
      catch (FileNotFoundException ex) {
         System.exit(0);
      }
      catch (IOException ex2) {
         System.exit(0);
      }
      finally {
         br.close();
      }
   }
   
   public int getWordCount() {
      if (wholeText == null || wholeText.isEmpty()) {
         return 0;
      }

      String[] words = wholeText.split(" ");
      return words.length;
   }
   
   public long getFileLength() {
      return wholeText.length();
   }
   
   public String getFileName() {
      return fileName;
   }
   
   public int countThisWord(String fileWithWords) {
      String[] words = fileWithWords.split("\\s+");
      return words.length;
   }
   
   //public String getWordsHavingCount(int count) {
   //}
   
   //public String getWordsHavingLength(int wordLength) {
   //}
   
   //public String getMostFrequentWord() {
   //}
   
   //public float getAverageWordCount() {
   //}
   
   //public int getUniqueWordCount() {
   //}
   
}