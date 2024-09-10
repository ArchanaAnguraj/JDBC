package JDBC;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.Scanner;

//public class DAY1 {
//
//	public static void main(String[] args) {
//
//		//1.load the driver class
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver"); //path of the driver class
//			System.out.println("Driver is loader");
//		} catch (ClassNotFoundException e) {
//			
//			e.printStackTrace();
//		}
//	
//		//2.establish the driverconncetion to database
//		String url="jdbc:mysql://localhost:3306/jdbc2024";  //this line connect java to SQL
//		String user_name="root";                //SQL USERNAME
//		String password="necece@12345";         //SQL PASSWORD
//		Connection c = null;
//		try {
//			 c=DriverManager.getConnection(url, user_name, password);
//			System.out.println("Drive manager is execute "+ c);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//		//3 create sql statement
//		Statement st = null;
//		try {
//			 st=c.createStatement();
//			System.out.println("create sql query");
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//		
//		
//		//4.execute the SQL Queries
//		ResultSet res=null;
//		  try {
//		    res=st.executeQuery("select*from employee"); //if we give wrong syntax we get null pointer exception because res=null;
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		  
//		  
//		//5.print or process the result
//		  
//		  try {
//			  while(res.next()==true) {
//			System.out.println(res.getInt(1)+","+res.getString(2)+","+res.getString(3)+","+res.getInt(4));
//			  }
//		} catch (SQLException e) {
//			e.printStackTrace();
//			
//		}
//		  finally
//		  {
//			 close(res,st,c); 
//		  }
//		  
//	}
//	static void close(ResultSet res,Statement st,Connection c)
//	 {
//		 try 
//		  {
//			res.close();
//			System.out.println("Resultset close");
//	
//			st.close();
//			System.out.println("Statement close");
//		  
//			c.close();
//			System.out.println("Connection close");
//		  } 
//		  catch (SQLException e) 
//		  {
//			e.printStackTrace();
//		  }
//	 }
//
//
//}

//--------------------------------------//
//class Myconnect
//{
//	static String url="jdbc:mysql://localhost:3306/jdbc2024";  //this line connect java to SQL
//	static String user_name="root";                //SQL USERNAME
//	static String password="necece@12345";         //sql password
//	 
//	static Connection c=null;
//	static  Connection connect() throws ClassNotFoundException, SQLException 
//	 {	
//		 Class.forName("com.mysql.cj.jdbc.Driver");
//		 c=DriverManager.getConnection(url, user_name, password);
//		 return c;
//		
//	 }
//     
//	 
//	 
//	 static void close(ResultSet res,Statement st,Connection c)
//	 {
//		 try 
//		  {
//			 if(res!=null) {
//			 res.close();
//			 }
//			 if(st!=null) {
//			st.close();
//			 }
//			 if(c!=null);{
//		    c.close();
//			 }
//	
//		  } 
//		  catch (SQLException e) 
//		  {
//			e.printStackTrace();
//		  }
//	 }
//}
//public class DAY1 {
//
//	public static void main(String[] args) {	
//		Connection c = null;
//		Statement st = null;
//		ResultSet res=null;
//		
//		try {
//		    c=Myconnect.connect();
//			st=c.createStatement();
//			res=st.executeQuery("select*from employee");
//			
//			
//			int id,salary;
//			String name,dept;
//			
//			
//			 while(res.next()==true) {
//				 id=res.getInt(1);
//				 name=res.getString(2);
//				 dept=res.getString(3);
//				 salary=res.getInt(4);
//					System.out.printf("%d %-9s %-6s %-6d\n",id,name,dept,salary); //we give -9,-6,-6 for alignment properly
//		          }
//		}
//       catch (ClassNotFoundException | SQLException e) {
//			
//			e.printStackTrace();
//		}
//		finally
//		  {
//			 Myconnect.close(res,st,c); 
//		  }
//	
//	
//	}
//}
//-------------------------------------------------------------------------//

//inert the query 


class Myconnect{
	static String url="jdbc:mysql://localhost:3306/jdbc2024";  //this line connect java to SQL
	static String user_name="root";                //SQL USERNAME
	static String password="necece@12345";         //sql password
	 
