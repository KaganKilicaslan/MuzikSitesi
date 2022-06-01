/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import dao.SarkiDao;
import entity.Sarki;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author ikbal
 */
@Named(value = "sarkiController")
@SessionScoped
public class SarkiController implements Serializable {

    private List<Sarki> sarkilar;
    private SarkiDao sarkiDao;
    private Sarki sarki;

    private int page = 1;
    private int pageSize = 10;
    private int pageCount;

    public void next() {
        if (this.page == this.getPageCount()) {
            this.page = 1;
        } else {
            this.page++;
        }
    }

    public void previous() {
        if (this.page == this.getPageCount()) {
            this.page = 1;
        } else {
            this.page--;
        }
    }

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
        this.pageCount = (int) Math.ceil(this.getSarkiDao().count() / (double) pageSize);
        return pageCount;

    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public void update() {
        sarkiDao.update(this.sarki);
        sarki = new Sarki();
    }

    public void delete(Sarki sarki) {
        sarkiDao.delete(sarki);
    }

    public void create() {
        sarkiDao.create(this.sarki);
        sarki = new Sarki();
    }

    public SarkiController() {
    }

    public List<Sarki> getSarkilar() {
        this.sarkilar = (List<Sarki>) this.getSarkiDao().findAll(page, pageSize);
        return sarkilar;
    }

    public void setSarkilar(List<Sarki> sarkilar) {
        this.sarkilar = sarkilar;
    }

    public SarkiDao getSarkiDao() {
        if (sarkiDao == null) {
            sarkiDao = new SarkiDao();
        }
        return sarkiDao;
    }

    public void setSarkiDao(SarkiDao sarkiDao) {
        this.sarkiDao = sarkiDao;
    }

    public Sarki getSarki() {
        if (this.sarki == null) {
            sarki = new Sarki();
        }
        return sarki;
    }

    public void setSarki(Sarki sarki) {
        this.sarki = sarki;
    }

    public void updateForm(Sarki sarki) {
        this.sarki = sarki;
    }

    public void clearForm() {
        this.sarki = new Sarki();
    }
}
