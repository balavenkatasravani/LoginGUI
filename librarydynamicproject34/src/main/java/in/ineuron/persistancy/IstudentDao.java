package in.ineuron.persistancy;
import in.ineuron.dto.Student;
public interface IstudentDao {

	public String addStudent(Student student);
	public Student searchstudent(Integer id);
	public String deleteStudent(Integer id);
	public String updateStudent(Student student);
	public Student searchbook(Integer bookid);
	public Student searchbook(String bookauthor);
	public Student searchbook1(String bookname);
	public String updatebook(Student student);
	public String addbook(Student student);
	public String deletebook(Integer bookid);
}
