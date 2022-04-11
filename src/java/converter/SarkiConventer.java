/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package converter;

import dao.SarkiDao;
import entity.Sarki;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

/**
 *
 * @author SENANUR PAKSOY
 */
@FacesConverter("sarkiConverter")
public class SarkiConventer implements Converter{
       SarkiDao dao;

    public SarkiDao getDao() {
        if (dao == null) {
            dao = new SarkiDao();
        }
        return dao;
    }

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        int id = Integer.valueOf(string);
        Sarki c = (Sarki) this.getDao().findById(id);
        return c;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {
        Sarki c = (Sarki) t;
        return String.valueOf(c.getSarkiID());
    }
}
