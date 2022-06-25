//package MyPack;

//import MyPack.ArtistInfo;
import java.util.*; 
import java.sql.*; 

public class ArtistDAO{ 

private Connection con; 

public ArtistDAO() throws ClassNotFoundException,SQLException{
establishConnection(); } 

private void establishConnection() throws ClassNotFoundException,SQLException{ 
Class.forName("com.mysql.jdbc.Driver"); 
String conUrl = "jdbc:mysql://127.0.0.1/project"; 
con = DriverManager.getConnection(conUrl,"root","root"); 
} 

//
public ArrayList retrieveArtistList(String Name,String Password) throws SQLException { 

ArrayList artistList = new ArrayList(); 

String sql = " SELECT * FROM artistinfo WHERE uname = ? and password =?" ; 
PreparedStatement pStmt = con.prepareStatement(sql); 
pStmt.setString( 1, Name);
pStmt.setString( 2, Password); 


ResultSet rs = pStmt.executeQuery(); 

String name; 
String add; 
int pNo; 
String password; 
String confirm_password;
String itemid; 
String price;  

while ( rs.next() ) { 
name = rs.getString("uname"); 
add = rs.getString("address"); 
pNo = rs.getInt("phoneNumber"); 
password= rs.getString("password"); 
confirm_password = rs.getString("confirm_password"); 
itemid = rs.getString("itemId"); 
price = rs.getString("price"); 

ArtistInfo artistBean = new ArtistInfo(); 
artistBean.setName(name); 
artistBean.setAddress(add); 
artistBean.setPhoneNum(pNo); 
artistBean.setPassword(password); 
artistBean.setConfirm_password(confirm_password);
artistBean.setId(itemid); 
artistBean.setPrice(price);

artistList.add(artistBean); 

} 

 return artistList; 

}



public void addArtist(ArtistInfo artist) throws SQLException{ 

String sql = " INSERT INTO artistinfo VALUES (?, ?, ?,?,?,?,?)"; 
PreparedStatement pStmt = con.prepareStatement(sql); 

String name = artist.getName(); 
String add = artist.getAddress(); 
int pNo = artist.getPhoneNum(); 
String password = artist.getPassword(); 
String confirm_password = artist.getConfirm_password(); 
String id = artist.getId(); 
String price = artist.getPrice(); 

pStmt.setString( 1 , name ); 
pStmt.setString( 2 , add ); 
pStmt.setInt( 3 , pNo );
pStmt.setString( 4 , password ); 
pStmt.setString( 5 , confirm_password ); 
pStmt.setString( 6 , id ); 
pStmt.setString( 7 , price ); 

pStmt.executeUpdate(); 

} 

public ArrayList retrieveArtistlist() throws SQLException { 
ArrayList artistList = new ArrayList(); 
String sql = " SELECT * FROM artistinfo " ; 
PreparedStatement pStmt = con.prepareStatement(sql); 

ResultSet rs = pStmt.executeQuery(); 
String name; 
String add; 
int pNo; 
String password; 
String confirm_password;
String itemid; 
String price;  
while ( rs.next() ) { 
name = rs.getString("uname"); 
add = rs.getString("address"); 
pNo = rs.getInt("phoneNumber"); 
password= rs.getString("password"); 
confirm_password = rs.getString("confirm_password"); 
itemid = rs.getString("itemId"); 
price = rs.getString("price"); 
ArtistInfo artistBean = new ArtistInfo(); 
artistBean.setName(name); 
artistBean.setAddress(add); 
artistBean.setPhoneNum(pNo); 
artistBean.setPassword(password); 
artistBean.setConfirm_password(confirm_password);
artistBean.setId(itemid); 
artistBean.setPrice(price);
artistList.add(artistBean); 
} 
 return artistList; 
}



}
