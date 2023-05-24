import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.CollectionUtils;

public class TestGraphe {
    /**
     * test qui permet de voir si ajouterArc fonctionne correctement
     */
    @Test
    void testAjouterArc() {
        GrapheListe gListe = new GrapheListe();
        gListe.ajouterArc("A", "B", 10);
        String dep = gListe.getEnsNom().get(0);
        String dest = gListe.getEnsNoeuds().get(0).getAdj().get(0).getDest();
        double cout = gListe.getEnsNoeuds().get(0).getAdj().get(0).getCout()
        assertEquals("Le départ est A", "A", dep);
        assertEquals("La destination est B", "B", dest);
        assertEquals("Le cout devrait être 10", 10, cout,0.001);
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
