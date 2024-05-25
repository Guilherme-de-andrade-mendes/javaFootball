import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PartidaDAO implements DAO<Partida> {
    @Override
    public void save(Partida p) {
        String sql = "INSERT INTO partida (idPartida, dataJogo, time1, time2, placarTime1, placarTime2)" +
                "VALUES (?,?,?,?,?,?)";
        try (PreparedStatement stmt = ConnectionFactory.createStatement(sql)) {
            stmt.setInt(1, p.getIdPartida());
            stmt.setString(2, p.getDataJogo());
            stmt.setInt(3, p.getTime1().getIdTime());
            stmt.setInt(4, p.getTime2().getIdTime());
            stmt.setInt(5, p.getPlacarTime1());
            stmt.setInt(6, p.getPlacarTime2());
            stmt.executeUpdate();
            System.out.println("Partida inserida com sucesso!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Partida p) {
        String sql = "UPDATE time SET dataJogo = ?, time1 = ? time2 = ?," +
                "placarTime1 = ?, placarTime2 = ?  WHERE idPartida = ?";
        try (PreparedStatement stmt = ConnectionFactory.createStatement(sql)) {
            stmt.setString(1, p.getDataJogo());
            stmt.setInt(2, p.getTime1().getIdTime());
            stmt.setInt(3, p.getTime2().getIdTime());
            stmt.setInt(4, p.getPlacarTime1());
            stmt.setInt(5, p.getPlacarTime2());
            stmt.setInt(6, p.getIdPartida());
            stmt.executeUpdate();
            System.out.println("Update compilado com sucesso!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Partida p) {
        String sql = "DELETE FROM partida WHERE idPartida = ?";
        try (PreparedStatement stmt = ConnectionFactory.createStatement(sql)) {
            stmt.setInt(1, p.getIdPartida());
            stmt.executeUpdate();
            System.out.println("Exclusão concluída com sucesso!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Partida findOne(int id) {
        String sql = "SELECT * FROM partida WHERE idPartida = ?";
        Partida p = null;
        TimeDAO timeDAO = new TimeDAO();
        Time t2;
        try (PreparedStatement stmt = ConnectionFactory.createStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            stmt.setInt(1, id);
            if (rs.next()) {
                p = new Partida(rs.getInt("idPartida"), rs.getString("dataJogo"),
                        timeDAO.findOne(rs.getInt("time1")), timeDAO.findOne(rs.getInt("time2"))
                        , rs.getInt("placarTime1"), rs.getInt("placarTime2"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return p;
    }

    @Override
    public List<Partida> findAll() {
        String sql = "SELECT * FROM partida";
        List<Partida> partidas = new ArrayList<>();

        Partida p;
        try (PreparedStatement stmt = ConnectionFactory.createStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                TimeDAO timeDAO = new TimeDAO();
                p = new Partida(rs.getInt("idPartida"), rs.getString("dataJogo"),
                        timeDAO.findOne(rs.getInt("time1")), timeDAO.findOne(rs.getInt("time2"))
                        , rs.getInt("placarTime1"), rs.getInt("placarTime2"));
                partidas.add(p);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return partidas;
    }
}
