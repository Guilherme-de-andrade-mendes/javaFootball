public class Partida {
    private int idPartida;
    private String dataJogo;
    private Time time1;
    private Time time2;
    private int placarTime1;
    private int placarTime2;

    public Partida(int idPartida, String dataJogo, Time time1, Time time2, int placarTime1, int placarTime2) {
        this.idPartida = idPartida;
        this.dataJogo = dataJogo;
        this.time1 = time1;
        this.time2 = time2;
        this.placarTime1 = placarTime1;
        this.placarTime2 = placarTime2;
    }

    public void atualizarPlacar(int placarTime1, int placarTime2) {
        if (placarTime1 >= 0 && placarTime2 >= 0) {
            if ((this.placarTime1 != placarTime1 || this.placarTime2 != placarTime2)) {
                this.placarTime1 = placarTime1;
                this.placarTime2 = placarTime2;
                System.out.println("Placar atualizado com sucesso!\nPlacar atual: [" + this.placarTime1 + " - " +
                        this.placarTime2 + " ]");
            } else
                System.out.println("O placar se manteve igual, logo não é necessário uma atualização nos valores.");
        } else
            System.out.println("Erro: Foi encontrado um valor negativo no placar.");
    }

    public void mostrarDados() {
        System.out.println(this);
    }

    public int getIdPartida() {
        return idPartida;
    }

    public void setIdPartida(int idPartida) {
        this.idPartida = idPartida;
    }

    public String getDataJogo() {
        return dataJogo;
    }

    public void setDataJogo(String dataJogo) {
        this.dataJogo = dataJogo;
    }

    public int getPlacarTime1() {
        return placarTime1;
    }

    public void setPlacarTime1(int placarTime1) {
        this.placarTime1 = placarTime1;
    }

    public Time getTime1() {
        return time1;
    }

    public void setTime1(Time time1) {
        this.time1 = time1;
    }

    public Time getTime2() {
        return time2;
    }

    public void setTime2(Time time2) {
        this.time2 = time2;
    }

    public int getPlacarTime2() {
        return placarTime2;
    }

    public void setPlacarTime2(int placarTime2) {
        this.placarTime2 = placarTime2;
    }


    @Override
    public String toString() {
        return "Partida: " + idPartida + "\nData: " + dataJogo + "\nTime 1: " + time1 + "\nTime 2: " +
                time2 + "\nPlacar: [ " + placarTime1 + " - " + placarTime2 + " ] ";
    }
}
