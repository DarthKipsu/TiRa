package johtek.nlp;

import opennlp.tools.parser.Parse;

import java.io.IOException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ExtractorTest {
    
    private static NLPUtils NLP;
    
    public ExtractorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() throws IOException {
        NLP = new NLPUtils();
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testaaEkaSubjekti() {
        String txt = "This course is fun.";
        Parse parsed = NLP.parse(txt);
        assertEquals("course", Extractor.extractSubject(parsed));
    }
    
    @Test
    public void testaaTokaSubjekti() {
        String txt = "Gregor is ill.";
        Parse parsed = NLP.parse(txt);
        assertEquals("Gregor", Extractor.extractSubject(parsed));
    }
    
    @Test
    public void testaaKolmasSubjekti() {
        String txt = "Because of his injuries, Gregor had lost much of his mobility.";
        Parse parsed = NLP.parse(txt);
        assertEquals("Gregor", Extractor.extractSubject(parsed));
    }
    
    @Test
    public void testaaSubjektiEiLoydy() {
        String txt = "And even if he did catch the train he would not avoid his boss's " +
                      "anger as the office assistant would have been there to see the five " +
                      "o'clock train go, he would have put in his report about Gregor's " +
                      "not being there a long time ago.";
        Parse parsed = NLP.parse(txt);
        assertNull(Extractor.extractSubject(parsed));
    }
    
}
