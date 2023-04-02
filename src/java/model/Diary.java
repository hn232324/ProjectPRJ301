/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import dal.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author DELL
 */
public class Diary {
   int id;
   String Title;
   String Note;
   String crday;
   String uday;
   int aid;
   int fid;
   
   public Diary() {
       connect();
    }

    public Diary(int id, String Title, String Note,String crday, String uday, int aid) {
        this.id = id;
        this.Title = Title;
        this.Note = Note;
        this.crday = crday;
        this.uday = uday;
        this.aid = aid;
        
        connect();
    }

    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public String getNote() {
        return Note;
    }

    public void setNote(String Note) {
        this.Note = Note;
    }

    public String getCrday() {
        return crday;
    }

    public void setCrday(String crday) {
        this.crday = crday;
    }

    public String getUday() {
        return uday;
    }

    public void setUday(String uday) {
        this.uday = uday;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }
    Connection cnn; //Ket noi SQL
    Statement stm; // Thu thi cau lenh
    PreparedStatement pstm;
    ResultSet rs;
    public void connect() {
        try {
            cnn = (new DBContext()).connection;
            if (cnn != null) {
                System.out.println("Connect Successfull");
            }
        } catch (Exception e) {
            System.out.println("Fail: " + e.getMessage());
        }
    }
    
    void delete(Diary d) {
        try {
            String sql = "delete from Diary "
                    + "where id=? ";
            pstm = cnn.prepareStatement(sql);
            pstm.setInt(1, Integer.parseInt(sql));
            pstm.execute();

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

   
}
