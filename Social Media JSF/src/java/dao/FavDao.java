package dao;
import util.Db;
import entity.Person;
import entity.Post;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FavDao {
    
    public void addLike(Post post){
        
        Db db = new Db();
        Connection con = db. connect();
        
         final String sqlSelect = "SELECT * FROM FAV WHERE FAV_USERID = ? AND FAV_POSTID = ?";
         final String sql = "INSERT INTO FAV(FAV_USERID,FAV_POSTID) VALUES(?,?)";
         final String sqlFavIncrement = "UPDATE POST SET LIKES = LIKES+1 WHERE POSTID = ?";
         final String sqlDislike = "DELETE FROM FAV WHERE FAV_POSTID = ?";
         final String sqlFavDiscrement = "UPDATE POST SET LIKES = LIKES-1 WHERE POSTID = ?";
         PreparedStatement ps = null;
         int count = 0;
        
        try{
            ps =con.prepareStatement(sqlSelect);
            ps.setInt(1, Person.PersonInstance.getId());
            ps.setInt(2, post.getId());
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                ps = con.prepareStatement(sqlDislike);
                ps.setInt(1, post.getId());
                ps.execute();
                
                ps=con.prepareStatement(sqlFavDiscrement);
                ps.setInt(1, post.getId());
                ps.executeUpdate();
                
            }else{

                    ps =con.prepareStatement(sql);
                    ps.setInt(1, Person.PersonInstance.getId());
                    ps.setInt(2, post.getId());
                    count = ps.executeUpdate();
                    if(count != 0){
                        ps = con.prepareStatement(sqlFavIncrement);
                        ps.setInt(1, post.getId());
                        ps.execute();
                    }
            }      
            
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try{
                con.close();
            }catch(Exception ex){
                ex.printStackTrace();
            }
        } 
    }
}
