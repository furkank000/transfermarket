
package entity;

import java.util.Objects;

/**
 *
 * @author muhenestugtekin
 */
public class Lig {
    private Long id;
    private String ligisim;
    private String ulke;
    private int piyasaDegeri;
    

    public Lig(Long id, String ligisim, String ulke, int piyasaDegeri) {
        this.id = id;
        this.ligisim = ligisim;
        this.ulke = ulke;
        this.piyasaDegeri = piyasaDegeri;
    }

    public Lig() {
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLigisim() {
        return ligisim;
    }

    public void setLigisim(String ligisim) {
        this.ligisim = ligisim;
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.id);
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
        final Lig other = (Lig) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
    
}
