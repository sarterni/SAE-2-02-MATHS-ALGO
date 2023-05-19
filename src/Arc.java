public class Arc {
    //attributs
    private String dest;
    private double cout;

    //Constructeur
    public Arc(String d, double c){
        this.dest = d;
        if(c >= 0){
            this.cout = c;
        } else {
            this.cout = 0;
        }
    }
}
