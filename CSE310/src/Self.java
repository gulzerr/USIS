import java.io.*;  
public class Self  
{  
    public static void main(String args[]) throws Exception  
    {  
    
        FileInputStream getFile=new FileInputStream("D:\\My Codes\\cse310-project\\CSE310\\src\\Self.java");

        BufferedReader read=new BufferedReader(new InputStreamReader(getFile));  
            String iterate;  
            while((iterate = read.readLine() ) != null)  
            {  
                System.out.println(iterate);  
            }  

    }  
} 