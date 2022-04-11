/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package converter;

import dao.SanatciDao;
import entity.Sanatci;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

/**
 *
 * @author SENANUR PAKSOY
 */
@FacesConverter("sanatciConverter")
public class SanatciConventer implements Converter{
     SanatciDao dao;

    public SanatciDao getDao() {
        if (dao == null) {
            dao = new SanatciDao();
        }
        return dao;
    }

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        int id = Integer.valueOf(string);
        Sanatci c = (Sanatci) this.getDao().findById(id);
        return c;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {
        Sanatci c = (Sanatci) t;
        return String.valueOf(c.getSanatciid());
    }

   
}
