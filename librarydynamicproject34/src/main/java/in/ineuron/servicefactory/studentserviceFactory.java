package in.ineuron.servicefactory;

import in.ineuron.service.Istudentservice;
import in.ineuron.service.studentServiceimpl;

public class studentserviceFactory {
	private studentserviceFactory() {
		
	}
private static Istudentservice studentservice=null;
public static Istudentservice getstudentService()
{
	if(studentservice==null)
	{
		studentservice=new studentServiceimpl();
		
	}
	return studentservice;
}
}
