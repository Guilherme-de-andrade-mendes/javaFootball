import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TimeDAO implements DAO<Time> {
    @Override
    public void save(Time t) {
        String sql = "INSERT INTO time (idTime, pais)" +
                "VALUES (?,?)";
        try (PreparedStatement stmt = ConnectionFactory.createStatement(sql)) {
            stmt.setInt(1, t.getIdTime());
            stmt.setString(2, t.getPais());
            stmt.executeUpdate();
            System.out.println("Time inserido com sucesso!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Time t) {
        String sql = "UPDATE time SET pais = ? WHERE idTime = ?";
        try (PreparedStatement stmt = ConnectionFactory.createStatement(sql)) {
            stmt.setString(1, t.getPais());
            stmt.setInt(2, t.getIdTime());
            stmt.executeUpdate();
            System.out.println("Update compilado com sucesso!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Time t) {
        String sql = "DELETE FROM time WHERE idTime = ?";
        try (PreparedStatement stmt = ConnectionFactory.createStatement(sql)) {
            stmt.setInt(1, t.getIdTime());
            stmt.executeUpdate();
            System.out.println("Exclusão concluída com sucesso!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Time findOne(int id) {
        String sql = "SELECT * FROM time WHERE idTime = ?";
        Time t = null;
        try (PreparedStatement stmt = ConnectionFactory.createStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                t = new Time(rs.getInt("idTime"), rs.getString("pais"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return t;
    }

    @Override
    public List<Time> findAll() {
        String sql = "SELECT * FROM time";
        List<Time> times = new ArrayList<>();
        Time t;
        try (PreparedStatement stmt = ConnectionFactory.createStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                t = new Time(rs.getInt("idTime"), rs.getString("pais"));
                times.add(t);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return times;
    }
}
