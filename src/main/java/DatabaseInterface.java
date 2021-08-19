import java.sql.SQLException;
import java.util.List;

public interface DatabaseInterface {

    public void add(Client client) throws ClassNotFoundException, SQLException;
    public Client edit(Client client, String clientno) throws SQLException;
    public void delete(String clientno) throws SQLException;
    public List<Client> display() throws ClassNotFoundException, SQLException;
}
