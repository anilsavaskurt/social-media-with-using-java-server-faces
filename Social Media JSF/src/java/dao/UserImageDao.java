package dao;
import util.Db;
import entity.Image;
import entity.Person;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserImageDao {
    
    
    public ArrayList<Image> All() {
        
         Db db = new Db();
         Connection con = db.connect();
         ArrayList<Image> imageList = new ArrayList<>();
            
        try {
            
            PreparedStatement ps = con.prepareStatement("SELECT * FROM IMAGE");
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                
                Image img = new Image();
                img.setUserId(rs.getInt("IMAGE_USERID"));
                img.setFilePath(rs.getString("PATH"));
                img.setFileName(rs.getString("NAME"));
                img.setFileType(rs.getString("TYPE"));
                imageList.add(img);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            try{
                con.close();
            }catch(Exception ex){
                ex.printStackTrace();
            }
        } 
        return imageList;
    }
    
    public Image getProfilePictrues(Person person){
        
         Db db = new Db();
         Connection con = db.connect();
         final String sql = "SELECT * FROM IMAGE WHERE IMAGE_USERID = ?";
         Image img = new Image();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, person.getId());
            ResultSet rs = ps.executeQuery();
         
            if(rs.next()){
                
                img.setUserId(rs.getInt("IMAGE_USERID"));
                img.setFilePath(rs.getString("PATH"));
                img.setFileName(rs.getString("NAME"));
                img.setFileType(rs.getString("TYPE"));
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            try{
                con.close();
            }catch(Exception ex){
                ex.printStackTrace();
            }
        } 
       return img;
    }
}
