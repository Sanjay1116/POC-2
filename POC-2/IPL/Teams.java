package IPL;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

public class Teams {

	public static void main(String[] args) {
		try{
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ipl", "root", "$anjay@161101");
			 Statement st=con.createStatement();
			
			FileInputStream fstream = new FileInputStream("C:\\Users\\sanjayraman.sriram\\Documents\\POC-2\\player.txt");
			    DataInputStream in = new DataInputStream(fstream);
			    BufferedReader br = new BufferedReader(new InputStreamReader(in));
			    String strLine;
			    ArrayList list=new ArrayList();
			    while ((strLine = br.readLine()) != null){
			    list.add(strLine);
			    }
			  Iterator itr;
			    for (itr=list.iterator(); itr.hasNext(); ){
			  String str=itr.next().toString();  
			    String [] splitSt =str.split("	");
			    String tname="	",pname="	";
			      for (int i = 0 ; i < splitSt.length ; i++)
			    	  {
			         tname=splitSt[0];
			     pname=splitSt[1];
			     
			    }
			      
			int k=st.executeUpdate("insert into IPLTeams(teamname,playername) values('"+tname+"','"+pname+"')");
			    System.out.println("Insert Success");
			}
			}
			catch(Exception e){
				System.out.println(e);
			}

	}

}
