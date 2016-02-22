package johtek.nlp;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import opennlp.tools.parser.Parse;

public class Extractor {
    
    /**
     * Löytää lauseen subjektin jäsennyspuusta.
     * 
     * @param root jäsennyspuun juuri (S)
     * @return subjekti String-oliona
     */
    public static String extractSubject(Parse root) {
        // Toteuta subjektin löytäminen jäsennyspuusta seuraavasti:
        // Valitse juuren (root) lapsista solmu, jonka POS-tag on NP
        // Suorita kyseisestä solmusta BFS-haku sen alipuussa
        // Subjekti on ensimmäisessä löydetyssä solmussa, jonka POS-tag on substantiivi
        // Substantiiveja ovat solmut, joiden POS-tag on NN, NNP, NNS tai NNPS
        // Jos substantiivia ei löydy, palauta null

        if (root == null) return null;

        for (Parse child : root.getChildren()) {
            if (child.getType().equals("NP")) {
                Deque<Parse> d = new ArrayDeque<>();
                d.add(child);
                return findSubjectWithBreadthFirstSearch(d);
            }
        }

        // tarvittavat Parse-olion metodit:
        // solmu.getChildren() palauttaa Parse[] taulukon lapsista
        // solmu.getType() palauttaa String-oliona solmun POS-tagin, esim. NP tai VP
        // solmu.getCoveredText() palauttaa kyseiseen solmuun liittyvän osan alkuperäisestä tekstistä
        
        return null;
    }

    private static String findSubjectWithBreadthFirstSearch(Deque<Parse> d) {
        if (d.isEmpty()) return null;
        Parse node = d.pollFirst();
        if (node.getType().equals("NN") ||
                node.getType().equals("NNP") ||
                node.getType().equals("NNS") ||
                node.getType().equals("NNPS")) {
            return node.getCoveredText();
        }
        for (Parse child : node.getChildren()){
            d.add(child);
        }
        return findSubjectWithBreadthFirstSearch(d);
    }

    public static Map extractVerbs(Parse root, Map<String, Integer> verbs) {
        if (root == null) return null;

        Deque<Parse> d = new ArrayDeque<>();
        d.add(root);
        return findVerbsWithBreadthFirstSearch(d, verbs);
    }

    private static Map findVerbsWithBreadthFirstSearch(Deque<Parse> d, Map<String, Integer> verbs) {
        if (d.isEmpty()) return verbs;
        Parse node = d.pollFirst();
        if (node.getType().equals("VB") ||
                node.getType().equals("VBD") ||
                node.getType().equals("VBG") ||
                node.getType().equals("VBN") ||
                node.getType().equals("VBP") ||
                node.getType().equals("VBZ")) {
            String v = node.getCoveredText();
            if (!verbs.containsKey(v)) verbs.put(v, 0);
            verbs.replace(v, verbs.get(v) + 1);
        }
        for (Parse child : node.getChildren()){
            d.add(child);
        }
        return findVerbsWithBreadthFirstSearch(d, verbs);
    }
    
}
