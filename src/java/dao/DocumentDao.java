/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Document;
import java.util.ArrayList;
import java.util.List;
import util.DbConnection;

/**
 *
 * @author ikbal
 */
public class DocumentDao extends DbConnection {
    public List<Document>findAll(){
        List<Document>dList=new ArrayList<>();
        
        return dList;
        
    }
}
