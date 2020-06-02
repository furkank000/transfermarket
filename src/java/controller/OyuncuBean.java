
package controller;

import dao.OyuncuDao;
import entity.Oyuncu;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 * @author mehmet
 */
@Named
@SessionScoped
public class OyuncuBean implements Serializable {
    private OyuncuDao dao;
    private Oyuncu entity;

    public OyuncuBean() {
    }

    
    public OyuncuDao getDao() {
        if(this.dao == null)
            this.dao = new OyuncuDao();
        return dao;
    }

    public void setDao(OyuncuDao dao) {
        this.dao = dao;
    }

    public Oyuncu getEntity() {
        if(this.entity == null)
            this.entity = new Oyuncu();
        return entity;
    }

    public void setEntity(Oyuncu entity) {
        this.entity = entity;
    }
    
    public String create(){
        this.getDao().create(entity);
        return "/oyuncu/list";
    }
    
    public List<Oyuncu> getRead(){
        return this.getDao().read();
    }
    
    public String updateForm(Oyuncu o){
        this.entity = o;
        return "/oyuncu/update";
    }
    
    public String update(){
        this.getDao().update(entity);
        return "/oyuncu/list";
    }
    
    public void delete(Oyuncu o){
        this.getDao().delete(o);
    }
}
