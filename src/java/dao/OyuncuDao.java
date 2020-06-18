package dao;

import entity.Oyuncu;
import entity.Takim;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import util.DBConnect;

/**
 * @author mehmet
 */
public class OyuncuDao {
    private Connection connection;

    private TakimDao takimdao;

    public List<Oyuncu> read(int page, int pageSize) {
        List<Oyuncu> list = new ArrayList<>();
        int start = (page - 1) * pageSize;
        try {
            connection=DBConnect.getConnection();
            PreparedStatement pst = connection.prepareStatement("select id, isim, fktakim,  boy, mevki, ayak, piyasa_degeri, numara, uyruk from oyuncu order by id asc limit " + start + "," + pageSize);        
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Takim t = this.getTakimdao().getById(rs.getLong("fktakim"));
                Oyuncu tmp = new Oyuncu(rs.getLong("id"), t, rs.getString("isim"), rs.getString("boy"), rs.getString("mevki"), rs.getString("ayak"), rs.getInt("piyasa_degeri"), rs.getInt("numara"), rs.getString("uyruk"));
                list.add(tmp);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        finally{
        DBConnect.closeConnection(connection);
        }
        return list;
    }

    public int count() {
        int count = 0;
        try {
            connection=DBConnect.getConnection();
            PreparedStatement pst = connection.prepareStatement("select count(id) as oyuncu_count from oyuncu ");
            ResultSet rs = pst.executeQuery();
            rs.next();
            count = rs.getInt("oyuncu_count");
            } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        finally{
        DBConnect.closeConnection(connection);
        }
        return count;
    }

    public void create(Oyuncu o) {
        try {
            connection=DBConnect.getConnection();
            PreparedStatement pst = connection.prepareStatement("insert into oyuncu (id,fktakim, isim, boy, mevki, ayak, piyasa_degeri, numara,uyruk) values(default,?,?,?,?,?,?,?,?)");
            pst.setLong(1, o.getTakim().getId());
            pst.setString(2, o.getIsim());
            pst.setString(3,o.getBoy());
            pst.setString(4,o.getMevki());
            pst.setString(5, o.getAyak());
            pst.setInt(6, o.getPiyasaDegeri());
            pst.setInt(7, o.getNumara());
            pst.setString(8, o.getUyruk());
            pst.executeUpdate();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        finally{
        DBConnect.closeConnection(connection);
        }
    }

    public void update(Oyuncu o) {
        try {
            connection=DBConnect.getConnection();
            PreparedStatement pst = connection.prepareStatement("update oyuncu set fktakim=?,isim=?,boy=?,mevki=?,ayak=?,piyasa_degeri=?,numara=?,uyruk=?  where id=?");
            pst.setLong(1, o.getTakim().getId());
            pst.setString(2, o.getIsim());
            pst.setString(3,o.getBoy());
            pst.setString(4,o.getMevki());
            pst.setString(5, o.getAyak());
            pst.setInt(6, o.getPiyasaDegeri());
            pst.setInt(7, o.getNumara());
            pst.setString(8, o.getUyruk());
            pst.setLong(9, o.getId());
            pst.executeUpdate();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        finally{
        DBConnect.closeConnection(connection);
        }
    }

    public void delete(Oyuncu o) {
        try {
            connection=DBConnect.getConnection();
            PreparedStatement pst = connection.prepareStatement("delete from oyuncu where id = " + o.getId());
            pst.executeUpdate();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        finally{
        DBConnect.closeConnection(connection);
        }
    }
public TakimDao getTakimdao() {
        if (this.takimdao == null) 
            this.takimdao = new TakimDao();
        return takimdao;
    }

    public void setTakim(TakimDao takimdao) {
        this.takimdao = takimdao;
    }

}
