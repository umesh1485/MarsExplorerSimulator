package com.mars.explorer.tests;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.mars.explorer.data.MarsExplorerData;
import com.mars.explorer.util.MarsExplorerUtil;

public class TestMarsExplorerUtil {

	@Test
	public void testPlaceBlockExplorerReport(){
		MarsExplorerUtil.place(0, 0);
		MarsExplorerUtil.block(0, 2);
		MarsExplorerUtil.explorer(0, 3);
		List<String> path = new ArrayList<>();
		path.add(0+","+0);
		path.add(0+","+1);
		path.add(1+","+1);
		path.add(1+","+2);
		path.add(1+","+3);
		path.add(0+","+3);
		Assert.assertTrue(MarsExplorerData.path.equals(path));
		
		List<String> exploredUnits = new ArrayList<>();
		exploredUnits.add(0+","+0);
		exploredUnits.add(0+","+3);
		
		Assert.assertTrue(MarsExplorerData.exploredUnits.equals(exploredUnits));
		Assert.assertTrue(MarsExplorerData.currentPosition.equals(0+","+3));
		
		

	}
}
