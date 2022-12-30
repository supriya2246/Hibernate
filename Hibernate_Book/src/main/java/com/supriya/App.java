package com.supriya;

import java.util.ArrayList;
import org.hibernate.Session;

import com.supriya.Entity.Book;
import com.supriya.Util.HibernateUtil;

public class App
{
 public static void main( String[] args )
 {
	 Session ss=HibernateUtil.getSessionFactory().openSession();
	 ss.beginTransaction();

	 ArrayList<Book> l=new ArrayList<Book>();
	 Book b=new Book("Adv_Java","Rechard");
	 Book b1=new Book("Hibernate","Sathish");
	 Book b2=new Book("Spring_Boot","Nandha Kumar");
	 Book b3=new Book("Core_Java","Lavanya");

	 l.add(b); l.add(b1); l.add(b2); l.add(b3);
	 // save the book objects
	 l.forEach(n->ss.save(n));
	 //do changes
	 b2.setAuthor("Ram");
	 // update the Book object
	 ss.saveOrUpdate(b2);
	 
	 b.setAuthor("Ravi");
	 // update the Book object
	 ss.saveOrUpdate(b);

	 // get Book entity using get() method
	 System.out.println("using get() method");
	 Book book = ss.get(Book.class, 2);
	 System.out.println("Book name: "+book.getBookName());
	 System.out.println("Book Author: "+book.getAuthor());
	 // get Book entity using load() method
	 System.out.println("using load() method");
	 Book book1 = ss.load(Book.class, 2);
	 System.out.println("Book name: "+book1.getBookName());
	 System.out.println("Book Author: "+book1.getAuthor());
	 // Obtain an entity using byId() method
	 System.out.println("using byId() method");
	 Book book2 = ss.load(Book.class, 2);
	 System.out.println("Book name: "+book2.getBookName());
	 System.out.println("Book Author: "+book2.getAuthor());

	 //delete a persistent Book object
	 if(b3 !=null) {
	 ss.delete(b3); }

	 ss.getTransaction().commit();
	 System.out.println("Txn completed");
	 }
	}