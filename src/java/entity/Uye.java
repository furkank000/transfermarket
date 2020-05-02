
package entity;

import java.sql.Date;

/**
 *
 * @author mehmet
 */
public class Uye {
    private int id;
    private String isim;
    private String soyisim;
    private String mail;
    private Date katilmaTarihi;

    public Uye() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getSoyisim() {
        return soyisim;
    }

    public void setSoyisim(String soyisim) {
        this.soyisim = soyisim;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Date getKatilmaTarihi() {
        return katilmaTarihi;
    }

    public void setKatilmaTarihi(Date katilmaTarihi) {
        this.katilmaTarihi = katilmaTarihi;
    }
    
    
}