	static Connection c=null;
	static  Connection connect() throws ClassNotFoundException, SQLException 
	 {	
		 Class.forName("com.mysql.cj.jdbc.Driver");
		 c=DriverManager.getConnection(url, user_name, password);
		 return c;
		
	 }
     
	static void close(ResultSet res,Statement st,Connection c)
	 {
		 try 
		  {
			 if(res!=null) {
			 res.close();
			 }
			 if(st!=null) {
			st.close();
			 }
			 if(c!=null);{
		    c.close();
			 }
	       } 
		  catch (SQLException e) 
		  {
			e.printStackTrace();
		  }
	 }
}

//public class DAY1 {
//
//	public static void main(String[] args) {
		//1."inserting 1 data or 1 row by hard code"
		
//		Connection c=null;
//		Statement st=null;
//		String q="insert into employee(e_id,e_name,e_dept,e_salary)"+ "values(6,'alex','IT',30000)";
//		
//		try {
//			c=Myconnect.connect();
//			st=c.createStatement();
//			int x=st.executeUpdate(q); //adding a new row in ,alredy prsent in employee db
//		             //we use update query because we updating the query
//			if(x==0)
//				System.out.println("no one is upadte");
//			else
//				System.out.println("update " + x +" rows");
//		}     
//		catch (ClassNotFoundException |SQLException e) {
//			e.printStackTrace();
//		}
//		
//		finally
//		  {
//			 Myconnect.close(null,st,c); 
//		  }
//		
	

		
		
		//2."inserting by user"
//		Scanner sc1=new Scanner(System.in);
//		Scanner sc2=new Scanner(System.in);
//		int id,salary;
//		String name,dept;
//		
//		Connection c=null;
//		PreparedStatement st=null;
//		String q="insert into employee(e_id,e_name,e_dept,e_salary)"+ "values (?,?,?,?)";
//		
//		
//
//		System.out.println("Enter the id");
//		id=sc1.nextInt();
//		
//		System.out.println("Enter the name");
//		name=sc2.nextLine();
//		
//		System.out.println("Enter the dept");
//		dept=sc2.nextLine();
//		
//		System.out.println("Enter the salary");
//	    salary=sc1.nextInt();
//		
//		try {
//			c=Myconnect.connect();
//		    st=c.prepareStatement(q);
//		     
//		    st.setInt(1,id);          //first qustion mark set id.
//		    st.setInt(4,salary);     //4th qustion mark set salary.
//		    st.setString(2,name);   //2nd-name
//		    st.setString(3,dept);  //3rd-salary
//		    
//		    
//		  int c1 =st.executeUpdate();
//		  System.out.println("upadte is "+c1);
//		
//		
//		} catch (SQLException | ClassNotFoundException e) {
//			e.printStackTrace();
//		}	
//		
//		
//	}
//}
//----------------------------------------------------------//

//update 

//public class DAY1 {
//
//	public static void main(String[] args) {
//		String url="jdbc:mysql://localhost:3306/jdbc2024";
//	    String password="necece@12345";
//		String username="root";
//	    
//		
//		Connection c=null;
//		Statement st=null;
//		PreparedStatement pst=null;
//		
//		Scanner sc=new Scanner(System.in);
//		System.out.println("enter the dept");
//		 String dept=sc.nextLine();
//		 System.out.println("enter the salary");
//		 int salary=sc.nextInt();
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			c=DriverManager.getConnection(url,username,password);
//			
//			//String sql="update `employee` set `e_salary`=`e_salary`+5000 where `e_dept`='Hr'";
//			//st=c.createStatement();
//			
//			String sql="update `employee` set `e_salary`=`e_salary`+? where `e_dept`=?"; //for user input
//			 pst = c.prepareStatement(sql);
//			 pst.setInt(1,salary);
//			 pst.setString(2,dept);
//
//			int c1=pst.executeUpdate();
//			if(c1!=0)
//			System.out.println("output is "+c1);
//			else
//				System.out.println("update is failure");
//		} catch (ClassNotFoundException |SQLException e) {
//			e.printStackTrace();
//		}
//		finally {
//			Myconnect.close(null, st, c);
//		}
//		
//		
//	}
//}
////------------------------------------------------------------//

