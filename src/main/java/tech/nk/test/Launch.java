package tech.nk.test;

import java.util.ArrayList;

import tech.nk.dao.ConnectionFactory;
import tech.nk.dao.ContactDaoImpl;
import tech.nk.model.ContactPojo;

public class Launch {

	public static void main(String[] args) {
		
		ArrayList<ContactPojo> readContact=new ContactDaoImpl().readContact();
		for(ContactPojo cp:readContact)
		{
			System.out.println(cp);
		}
	}
}
