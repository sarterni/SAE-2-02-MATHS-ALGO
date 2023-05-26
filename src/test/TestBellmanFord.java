import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.Test;


public class TestBellmanFord {
    @Test
    void testBellmanFord() {
        try{
            GrapheListe gListe = new GrapheListe("Graphe1.txt");
            BellmanFord bf = new BellmanFord(gListe, "1");
            assertEquals("Le départ est 1", "1", bf.getDepart());
            assertEquals("La destination est 2", "2", bf.getDestination());
            assertEquals("Le cout devrait être 4", 4, bf.getCout(),0.001);
        }catch (IOException e){
            e.setStackTrace(null);
        }
    }

    @Test
    
    
}
