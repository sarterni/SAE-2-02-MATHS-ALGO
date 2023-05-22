public class MainGrapheList {

    public static void main(String[] args) {
        GrapheListe grapheG = new GrapheListe();
        grapheG.ajouterArc("A", "B", 1);
        grapheG.ajouterArc("A", "C", 2);
        grapheG.ajouterArc("B", "C", 3);
        grapheG.ajouterArc("B", "D", 4);
        grapheG.ajouterArc("C", "D", 5);
        grapheG.ajouterArc("C", "E", 6);
        grapheG.ajouterArc("D", "E", 7);
        grapheG.ajouterArc("D", "F", 8);
        grapheG.ajouterArc("E", "F", 9);
        grapheG.ajouterArc("E", "G", 10);
        grapheG.ajouterArc("F", "G", 11);
        grapheG.ajouterArc("F", "A", 12);
        grapheG.ajouterArc("G", "A", 13);
        System.out.println(grapheG);

        
        System.out.println(grapheG.listeNoeuds());
        System.out.println(grapheG.suivants("A"));
        System.out.println(grapheG.suivants("B"));
        System.out.println(grapheG.suivants("C"));
        System.out.println(grapheG.suivants("D"));
        System.out.println(grapheG.suivants("E"));
        System.out.println(grapheG.suivants("F"));
        System.out.println(grapheG.suivants("G"));

        // System.out.println(grapheG.listeNoeuds());
        // System.out.println(grapheG.suivants("A"));
        // System.out.println(grapheG.suivants("B"));
        // System.out.println(grapheG.suivants("C"));
        // System.out.println(grapheG.suivants("D"));
        // System.out.println(grapheG.suivants("E"));
        // System.out.println(grapheG.suivants("F"));
        // System.out.println(grapheG.suivants("G"));
    }
}
