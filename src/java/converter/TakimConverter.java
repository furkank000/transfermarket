
package converter;

import dao.TakimDao;
import entity.Takim;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author mehmet
 */
@FacesConverter(value = "TakimConverter")
public class TakimConverter implements Converter{

    private TakimDao takimdao;

    public TakimDao getTakimdao() {
        if(this.takimdao == null)
            this.takimdao = new TakimDao();
        return takimdao;
    }

    public void setTakimdao(TakimDao takimdao) {
        this.takimdao = takimdao;
    }
    
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        return this.getTakimdao().getById(Integer.valueOf(string));
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        Takim t = (Takim) o;
        return String.valueOf(t.getId());
    }
    
}
