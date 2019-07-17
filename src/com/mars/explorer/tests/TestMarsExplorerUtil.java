package com.mars.explorer.tests;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import com.mars.explorer.data.MarsExplorerData;
import com.mars.explorer.util.MarsExplorerUtil;

public class TestMarsExplorerUtil {
	@Before
	public void refresh(){
		MarsExplorerData.exploredUnits.clear();
		MarsExplorerData.blockedUnits.clear();
		MarsExplorerData.path.clear();
	}
	// this single test will cover PLACE, BLOCK, EXPLORER, REPORT
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
	
	@Test
	public void testPlaceBlock_withoutPlace(){
		
		MarsExplorerUtil.block(0, 2);
		Assert.assertTrue(MarsExplorerData.exploredUnits.size()==0);
		Assert.assertTrue(MarsExplorerData.blockedUnits.size()==0);
	}
	
	@Test
	public void testPlaceExplorer_withoutPlace(){
		
		MarsExplorerUtil.explorer(0, 2);
		Assert.assertTrue(MarsExplorerData.exploredUnits.size()==0);
	}
	
	@Test
	public void testPlaceReport_withoutPlace(){
		
		MarsExplorerUtil.block(0, 2);
		MarsExplorerUtil.explorer(0, 3);
		Assert.assertTrue(MarsExplorerData.exploredUnits.size()==0);
	}
}
