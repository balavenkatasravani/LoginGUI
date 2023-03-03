package in.ineuron.service;

import in.ineuron.daofactory.studentDaoFactory;
import in.ineuron.dto.Student;
import in.ineuron.persistancy.IstudentDao;
import in.ineuron.servicefactory.studentserviceFactory;

public class studentServiceimpl implements Istudentservice {
	private IstudentDao stdao;
	@Override
	public String addStudent(Student student) {
		 stdao=studentDaoFactory.getstudentDao();
		 
		 return stdao.addStudent(student);
		
	}

	@Override
	public Student searchstudent(Integer id) {
		stdao=studentDaoFactory.getstudentDao();
		 
		 return stdao.searchstudent(id);
		
	}

	@Override
	public String updateStudent(Student student) {
		stdao = studentDaoFactory.getstudentDao();
		return stdao.updateStudent(student);
	}

	@Override
	public String deleteStudent(Integer id) {
		stdao=studentDaoFactory.getstudentDao();
		return stdao.deleteStudent(id);
	}
	@Override
	public Student searchbook(Integer bookid)
	{
		stdao =studentDaoFactory.getstudentDao();
		return stdao.searchbook(bookid);
	}
	@Override
	public Student searchbook(String bookauthor)
	{
	stdao =studentDaoFactory.getstudentDao();
	return stdao.searchbook(bookauthor);
	}
	@Override
	public Student searchbook1(String bookname)
	{
		stdao =studentDaoFactory.getstudentDao();
		return stdao.searchbook(bookname);
	}
	@Override
	public String updatebook(Student student)
	{
		stdao =studentDaoFactory.getstudentDao();
		return stdao.updatebook(student);
	}
	@Override
	public String addbook(Student student) {
		stdao =studentDaoFactory.getstudentDao();
		return stdao.addbook(student);
	}
	@Override
	public String deletebook(Integer bookid)
	{
		stdao =studentDaoFactory.getstudentDao();
		return stdao.deletebook(bookid);
	}

}
