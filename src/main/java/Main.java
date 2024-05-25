public class Main {
    public static void main(String[] args) {


        TimeDAO timeDAO = new TimeDAO();

        System.out.println(timeDAO.findAll());
        System.out.println(timeDAO.findOne(1));


        PartidaDAO partidaDAO = new PartidaDAO();

        System.out.println(partidaDAO.findOne(1));
        System.out.println(partidaDAO.findAll());


    }
}