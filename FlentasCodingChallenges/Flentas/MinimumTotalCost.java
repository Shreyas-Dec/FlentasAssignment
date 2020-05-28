package com.challenge.Flentas;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MinimumTotalCost {

	/**
	 * This method will provide the minimum cost for the particular trip
	 * 
	 */
	public static void totalMinimumCost() {

		Scanner sc = new Scanner(System.in);

		Integer TestCase = 0;

		try {
			System.out.print("Enter number betwen 1 and 10: ");
			TestCase = sc.nextInt();
			System.out.println(TestCase);
			for (int i = 0; i < TestCase; i++) {
				System.out.print("Enter number of people");
				int numberOfPeople = sc.nextInt();
				List<Integer> listOfCost = new ArrayList<>();
				for (int j = 0; j < numberOfPeople; j++) {
					System.out.print("Enter cost of each person in sequential order.");
					Integer cost = sc.nextInt();
					listOfCost.add(cost);
				}
				List<Integer> listOfCostAtTemple = new ArrayList<>();
				List<Integer> listOfCopyArrayList = new ArrayList<>();
				listOfCopyArrayList.addAll(listOfCost);
				int totalCost = 0;
				System.out.println("Per trip Cost");
				int cycle = numberOfPeople;
				for (int k = 0; k < numberOfPeople - 1; k++) {
					cycle = cycle - 2;
					Integer upward_first_cost = 0;
					Integer upward_second_cost = 0;

					if (listOfCost.size() >= 2) {
						upward_first_cost = listOfCost.get(0);
						upward_second_cost = listOfCost.get(1);
						listOfCost.remove(0);
						listOfCost.remove(0);

					} else {
						upward_first_cost = listOfCopyArrayList.get(0);
						upward_second_cost = listOfCopyArrayList.get(1);
					}

					if (upward_first_cost > upward_second_cost) {
						totalCost = totalCost + upward_first_cost;
					} else {
						totalCost = totalCost + upward_second_cost;
					}
					if (listOfCostAtTemple.size() > 0) {
						totalCost = totalCost + listOfCostAtTemple.get(0);
						listOfCostAtTemple.remove(0);
					} else if (listOfCost.size() >= 2) {
						if (upward_first_cost < upward_second_cost) {
							totalCost = totalCost + upward_first_cost;
						} else {
							totalCost = totalCost + upward_second_cost;
						}
						listOfCostAtTemple.add(upward_second_cost);
					}

				}

				System.out.println("Minimum Cost Per Trip:" + totalCost);
			}

		} catch (InputMismatchException e) {
			System.out.println("You did not enter a Integer.");
			sc.nextLine();
		}

	}

	public static void main(String[] args) {
		totalMinimumCost();
	}

}
