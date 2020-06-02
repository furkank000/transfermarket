package dao;

import entity.Oyuncu;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnect;

/**
 * @author mehmet
 */
public class OyuncuDao extends DBConnect {

    public List<Oyuncu> read() {
        List<Oyuncu> list = new ArrayList<>();
        try {
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("select id, isim, fktakim, dogum_tarihi, boy, mevki, ayak, piyasa_degeri, numara, uyruk from oyuncu order by id asc");
            while (rs.next()) {
                Oyuncu tmp = new Oyuncu(rs.getInt("id"), rs.getInt("fktakim"), rs.getString("isim"), rs.getDate("dogum_tarihi"), rs.getString("boy"), rs.getString("mevki"), rs.getString("ayak"), rs.getInt("piyasa_degeri"), rs.getInt("numara"), rs.getString("uyruk"));
                list.add(tmp);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }

    public void create(Oyuncu o) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("insert into oyuncu (fktakim, isim, dogum_tarihi, boy, mevki, ayak, piyasa_degeri, numara,uyruk) values(" + o.getFktakim() + ",'" + o.getIsim() + "'," + o.getDogumTarihi() + ",'" + o.getBoy() + "','" + o.getMevki() + "','" + o.getAyak() + "'," + o.getPiyasaDegeri() + "," + o.getNumara() + ",'" + o.getUyruk() + "')");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void update(Oyuncu o) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("update oyuncu set fktakim = " + o.getFktakim() + " where id = " + o.getId());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void delete(Oyuncu o) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("delete from oyuncu where id = " + o.getId());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

}
