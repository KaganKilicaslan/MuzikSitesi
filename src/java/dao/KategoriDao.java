/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;



import entity.Kategori;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DbConnection;

/**
 *
 * @author karao
 */
public class KategoriDao extends DbConnection {
    public List<Kategori> list(){
        List<Kategori> list = new ArrayList<>();

      try{
            Connection c = this.connect();
            Statement state = c.createStatement();
            String sorgu = "SELECT * from kategori order by kategoriid";
            ResultSet  result = state.executeQuery(sorgu);
            while(result.next()){
            list.add(new Kategori(
                    result.getInt(1),
                    result.getString(2)
                    
            ));
         }
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return list;
    }
    
      public List<Kategori> findAll(int page,int pageSize){
        List<Kategori> list = new ArrayList<>();
        int start = (page - 1) * pageSize;
      try{
            Connection c = this.connect();
            Statement state = c.createStatement();
            String sorgu = "SELECT * from kategori  order by kategoriid asc limit "+pageSize+","+start;
            ResultSet  result = state.executeQuery(sorgu);
            while(result.next()){
            list.add(new Kategori(
                    result.getInt(1),
                    result.getString(2)
                    
            ));
         }
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return list;
    }
      
        public int count(){
        int count=0;
      try{
            Connection c = this.connect();
            Statement state = c.createStatement();
            String sorgu = "SELECT count (kategori)as kategori_count from kategori";
            ResultSet  result = state.executeQuery(sorgu);
             result.next();
             count = result.getInt("kategori_count");
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return count;
    }
    
    
    
     //Silme Fonksiyonu
    public String delete(Kategori kategori){
        
        try{
            Connection c = this.connect();
            Statement st = c.createStatement();
            String sql = "delete from kategori where kategoriid = "+kategori.getKategoriID();
            

            st.executeUpdate(sql);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return "index";
    }
    //..Oluşturma Fonksiyonu 
    public String create(Kategori kategori){
        
        try{
            Connection c = this.connect();
            Statement st = c.createStatement();
            String sorgu = "insert into kategori (kategoriadi) values ('"+kategori.getKategoriAdi()+"')";
            

            st.executeUpdate(sorgu);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return "index";
    }
    
    //..Güncelleme Fonksiyonu 
    public String update(Kategori kategori){
        
        try{
            Connection c = this.connect();
            Statement st = c.createStatement();
            String sorgu = "update kategori set kategoriadi = '"+kategori.getKategoriAdi()+"' where kategoriid = '"+kategori.getKategoriID()+"'";
            

            st.executeUpdate(sorgu);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return "index";
    }
    
}