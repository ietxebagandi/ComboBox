package ehu.isad;

public class Argazkia {

    private String izena;
    private String fitx;

    public Argazkia(String pIzena, String pFitx){
        this.izena=pIzena;
        this.fitx=pFitx;
    }

    public String getIzena(){
        return this.izena;
    }

    public String getFitx(){
        return this.fitx;
    }

    public String toString(){
        return String.format(this.izena);
    }

}
