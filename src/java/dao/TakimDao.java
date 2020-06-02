package dao;

import entity.Takim;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnect;

/**
 * @author mehmet
 */
public class TakimDao extends DBConnect {

    public List<Takim> read() {
        List<Takim> list = new ArrayList<>();
        try {
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("select id, isim, fklig, teknik_direktur, sira, avarage, gol_degerleri, puan from takim order by id asc");
            while (rs.next()) {
                Takim tmp = new Takim(rs.getInt("id"), rs.getInt("fklig"), rs.getInt("puan"), rs.getInt("sira"), rs.getInt("avarage"), rs.getString("isim"), rs.getString("teknik_direktur"), rs.getString("gol_degerleri"));
                list.add(tmp);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }

    public void create(Takim o) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("insert into takim (fklig, isim, teknik_direktur) values(" + o.getFklig() + ",'" + o.getIsim() + "','" + o.getTeknikDirektur() + "')");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void update(Takim o) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("update takim set fklig = " + o.getFklig()+ " where id = " + o.getId());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void delete(Takim o) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("delete from takim where id = " + o.getId());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

}
