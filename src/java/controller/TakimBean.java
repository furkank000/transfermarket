
package controller;

import dao.TakimDao;
import entity.Lig;
import entity.Takim;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author mehmet
 */
@Named
@SessionScoped
public class TakimBean implements Serializable {
    private TakimDao takimdao;
    private Takim takim;
    @Inject
    private LigBean liglerbean;
    
    
    public TakimBean() {
    }

    public void create(){
        this.getTakimdao().create(takim);
        this.formtemizle();
    }
    public List<Lig> getLigLists(){
    return this.getLiglerbean().getRead();
    }
    
    public List<Takim> getRead(){
        return this.getTakimdao().read();
    }
     public List<Takim> getRead2(){
        return this.getTakimdao().read2();
    }
    
    public void updateForm(Takim t){
        this.takim = t;
    }
    
    public void update(){
        this.getTakimdao().update(takim);
        this.formtemizle();
    }
    
    public void delete(Takim o){
        this.getTakimdao().delete(o);
    }

    public void formtemizle() {
        this.takim=new Takim();
    }
    public TakimDao getTakimdao() {
        if(this.takimdao==null)
            this.takimdao=new TakimDao();
        return takimdao;
    }

    public void setTakimdao(TakimDao takimdao) {
        this.takimdao = takimdao;
    }

    public Takim getTakim() {
        if(this.takim==null)
            this.takim=new Takim();
        return takim;
    }

    public void setTakim(Takim takim) {
        this.takim = takim;
    }

    public LigBean getLiglerbean() {
        if(this.liglerbean==null)
            this.liglerbean=new LigBean();
        return liglerbean;
    }
    
    
}
