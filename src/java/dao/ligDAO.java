/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Lig;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import util.DBConnect;

/**
 *
 * @author muhenestugtekin
 */

public class ligDAO extends DBConnect {
private Connection connection;
    public Lig getById(int id){
        Lig l = null;
        try {
           connection=DBConnect.getConnection();
            PreparedStatement pst = connection.prepareStatement("select * from lig where id=?");
            pst.setLong(1, id);
            ResultSet rs=pst.executeQuery();
            rs.next();
            l = new Lig(rs.getLong("id"), rs.getString("isim"), rs.getString("ulke"), rs.getInt("piyasa_degeri"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        finally{
        DBConnect.closeConnection(connection);
        }
        return l;
    }
    
    public void create(Lig l) {
        try {
            connection=DBConnect.getConnection();
            PreparedStatement pst = connection.prepareStatement("insert into lig (isim, ulke, piyasa_degeri) values (?,?,?)");
                   pst.setString(1, l.getLigisim());
                   pst.setString(2, l.getUlke());
                   pst.setInt(3, l.getPiyasaDegeri());
                   pst.executeUpdate();
        } 
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        finally{
        DBConnect.closeConnection(connection);
        }
    }

    public List<Lig> read() {
        List<Lig> list = new ArrayList<>();
        try {
           connection=DBConnect.getConnection();
            PreparedStatement pst = connection.prepareStatement("select * from lig order by id asc");
            ResultSet rs=pst.executeQuery();
            while (rs.next()) {
                Lig tmp = new Lig(rs.getLong("id"), rs.getString("isim"), rs.getString("ulke"), rs.getInt("piyasa_degeri"));
                list.add(tmp);
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        finally{
        DBConnect.closeConnection(connection);
        }
        return list;
    }

    public void update(Lig l) {
        try {
            connection=DBConnect.getConnection();
            PreparedStatement pst = connection.prepareStatement("update lig set isim=?,ulke=?,piyasa_degeri=? where id=?");
            pst.setString(1, l.getLigisim());
                   pst.setString(2, l.getUlke());
                   pst.setInt(3, l.getPiyasaDegeri());
                   pst.setLong(4, l.getId());
                   pst.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        finally{
        DBConnect.closeConnection(connection);
        }
    }

    public void delete(Lig l) {
        try {
            connection=DBConnect.getConnection();
            PreparedStatement pst = connection.prepareStatement("delete from lig where id=" + l.getId());
            pst.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        finally{
        DBConnect.closeConnection(connection);
        }
    }

    List<Lig> getLiglist(Long id) {
        List<Lig> liglistesi=new ArrayList<>();
        try {
            connection=DBConnect.getConnection();
            PreparedStatement pst = connection.prepareStatement("select * from lig_takim where takim_id=?");
            pst.setLong(1, id);
            ResultSet rs=pst.executeQuery();
            while (rs.next()) {
                liglistesi.add(this.find(rs.getInt("lig_id")));
                }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        finally{
        DBConnect.closeConnection(connection);
        }
        return liglistesi;
    }
public Lig find(int lig_id){
Lig l=null;
    try {
            connection=DBConnect.getConnection();
            PreparedStatement pst = connection.prepareStatement("select * from lig where id="+lig_id);
            ResultSet rs=pst.executeQuery();
            rs.next();
            l=new Lig();
            l.setId(rs.getLong("id"));
            l.setLigisim(rs.getString("isim"));
            l.setUlke(rs.getString("ulke"));
            l.setPiyasaDegeri(rs.getInt("piyasa_degeri"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    finally{
        DBConnect.closeConnection(connection);
        }
return l;
}
}
