
package entity;

/**
 *
 * @author mehmet
 */
public class Takim {
    private int id;
    private int fklig;
    private int puan;
    private int sira;
    private int avarage;
    private String isim;
    private String teknikDirektur;
    private String golDegerleri;

    public Takim() {
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFklig() {
        return fklig;
    }

    public void setFklig(int fklig) {
        this.fklig = fklig;
    }

    public int getPuan() {
        return puan;
    }

    public void setPuan(int puan) {
        this.puan = puan;
    }

    public int getSira() {
        return sira;
    }

    public void setSira(int sira) {
        this.sira = sira;
    }

    public int getAvarage() {
        return avarage;
    }

    public void setAvarage(int avarage) {
        this.avarage = avarage;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getTeknikDirektur() {
        return teknikDirektur;
    }

    public void setTeknikDirektur(String teknikDirektur) {
        this.teknikDirektur = teknikDirektur;
    }

    public String getGolDegerleri() {
        return golDegerleri;
    }

    public void setGolDegerleri(String golDegerleri) {
        this.golDegerleri = golDegerleri;
    }
    
}