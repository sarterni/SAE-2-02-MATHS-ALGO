public class Arc {
    //
    /**
     * dest: destination de l'arc
     * cout: cout du trajet
     */
    private String dest;
    private double cout;

    //Constructeur
    /**
     * Constructeur permettant de générer un nouveau arc
     * @param d destination de l'arc
     * @param c cout du trajet
     */
    public Arc(String d, double c){
        this.dest = d;
        if(c >= 0){
            this.cout = c;
        } else {
            this.cout = 0;
        }
    }
    /**
     * getteur permettent d'utiliser destination dans d'autres classes
     * @return this.dest
     */
    public String getDest() {
        return this.dest;
    }
    /**
     * getteur permettant d'utiliser le cout dans d'autres classes
     * @return this.cout
     */
    public double getCout() {
        return this.cout;
    }
}
