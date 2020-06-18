/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.*;
import entity.*;
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
public class MusabakaBean implements Serializable {

    private musabakaDAO musabakadao;
    private Musabaka musabaka;
    private TakimDao takimdao;
    private ligDAO ligdao;


    public void create() {
        this.getMusabakadao().create(musabaka);
        this.formtemizle();
    }
    

    public List<Musabaka> getRead() {
        return this.getMusabakadao().read();
    }

    public void updateForm(Musabaka m) {
        this.musabaka = m;
    }

    public void update() {
        this.getMusabakadao().update(musabaka);
        this.formtemizle();
    }

    public void delete(Musabaka m) {
        this.getMusabakadao().delete(m);
    }

    public void formtemizle() {
        this.musabaka=new Musabaka();
    }
    
    public MusabakaBean() {
    }
public List<Takim> getTakimRead() {
        return this.getTakimdao().read2();
    }

    public musabakaDAO getMusabakadao() {
        if(this.musabakadao==null)
            this.musabakadao=new musabakaDAO();
        return musabakadao;
    }

    public void setMusabakadao(musabakaDAO musabakadao) {
        this.musabakadao = musabakadao;
    }

    public Musabaka getMusabaka() {
        if(this.musabaka==null)
            this.musabaka=new Musabaka();
        return musabaka;
    }

    public void setMusabaka(Musabaka musabaka) {
        this.musabaka = musabaka;
    }

    public TakimDao getTakimdao() {
        if(this.takimdao==null)
            this.takimdao=new TakimDao();
        return takimdao;
    }

    public ligDAO getLigdao() {
        if(this.ligdao==null)
            this.ligdao=new ligDAO();
        return ligdao;
    }

    
    
}
