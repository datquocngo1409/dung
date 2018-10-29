import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
public class DictionaryManagement { 
    Dictionary dictionary = new Dictionary();
    DictionaryManagement() {        
        dictionary.creatList("Dictionary.txt");
    }
    
    public Boolean Add(String _target,String _explain) throws IOException {
        Word newWord = new Word(_target, _explain);
        
        for(Word item:Dictionary.ds)
        {
            if(item.getWord_target().equals(newWord.getWord_target()))
                return false;
        }
        
        Dictionary.ds.add(newWord);

        try {
            File f = new File("Dictionary.txt");
            FileWriter fw = new FileWriter(f);

            for (Word item : Dictionary.ds) {
                String target = item.getWord_target() + "\n";
                fw.write(target);
                String explain_ = item.getWord_explain() + "\n";
                fw.write(explain_);
            }
            fw.close();
        } catch (Exception ex) {}
        return true;
    }

    public ArrayList<Word> dictionaryLookup(String target) {
        ArrayList<Word> listResult = new ArrayList<Word>();
        target = target.trim();
        for (Word item : Dictionary.ds) {
            if (item.getWord_target().indexOf(target)==0) {
                listResult.add(item);
            }
        }
        return listResult;
    }
    
    Boolean edit(String targetOld,String targetNew, String explain) {
        try{
            for(Word w : Dictionary.ds)
            {
                if(w.getWord_target().equals(targetOld))
                {
                    Dictionary.ds.remove(w);
                    break;
                }
            }
            Dictionary.ds.add(new Word(targetNew, explain));
            return true;
        }catch(Exception e) {}
        return false;
    }

    Boolean delWord(String target) {
        target = target.trim();
        for(Word item:Dictionary.ds)
        {
            if(item.getWord_target().equals(target))
            {
                Dictionary.ds.remove(item);
                return true;
            }
        }
        return false;
    }
}