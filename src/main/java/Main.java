public class Main {
    public static void main(String[] args) {

        Time t1 = new Time(1, "Brasil");
        Time t2 = new Time(2, "Argentina");
        TimeDAO timeDAO = new TimeDAO();
//        timeDAO.save(t1);
//        timeDAO.save(t2);

        System.out.println(timeDAO.findAll());
        System.out.println(timeDAO.findOne(1));




//        Partida p1 = new Partida(1,"24/05/2024",t1,t2,3,2);
        PartidaDAO partidaDAO = new PartidaDAO();
//        partidaDAO.save(p1);

        System.out.println(partidaDAO.findOne(1));
        System.out.println(partidaDAO.findAll());

//        t1.mostrarDados();
//        p1.mostrarDados();

//        p1.atualizarPlacar(4,2);
//        p1.atualizarPlacar(1,2);
//        p1.atualizarPlacar(-1,2);

    }
}