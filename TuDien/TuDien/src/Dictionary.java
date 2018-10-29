import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;


public class Dictionary {
    static ArrayList<Word> ds = new ArrayList<>();

    public void creatList(String pathFile) {
        if (pathFile == null) {
            pathFile = "dictionaries.txt";
        }
        
        String s1, s2, s3;
        Word w;
        
        try {
            FileReader fileReader = new FileReader(pathFile);
            BufferedReader buffed = new BufferedReader(
		   new InputStreamReader(
                      new FileInputStream(pathFile), "UTF8"));
            
            while ((s1 = buffed.readLine()) != null) {
                s2 = s1.substring(0, s1.indexOf("\t"));
                s3 = s1.substring(s1.indexOf("\t") + 1);
                w = new Word(s2, s3);
                ds.add(w);
            }
            
            buffed.close();
            fileReader.close();

        } catch (IOException ex) {
            System.out.println("LỖI");
        }
    }
     
    public static void ghiFile() {
        try
        {
            FileWriter fileWriter = new FileWriter("Dictionary.txt");
            BufferedWriter buffed = new BufferedWriter(
		   new OutputStreamWriter(new FileOutputStream("Dictionary.txt"), "UTF8"));
            for (Word item:ds)
            {
                String target_ = item.getWord_target() + "\t";
                buffed.write(target_);
                String explain_ = item.getWord_explain() + "\n";
                buffed.write(explain_);
            }
            
            buffed.close();
            fileWriter.close();
        } catch (IOException ex) {}
     }
}
