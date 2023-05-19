public class MainGrapheList {

    public static void main(String[] args) {
        GrapheListe g = new GrapheListe();
        g.ajouterArc("A", "B", 1);
        g.ajouterArc("A", "C", 2);
        g.ajouterArc("B", "C", 3);
        g.ajouterArc("B", "D", 4);
        g.ajouterArc("C", "D", 5);
        g.ajouterArc("C", "E", 6);
        g.ajouterArc("D", "E", 7);
        g.ajouterArc("D", "F", 8);
        g.ajouterArc("E", "F", 9);
        g.ajouterArc("E", "G", 10);
        g.ajouterArc("F", "G", 11);
        System.out.println(g.listeNoeuds());
        System.out.println(g.suivants("A"));
        System.out.println(g.suivants("B"));
        System.out.println(g.suivants("C"));
        System.out.println(g.suivants("D"));
        System.out.println(g.suivants("E"));
        System.out.println(g.suivants("F"));
        System.out.println(g.suivants("G"));
    }
}
