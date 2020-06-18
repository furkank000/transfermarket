package dao;

import entity.Lig;
import entity.Takim;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnect;

/**
 * @author mehmet
 */
public class TakimDao extends DBConnect {
    private ligDAO ligdao;
    private Connection connection;
    List<Takim> takimlist;

    public List<Takim> read() {
        try {
            connection=DBConnect.getConnection();
            PreparedStatement pst = connection.prepareStatement("select * from takim order by id desc limit 10");
            ResultSet rs=pst.executeQuery();
            this.takimlist=new ArrayList<>();
            while (rs.next()) {
                Takim tmp=new Takim();
                tmp.setId(rs.getLong("id"));
                tmp.setPuan(rs.getInt("puan"));
                tmp.setSira(rs.getInt("sira"));
                tmp.setAveraj(rs.getInt("averaj"));
                tmp.setIsim(rs.getString("isim"));
                tmp.setLigler(this.getLigdao().getLiglist(tmp.getId()));
                getTakimlist().add(tmp);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        finally{
        DBConnect.closeConnection(connection);
        }
        return getTakimlist();
    }

    public void create(Takim o) {
        try {
            connection=DBConnect.getConnection();
            PreparedStatement pst = connection.prepareStatement("insert into takim (isim,puan,sira,averaj) values(?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, o.getIsim());
            pst.setInt(2, o.getPuan());
            pst.setInt(3, o.getSira());
            pst.setInt(4, o.getAveraj());
            int takimid=0;
            pst.executeUpdate();
            ResultSet gk=pst.getGeneratedKeys();
            if(gk.next()){
            takimid=gk.getInt(1);
            }
            
            for (Lig l:o.getLigler()){
            pst = connection.prepareStatement("insert into lig_takim values(?,?)");
            pst.setLong(1, l.getId());
            pst.setLong(2, takimid);
            pst.executeUpdate();
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        finally{
        DBConnect.closeConnection(connection);
        }

    }

    public void update(Takim o) {
        try {
            connection=DBConnect.getConnection();
            PreparedStatement pst = connection.prepareStatement("update takim set isim=?,puan=?,sira=?,averaj=? where id = ?");
            pst.setString(1, o.getIsim());
            pst.setInt(2, o.getPuan());
            pst.setInt(3, o.getSira());
            pst.setInt(4, o.getAveraj());
            pst.setLong(5, o.getId());
            pst.executeUpdate();
            pst = connection.prepareStatement("delete from lig_takim where takim_id = ?");
            pst.setLong(1, o.getId());
            pst.executeUpdate();
            for (Lig l:o.getLigler()){
            pst = connection.prepareStatement("insert into lig_takim values(?,?)");
            pst.setLong(1, l.getId());
            pst.setLong(2, o.getId());
            pst.executeUpdate();
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        finally{
        DBConnect.closeConnection(connection);
        }
    }

    public void delete(Takim o) {
        try {
            connection=DBConnect.getConnection();
            PreparedStatement pst = connection.prepareStatement("delete from lig_takim where takim_id = ?");
            pst.setLong(1, o.getId());
            pst.executeUpdate();
            pst = connection.prepareStatement("delete from takim where id = ?");
            pst.setLong(1, o.getId());
            pst.executeUpdate();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        finally{
        DBConnect.closeConnection(connection);
        }
    }
        public Takim getById(Long id) {
        Takim t = null;
        try {
            connection=DBConnect.getConnection();
            PreparedStatement pst = connection.prepareStatement("select * from takim where id = ?");
            pst.setLong(1, id);
            ResultSet rs=pst.executeQuery();
            rs.next();
            t = new Takim(rs.getLong("id"), rs.getInt("puan"), rs.getInt("sira"), rs.getInt("averaj"), rs.getString("isim"));
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
         finally{
        DBConnect.closeConnection(connection);
        }
        
        return t;
    }
        public int count() {
        int count = 0;
        try {
            connection=DBConnect.getConnection();
            PreparedStatement pst = connection.prepareStatement("select count(id) as takim_count from takim ");
            ResultSet rs = pst.executeQuery();
            rs.next();
            count = rs.getInt("takim_count");
            } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        finally{
        DBConnect.closeConnection(connection);
        }
        return count;
    }
        public List<Takim> read2() {
        try {
            connection=DBConnect.getConnection();
            PreparedStatement pst = connection.prepareStatement("select * from takim");
            ResultSet rs=pst.executeQuery();
            this.takimlist=new ArrayList<>();
            while (rs.next()) {
                Takim tmp=new Takim();
                tmp.setId(rs.getLong("id"));
                tmp.setPuan(rs.getInt("puan"));
                tmp.setSira(rs.getInt("sira"));
                tmp.setAveraj(rs.getInt("averaj"));
                tmp.setIsim(rs.getString("isim"));
                tmp.setLigler(this.getLigdao().getLiglist(tmp.getId()));
                getTakimlist().add(tmp);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        finally{
        DBConnect.closeConnection(connection);
        }
        return getTakimlist();
    }

    public ligDAO getLigdao() {
        if(this.ligdao==null)
            this.ligdao=new ligDAO();
        return ligdao;
    }

    public List<Takim> getTakimlist() {
        if(this.takimlist==null)
            this.takimlist=new ArrayList<>();
        return takimlist;
    }

    

}
