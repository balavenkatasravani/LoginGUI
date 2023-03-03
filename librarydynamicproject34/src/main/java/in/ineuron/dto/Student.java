package in.ineuron.dto;

import java.io.Serializable;

public class Student implements Serializable {
	private static final long serialVersionUID = 1L;
 private Integer id;
 private String name;
 private Integer age;
 private String	book1;
 private String	book2;
 private String	book3;
 private Integer bookid;
 private String date;
 
 public String getDate() {
	return date;
}

public void setDate(String date) {
	this.date = date;
}

public Integer getBookid() {
	return bookid;
}

public void setBookid(Integer bookid) {
	this.bookid = bookid;
}

public String getBookname() {
	return bookname;
}

public void setBookname(String bookname) {
	this.bookname = bookname;
}

public String getBookauthor() {
	return bookauthor;
}

public void setBookauthor(String bookauthor) {
	this.bookauthor = bookauthor;
}

private String	bookname;
 private String	bookauthor;


@Override
public String toString() {
	return "Student [id=" + id + ", name=" + name + ", age=" + age + ", book1=" + book1 + ", book2=" + book2
			+ ", book3=" + book3 + ", bookid=" + bookid + ", date=" + date + ", bookname=" + bookname + ", bookauthor="
			+ bookauthor + "]";
}

public Integer getId() {
	return id;
}

//@Override
//public String toString() {
//	return "Student [id=" + id + ", name=" + name + ", age=" + age + ", book1=" + book1 + ", book2=" + book2
//			+ ", book3=" + book3 + ", bookid=" + bookid + ", bookname=" + bookname + ", bookauthor=" + bookauthor + "]";
//}

public void setId(Integer id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public Integer getAge() {
	return age;
}

public void setAge(Integer age) {
	this.age = age;
}

public String getBook1() {
	return book1;
}

public void setBook1(String book1) {
	this.book1 = book1;
}

public String getBook2() {
	return book2;
}

public void setBook2(String book2) {
	this.book2 = book2;
}

public String getBook3() {
	return book3;
}

public void setBook3(String book3) {
	this.book3 = book3;
}

public static long getSerialversionuid() {
	return serialVersionUID;
}


}

