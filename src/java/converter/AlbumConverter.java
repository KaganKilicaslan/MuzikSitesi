/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package converter;

import dao.AlbumDao;
import entity.Album;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

/**
 *
 * @author SENANUR PAKSOY
 */
@FacesConverter("albumConverter")
public class AlbumConverter implements Converter {

    AlbumDao dao;

    public AlbumDao getDao() {
        if (dao == null) {
            dao = new AlbumDao();
        }
        return dao;
    }

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        int id = Integer.valueOf(string);
        Album c = (Album) this.getDao().findById(id);
        return c;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {
        Album c = (Album) t;
        return String.valueOf(c.getAlbumID());
    }

}
