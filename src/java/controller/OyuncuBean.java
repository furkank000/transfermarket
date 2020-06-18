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

    private OyuncuDao oyuncudao;
    private Oyuncu oyuncu;

    private int page = 1;
    private int pageSize = 5;
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
        this.pageCount = (int) Math.ceil(this.getOyuncudao().count() / (double) pageSize);
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

    

    public void create() {
        this.getOyuncudao().create(oyuncu);
        this.formtemizle();
    }

    public List<Oyuncu> getRead() {
        return this.getOyuncudao().read(page, pageSize);
    }

    public void updateForm(Oyuncu o) {
        this.oyuncu = o;
    }

    public void update() {
        this.getOyuncudao().update(oyuncu);
        this.formtemizle();
    }

    public void delete(Oyuncu o) {
        this.getOyuncudao().delete(o);
    }

     public void formtemizle() {
        this.oyuncu=new Oyuncu();
    }
    public OyuncuDao getOyuncudao() {
        if(this.oyuncudao==null)
            this.oyuncudao=new OyuncuDao();
        return oyuncudao;
    }

    public void setOyuncudao(OyuncuDao oyuncudao) {
        this.oyuncudao = oyuncudao;
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
