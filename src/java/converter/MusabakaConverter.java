/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

import dao.musabakaDAO;
import entity.Musabaka;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author muhenestugtekin
 */
@FacesConverter(value = "MusabakaConverter")
public class MusabakaConverter implements Converter{

    private musabakaDAO musabakadao;
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
       return this.getMusabakadao().getById(Integer.valueOf(string));
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {
      Musabaka m = (Musabaka) t;
      return m.getId().toString();
    }

    public musabakaDAO getMusabakadao() {
        if(this.musabakadao==null)
            this.musabakadao=new musabakaDAO();
        return musabakadao;
    }
    
}
