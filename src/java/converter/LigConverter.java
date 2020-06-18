/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

import dao.ligDAO;
import entity.Lig;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author muhenestugtekin
 */
@FacesConverter(value = "LigConverter")
public class LigConverter implements Converter{

    private ligDAO ligdao;
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
       return this.getLigdao().getById(Integer.valueOf(string));
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {
      Lig l = (Lig) t;
      return l.getId().toString();
    }

    public ligDAO getLigdao() {
        if(this.ligdao==null)
            this.ligdao=new ligDAO();
        return ligdao;
    }

   

}
