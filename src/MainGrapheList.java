public class MainGrapheList {

    public static void main(String[] args) {
        GrapheListe grapheG = new GrapheListe();
        grapheG.ajouterArc("A", "B", 12);
        grapheG.ajouterArc("A", "D", 87);
        grapheG.ajouterArc("B", "E", 11);
        grapheG.ajouterArc("C", "A", 19);
        grapheG.ajouterArc("D", "C", 10);
        grapheG.ajouterArc("D", "B", 23);
        grapheG.ajouterArc("E", "D",43);
        System.out.println(grapheG);
        //GrapheListe grapheG2 = new GrapheListe("Graphe42.txt");
        //System.out.println(grapheG2);
    }
}
