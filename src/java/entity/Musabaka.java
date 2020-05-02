
package entity;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author mehmet
 */
public class Musabaka {
    private int id;
    private int fktakim1;
    private int fktakim2;
    private String sonuc;
    private Date tarih;
    private int hafta;
    private Time saat;

    public Musabaka() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFktakim1() {
        return fktakim1;
    }

    public void setFktakim1(int fktakim1) {
        this.fktakim1 = fktakim1;
    }

    public int getFktakim2() {
        return fktakim2;
    }

    public void setFktakim2(int fktakim2) {
        this.fktakim2 = fktakim2;
    }

    public String getSonuc() {
        return sonuc;
    }

    public void setSonuc(String sonuc) {
        this.sonuc = sonuc;
    }

    public Date getTarih() {
        return tarih;
    }

    public void setTarih(Date tarih) {
        this.tarih = tarih;
    }

    public int getHafta() {
        return hafta;
    }

    public void setHafta(int hafta) {
        this.hafta = hafta;
    }

    public Time getSaat() {
        return saat;
    }

    public void setSaat(Time saat) {
        this.saat = saat;
    }
    
    
}
