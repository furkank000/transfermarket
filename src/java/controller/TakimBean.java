
package controller;

import dao.TakimDao;
import entity.Takim;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author mehmet
 */
@Named
@SessionScoped
public class TakimBean implements Serializable {
    private TakimDao dao;
    private Takim entity;

    public TakimBean() {
    }

    
    public TakimDao getDao() {
        if(this.dao == null)
            this.dao = new TakimDao();
        return dao;
    }

    public void setDao(TakimDao dao) {
        this.dao = dao;
    }

    public Takim getEntity() {
        if(this.entity == null)
            this.entity = new Takim();
        return entity;
    }

    public void setEntity(Takim entity) {
        this.entity = entity;
    }
    
    public String create(){
        this.getDao().create(entity);
        return "/takim/list";
    }
    
    public List<Takim> getRead(){
        return this.getDao().read();
    }
    
    public String updateForm(Takim o){
        this.entity = o;
        return "/takim/update";
    }
    
    public String update(){
        this.getDao().update(entity);
        return "/takim/list";
    }
    
    public void delete(Takim o){
        this.getDao().delete(o);
    }
}
