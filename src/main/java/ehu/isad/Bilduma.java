package ehu.isad;

public class Bilduma {

    private  String izena;

    public Bilduma(String pIzena){
        this.izena=pIzena;
    }

    public String toString(){
        return String.format(this.izena);
    }
}
