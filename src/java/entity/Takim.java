
package entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author mehmet
 */
public class Takim {
    private Long id;
    private int puan;
    private int sira;
    private int averaj;
    private String isim;
    private Oyuncu oyuncu;
    private List<Lig> Ligler;
    public Takim() {
    }

    public Takim(Long id, int puan, int sira, int averaj, String isim) {
        this.id = id;
        this.puan = puan;
        this.sira = sira;
        this.averaj = averaj;
        this.isim = isim;
        
    }
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public int getAveraj() {
        return averaj;
    }

    public void setAveraj(int averaj) {
        this.averaj = averaj;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.id);
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
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

  

    public List<Lig> getLigler() {
        if(this.Ligler==null)
            this.Ligler=new ArrayList<>();
        return Ligler;
    }

    public void setLigler(List<Lig> Ligler) {
        this.Ligler = Ligler;
    }

    public Oyuncu getOyuncu() {
        if(this.oyuncu==null)
            this.oyuncu=new Oyuncu();
        return oyuncu;
    }

    public void setOyuncu(Oyuncu oyuncu) {
        this.oyuncu = oyuncu;
    }
    
}
