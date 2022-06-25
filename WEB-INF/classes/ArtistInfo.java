//package MyPack;

import java.io.*; 
public class ArtistInfo implements Serializable{ 

private String name; 
private String address; 
private int phoneNum;
private String password; 
private String confirm_password; 
private String id; 
private String price; 

public ArtistInfo() { 
name = ""; 
address = ""; 
phoneNum = 0;
password = ""; 
confirm_password = "";
id = ""; 
price = ""; 
} 


public void setName(String n){ 
name = n; } 

public void setAddress(String a){ 
address = a; } 

public void setPhoneNum(int pNo){ 
phoneNum = pNo;} 

public void setPassword(String p){ 
    password = p; } 
    
    public void setConfirm_password(String cp){ 
    confirm_password=cp; }

    public void setId(String i){ 
       id = i; } 
        
        public void setPrice(String pr){ 
        price = pr; }



public String getName( ){ 
return name;} 

public String getAddress( ){ 
return address; } 

public int getPhoneNum( ){ 
return phoneNum;} 
public String getPassword( ){ 
    return password;} 
    
    public String getConfirm_password( ){ 
    return confirm_password; } 
    public String getId( ){ 
        return id;} 
        
        public String getPrice( ){ 
        return price; } 

} // end class PersonInfo 