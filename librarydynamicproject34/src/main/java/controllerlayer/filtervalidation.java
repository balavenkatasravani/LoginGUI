package controllerlayer;

import java.io.IOException;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import java.io.PrintWriter;

import in.ineuron.dto.Student;
import in.ineuron.service.Istudentservice;
import in.ineuron.servicefactory.studentserviceFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;

/**
 * Servlet Filter implementation class filtervalidation
 */
@WebFilter("/disp/*")

public class filtervalidation implements Filter {
	public void init(FilterConfig fConfig) throws ServletException {
		
		// TODO Auto-generated method stub
	}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String eid_err_msg = "", ename_err_msg = "", eage_err_msg = "", email_err_msg = "", mobile_err_msg = "";
		boolean flag = false;
		Istudentservice studentService=	studentserviceFactory.getstudentService();
		
		String bookiddelb = request.getParameter("bookiddelb");
			String idup = request.getParameter("idup");
			String date = request.getParameter("date");
			String id = request.getParameter("id");
			String cid = request.getParameter("cid");
			String ids = request.getParameter("ids");
			System.out.println(ids);
			String iddelf = request.getParameter("iddelf");
			String iddelb= request.getParameter("iddelb");
			String bookida = request.getParameter("bookida");
			String bookidup = request.getParameter("bookidup");
			String bookname = request.getParameter("bookname");
			String bookauthor = request.getParameter("bookauthor");
			String username=request.getParameter("username");
			System.out.println(bookida);
//			if(id==null||id.equals("")) {
//				//flag=true;
//				chain.doFilter(request, response);
			
			if(bookiddelb!=null||ids!=null||username!=null) {
				//flag=true;
				chain.doFilter(request, response);
			}
			
			if(iddelf!=null||cid!=null) {
				//flag=true;
				chain.doFilter(request, response);
			}
			if(iddelb!=null) {
				//flag=true;
				chain.doFilter(request, response);
			}
			if(bookida!=null) {
				//flag=true;
				chain.doFilter(request, response);
			}
			if(date!=null) {
				//flag=true;
				chain.doFilter(request, response);
			}
			if(id==null||id.equals("")) {
				//flag=true;
				chain.doFilter(request, response);
			}
			if(bookname!=null) {
				//flag=true;
				chain.doFilter(request, response);
			}
			if(bookauthor!=null) {
				//flag=true;
				chain.doFilter(request, response);
			}
			if(idup!=null){
				
					Student student1 ;
		    student1 = studentService.searchstudent(Integer.parseInt(idup));
			//Student student = studentService.searchstudent(Integer.parseInt(id));
			student1.getId() ;
		Student student = new Student();
		student.setId(Integer.parseInt(idup));
			PrintWriter out = response.getWriter();
			if (true){
				out.println("<body>");
				out.println("<br/><br/><br/>");
				out.println("<center>");
				out.println("<table border='1'>");
				out.println("<tr><th>ID</th><td>" + student1.getId() + "</td></tr>");
				out.println("<tr><th>NAME</th><td>" + student1.getName() + "</td></tr>");
				out.println("<tr><th>AGE</th><td>" + student1.getAge() + "</td></tr>");
				out.println("<tr><th>book1</th><td>" + student1.getBook1() + "</td></tr>");
				out.println("<tr><th>book2</th><td>" + student1.getBook2() + "</td></tr>");
				out.println("<tr><th>book3</th><td>" + student1.getBook3() + "</td></tr>");
				out.println("</table>");
				out.println("</center>");
				out.println("</body>");
			} else {
				out.println("<h1 style='color:red;text-align:center;'>RECORD NOT AVAILABLE FOR THE GIVEN ID " + id
						+ "</h1>");
			}
			//out1.close();
			System.out.println(id+"filter");
			//PrintWriter out = response.getWriter();
			if (student1.getBook1().equalsIgnoreCase("s")) {
			flag=true;
			}
			else if(student1.getBook2().equalsIgnoreCase("s"))
				{flag=true;}
			else if(student1.getBook3().equalsIgnoreCase("s"))
					{
				flag=true;	
					}
			else {
//				out.println("<h1 style='color:red;text-align:center;'>limited :: " + id
//						+ "</h1>");
				
				//eid_err_msg = "Employee id is required";
				
				System.out.println(id+"you have a space");
				flag=false;
			}
//			} else {
//				if (Integer.parseInt(sid) ==6) {
//					eid_err_msg = "Employee id within 20 to 30";
//					flag = true;
//					System.out.println(sid+" range");
//				} else {
//					flag = false;
//				}
//			}
			if (flag == true) {
				chain.doFilter(request, response);
					
			} else {
				out.println("<h1 style='color:red;text-align:center;'>your limit excesseded :: " + id
						+ "</h1>");
//				out.println("<html><head><title>Output</title></head>");
//				out.println("<body bgcolor='lightgreen'>");
//				out.println("<center>");
//				out.println("<h1 style='color:red; text-align:center;'>Employee Registration Details</h1>");
//				out.println("<form method='post' action='./disp/searchform'>");
//				out.println("<table>");
//				out.println("<tr><th>ID</th><td><input type='text' name ='id' value='" + id + "'/>bye</td><td> <font color='red' size ='5'>"
//						+ eid_err_msg + "</font></td></tr>");
//				
//				out.println("<tr><td></td><td><input type='submit' value='reg'/></td></tr>");
//				out.println("</table>");
//				out.println("</form>");
//				out.println("</center>");
//				out.println("</body>");
//				out.println("</html>");

			}
			}
			else
			{
				chain.doFilter(request, response);
			}
			
	}	
	
		

	public void destroy() {

	}
	
}
