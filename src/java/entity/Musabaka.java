
package entity;

import java.util.Objects;

/**
 *
 * @author muhenestugtekin
 */
public class Musabaka {
    private Long id=null;
    private String sonuc;
    private int hafta;
    private Takim takim1;
    private Takim takim2;

    public Musabaka(Long id,  String sonuc, int hafta,Takim takim1,Takim takim2) {
        this.id = id;
        this.sonuc = sonuc;
        this.hafta = hafta;
        this.takim1=takim1;
        this.takim2=takim2;
    }

    public Musabaka() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

  

    public String getSonuc() {
        return sonuc;
    }

    public void setSonuc(String sonuc) {
        this.sonuc = sonuc;
    }

    public int getHafta() {
        return hafta;
    }

    public void setHafta(int hafta) {
        this.hafta = hafta;
    }


    public Takim getTakim1() {
        if(this.takim1==null)
            this.takim1=new Takim();
        return takim1;
    }

    public void setTakim1(Takim takim1) {
        this.takim1 = takim1;
    }
         public Takim getTakim2() {
        if(this.takim2==null)
            this.takim2=new Takim();
        return takim2;
    }

    public void setTakim2(Takim takim2) {
        this.takim2 = takim2;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.id);
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
        final Musabaka other = (Musabaka) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
}
