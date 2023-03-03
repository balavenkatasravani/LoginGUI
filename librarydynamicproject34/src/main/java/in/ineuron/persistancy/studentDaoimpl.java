package in.ineuron.persistancy;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import in.ineuron.dto.Student;
import in.ineuron.util.util;
//import util.jdbcutil;

public class studentDaoimpl implements IstudentDao {
Connection connection=null;
PreparedStatement pstmt=null;
ResultSet resultset=null;
	@Override
	public String addStudent(Student student) {
		String sqlinsertQuery="insert into mystd(`name`,`age`,`book1`,`book2`,`book3`,`date`)values(?,?,?,?,?,?)";
		try {
			connection=util.getJdbcConnection();
			if(connection!=null)
			{
				pstmt=connection.prepareStatement(sqlinsertQuery);
				
			}
			if(pstmt!=null)
			{
				pstmt.setString(1, student.getName()); 
				pstmt.setInt(2, student.getAge());
				pstmt.setString(3, student.getBook1());
				pstmt.setString(4,student.getBook2());
				pstmt.setString(5,student.getBook3());
				pstmt.setString(6,student.getDate());
				int rowaffected=pstmt.executeUpdate();
				if(rowaffected==1)
					
				{
					return "success"; 
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "failure";
	}
	@Override
	public String addbook(Student student) {
		String sqlinsertQuery="insert into librarybooks(`bookid`,`bookname`,`bookauthor`)values(?,?,?)";
		try {
			connection=util.getJdbcConnection();
			if(connection!=null)
			{
				pstmt=connection.prepareStatement(sqlinsertQuery);
				
			}
			if(pstmt!=null)
			{
				pstmt.setInt(1, student.getBookid()); 
				pstmt.setString(2, student.getBookname());
				pstmt.setString(3,student.getBookauthor());
				
				int rowaffected=pstmt.executeUpdate();
				if(rowaffected==1)
					
				{
					return "success"; 
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "failure";
	}

	@Override
	public Student searchstudent(Integer id) {
		Student student=null;
		String sqlinsertQuery="select id,name,age,book1,book2,book3,date from mystd where id=?";
		try {
			connection=util.getJdbcConnection();
			if(connection!=null)
			{
				pstmt=connection.prepareStatement(sqlinsertQuery);
				}
			if(pstmt!=null)
			{
				
				pstmt.setInt(1,id);
			}
			if(pstmt!=null)
			{
				resultset=pstmt.executeQuery();
			}
			if(resultset.next())
			{
				
						student =new Student();
						student.setId(resultset.getInt(1));
						student.setName(resultset.getString(2));
								student.setAge(resultset.getInt(3));
								student.setBook1(resultset.getString(4));
								student.setBook2(resultset.getString(5));
								student.setBook3(resultset.getString(6));
								student.setDate(resultset.getString(7));
						return student;
			}
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//return student;
		//return "failure";
		return student;
		
	}
	public Student searchbook(Integer bookid) {
		Student student=null;
		String sqlinsertQuery="select bookid,bookname,bookauthor from librarybooks where bookid=?";
		try {
			connection=util.getJdbcConnection();
			if(connection!=null)
			{
				pstmt=connection.prepareStatement(sqlinsertQuery);
				}
			if(pstmt!=null)
			{
				
				pstmt.setInt(1,bookid);
			}
			if(pstmt!=null)
			{
				resultset=pstmt.executeQuery();
			}
			if(resultset.next())
			{
				
						student =new Student();
						student.setBookid(resultset.getInt(1));
						student.setBookname(resultset.getString(2));
						student.setBookauthor(resultset.getString(3));
								
						return student;
			}
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//return student;
		//return "failure";
		return student;
		
	}
	public Student searchbook( String bookauthor) {
		Student student=null;
		String sqlinsertQuery="select bookid,bookname,bookauthor from librarybooks where bookauthor=?";
		try {
			connection=util.getJdbcConnection();
			if(connection!=null)
			{
				pstmt=connection.prepareStatement(sqlinsertQuery);
				}
			if(pstmt!=null)
			{
				
				pstmt.setString(1,bookauthor);
			}
			if(pstmt!=null)
			{
				resultset=pstmt.executeQuery();
			}
			if(resultset.next())
			{
				
						student =new Student();
						
						student.setBookid(resultset.getInt(1));
						student.setBookname(resultset.getString(2));
						student.setBookauthor(resultset.getString(3));
						return student;
			}
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//return student;
		//return "failure";
		return student;
		
	}
	public Student searchbook1( String bookname) {
 
		Student student=null;
		String sqlinsertQuery="select bookid,bookname,bookauthor from librarybooks where bookid=?";
		try {
			connection=util.getJdbcConnection();
			if(connection!=null)
			{
				pstmt=connection.prepareStatement(sqlinsertQuery);
				}
			if(pstmt!=null)
			{
				
				pstmt.setString(1,bookname);
			}
			if(pstmt!=null)
			{
				resultset=pstmt.executeQuery();
			}
			if(resultset.next())
			{
				
						student =new Student();
						student.setBookid(resultset.getInt(1));
						student.setBookname(resultset.getString(2));
						student.setBookauthor(resultset.getString(3));
						return student;
			}
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return student;
		
	}

	
	//@Override
	public String deleteStudent(Integer id) {
		String sqlinsertQuery="delete from mystd where id=?";
		try {
			connection=util.getJdbcConnection();
			if(connection!=null)
			{
				pstmt=connection.prepareStatement(sqlinsertQuery);
				}
			if(pstmt!=null)
			{
				
				pstmt.setInt(1,id);
			}
			
			if(pstmt!=null)
			{
				int rowaffected=pstmt.executeUpdate();
				if(rowaffected==1)
					
				{
					return "success"; 
				}
				else
				{
					return "not deleted";		
					}
			}
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "failure";
	}
	public String deletebook(Integer bookid) {
		String sqlinsertQuery="delete from librarybooks where bookid=?";
		try {
			connection=util.getJdbcConnection();
			if(connection!=null)
			{
				pstmt=connection.prepareStatement(sqlinsertQuery);
				}
			if(pstmt!=null)
			{
				
				pstmt.setInt(1,bookid);
			}
			
			if(pstmt!=null)
			{
				int rowaffected=pstmt.executeUpdate();
				if(rowaffected==1)
					
				{
					return "success"; 
				}
				else
				{
					return "not deleted";		
					}
			}
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "failure";
	}
	public String updateStudent(Student student)
	{
		String sqlUpdateQuery = "update mystd set name=?,age=?,book1=?,book2=?,book3=?,date=? where id=?";
		try {
			connection = util.getJdbcConnection();

			if (connection != null)
				pstmt = connection.prepareStatement(sqlUpdateQuery);

			if (pstmt != null) {

				pstmt.setString(1, student.getName());
				pstmt.setInt(2, student.getAge());
				pstmt.setString(3, student.getBook1());
				pstmt.setString(4, student.getBook2());
				pstmt.setString(5, student.getBook3());
				pstmt.setString(6, student.getDate());
				pstmt.setInt(7, student.getId());

				int rowAffected = pstmt.executeUpdate();
				if (rowAffected == 1) {
					return "success";
				}
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}

		return "failure";
	}		
	public String updatebook(Student student)
	{
		String sqlUpdateQuery = "update librarybooks set bookname=?,bookauthor=? where bookid=?";
		try {
			connection = util.getJdbcConnection();

			if (connection != null)
				pstmt = connection.prepareStatement(sqlUpdateQuery);

			if (pstmt != null) {

				pstmt.setString(1, student.getBookname());
				pstmt.setString(2, student.getBookauthor());
				pstmt.setInt(3, student.getBookid());
				
				int rowAffected = pstmt.executeUpdate();
				if (rowAffected == 1) {
					return "success";
				}
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}

		return "failure";
	}		
		
	}
	



