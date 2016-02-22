package johtek.nlp;

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
        
        // tarvittavat Parse-olion metodit:
        // solmu.getChildren() palauttaa Parse[] taulukon lapsista
        // solmu.getType() palauttaa String-oliona solmun POS-tagin, esim. NP tai VP
        // solmu.getCoveredText() palauttaa kyseiseen solmuun liittyvän osan alkuperäisestä tekstistä
        
        return "";
    }
    
}
