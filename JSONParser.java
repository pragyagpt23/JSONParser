import java.util.*;
import java.io.*;

public class JSONParser {
     public static int size;
     public static void main(String[] arg) {

        String s = "{" +
                         "\"RollNo\":1," +
                         "\"Name\":\"Jack\"," +
                         "\"Country\":\"Denmark\"" +    
                                           
                   "}";
        		               
   		   
        System.out.println(s);
        valid(s);
        
      
     }
      
     public static void valid(String s) {
               if((check_object(s)==0) || (check_array(s)==0))
                      System.out.println("This is a Valid JSON Grammar!!");
               else 
                      System.out.println("This is not a Valid JSON Grammar!!");
     }
 
     public static int check_object(String s) {
               size=s.length();
               if(!((s.substring(0,1)).equals("{")) || !((s.substring(size-1,size)).equals("}")))
                       return -1;
               String str=s.substring(1,size-1);
               String[] arr=str.split(",");
               for(String a:arr)
                     if(check_pair(a)!=0)
                        return -1;
               return 0;
     }

     public static int check_array(String s) {
               size=s.length();
               if(!((s.substring(0,1)).equals("[")) || !((s.substring(size-1,size)).equals("]")))
                       return -1;
               String str=s.substring(1,size-1);
               String[] arr=str.split(",");
               for(String a:arr)
                     if(check_value(a)!=0)
                        return -1;
               return 0;
     }
  
     public static int check_pair(String s) {
              String[] arr=s.split(":");
              if(arr.length!=2)
                    return -1;
              if(check_string(arr[0])!=0 || check_value(arr[1])!=0)
                    return -1;
              return 0;
     }
     
     public static int check_string(String s) {
              size=s.length();
              if(!((s.substring(0,1)).equals("\"")) || !((s.substring(size-1,size)).equals("\"")))
              {
                     System.out.println("Not a valid string!!");
                     return -1;
              }
              return 0;
     }

     public static int check_value(String s) {
              if((s.equals("null")) || (s.equals("true")) || (s.equals("false")) || (check_number(s)==0) || (check_string(s)==0) ||(check_object(s)==0) || (check_array(s)==0))
                   return 0;
              else
                   return -1;
     }
  
     public static int check_number(String s)
     {
              try
              {
                   int n = Integer.parseInt(s);
              }
              catch(Exception e)
              {
                   return -1;
              }
              return 0;
     }
}
