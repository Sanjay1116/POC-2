package IPL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateTeams 
{
	public static void main(String[] args) 
	{
		try 
		{
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ipl", "root", "$anjay@161101");
			Statement st=con.createStatement();
			ResultSet myRs = null;
			Scanner sc = new Scanner(System.in);
			String Team, Player, ch;
			int Score;
			do
			{
				System.out.print("Enter the Team Name: ");
				Team = sc.next();
				System.out.print("Enter the Player Name: ");
				Player = sc.next();
				System.out.print("Enter Score for Player - "+Player+": ");
				Score = sc.nextInt();
				int k=st.executeUpdate("update IPLTeams set Score="+Score+" where TeamName='"+Team+"' and PlayerName='"+Player+"'");
				System.out.print("Press 'Yes' to enter more Score: ");
				ch = sc.next();
			}while (ch == "Yes");
			
			myRs = st.executeQuery("select TeamId, TeamName, PlayerName, min(Score) AS Score\r\n"
					+ "			from IPLTeams \r\n"
					+ "			group by TeamId, TeamName, PlayerName;");
			
			
			
			System.out.println("TeamId	TeamName	PlayerName	Score");
			while (myRs.next()) 
			{	
				int tid = myRs.getInt("TeamId");
				String tname = myRs.getString("TeamName");
				String pname = myRs.getString("PlayerName");
				int scoredb = myRs.getInt("Score");
				System.out.println(tid+"	"+tname+"	"+pname+"	"+scoredb);}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}