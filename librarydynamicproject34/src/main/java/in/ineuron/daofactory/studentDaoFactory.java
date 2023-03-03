package in.ineuron.daofactory;

import in.ineuron.persistancy.IstudentDao;
import in.ineuron.persistancy.studentDaoimpl;

public class studentDaoFactory {
private studentDaoFactory() {
	
}
 private static IstudentDao studentDao=null;
public  static IstudentDao getstudentDao()
{
	if(studentDao==null) {
	  studentDao=new studentDaoimpl();
	}
	 return studentDao;
	
}
}