//delete

//public class DAY1 {
//
//	public static void main(String[] args) {
//		
//		
//		Connection c=null;
//		Statement st=null;
//		PreparedStatement pst=null;
//		
//		Scanner sc=new Scanner(System.in);
//		System.out.println("Enter the id to be deleted");
//		int id=sc.nextInt();
//		
//		try
//		{
//		 c=Myconnect.connect();
////		 st=c.createStatement();
////		 int c1=st.executeUpdate("delete from `employee` where `e_id`=7");
//		 
//		 String sql=("delete from `employee` where `e_id`=?");   //get from user
//		 pst=c.prepareStatement(sql);
//		 pst.setInt(1, id);
//		 
//		 int c1=pst.executeUpdate();
//		 //System.out.println(pst.executeUpdate());
//		 if(c1!=0)
//			 System.out.println("delete query");
//		 else
//			 System.out.println("not delete");
//		}
//		catch(Exception e)
//		{
//			e.printStackTrace();
//		}
//		finally {
//			Myconnect.close(null, st, c);
//		}
//	}
//}
//	    
//----------------------------------------------------------------------------------------------------//

//inserting multiplr row(Batch data) 
//public class DAY1 {
//	public static void main(String[] args) {
//		
//		 Scanner sc1=new Scanner(System.in);
//		 Scanner sc2=new Scanner(System.in);
//	String url="jdbc:mysql://localhost:3306/jdbc2024";
//	String username="root";
//	String password="necece@12345";
//		
//	Connection c=null;
//	PreparedStatement pst=null;
//
//	int id,salary;
//	String name,dept;
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//		    Connection con=DriverManager.getConnection(url, username,password);
//		    
//		    String q="insert into employee(e_id,e_name,e_dept,e_salary)"+"values(?,?,?,?)";
//		    pst=con.prepareStatement(q);
//		  
//		  for(;;) {
//		    System.out.println("Enter the id");
//		    id=sc1.nextInt();
//		    System.out.println("Enter the name");
//		    name=sc2.nextLine();
//		    System.out.println("Enter the dept");
//		    dept=sc2.nextLine();
//		    System.out.println("Enter the salary");
//		    salary=sc1.nextInt();
//		    
//		    
//		    pst.setInt(1, id);
//		    pst.setString(2, name);
//		    pst.setString(3, dept);
//		    pst.setInt(4, salary);
//		    
//		    
//		   pst.addBatch();
//		   System.out.println("do u want to more to execute ? yes/no");
//		   String ch=sc2.nextLine();
//		   
//		   if(ch.equals("no"))
//		   {
//			   break;
//		   }
//		  }
//		 int a[] =pst.executeBatch();
//		 for( int x:a)
//		 {
//			 System.out.println(x);
//		 }
//			 
//		    
//		    
//		    
//		} catch (Exception e) {
//			
//			e.printStackTrace();
//		}
//		
//	}
//}

//-------------------------------------------------------------------------------------//

//"Meta data"---//to make sure if the data of table is not available , dont know whic column are inside the tables to overcome this we use meta data
//public class DAY1 {
//	public static void main(String[] args) {
//     
//       String url="jdbc:mysql://localhost:3306/online_food_delievry";
//       String username="root";
//       String password="necece@12345";
//       
//       Connection c=null;
//       Statement st=null;
//       ResultSet res =null;
//       ResultSetMetaData resmd=null;
//		String q="select*from user";
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			c=DriverManager.getConnection(url, username, password);
//	       
//			 st = c.createStatement();
//			 
//			 res = st.executeQuery(q);
//			 
//			 resmd = res.getMetaData();  //its for used to visible the data or get the invisible data
//			 //System.out.println(resmd);
//			 
//			 int x=resmd.getColumnCount();//how many columns are there..
//			
//			 for(int i=1;i<=x;i++)
//			 {
//				 System.out.println("column no :"+i+"\ncolunmName :"+resmd.getColumnName(i)+"\ncolumn dataType :"+resmd.getColumnTypeName(i)+" \nits column null :"+(resmd.isNullable(i)==1?"yes":"no"));
//			 }                                                       //get coloumn name                          //get type of the column                            //check itsnull or not null?
//			                                                         //like name,id                              /like int,varchar();
//			 } catch (Exception e) {
//			e.printStackTrace();
//		}}
//}

