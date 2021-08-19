import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseService implements DatabaseInterface{

    Connection con;

    public DatabaseService(Connection con){
        this.con = con;
    }

    @Override
    public void add(Client client) throws ClassNotFoundException, SQLException {
        String quer1 =  "INSERT INTO loantable VALUES(?,?,?,?,?)";
        PreparedStatement query = con.prepareStatement(quer1);

        query.setString(1,client.getClientno());
        query.setString(2,client.getClientname());
        query.setDouble(3,client.getLoanamount());
        query.setInt(4,client.getYears());
        query.setString(5,client.getLoantype());

    }

    @Override
    public Client edit(Client client, String clientno) throws SQLException {
        PreparedStatement query;
        query = con.prepareStatement("Update loantable set years=?,clientname=?,loanamount=?,loantype=? where clientno=?");
        query.setString(1,client.getClientno());
        query.setString(2,client.getClientname());
        query.setDouble(3,client.getLoanamount());
        query.setInt(4,client.getYears());
        query.setString(5,client.getLoantype());

        query.executeUpdate();
        return client;
    }

    @Override
    public void delete(String clientno) throws SQLException {

        String quer1 = "Delete from loantable where clientno=?";
        PreparedStatement query = con.prepareStatement(quer1);
        query.setString(1,clientno);
        query.executeUpdate();
    }

    @Override
    public List<Client> display() throws ClassNotFoundException, SQLException {
        List<Client> clientList = new ArrayList<Client>();

        String quer1 = "SELECT * from loantable";
        PreparedStatement query = con.prepareStatement(quer1);
        ResultSet rs = query.executeQuery();

        Client obj1;

        while(rs.next()){
            obj1 = new Client(rs.getString("clientno"),rs.getString("clientname"),
                    rs.getDouble("loanamount"),rs.getInt("years"),rs.getString("loantype"));

            clientList.add(obj1);
        }
        return clientList;
    }
}
