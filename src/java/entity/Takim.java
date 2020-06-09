
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

    public Takim(int id, int fklig, int puan, int sira, int avarage, String isim, String teknikDirektur, String golDegerleri) {
        this.id = id;
        this.fklig = fklig;
        this.puan = puan;
        this.sira = sira;
        this.avarage = avarage;
        this.isim = isim;
        this.teknikDirektur = teknikDirektur;
        this.golDegerleri = golDegerleri;
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

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Takim other = (Takim) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
}
