package basic._04.coll_comparator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class Comparator_Test_J {
	
	/**
	 * 
	 */
	@Test
	public void test() {
		final List<Person> personList = 
				Arrays.asList(
						new Person("Alice", 20),
						new Person("James", 35),
						new Person("Tonny", 50),
						new Person("Jack",  15));
		
		personList.sort(new PersonAgeComparator<Person>());
		
		assertThat(personList, is(Arrays.asList(
				new Person("Jack",  15),
				new Person("Alice", 20),
				new Person("James", 35),
				new Person("Tonny", 50))));
	}
	
}
