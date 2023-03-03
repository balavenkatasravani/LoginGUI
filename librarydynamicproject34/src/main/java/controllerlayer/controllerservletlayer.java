package controllerlayer;

import java.io.IOException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import in.ineuron.dto.Student;
import in.ineuron.service.Istudentservice;
import in.ineuron.servicefactory.studentserviceFactory;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
/**
 * Servlet implementation class controllerservletlayer
 */
@WebServlet("/disp/*")
public class controllerservletlayer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doprocess(request,response);
		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doprocess(request,response);
	}

	private void doprocess(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Istudentservice studentService=	studentserviceFactory.getstudentService();
		System.out.println("Request URI :: " + request.getRequestURI());
		System.out.println("Path info   :: " + request.getPathInfo());

		if (request.getRequestURI().endsWith("addform")) {
			
			String age = request.getParameter("age");
			String name = request.getParameter("name");
			String book1 = request.getParameter("book1");
			String book2 = request.getParameter("book2");
			String book3 = request.getParameter("book3");
			String date=request.getParameter("date");
			Date sqldom=java.sql.Date.valueOf(date);
			Student student = new Student();
			student.setName(name);
			student.setAge(Integer.parseInt(age));
			student.setBook1(book1);
			student.setBook2(book2);

			student.setBook3(book3);
            student.setDate(date);

			String status = studentService.addStudent(student);
			PrintWriter out=null;
			try {
				out = response.getWriter();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (status.equals("success")) {
				out.println("<h1 style='color:green; text-align:center;'>REGISTRATION SUCCESFULL</h1>");
			} else {
				out.println("<h1 style='color:green; text-align:center;'>REGISTRATION FAILED</h1>");
			}
			out.close();
		}
		 
		 
       if (request.getRequestURI().endsWith("addbook")) {
			
			String bookid = request.getParameter("bookida");
			String bookname = request.getParameter("bookname");
			String bookauthor = request.getParameter("bookauthor");
			//String date=request.getParameter("date");
			Student student = new Student();
			
			student.setBookid(Integer.parseInt(bookid));
			student.setBookname(bookname);
			student.setBookauthor(bookauthor);
            
			String status = studentService.addbook(student);
			PrintWriter out=null;
			try {
				out = response.getWriter();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (status.equals("success")) {
				out.println("<h1 style='color:green; text-align:center;'>BOOK ADDED SUCCESFULL</h1>");
			} else {
				out.println("<h1 style='color:green; text-align:center;'>BOOK ADDING FAILED</h1>");
			}
			out.close();
		}
		if (request.getRequestURI().endsWith("searchform")) {
			String id = request.getParameter("ids");
			System.out.println(id);
			Student student = studentService.searchstudent(Integer.parseInt(id));
			PrintWriter out = response.getWriter();
			if (student != null) {
				// display student records as a form data so it is editable
				out.println("<body>");
				out.println("<center>");
				//out.println("<form method='post' action='./disp/updaterecord'>");
				out.println("<table>");
				out.println("<tr><th>ID</th><td>" + student.getId() + "</td></tr>");
				out.println("<input type='hidden' name='ids' value='" + student.getId() + "'/>");
				out.println("<tr><th>NAME</th><td><input type='text' name='name' value='" + student.getName()
						+ "'/></td></tr>");
				out.println("<tr><th>AGE</th><td><input type='text' name='age' value='" + student.getAge()
						+ "'/></td></tr>");
				out.println("<tr><th>book1</th><td><input type='text' name='book1' value='" + student.getBook1()
						+ "'/></td></tr>");
				out.println("<tr><th>book2</th><td><input type='text' name='book2' value='" + student.getBook2()
				+ "'/></td></tr>");
				
				out.println("<tr><th>book3</th><td><input type='text' name='book3' value='" + student.getBook3()
				+ "'/></td></tr>");
				out.println("<tr><th>date</th><td><input type='text' name='date' value='" + student.getDate()
				+ "'/></td></tr>");
				out.println("<tr><td></td><td><input type='submit' value='submited'/></td></tr>");
				out.println("</table>");
				out.println("</form>");
				out.println("</center>");
				out.println("</body>");
			} else {
				// display not found message
				out.println("<body>");
				out.println("<h1 style='color:red;text-align:center;'>Record not avaialable for the give id :: " + id
						+ "</h1>");
				out.println("</body>");
			}
			out.close();
		}
		if (request.getRequestURI().endsWith("checkdue")) {
			String id = request.getParameter("cid");
			System.out.println(id);
			Student student = studentService.searchstudent(Integer.parseInt(id));
			PrintWriter out = response.getWriter();
			String date1=student.getDate();
			System.out.println(date1+"from db");
			
			SimpleDateFormat sdf=new SimpleDateFormat("dd-mm-yy");
			System.out.println(date1+"converting  db");
			LocalDate currentDate=LocalDate.now();
			System.out.println(currentDate+"currentdate  ");
			LocalDate date2=LocalDate.parse(date1);
			System.out.println(date2+"date2");
			long diffDays=ChronoUnit.DAYS.between(date2,currentDate);
			System.out.println(diffDays+"diffDays");
			if(diffDays<5)
			{
				diffDays=0;
				out.println("<h1 style='color:red;text-align:center;'>no dueamount  </h1>");
			}
			else
			{
				diffDays=((diffDays-5)*10);
				System.out.println(diffDays+"diffDays");
				out.println("<h1 style='color:red;text-align:center;'>Dueamount is :: " + diffDays
						+ "</h1>");
			}
			
			//out.println("<h1DUEMONEY IS::+diffDays+></h1> ");
			out.close();
			
		}
		if (request.getRequestURI().endsWith("searchbookbyid")) {
			String bookid = request.getParameter("bookid");

			Student student = studentService.searchbook(Integer.parseInt(bookid));
			PrintWriter out = response.getWriter();
			if (student != null) {
				// display student records as a form data so it is editable
				out.println("<body>");
				out.println("<center>");
				//out.println("<form method='post' action='./disp/updaterecord'>");
				out.println("<table>");
				out.println("<tr><th>BOOKID</th><td>" + student.getBookid() + "</td></tr>");
				out.println("<input type='hidden' name='bookid' value='" + student.getBookid() + "'/>");
				out.println("<tr><th>BOOKNAME</th><td><input type='text' name='bookname' value='" + student.getBookname()
						+ "'/></td></tr>");
				out.println("<tr><th>BOOKAUTHOR</th><td><input type='text' name='bookauthor' value='" + student.getBookauthor()
						+ "'/></td></tr>");
				
				//out.println("<tr><td></td><td><input type='submit' value='update'/></td></tr>");
				out.println("</table>");
				out.println("</form>");
				out.println("</center>");
				out.println("</body>");
			} else {
				// display not found message
				out.println("<body>");
				out.println("<h1 style='color:red;text-align:center;'>Record not avaialable for the give id :: " + bookid
						+ "</h1>");
				out.println("</body>");
			}
			out.close();
		}
		if (request.getRequestURI().endsWith("searchbookbyname")) {
			String bookname = request.getParameter("bookname");

			Student student = studentService.searchbook1(bookname);
			PrintWriter out = response.getWriter();
			if (student != null) {
				// display student records as a form data so it is editable
				out.println("<body>");
				out.println("<center>");
				//out.println("<form method='post' action='./disp/updaterecord'>");
				out.println("<table>");
				out.println("<tr><th>BOOKID</th><td>" + student.getBookid() + "</td></tr>");
				out.println("<input type='hidden' name='bookid' value='" + student.getBookid() + "'/>");
				out.println("<tr><th>BOOKNAME</th><td><input type='text' name='bookname' value='" + student.getBookname()
						+ "'/></td></tr>");
				out.println("<tr><th>BOOKAUTHOR</th><td><input type='text' name='bookauthor' value='" + student.getBookauthor()
						+ "'/></td></tr>");
				
				//out.println("<tr><td></td><td><input type='submit' value='update'/></td></tr>");
				out.println("</table>");
				out.println("</form>");
				out.println("</center>");
				out.println("</body>");
			} else {
				// display not found message
				out.println("<body>");
				out.println("<h1 style='color:red;text-align:center;'>Record not avaialable for the give id :: " + bookname
						+ "</h1>");
				out.println("</body>");
			}
			out.close();
		}
		if (request.getRequestURI().endsWith("searchbookbyauthor")) {
			String bookauthor = request.getParameter("bookauthor");

			Student student = studentService.searchbook(bookauthor);
			PrintWriter out = response.getWriter();
			if (student != null) {
				// display student records as a form data so it is editable
				out.println("<body>");
				out.println("<center>");
				//out.println("<form method='post' action='./disp/updaterecord'>");
				out.println("<table>");
				out.println("<tr><th>BOOKID</th><td>" + student.getBookid() + "</td></tr>");
				out.println("<input type='hidden' name='bookid' value='" + student.getBookid() + "'/>");
				out.println("<tr><th>BOOKNAME</th><td><input type='text' name='bookname' value='" + student.getBookname()
						+ "'/></td></tr>");
				out.println("<tr><th>BOOKAUTHOR</th><td><input type='text' name='bookauthor' value='" + student.getBookauthor()
						+ "'/></td></tr>");
				
				//out.println("<tr><td></td><td><input type='submit' value='update'/></td></tr>");
				out.println("</table>");
				out.println("</form>");
				
				//out.println("<h1><a href='../updateform.html 'target='body'>UPDATE</h1></a><br/><br/>");
				out.println("</center>");
				out.println("</body>");
			} else {
				// display not found message
				out.println("<body>");
				out.println("<h1 style='color:red;text-align:center;'>Record not avaialable for the author :: " + bookauthor
						+ "</h1>");
				out.println("</body>");
			}
			out.close();
		}

		 if (request.getRequestURI().endsWith("deleteform")) {
				
				String id = request.getParameter("iddelf");
				
				String msg=studentService.deleteStudent(Integer.parseInt(id));
				
				
				
				PrintWriter out=null;
				try {
					out = response.getWriter();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				if (msg.equals("success")) {
					out.println("<h1 style='color:green; text-align:center;'>REGISTRATION SUCCESFULL</h1>");
				} else {
					out.println("<h1 style='color:green; text-align:center;'>REGISTRATION FAILED</h1>");
				}
				out.close();
		 }
		 if (request.getRequestURI().endsWith("deletebook")) {
				
				String bookid = request.getParameter("bookiddelb");
				
				String msg=studentService.deletebook(Integer.parseInt(bookid));
				
				
				
				PrintWriter out=null;
				try {
					out = response.getWriter();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				if (msg.equals("success")) {
					out.println("<h1 style='color:green; text-align:center;'>deleted SUCCESFULL</h1>");
				} else {
					out.println("<h1 style='color:green; text-align:center;'>deletion FAILED</h1>");
				}
				out.close();
		 }
				
		 if (request.getRequestURI().endsWith("editform")) {
				String id = request.getParameter("idup");

				Student student = studentService.searchstudent(Integer.parseInt(id));
				PrintWriter out = response.getWriter();
				if (student != null) {
					// display student records as a form data so it is editable
					out.println("<body>");
					out.println("<center>");
					out.println("<form method='post' action='./disp/updaterecord'>");
					out.println("<table>");
					out.println("<tr><th>ID</th><td>" + student.getId() + "</td></tr>");
					out.println("<input type='hidden' name='idup' value='" + student.getId() + "'/>");
					out.println("<tr><th>NAME</th><td><input type='text' name='name' value='" + student.getName()
							+ "'/></td></tr>");
					out.println("<tr><th>AGE</th><td><input type='text' name='age' value='" + student.getAge()
							+ "'/></td></tr>");
					out.println("<tr><th>BOOK1</th><td><input type='text' name='book1' value='" + student.getBook1()
							+ "'/></td></tr>");
					out.println("<tr><th>BOOK2</th><td><input type='text' name='book2' value='" + student.getBook2()
					+ "'/></td></tr>");
					out.println("<tr><th>BOOK3</th><td><input type='text' name='book3' value='" + student.getBook3()
					+ "'/></td></tr>");
					out.println("<tr><th>DATE</th><td><input type='text' name='date' value='" + student.getDate()
					+ "'/></td></tr>");
					out.println("<tr><td></td><td><input type='submit' value='update'/></td></tr>");
					out.println("</table>");
					out.println("</form>");
					out.println("</center>");
					out.println("</body>");
				} else {
					// display not found message
					out.println("<body>");
					out.println("<h1 style='color:red;text-align:center;'>Record not avaialable for the give id :: " + id
							+ "</h1>");
					out.println("</body>");
				}
				out.close();
			}
			if (request.getRequestURI().endsWith("updaterecord")) {
				String id = request.getParameter("idup");
				String name = request.getParameter("name");
				String age = request.getParameter("age");
				String book1 = request.getParameter("book1");
				String book2 = request.getParameter("book2");
				String book3 = request.getParameter("book3");
				String date = request.getParameter("date");

				Student student = new Student();
				student.setId(Integer.parseInt(id));
				 student.setName(name);
				 
				student.setAge(Integer.parseInt(age));
				student.setBook1(book1)  ;
				student.setBook2(book2)  ;
				student.setBook3(book3); 
				student.setDate(date); ;
				//System.out.println()
				

				String status = studentService.updateStudent(student);
				PrintWriter out = response.getWriter();

				if (status.equals("success")) {
					out.println("<h1 style='color:green; text-align:center;'>STUDENT RECORD UPDATED SUCCESSFULLY</h1>");
				} else {
					out.println("<h1 style='color:green; text-align:center;'>STUDENT RECORD UPDATION FAILED</h1>");
				}
				out.close();

			}
			if (request.getRequestURI().endsWith("editbook")) {
				String bookid = request.getParameter("bookidup");

				Student student = studentService.searchbook(Integer.parseInt(bookid));
				PrintWriter out = response.getWriter();
				if (student != null) {
					// display student records as a form data so it is editable
					out.println("<body>");
					out.println("<center>");
					out.println("<form method='post' action='./disp/updatebook'>");
					out.println("<table>");
					out.println("<tr><th>BOOKID</th><td>" + student.getBookid()+ "</td></tr>");
					out.println("<input type='hidden' name='bookidup' value='" + student.getBookid() + "'/>");
					out.println("<tr><th>BOOKNAME</th><td><input type='text' name='bookname' value='" + student.getBookname()
							+ "'/></td></tr>");
					out.println("<tr><th>BOOKAUTHOR</th><td><input type='text' name='bookauthor' value='" + student.getBookauthor()
							+ "'/></td></tr>");
					
					out.println("<tr><td></td><td><input type='submit' value='update'/></td></tr>");
					out.println("</table>");
					out.println("</form>");
					out.println("</center>");
					out.println("</body>");
				} else {
					// display not found message
					out.println("<body>");
					out.println("<h1 style='color:red;text-align:center;'>Record not avaialable for the give id :: " + bookid
							+ "</h1>");
					out.println("</body>");
				}
				out.close();
			}
			if (request.getRequestURI().endsWith("updatebook")) {
				String bookid= request.getParameter("bookidup");
				String bookname = request.getParameter("bookname");
				String bookauthor = request.getParameter("bookauthor");
				
				Student student = new Student();
				student.setBookid(Integer.parseInt(bookid));
				student.setBookname(bookname);
				student.setBookauthor(bookauthor)  ;
				
				

				String status = studentService.updatebook(student);
				PrintWriter out = response.getWriter();

				if (status.equals("success")) {
					out.println("<h1 style='color:green; text-align:center;'>BOOK RECORD UPDATED SUCCESSFULLY</h1>");
				} else {
					out.println("<h1 style='color:green; text-align:center;'>BOOK RECORD UPDATION FAILED</h1>");
				}
				out.close();

			}
			if (request.getRequestURI().endsWith("validation")) {
				String username = request.getParameter("username");
				String password = request.getParameter("password");
				PrintWriter out = response.getWriter();
				String v1 = "sravani202";
				String p1 ="V202";
				if(username.equalsIgnoreCase(v1) && password.equalsIgnoreCase(p1))
				{
					out.println("<body bgcolor='#ff9999'>");
					out.println("<frameset cols='80%'>");
					out.println("<frame src='home.html'/>");
					
					out.println("<center>");
					//out.println("<body bgcolor='#ff9999'>");
					out.println("<h1><a href='../menu.html' target='body'>go to library</h1></a><br/><br/>");
					//out.println("<h1><a href='../updateform.html 'target='body'>UPDATE</h1></a><br/><br/>");
					
					out.println("</frameset>");
					out.println("</center>");
				}
				//out.println("<h1><a href='../menu.html' target='body'> hi go to library</h1></a><br/><br/>");
				else
				{
					System.out.print(username);
					System.out.println(password);
					out.println("<h3> enter the correct username and password</h3>");
				}
				out.close();
			}
			
	}

	

}
