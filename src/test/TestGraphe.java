import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.CollectionUtils;

public class TestGraphe {
    /**
     * test qui permet de voir si ajouterArc fonctionne correctement
     * avec le constructeur vide
     */
    @Test
    void testAjouterArcVide() {
        GrapheListe gListe = new GrapheListe();
        gListe.ajouterArc("A", "B", 10);
        String dep = gListe.listeNoeuds().get(0);
        String dest = gListe.getEnsNoeuds().get(0).getAdj().get(0).getDest();
        double cout = gListe.getEnsNoeuds().get(0).getAdj().get(0).getCout();
        assertEquals("Le départ est A", "A", dep);
        assertEquals("La destination est B", "B", dest);
        assertEquals("Le cout devrait être 10", 10, cout,0.001);
    }

    @Test
    void testAjouterArcFichier() {
        try{
            GrapheListe gListe = new GrapheListe("Graphe1.txt");
            gListe.ajouterArc("A", "B", 10);
            String dep = gListe.listeNoeuds().get(0);
            String dest = gListe.getEnsNoeuds().get(0).getAdj().get(0).getDest();
            double cout = gListe.getEnsNoeuds().get(0).getAdj().get(0).getCout();
            assertEquals("Le départ est 1", "1", dep);
            assertEquals("La destination est 2", "2", dest);
            assertEquals("Le cout devrait être 4", 4, cout,0.001);
        }catch (IOException e){
            e.setStackTrace(null);
        }
    }

    @Test
    void testListeNoeuds() {

    }

    @Test
    void testSuivants() {

    }

    @Test
    void testToGraphviz() {

    }
}
