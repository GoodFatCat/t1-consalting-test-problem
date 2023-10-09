package com.github.goodfatcat.t1consaltingtestproblem.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class FinderRepetitionServiceImpl implements FinderRepetitionService {

	@Override
	public Map<String, Integer> findRepetitions(String line) {
		Map<String, Integer> hashMap = new HashMap<>();
		Arrays.stream(line.split("")).forEach(character -> {
			Integer count = hashMap.get(character);
			if (count == null) {
				hashMap.put(character, 1);
			} else {
				hashMap.put(character, ++count);
			}
		});
		return hashMap.entrySet().stream()
				.sorted((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue())).collect(Collectors.toMap(
						entry -> entry.getKey(), entry -> entry.getValue(), (oldValue, newValue) -> oldValue, LinkedHashMap::new));
	}

}
