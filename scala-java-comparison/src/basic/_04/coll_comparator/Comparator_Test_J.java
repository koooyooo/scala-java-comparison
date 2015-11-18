package basic._04.coll_comparator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.*;

public class Comparator_Test_J {
	
	/**
	 * [API 8以前]
	 * Comparatorを実装したクラスを利用したソート
	 * 
	 * シナリオ：人物の情報が格納されたリストを年齢でソートする
	 * 着眼点： 8以前では主に Comparatorを実装した実現したが、そもそもComparatorの責任範囲は関数相当であった。
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void test() {
		final List<Person> personList = 
				Arrays.asList(
						new Person("Alice", 20),
						new Person("James", 35),
						new Person("Tonny", 50),
						new Person("Jack",  15));
		
		// ソート処理。右の処理と同等。Collections.sort(list, c);
		personList.sort(new PersonAgeComparator<Person>());
		
		assertThat(personList, is(Arrays.asList(
				new Person("Jack",  15),
				new Person("Alice", 20),
				new Person("James", 35),
				new Person("Tonny", 50))));
	}
	
	/**
	 * [API 8以降]
	 * 関数を利用して実現したソート (関数の実装は Comparatorと同等)
	 * 
	 * シナリオ：人物の情報が格納されたリストを年齢でソートする
	 * 着眼点： 関数を利用することで、コードは簡素化された。
	 * 		  但し、8以前で利用した様な汎用的なComparatorは無いので、比較処理を使い回す際には
	 *        Function自体を変数として宣言しておき、適宜参照を配分させる必要がある。
	 */
	@Test
	public void test2() {
		final List<Person> personList = 
				Arrays.asList(
						new Person("Alice", 20),
						new Person("James", 35),
						new Person("Tonny", 50),
						new Person("Jack",  15));
		
		final List<Person> sortedList = 
				personList.stream().sorted(
						(p1, p2) -> p1.age() - p2.age()).collect(Collectors.toList());
		
		assertThat(sortedList, is(Arrays.asList(
				new Person("Jack",  15),
				new Person("Alice", 20),
				new Person("James", 35),
				new Person("Tonny", 50))));
	}
	
}
