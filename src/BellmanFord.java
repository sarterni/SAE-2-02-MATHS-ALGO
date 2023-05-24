public class BellmanFord {

    public  Valeur resoudre(Graphe g, String depart) {
        Valeur res = new Valeur();
        res.setDepart(depart);
        res.setGraphe(g);

        for (String s : g.listeNoeuds()) {
            if (s.equals(depart)) {
                res.setDistance(s, 0);
            } else {
                res.setDistance(s, Double.POSITIVE_INFINITY);
            }
            res.setParent(s, null);
        }

        for (int i = 1; i < g.listeNoeuds().size(); i++) {
            for (String s : g.listeNoeuds()) {
                for (Arc a : g.suivants(s)) {
                    if (res.getDistance(a.getDest()) > res.getDistance(s) + a.getCout()) {
                        res.setDistance(a.getDest(), res.getDistance(s) + a.getCout());
                        res.setParent(a.getDest(), s);
                    }
                }
            }
        }

        for (String s : g.listeNoeuds()) {
            for (Arc a : g.suivants(s)) {
                if (res.getDistance(a.getDest()) > res.getDistance(s) + a.getCout()) {
                    System.out.println("Erreur");
                }
            }
        }
        return res;
    }

}
