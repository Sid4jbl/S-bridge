package collectionsChallenge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
public class Demo {

	public static void main(String[] args) {
		Person person1 = new Person("Sridhar","21","Hyderabad");
		Person person2 = new Person("Phani","24","Delhi");
		Person person3 = new Person("Somu","36","Pune");
		Person person4 = new Person("Sridhar","21","Chennai");
		Person person5 = new Person("Mahesh","45","Mumbai");
		List<Person> personList = new ArrayList<>();
		personList.add(person1);
		personList.add(person2);
		personList.add(person3);
		personList.add(person4);
		personList.add(person5);
		
		System.out.println("Person List : "+ personList);
		List<Person> newList = personList.stream().filter(disctinctByName(p->p.getName())).collect(Collectors.toList());
		System.out.println("New filtered List: "+newList);
		System.out.println("Person name List:" +personList.stream().map(Person:: getName).distinct().collect(Collectors.toList()));
		
		
		
		
		
	}
	
	public  static <T> Predicate<T> disctinctByName(Function<? super T,?> nameCheck){
		
		Map<Object , Boolean> present = new HashMap<>();
		return t -> present.putIfAbsent(nameCheck.apply(t), Boolean.TRUE)==null;
		
	}

}
