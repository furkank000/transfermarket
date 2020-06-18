
package dao;

import entity.Kullanici;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import util.DBConnect;
import util.NavigationBean;

/**
 * @author muhenestugtekin
 */
public class KullaniciDAO {
    Connection connection;
    NavigationBean navigate;
    private static boolean admin;
    private static boolean login;
    
    
    public List<Kullanici> getList(int page,int pageSize) {
        List<Kullanici> kullanicilistesi = new ArrayList<>();
        int start=(page-1)*pageSize;
        try {
            connection=DBConnect.getConnection();
            PreparedStatement pst = connection.prepareStatement("select * from kullanici order by kullanici_id asc limit "+start+","+pageSize);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                kullanicilistesi.add(new Kullanici(rs.getInt("kullanici_id"), rs.getString("kullanici_adi"), rs.getString("kullanici_sifre")));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            DBConnect.closeConnection(connection);
        }
        return kullanicilistesi;
    }

    public double count() {
        int count=0;
       try {
            connection=DBConnect.getConnection();
            PreparedStatement pst = connection.prepareStatement("select count(kullanici_id) as kulllanici_count from kullanici");
            ResultSet rs = pst.executeQuery();
            rs.next();
            count=rs.getInt("kullanici_count");
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            DBConnect.closeConnection(connection);
        }
        return count;
    }


    public void giris(Kullanici kullanici) {
        int id=0;
        String ad=null;
        String sifre=null;
        int yetki=0;
       try {
        connection=DBConnect.getConnection();
        PreparedStatement pst=connection.prepareStatement("select * from kullanici where kullanici_adi=?");
        pst.setString(1,kullanici.getKullanici_adi());
          ResultSet rs = pst.executeQuery();
                rs.next();
                id=rs.getInt("kullanici_id");
                ad = rs.getString("kullanici_adi");
                sifre=rs.getString("kullanici_sifre");
                yetki=rs.getInt("kullanici_yetki");
                if (id==0) {
                getNavigate().modulepage("kullanicigirisi");
                this.setLogin(false);
                }
                else if(id!=0){
       if(sifre.equals(kullanici.getKullanici_sifre())){
           FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("gelen_kullanici",kullanici);
           this.setLogin(true);
           if(yetki==1){
           getNavigate().adminpage("admin");
           this.setAdmin(true);
           }
           else{
           getNavigate().secretpage("secret");
           this.setAdmin(false);
           }
           }
       }
       else{
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Kullanıcı adı veya şifre hatalı!!!!", null);
                FacesContext.getCurrentInstance().addMessage(null, msg);
                this.setLogin(false);
           getNavigate().modulepage("kullanicigirisi");
       }
       }
         catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    finally {
            DBConnect.closeConnection(connection);
        }
    }
    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public NavigationBean getNavigate() {
        if(this.navigate==null)
            this.navigate=new NavigationBean();
        return navigate;
    }

    public boolean isLogin() {
        return login;
    }

    public void setLogin(boolean login) {
        this.login = login;
    }
    
}
