package dao;

import entity.Oyuncu;
import entity.Takim;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnect;

/**
 * @author mehmet
 */
public class OyuncuDao extends DBConnect {

    private TakimDao takim;

    public TakimDao getTakim() {
        if (this.takim == null) {
            this.takim = new TakimDao();
        }
        return takim;
    }

    public void setTakim(TakimDao takim) {
        this.takim = takim;
    }

    public List<Oyuncu> read(int page, int pageSize) {
        List<Oyuncu> list = new ArrayList<>();
        int start = (page - 1) * pageSize;
        try {
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("select id, isim, fktakim, dogum_tarihi, boy, mevki, ayak, piyasa_degeri, numara, uyruk from oyuncu order by id asc limit " + start + "," + pageSize);
            while (rs.next()) {
                Takim t = this.getTakim().getById(rs.getInt("fktakim"));
                Oyuncu tmp = new Oyuncu(rs.getInt("id"), t, rs.getString("isim"), rs.getDate("dogum_tarihi"), rs.getString("boy"), rs.getString("mevki"), rs.getString("ayak"), rs.getInt("piyasa_degeri"), rs.getInt("numara"), rs.getString("uyruk"));
                list.add(tmp);
            }
            st.close();
            rs.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }

    public int count() {
        int count = 0;
        try {
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("select count(id) as oyuncu_count from oyuncu ");
            rs.next();
            count = rs.getInt("oyuncu_count");
            st.close();
            rs.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return count;
    }

    public void create(Oyuncu o) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("insert into oyuncu (fktakim, isim, dogum_tarihi, boy, mevki, ayak, piyasa_degeri, numara,uyruk) values(" + o.getTakim().getId() + ",'" + o.getIsim() + "'," + o.getDogumTarihi() + ",'" + o.getBoy() + "','" + o.getMevki() + "','" + o.getAyak() + "'," + o.getPiyasaDegeri() + "," + o.getNumara() + ",'" + o.getUyruk() + "')");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void update(Oyuncu o) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("update oyuncu set fktakim = " + o.getTakim().getId() + " where id = " + o.getId());
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
