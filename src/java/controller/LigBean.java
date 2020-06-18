
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ligDAO;
import entity.Lig;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author muhenestugtekin
 */
@Named
@SessionScoped
public class LigBean implements Serializable {

    private ligDAO ligdao;
    private Lig lig;

    
    public LigBean() {
    }

    public void create() {
        this.getLigdao().create(lig);
        this.formtemizle();
    }

    public List<Lig> getRead() {
        return this.getLigdao().read();
    }

    public void updateForm(Lig l) {
        this.lig = l;
    }

    public void update() {
        this.getLigdao().update(lig);
        this.formtemizle();
    }

    public void delete(Lig l) {
        this.getLigdao().delete(l);
    }

    public void formtemizle() {
        this.lig=new Lig();
    }
    public ligDAO getLigdao() {
        if(this.ligdao==null)
            this.ligdao=new ligDAO();
        return ligdao;
    }

    public void setLigdao(ligDAO ligdao) {
        this.ligdao = ligdao;
    }

    public Lig getLig() {
        if(this.lig==null)
            this.lig=new Lig();
        return lig;
    }

    public void setLig(Lig lig) {
        this.lig = lig;
    }

    

 

}
