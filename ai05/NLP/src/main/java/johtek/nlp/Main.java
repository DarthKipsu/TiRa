package johtek.nlp;

import opennlp.tools.parser.Parse;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class Main {
        
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // Käytä tätä oliota NLP-metodien hyödyntämiseen, esim. NLP.parse(lause)
        NLPUtils NLP = new NLPUtils();
    
        File file = new File(Main.class.getResource("/metamorphosis.txt").getFile());
        // File file = new File(Main.class.getResource("/wikipedia.txt").getFile());
        List<String> lines = FileUtils.readLines(file);

        for (String line : lines) {
            for (String sentence : NLP.detectSentences(line)) {
                // logiikka tähän
            }
        }
    }
    
}
