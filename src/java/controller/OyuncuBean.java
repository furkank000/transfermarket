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

    private int page = 1;
    private int pageSize = 10;
    private int pageCount;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageCount() {
        this.pageCount = (int) Math.ceil(this.getDao().count() / (double) pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public void next() {
        if (this.page == this.getPageCount()) {
            this.page = 1;
        } else {
            this.page++;
        }
    }

    public void previous() {
        if (this.page == 1) {
            this.page = this.getPageCount();
        } else {
            this.page--;
        }
    }

    public OyuncuBean() {
    }

    public OyuncuDao getDao() {
        if (this.dao == null) {
            this.dao = new OyuncuDao();
        }
        return dao;
    }

    public void setDao(OyuncuDao dao) {
        this.dao = dao;
    }

    public Oyuncu getEntity() {
        if (this.entity == null) {
            this.entity = new Oyuncu();
        }
        return entity;
    }

    public void setEntity(Oyuncu entity) {
        this.entity = entity;
    }

    public String create() {
        this.getDao().create(entity);
        return "/oyuncu/list";
    }

    public List<Oyuncu> getRead() {
        return this.getDao().read(page, pageSize);
    }

    public String updateForm(Oyuncu o) {
        this.entity = o;
        return "/oyuncu/update";
    }

    public String update() {
        this.getDao().update(entity);
        return "/oyuncu/list";
    }

    public void delete(Oyuncu o) {
        this.getDao().delete(o);
    }
}
