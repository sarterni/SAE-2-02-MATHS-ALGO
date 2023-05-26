import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.Test;

public class TestDijkstra {
    @Test
    void testDijkstra() {
        try{
            GrapheListe gListe = new GrapheListe("Graphe1.txt");
            Dijkstra d = new Dijkstra(gListe, "1");
            assertEquals("Le départ est 1", "1", d.getDepart());
            assertEquals("La destination est 2", "2", d.getDestination());
            assertEquals("Le cout devrait être 4", 4, d.getCout(),0.001);
        }catch (IOException e){
            e.setStackTrace(null);
        }
    }
}

    