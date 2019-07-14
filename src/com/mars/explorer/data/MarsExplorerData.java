package com.mars.explorer.data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MarsExplorerData {

	public static Set<String> blockedUnits = new HashSet<>();
	public static List<String> exploredUnits = new ArrayList<>();
	public static List<String> path = new ArrayList<>();
	public static String currentPosition = "0,0";
	
}
