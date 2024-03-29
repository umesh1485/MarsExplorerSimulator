package com.mars.explorer.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.mars.explorer.data.MarsExplorerData;
import com.mars.explorer.util.MarsExplorerUtil;

public class MarsExplorerMain {

	public static void main(String[] args) throws IllegalArgumentException, IOException {
		// TODO Auto-generated method stub

		/*
		 * MarsExplorerUtil.place(0, 0); MarsExplorerUtil.block(0, 2);
		 * MarsExplorerUtil.explorer(0, 3);
		 * 
		 * MarsExplorerUtil.report();
		 */
		optionSelect();

	}

	private static void optionSelect() throws IllegalArgumentException, IOException {
		System.out.println("please select a option and enter:");
		if ((MarsExplorerData.exploredUnits.size() == 0)) {
			System.out.println("Note - Kindly PLACE the toy first to start with further movement.");
		}
		System.out.println("1. PLACE");
		System.out.println("2. BLOCK");
		System.out.println("3. EXPLORER");
		System.out.println("4. REPORT");
		System.out.println("Any key to exit");
		// Enter data using BufferReader
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int x = 0;
		int y = 0;
		switch (Integer.parseInt(reader.readLine().trim())) {
		case 1:
			System.out.println("enter x: ");
			x = Integer.parseInt(reader.readLine().trim());
			System.out.println("enter y: ");
			y = Integer.parseInt(reader.readLine().trim());
			MarsExplorerUtil.place(x, y);
			optionSelect();
			break;
		case 2:
			if (MarsExplorerData.exploredUnits.size() > 0) {
				System.out.println("enter x: ");
				x = Integer.parseInt(reader.readLine().trim());
				System.out.println("enter y: ");
				y = Integer.parseInt(reader.readLine().trim());
				MarsExplorerUtil.block(x, y);
			} else {
				System.out.println("Kindly PLACE the toy first.");
			}
			optionSelect();
			break;
		case 3:
			if (MarsExplorerData.exploredUnits.size() > 0) {
				System.out.println("enter x: ");
				x = Integer.parseInt(reader.readLine().trim());
				System.out.println("enter y: ");
				y = Integer.parseInt(reader.readLine().trim());
				MarsExplorerUtil.explorer(x, y);
			} else {
				System.out.println("Kindly PLACE the toy first.");
			}
			optionSelect();
			break;
		case 4:
			if (MarsExplorerData.exploredUnits.size() > 0) {
				MarsExplorerUtil.report();
			} else {
				System.out.println("Kindly PLACE the toy first.");
			}

			break;
		default:
			System.out.println("Exiting from program.");
		}

	}
}
