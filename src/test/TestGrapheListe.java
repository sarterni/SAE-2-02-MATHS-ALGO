
/**
 * TestGrapheListe
 */

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.Test;

public class TestGrapheListe {
    @Test
    void testGrapheListe() {
        try {
            GrapheListe gListe = new GrapheListe("Graphe1.txt");
            assertEquals("Le nombre de sommets est 4", 4, gListe.getVertices().size());
            assertEquals("Le nombre d'arcs est 4", 4, gListe.getEdges().size());
            assertEquals("Le sommet 1 a 2 arcs", 2, gListe.getEdges(gListe.getVertex("1")).size());
            assertEquals("Le sommet 2 a 1 arc", 1, gListe.getEdges(gListe.getVertex("2")).size());
            assertEquals("Le sommet 3 a 1 arc", 1, gListe.getEdges(gListe.getVertex("3")).size());
            assertEquals("Le sommet 4 a 0 arc", 0, gListe.getEdges(gListe.getVertex("4")).size());
        } catch (IOException e) {
            e.setStackTrace(null);
        }
    }

}