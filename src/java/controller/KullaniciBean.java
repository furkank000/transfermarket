

package controller;

import dao.KullaniciDAO;
import entity.Kullanici;
import java.io.Serializable;
import java.sql.SQLException;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import util.NavigationBean;

/**
 * @author mehmet
 */
@Named
@SessionScoped
public class KullaniciBean implements Serializable{
    private KullaniciDAO kullaniciDAO;
    private Kullanici kullanici;
    private int page=1;
    private int pageSize=5;
    private int pageCount;
    NavigationBean navigate;

    public KullaniciBean() {
    }
    public void giris() throws SQLException{
        if(this.kullanici==null){
        this.kullanici =new Kullanici();}
        this.getKullaniciDAO().giris(kullanici);
    }
    public String gonder() throws SQLException{
    this.giris();
    if(getKullaniciDAO().isLogin()==true&&getKullaniciDAO().isAdmin()==true){
    return getNavigate().adminpage("admin");
    }
    else if(getKullaniciDAO().isLogin()==true&&getKullaniciDAO().isAdmin()==false)
    {
    return getNavigate().secretpage("secret");
    }
    else{
        return getNavigate().modulepage("kullanicigirisi");
    }
    }
    
    public void ileri(){
        if(this.page==this.getPageCount())
            this.page=1;
        else
    this.page++;}
   public void geri(){
       if(this.page==1)
           this.page=this.getPageCount();
       else
   this.page--;}

    public KullaniciDAO getKullaniciDAO() {
        if(this.kullaniciDAO==null)
            this.kullaniciDAO=new KullaniciDAO();
        return kullaniciDAO;
    }

    public Kullanici getKullanici() {
        if(this.kullanici==null)
            this.kullanici=new Kullanici();
        return kullanici;
    }

    public void setKullanici(Kullanici kullanici) {
        this.kullanici = kullanici;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageCount() {
        this.pageCount=(int)Math.ceil(this.getKullaniciDAO().count()/(double)pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
    public NavigationBean getNavigate() {
        if(this.navigate==null)
            this.navigate=new NavigationBean();
        return navigate;
    }
    
    
}
