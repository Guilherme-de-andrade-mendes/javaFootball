import java.util.ArrayList;
import java.util.List;

public class Time {
    private int idTime;
    private String pais;

    public Time(int idTime, String pais) {
        this.idTime = idTime;
        this.pais = pais;
    }


    public int getIdTime() {
        return idTime;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public void mostrarDados() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Time: " + getIdTime() + "\nPais: " + getPais();
    }
}
