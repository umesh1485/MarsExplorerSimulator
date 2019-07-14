package com.mars.explorer.util;

import java.awt.geom.Point2D;
import java.util.HashMap;
import java.util.TreeMap;

import com.mars.explorer.data.MarsExplorerData;

public class MarsExplorerUtil {

	public static void block(int x, int y) {
		String requestedForUnit = x + "," + y;
		if (MarsExplorerData.blockedUnits.contains(requestedForUnit)
				&& requestedForUnit.equals(MarsExplorerData.currentPosition)) {
			System.out.println("requested unit " + requestedForUnit + " can't be blocked");
		} else {
			MarsExplorerData.blockedUnits.add(requestedForUnit);
		}
	}

	public static void explorer(int x, int y) {
		if (x >= 0 && x < 6 && y >= 0 && y < 6 && !MarsExplorerData.blockedUnits.contains(x+","+y)) {
			String sourcePosition = MarsExplorerData.currentPosition;
			while (!MarsExplorerData.currentPosition.equals(x + "," + y)) {
				String nearestMove = getNearestMove(x, y);

				if (nearestMove.equals(x+","+y)) {
					MarsExplorerData.exploredUnits.add(nearestMove);
				}
				MarsExplorerData.currentPosition = nearestMove;
				MarsExplorerData.path.add(nearestMove);
			}
		} else {
			System.out.println("could not explored: " + x + "," + y);
		}
	}

	private static String getNearestMove(double x, double y) {
		String[] currentAxises = MarsExplorerData.currentPosition.split(",");
		TreeMap<Double, String> possibleMove = new TreeMap<>();
		int xAxis = Integer.parseInt(currentAxises[0]);
		int yAxis = Integer.parseInt(currentAxises[1]);
		// for xAxis
		if ((xAxis - 1) >= 0) {
			String xmovedown = (xAxis - 1) + "," + yAxis;
			if (!MarsExplorerData.blockedUnits.contains(xmovedown)) {
				String[] movesArr = xmovedown.split(",");
				Double diff = Point2D.distance(Double.parseDouble(movesArr[0]), Double.parseDouble(movesArr[1]), x, y);
				possibleMove.put(diff, xmovedown);
			}
		}
		if ((xAxis + 1) < 6) {
			String xmoveup = (xAxis + 1) + "," + yAxis;
			if (!MarsExplorerData.blockedUnits.contains(xmoveup)) {
				String[] movesArr = xmoveup.split(",");
				Double diff = Point2D.distance(Double.parseDouble(movesArr[0]), Double.parseDouble(movesArr[1]), x, y);
				possibleMove.put(diff, xmoveup);
			}
		}

		// for yAxis
		if ((yAxis - 1) >= 0) {
			String ymovedown = xAxis + "," + (yAxis - 1);
			if (!MarsExplorerData.blockedUnits.contains(ymovedown)) {
				String[] movesArr = ymovedown.split(",");
				Double diff = Point2D.distance(Double.parseDouble(movesArr[0]), Double.parseDouble(movesArr[1]), x, y);
				possibleMove.put(diff, ymovedown);
			}
		}
		if ((yAxis + 1) < 6) {
			String ymoveup = xAxis + "," + (yAxis + 1);
			if (!MarsExplorerData.blockedUnits.contains(ymoveup)) {
				String[] movesArr = ymoveup.split(",");
				Double diff = Point2D.distance(Double.parseDouble(movesArr[0]), Double.parseDouble(movesArr[1]), x, y);

				possibleMove.put(diff, ymoveup);
			}
		}

		return possibleMove.get(possibleMove.firstKey());

	}

	public static void report() {
		if(!MarsExplorerData.path.isEmpty()){
			System.out.println("path  "+MarsExplorerData.path.toString());
			MarsExplorerData.path.clear();
		}
		System.out.println("E: " + MarsExplorerData.exploredUnits.toString());
		System.out.println("B: " + MarsExplorerData.blockedUnits.toString());
	}

	public static void place(int x, int y) {

		MarsExplorerData.currentPosition = x + "," + y;
		MarsExplorerData.exploredUnits.clear();
		MarsExplorerData.blockedUnits.clear();
		MarsExplorerData.exploredUnits.add(x + "," + y);
		MarsExplorerData.path.add(x+","+y);
	}

	private static String getMovementFromCurrentPosition(int targetX, int targetY) {
		int currentX = Integer.parseInt(MarsExplorerData.currentPosition.split(",")[0]);
		int currentY = Integer.parseInt(MarsExplorerData.currentPosition.split(",")[1]);
		if (targetX - currentX != 0 && (targetX - currentX) > 0) {
			return "X-forward";
		} else if (targetX - currentX != 0 && (targetX - currentX) < 0) {
			return "X-downward";
		} else if (targetY - currentY != 0 && (targetY - currentY) > 0) {
			return "Y-forward";
		} else if (targetY - currentY != 0 && (targetY - currentY) < 0) {
			return "Y-downward";
		} else {
			return "";
		}
	}
}
