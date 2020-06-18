package entity;


/**
 * @author mehmet
 */

public class Kullanici {

    private int kullanici_id;
    private String kullanici_adi;
    private String kullanici_sifre;
    private String kullanici_eski_sifre;
    private int kullanici_yetki;

    public Kullanici(int kullanici_id, String kullanici_adi, String kullanici_sifre) {
        this.kullanici_id = kullanici_id;
        this.kullanici_adi = kullanici_adi;
        this.kullanici_sifre = kullanici_sifre;
    }

    
    public Kullanici() {
    }

    
    public int getKullanici_id() {
        return kullanici_id;
    }

    public void setKullanici_id(int kullanici_id) {
        this.kullanici_id = kullanici_id;
    }

    public String getKullanici_adi() {
        return kullanici_adi;
    }

    public void setKullanici_adi(String kullanici_adi) {
        this.kullanici_adi = kullanici_adi;
    }

    public String getKullanici_sifre() {
        return kullanici_sifre;
    }

    public void setKullanici_sifre(String kullanici_sifre) {
        this.kullanici_sifre = kullanici_sifre;
    }

    public String getKullanici_eski_sifre() {
        return kullanici_eski_sifre;
    }

    public void setKullanici_eski_sifre(String kullanici_eski_sifre) {
        this.kullanici_eski_sifre = kullanici_eski_sifre;
    }

    public int getKullanici_yetki() {
        return kullanici_yetki;
    }

    public void setKullanici_yetki(int kullanici_yetki) {
        this.kullanici_yetki = kullanici_yetki;
    }

    @Override
    public String toString() {
        return "kullanici{" + "kullanici_id=" + kullanici_id + ", kullanici_adi=" + kullanici_adi + ", kullanici_sifre=" + kullanici_sifre + ", kullanici_eski_sifre=" + kullanici_eski_sifre + ", kullanici_yetki=" + kullanici_yetki + '}';
    }
     
 
}
