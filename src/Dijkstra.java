import java.util.ArrayList;
import java.util.List;


public class Dijkstra {

        public Graphe g;
        public Vertex a;

            //Q <- {} // utilisation d’une liste de noeuds à traiter
            List<Vertex> q = new ArrayList<Vertex>();
            //Pour chaque sommet v de G faire
            for (Vertex v : g.getVertices()) {
                //v.distance <- Infini
                v.setDistance(Integer.MAX_VALUE);
                //v.parent <- Indéfini
                v.setParent(null);
                //Q <- Q U {v} // ajouter le sommet v à la liste Q
                q.add(v);
            }
            //A.distance <- 0
            a.setDistance(0);
            //Tant que Q est un ensemble non vide faire
            while (!q.isEmpty()) {
                //u <- un sommet de Q telle que u.distance est minimale
                Vertex u = null;
                int min = Integer.MAX_VALUE;
                for (Vertex v : q) {
                    if (v.getDistance() < min) {
                        min = v.getDistance();
                        u = v;
                    }
                }
                //Q <- Q \ {u} // enlever le sommet u de la liste Q
                q.remove(u);
                //Pour chaque sommet v de Q tel que l’arc (u,v) existe faire
                for (Vertex v : q) {
                    if (g.getEdge(u, v) != null) {
                        //D <- u.distance + poids(u,v)
                        int d = u.getDistance() + g.getEdge(u, v).getWeight();
                        //Si D < v.distance
                        if (d < v.getDistance()) {
                            //Alors v.distance <- D
                            v.setDistance(d);
                            //v.parent <- u
                            v.setParent(u);
                        }
                    }
                }
            }
        }
 

    }


    //    Algorithme de Dijkstra
    //    Entrées :
    //    G un graphe orienté avec une pondération (poids) positive des arcs
    //    A un sommet (départ) de G
    //    Début
    //    Q <- {} // utilisation d’une liste de noeuds à traiter
    //    Pour chaque sommet v de G faire
    //      v.distance <- Infini
    //      v.parent <- Indéfini
    //      Q <- Q U {v} // ajouter le sommet v à la liste Q
    //    Fin Pour
    //    A.distance <- 0
    //    Tant que Q est un ensemble non vide faire
    //      u <- un sommet de Q telle que u.distance est minimale
    //      Q <- Q \ {u} // enlever le sommet u de la liste Q
    //      Pour chaque sommet v de Q tel que l’arc (u,v) existe faire
    //          D <- u.distance + poids(u,v)
    //          Si D < v.distance
    //              Alors v.distance <- D
    //                  v.parent <- u
    //          Fin Si
    //      Fin Pour
    //    Fin Tant que
    //    Fin
    
    // q: convertir en Java
    // a:
    //a:
    
