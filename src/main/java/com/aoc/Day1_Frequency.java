package com.aoc;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day1_Frequency {
	
	public static void main(String args[]) throws Exception {
		URL resource = Thread.currentThread().getContextClassLoader().getResource("Day1.txt");
		List<String> lines = Files.readAllLines(Paths.get(resource.toURI()));
		long frequency = lines.stream().mapToLong(line ->  Long.valueOf(line)).sum();
		System.out.println(" Puzzle 1:" + frequency);
		
		Set<Long> frequencies = new HashSet<>();
		frequency = 0;
		boolean found = false;
		while  (!found) {
			for (String line :lines) {
				if (!frequencies.add(frequency)) {
					found = true; 
					break;
				}
				frequency += Long.valueOf(line);
			}
			
			if (found) {
				System.out.println(" Puzzle 2:" + frequency);
			}
		}
	}

}
