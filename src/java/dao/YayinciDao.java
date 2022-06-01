/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Yayinci;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DbConnection;

/**
 *
 * @author Kagan
 */
public class YayinciDao extends DbConnection {
    
    public List<Yayinci> list(){
        List<Yayinci> list = new ArrayList<>();
    
        try{
            Connection c = this.connect();
            Statement state = c.createStatement();
            String sorgu = "SELECT * from yayinci order by yayinciid";
            ResultSet  result = state.executeQuery(sorgu);
            while(result.next()){
            list.add(new Yayinci(
                    result.getInt(1),
                    result.getInt(2),
                    result.getInt(3),
                    result.getInt(4),
                    result.getString(5)
                    
            ));
         } 
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return list;
    }
    
     public List<Yayinci> findAll(int page,int pageSize){
        List<Yayinci> list = new ArrayList<>();
         int start = (page - 1) * pageSize;
        try{
            Connection c = this.connect();
            Statement state = c.createStatement();
            String sorgu = "SELECT * from yayinci order by yayinciid asc limit "+pageSize+" offset "+start;
            ResultSet  result = state.executeQuery(sorgu);
            while(result.next()){
            list.add(new Yayinci(
                    result.getInt(1),
                    result.getInt(2),
                    result.getInt(3),
                    result.getInt(4),
                    result.getString(5)
                    
            ));
         } 
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return list;
    }
    
      public int count(){
       int count =0;
    
        try{
            Connection c = this.connect();
            Statement state = c.createStatement();
            String sorgu = "SELECT count (yayinciid) as yayinci_count from yayinci";
            ResultSet  result = state.executeQuery(sorgu);
            result.next();
            count =result.getInt("yayinci_count");
            
            
         
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return count;
    }
    
    
    
        
         //Silme Fonk.   
    public String delete(Yayinci yayinci){
        
        try{
            Connection c = this.connect();
            Statement st = c.createStatement();
            String sql = "delete from yayinci where yayinciid = "+yayinci.getYayinciID();
            

            st.executeUpdate(sql);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return "index";
    }
    //Oluşturma Fonk.
     public String create(Yayinci yayinci){
        
        try{
            Connection c = this.connect();
            Statement st = c.createStatement();
            String sorgu = "insert into yayinci (yayinciad) values ('"+yayinci.getYayinciAd()+"')";
            

            st.executeUpdate(sorgu);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return "index";
    }    
     
     //Guncelleme Fonk.
    public String update(Yayinci yayinci){
        
        try{
            Connection c = this.connect();
            Statement st = c.createStatement();
            String sorgu = "update yayinci set yayinciad = '"+yayinci.getYayinciAd()+"' where yayinciid = '"+yayinci.getYayinciID()+"'";
            

            st.executeUpdate(sorgu);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return "index";
    }
       
}
