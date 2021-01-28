package com.subham.test;

import java.util.List;

/**
 * @author <b>Subham Santra</b>
 *
 */
public class Test {
	public static void main(String[] args) {
		List<String> lists = List.of("Subham");
		System.out.println(lists);
		String textBlock = """
				1. Hey, how are you??
				2. I'm fine!!
				""";
		System.out.println(textBlock);
		System.out.println(new Mango());
	}
}
