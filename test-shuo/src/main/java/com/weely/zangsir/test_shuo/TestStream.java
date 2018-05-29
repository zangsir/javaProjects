package testShuo;

import java.util.ArrayList;
import java.util.List;

public class TestStream {
	public static void main(String[] args) {
	//test code on Stream() in java8
	//http://winterbe.com/posts/2014/03/16/java-8-tutorial/
	List<String> stringCollection = new ArrayList<>();
	stringCollection.add("ddd2");
	stringCollection.add("aaa2");
	stringCollection.add("bbb1");
	stringCollection.add("aaa1");
	stringCollection.add("bbb3");
	stringCollection.add("ccc");
	stringCollection.add("bbb2");
	stringCollection.add("ddd1");
	
	stringCollection
    .stream()
    .sorted()
    .filter((s) -> s.startsWith("b"))
    .forEach(System.out::println);
	
	System.out.println(stringCollection);
	
	//map operation
	stringCollection
    .stream()
    .map(String::toUpperCase)
    .sorted((a, b) -> a.compareTo(b))
    .forEach(System.out::println);
	
	//match op
	boolean anyStartsWithA =
		    stringCollection
		        .stream()
		        .anyMatch((s) -> s.startsWith("a"));

		System.out.println(anyStartsWithA);      // true

		boolean allStartsWithA =
		    stringCollection
		        .stream()
		        .allMatch((s) -> s.startsWith("a"));

		System.out.println(allStartsWithA);      // false

		boolean noneStartsWithZ =
		    stringCollection
		        .stream()
		        .noneMatch((s) -> s.startsWith("z"));

		System.out.println(noneStartsWithZ);      // true


	}
}
