public class MainDijktra {
    public static void main(String[] args) {
        //        G <- Graphe construit à partir du fichier texte
        Graphe g = new Graphe() {
            g.loadFromFile("graph1.txt");
            //        A <- Sommet de G
            Vertex a = g.getVertex("A");
            //        Dijkstra(G,A)
            Dijkstra d = new Dijkstra(g, a);
            //        Pour chaque sommet v de G faire
            for (Vertex v : g.getVertices()) {
                //            Afficher v.label, v.distance, v.parent.label
                System.out.println(v.getLabel() + " " + v.getDistance() + " " + v.getParent().getLabel());
            }
        }
    }
}

