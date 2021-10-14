package com.jpa.test;


import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.jpa.test.dao.UserRepository;
import com.jpa.test.entities.User;


@SpringBootApplication
public class CruDoperations1Application {
	static Scanner sc = new Scanner(System.in);

	public static void create(int id, String name, String city, String domain, UserRepository userRepository) {
		User user = new User();
		user.setId(id);
		user.setName(name);
		user.setCity(city);
		user.setdomain(domain);
		User u = userRepository.save(user);
		System.out.println(u);
	}

	public static void update(int id, UserRepository userRepository)  {
		String field;
		//if(userRepository.findById(id) == null) throw new APIexception();
		java.util.Optional<User> optional = userRepository.findById(id);
		User u = optional.get();
		
		String name;
		System.out.println("enter name : ");
		name = sc.nextLine();
		u.setName(name);
		
		String city;
		System.out.println("enter city : ");
		city = sc.nextLine();
		u.setCity(city);
		
		String domain;
		System.out.println("enter domain : ");
		domain = sc.nextLine();
		u.setdomain(domain);
		
		
		
		/*System.out.println("enter the field that needs to be updated : ");
		field = sc.next();
		if (field == "name") {
			String name;
			System.out.println("enter name : ");
			name = sc.nextLine();
			
			u.setName(name);
		}
		else if (field == "city") {
			String city;
			System.out.println("enter city : ");
			city = sc.nextLine();
		
			u.setCity(city);
		}
		else if (field == "domain") {
			String domain;
			System.out.println("enter domain : ");
			domain = sc.nextLine();
			u.setdomain(domain);
		}
		*/
		
		User result = userRepository.save(u);
		System.out.println(result);
	}
	public static void read(UserRepository userRepository) {
		int choice;
		System.out.println("Press 1 to see all entries or 2 for individual entry : ");
		choice = sc.nextInt();
		if(choice == 1) {
			Iterable<User> itr = userRepository.findAll();
			itr.forEach(user->{System.out.println(user);});
		}
		else if(choice == 2){
			int id;
			System.out.println("Enter Id : ");
			id = sc.nextInt();
			java.util.Optional<User> user = userRepository.findById(id);
			User u = user.get();
			System.out.println(u);
		}else {
			System.out.println("Wrong Choice");
		}
	}
	
	public static void delete(UserRepository userRepository) {
		int choice;
		System.out.println("Press 1 to delete all entries or 2 for individual entry : ");
		choice = sc.nextInt();
		if(choice == 1) {
			userRepository.deleteAll();
		}
		else if(choice == 2){
			int id;
			System.out.println("Enter id : ");
			id = sc.nextInt();
			userRepository.deleteById(id);
		}
		else {
			System.out.println("Wrong Choice");
		}
		
	}

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(CruDoperations1Application.class, args);

		UserRepository userRepository = context.getBean(UserRepository.class);
		
		int choice;
		System.out.println("Enter 1 for Insertion.\n Enter 2 for read\n Enter 3 for update\n Enter 4 for delete\n");
		choice = sc.nextInt();
		sc.nextLine();
		
		switch(choice) {
		case 1:
			String name, city, domain;
			int id;
			System.out.println("Enter ID : ");
			id = sc.nextInt();
			sc.nextLine();
			System.out.println("Enter name : ");
			name = sc.nextLine();
			System.out.println("Enter city : ");
			city = sc.nextLine();
			System.out.println("Enter domain : ");
			domain = sc.nextLine();
			create(id, name, city, domain, userRepository);
			break;
		
		case 2: 
			read(userRepository);
			break;
			
		case 3:
			int Rid;
			System.out.println("enter user ID : ");
			Rid = sc.nextInt();
			update(Rid,userRepository);
			break;
			
		case 4:
			delete(userRepository);
			break;
			
		default:
			System.out.println("WRONG CHOICE");
			break;
			
		}
		// cReate
		/*String name, city, domain;
		System.out.println("Enter name : ");
		name = sc.nextLine();
		System.out.println("Enter city : ");
		city = sc.nextLine();
		System.out.println("Enter domain : ");
		domain = sc.nextLine();
		create(name, city, domain, userRepository);*/

		// update

		/*int Rid;
		System.out.println("enter user ID : ");
		Rid = sc.nextInt();
		update(Rid,userRepository);
		
		*/
		//read(userRepository);
		
		

		

	}

}