//-----------------------------------------------------------------------------------//

//ACID PROPERTIES

//public class DAY1 {
//	public static void main(String[] args) {
//
//	       String url="jdbc:mysql://localhost:3306/jdbc2024";
//	       String username="root";
//	       String password="necece@12345";
//	     Scanner sc=new Scanner(System.in);  
//	   	

//Connection con=null;
//	   	int pin=123;
//	   	PreparedStatement pst1;
//	   	PreparedStatement pst2;
//	       
//	       try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//		    con = DriverManager.getConnection(url, username, password);
//		    con.setAutoCommit(false);//hold the all query after complte whole program execute all query
//		    
//		    //send money--loss money from who sends
//		    String sendQuery="update bank set balance=balance-? where u_id=?";
//		       
//		    //recevie money
//		    String receiveQuery="update bank set balance=balance+? where u_id=?";
//		    
//		    
//		    pst1 =con.prepareStatement(sendQuery);
//		    pst2=con.prepareStatement(receiveQuery);
//		    
//		    //get user input for sendQuery
//		    System.out.println("Enter the sender u_id :");
//		    int su_id=sc.nextInt();
//		    System.out.println("Enter the amount to send :");
//		    int amount=sc.nextInt();
//		    
//		    //set value for Sendquery
//		    pst1.setInt(1, amount);
//		    pst1.setInt(2, su_id);
//		    int x=pst1.executeUpdate();
//		    System.out.println("sending money :"+x);
//		    
//		   //get user input for 
//		    System.out.println("Enter the receiver u_id :");
//		    int ru_id=sc.nextInt();
//		   
//		   //set value for receivequery
//		    pst2.setInt(1, amount);
//		    pst2.setInt(2, ru_id);
//		    int x2=pst2.executeUpdate();
//		    System.out.println("recevie money :"+x2);
//		   
//		   System.out.println("enter upi pin :");
//		   int entredpin=sc.nextInt();
//		   if((pin==entredpin) &&( x==1 )&&(x2==1)) {
//		   con.commit(); //transaction complete execute all 
//		   System.out.println("success");
//		   }
//		   else
//		   {
//			   con.rollback();//transaction fail again go back 
//		       System.out.println("failure");
//		   }
//		   } catch (Exception e) {
//			e.printStackTrace();
//		}
//	 }
//}

//-----------------------------------------------------------------------------------------------------//
//stored procedure
//public class DAY1 {
//	public static void main(String[] args) {
//		  
//		   Scanner sc=new Scanner(System.in);
//		   String url="jdbc:mysql://localhost:3306/jdbc2024";
//	       String username="root";
//	       String password="necece@12345";
//	       Connection c=null;
//	       CallableStatement precal;
//	       String dept;
//	       try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			c = DriverManager.getConnection(url, username, password);

//			
//			precal = c.prepareCall("{call employee_count_dept(?,?)}"); //its like createstattement but here its procedure thats why we use prepare call
//		                  //call procudeurename (parameters)
//			System.out.println("enter the dept");
//			dept=sc.nextLine();
//			
//			
//			precal.setString(1, dept);   //set the value for dept
//		    precal.registerOutParameter(2, Types.INTEGER);   //get out count output we use registerOutparameter
//		                                   //integer type output we get that why we use types.integer   Type--class,INTEGER--FINAL-4
//		    
//		    precal.execute(); //ITS RETURN BOOLEAN IF ITS RETURN TRUE NEXT LINE WILL EXECUTE
//			int c1=precal.getInt(2);//get the output
//			
//			System.out.println("No of Employees "+dept+ "department are :"+c1);
//		}
//		 catch (Exception e) {
//			e.printStackTrace();
//		}
//     }
//}
//-------------------------------------------------------------------------------------------------------//








