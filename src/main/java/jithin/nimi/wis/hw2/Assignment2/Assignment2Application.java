package jithin.nimi.wis.hw2.Assignment2;

import jithin.nimi.wis.hw2.Assignment2.model.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;

@SpringBootApplication
public class Assignment2Application {

	public static HashMap<String, Student> studentHashMap;

	public static void main(String[] args) {

		studentHashMap = new HashMap<String, Student>();


		Student std1 = new Student("Nimi Jithin", "WIS");
		studentHashMap.put(std1.getId(),std1);

		Student std2 = new Student("Joel Alex", "WIS");
		studentHashMap.put(std2.getId(),std2);

		Student std3 = new Student("Rebecca Thomas", "WIS");
		studentHashMap.put(std3.getId(),std3);

		SpringApplication.run(Assignment2Application.class, args);

	}
}
