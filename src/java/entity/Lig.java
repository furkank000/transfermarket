
package entity;

/**
 *
 * @author mehmet
 */
public class Lig {
    private int id;
    private String isim;
    private String ulke;
    private int piyasaDegeri;

    public Lig() {
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

    public String getUlke() {
        return ulke;
    }

    public void setUlke(String ulke) {
        this.ulke = ulke;
    }

    public int getPiyasaDegeri() {
        return piyasaDegeri;
    }

    public void setPiyasaDegeri(int piyasaDegeri) {
        this.piyasaDegeri = piyasaDegeri;
    }
    
    
    
}
