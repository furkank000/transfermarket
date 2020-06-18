/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Lig;
import entity.Musabaka;
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
public class musabakaDAO extends DBConnect {
    
    private ligDAO lDao;
    private Connection connection;
    private TakimDao takdao;

    

    public void create(Musabaka l) {
        try {
            connection=DBConnect.getConnection();
            PreparedStatement pst = connection.prepareStatement("insert into musabaka (id,takim1, takim2, sonuc, hafta) values (default,?,?,?,?)");
            pst.setLong(1, l.getTakim1().getId());
            pst.setLong(2, l.getTakim2().getId());
            pst.setString(3, l.getSonuc());
            pst.setInt(4, l.getHafta());
            pst.executeUpdate();

        } 
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        finally{
        DBConnect.closeConnection(connection);
        }
    }

    public List<Musabaka> read() {
        List<Musabaka> list = new ArrayList<>();
        try {
            connection=DBConnect.getConnection();
            PreparedStatement pst = connection.prepareStatement("select * from musabaka order by id asc");
            ResultSet rs=pst.executeQuery();
            while (rs.next()) {
                Musabaka tmp=new Musabaka(); 
                tmp.setId(rs.getLong("id"));
                tmp.setTakim1(this.getTakdao().getById(rs.getLong("takim1")));
                tmp.setTakim2(this.getTakdao().getById(rs.getLong("takim2")));
                tmp.setSonuc(rs.getString("sonuc"));
                tmp.setHafta(rs.getInt("hafta"));
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
    
    public void update(Musabaka l) {
        try {
            connection=DBConnect.getConnection();
            PreparedStatement pst = connection.prepareStatement("update musabaka set takim1=?,takim2=?,sonuc=?,hafta=? where id=?");
            pst.setLong(1, l.getTakim1().getId());
            pst.setLong(2, l.getTakim2().getId());
            pst.setString(3, l.getSonuc());
            pst.setInt(4, l.getHafta());
            pst.setLong(5, l.getId());
            pst.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        finally{
        DBConnect.closeConnection(connection);
        }
    }

    public void delete(Musabaka l) {
        try {
            connection=DBConnect.getConnection();
            PreparedStatement pst = connection.prepareStatement("delete from musabaka where id=" + l.getId());
            pst.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        finally{
        DBConnect.closeConnection(connection);
        }
    }
    
    public Musabaka getById(int id) {
        Musabaka m = null;
        try {
            connection=DBConnect.getConnection();
            PreparedStatement pst = connection.prepareStatement("select * from musabaka where id = ?");
            pst.setInt(1, id);
            ResultSet rs=pst.executeQuery();
            rs.next();
            m.setId(rs.getLong("id"));
            m.setTakim1(this.getTakdao().getById(rs.getLong("takim1")));
            m.setTakim2(this.getTakdao().getById(rs.getLong("takim2")));
            m.setSonuc(rs.getString("sonuc"));
            m.setHafta(rs.getInt("hafta"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
         finally{
        DBConnect.closeConnection(connection);
        }
        
        return m;
    }
    
    public ligDAO getlDao() {
        if (lDao == null) {
            this.lDao = new ligDAO();
        }
        return lDao;
    }

    public void setlDao(ligDAO lDao) {
        this.lDao = lDao;
    }

    public TakimDao getTakdao() {
        if(this.takdao==null)
            this.takdao=new TakimDao();
        return takdao;
    }
    
}
