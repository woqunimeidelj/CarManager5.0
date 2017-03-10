package com.hsz.maven.utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Utils {
	/**
	 * 将set集合转化为List
	 * @param sets
	 * @return
	 */
	public static <T> List<T> setToList(Set<T> sets) {
		List<T> lists = new ArrayList<T>();
		for (T f : sets) {
			lists.add(f);
		}
		return lists;
	}
	
	/**
	 * 将list转化为set
	 * @param lists
	 * @return
	 */
	public static <T> Set<T> listToSet(List<T> lists) {
		Set<T> sets = new HashSet<T>();
		for (T f : lists) {
			sets.add(f);
		}
		return sets;
	}
}
