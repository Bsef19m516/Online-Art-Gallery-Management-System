
import java.util.*; 
import java.sql.*; 

public class CustomerDAO{ 

private Connection con; 

public CustomerDAO() throws ClassNotFoundException,SQLException{
establishConnection(); } 

private void establishConnection() throws ClassNotFoundException,SQLException{ 
Class.forName("com.mysql.jdbc.Driver"); 
String conUrl = "jdbc:mysql://127.0.0.1/project"; 
con = DriverManager.getConnection(conUrl,"root","root"); 
} 


public ArrayList retrieveCustomerList(String Name,String Password) throws SQLException { 

ArrayList customerList = new ArrayList(); 

String sql = " SELECT * FROM customerinfo WHERE uname = ? and password =?" ; 
PreparedStatement pStmt = con.prepareStatement(sql); 
pStmt.setString( 1, Name);
pStmt.setString( 2, Password); 


ResultSet rs = pStmt.executeQuery(); 

String name; 
String add; 
int pNo; 
String password; 
String confirm_password;
  

while ( rs.next() ) { 
name = rs.getString("uname"); 
add = rs.getString("address"); 
pNo = rs.getInt("phoneNumber"); 
password= rs.getString("password"); 
confirm_password = rs.getString("confirm_password"); 


CustomerInfo customerBean = new CustomerInfo(); 
customerBean.setName(name); 
customerBean.setAddress(add); 
customerBean.setPhoneNum(pNo); 
customerBean.setPassword(password); 
customerBean.setConfirm_password(confirm_password);


customerList.add(customerBean); 

} 

 return customerList; 

}

public void addCustomer(CustomerInfo customer) throws SQLException{ 

String sql = " INSERT INTO customerinfo VALUES (?, ?, ?,?,?)"; 
PreparedStatement pStmt = con.prepareStatement(sql); 

String name = customer.getName(); 
String add = customer.getAddress(); 
int pNo = customer.getPhoneNum(); 
String password = customer.getPassword(); 
String confirm_password = customer.getConfirm_password(); 


pStmt.setString( 1 , name ); 
pStmt.setString( 2 , add ); 
pStmt.setInt( 3 , pNo );
pStmt.setString( 4 , password ); 
pStmt.setString( 5 , confirm_password ); 

pStmt.executeUpdate(); 

} 



}
