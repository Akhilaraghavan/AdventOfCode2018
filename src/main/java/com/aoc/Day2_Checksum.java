package com.aoc;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;

public class Day2_Checksum {
	public static void main(String args[]) throws Exception {
		URL resource = Thread.currentThread().getContextClassLoader().getResource("Day2.txt");
		List<String> lines = Files.readAllLines(Paths.get(resource.toURI()));
		long twoCount = 0;
		long  threeCount = 0;
		
		for (String line : lines) {
			Map<String,Long> map = new HashMap<>();
			for (int i =0;i<line.length();i++) {
				String s = String.valueOf(line.charAt(i));
				map.compute(s, (k,v)-> v==null ? 1: ++v);
			}
			 Optional<Entry<String,Long>> optional = map.entrySet().stream().filter(e-> e.getValue()==2).findFirst();
			 if (optional.isPresent()) {
				 ++twoCount;
			 }
			 optional = map.entrySet().stream().filter(e-> e.getValue()==3).findFirst();
			 if (optional.isPresent()) {
				 ++threeCount;
			 }
		}
		System.out.println("Checksum is : " + twoCount * threeCount);
		
		boolean found = false;
		while (!found) {
			String line = lines.remove(0);
			boolean oneDiff = false;
			StringBuilder sb = new StringBuilder();
		
			for (String s : lines) {
				oneDiff = false;
				sb = new StringBuilder();
			
				if (line.length() != s.length()) {
					continue;
				}
				for (int i = 0; i<line.length();i++) {
					if (line.charAt(i) == s.charAt(i)) {
						sb.append(String.valueOf(line.charAt(i)));
						continue;
					}
					if (oneDiff) {
						oneDiff = false;
						break;
					}
					oneDiff = true;		
				}
				if (oneDiff) {
					found = true;
					break;
				}
			}
			
			if (found) {
				System.out.println("Common characters : "+ sb.toString());
			}
		}
	}
}
