package method_reference;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Sub set of lambda expression We may be able to use method reference if lambda
 * expression is possible
 * 
 * @author king
 *
 */
public class MethodReference {

	public static void main(String[] args) {
		List<String> names = new ArrayList<>();
		List<String> namesNew = new ArrayList<>();

		names.add("Mahesh");
		names.add("Suresh");

		// static methods
		names.forEach(System.out::println);

		// instance method;
		names.forEach(namesNew::add);

		// Reference to an instance method of an arbitrary object of a particular type
		List<Person> personList = new ArrayList<>();
		personList.add(new Person("Shafi"));
		personList.add(new Person("Shameer"));
		personList.forEach(Person::getName);
		
		// Constructor
		
		//1. no-arg constructor using Supplier Interface
		//Anonymous class
		Supplier<String> stringSupplier1 = new Supplier<String>() {
			@Override
			public String get() {
				return new String();
			}
		};
		System.out.println("Anonymous Supplier : "+stringSupplier1.get().length());
		
		//Lambda
		Supplier<String> stringSupplier2 = () -> new String();
		System.out.println("Lambda Supplier : "+stringSupplier2.get().length());
		
		//Method Reference
		Supplier<String> stringSupplier3 = String::new;
		System.out.println("Method reference Supplier : "+stringSupplier3.get().length());
		
		
		
		//2. single-arg constructor using 
		//Anonymous class
		Function<String, String> function1 = new Function<String, String>() {
			@Override
			public String apply(String t) {
				return new String(t);
			}
		};
		System.out.println("Anonymous Function :"+function1.apply("Shafi"));
		
		//Lambda
		Function<String, String> function2 = (s) -> new String(s);
		System.out.println("Lambda Function :"+function2.apply("Shafi"));
		
		//Method Inference
		Function<String, String> function3 = String::new;
		System.out.println("Reference Function :"+function3.apply("Shafi"));
		
		//3. 2-args constructor using
		//anonymous
		BiFunction<String, String, Locale> biFunction1 = new BiFunction<String, String, Locale>() {
			  public Locale apply(String lang, String country) {
			    return new Locale(lang, country);
			  }
		};
		System.out.println("Bifunction Anonymous: "+biFunction1.apply("en", "UK"));
		//Lambda
		BiFunction<String, String, Locale> biFunction2 = (s1, s2) -> new Locale(s1, s2);
		System.out.println("Bifunction Anonymous: "+biFunction1.apply("en", "IN"));
		
		//Method reference
		BiFunction<String, String, Locale> biFunction3 = Locale::new;
		System.out.println("Bifunction Anonymous: "+biFunction3.apply("en", "US"));
		
		//4. 3-args constructor using user defined Functional interface 
		//Anonymous
		TriFunction<String, String, String, Employee> triFunction1 = new TriFunction<String, String, String, Employee>() {
			@Override
			public Employee apply(String u, String v, String w) {
				return new  Employee(u, v, w);
			}
		};
		System.out.println("Trifunction anonymous : "+triFunction1.apply("Shafi", "12345", "Software Developer"));
		
		//Lambda
		TriFunction<String, String, String, Employee> triFunction2 = (s1, s2, s3) -> new Employee(s1, s2, s3);
		System.out.println("Trifunction Lambda : "+triFunction1.apply("Shafi", "67890", "Tech Lead"));
		
		//Method reference
		TriFunction<String, String, String, Employee> triFunction3 = Employee::new;
		System.out.println("Trifunction Method reference : "+triFunction3.apply("Shafi", "1357", "Architect"));
		
	}

}

class Person{
	private String name;

	public Person(String name) {
		super();
		this.name = name;
	}

	public void getName() {
		System.out.println("Person.getName():"+name);
	
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
