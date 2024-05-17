package com.coderscampus;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Map;
import java.util.Map.Entry;

public class MapService {
	public <K, V extends Comparable<V>> V getLargestValueInMap(Map<K, V> map) {
		Entry<K, V> maxEntry = Collections.max(map.entrySet(),
				(Entry<K, V> entry1, Entry<K, V> entry2) -> entry1.getValue().compareTo(entry2.getValue()));
		return maxEntry.getValue();
	}

	public <K, V extends Comparable<V>> V getSmallestValueInMap(Map<K, V> map) {
		Entry<K, V> maxEntry = Collections.min(map.entrySet(),
				(Entry<K, V> entry1, Entry<K, V> entry2) -> entry1.getValue().compareTo(entry2.getValue()));
		return maxEntry.getValue();
	}

	public Entry<LocalDate, Integer> findEntryByValue(Map<LocalDate, Integer> map, int value) {
		for (Map.Entry<LocalDate, Integer> entry : map.entrySet()) {
			if (entry.getValue() == value) {
				return entry;
			}
		}
		return null;
	}
}
