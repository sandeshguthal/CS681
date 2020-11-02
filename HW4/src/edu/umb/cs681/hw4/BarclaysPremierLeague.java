package edu.umb.cs681.hw4;

import java.util.stream.Collectors;

import java.util.*;

public class BarclaysPremierLeague {

	public BarclaysPremierLeague(String teamName, String manager, int yearEst, int netWorth, int titles) {
		super();
		this.manager = manager;
		this.teamName = teamName;
		this.yearEst = yearEst;
		this.netWorth = netWorth;
		this.titles = titles;
	}

	private int titles, yearEst;
	private float netWorth;

	private String manager, teamName;


	public void setManager(String manager) {
		this.manager = manager;
	}

	public void setNetWorth(float netWorth) {
		this.netWorth = netWorth;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public void setYearEst(int yearEst) {
		this.yearEst = yearEst;
	}

	public void setTitles(int titles) {
		this.titles = titles;
	}

	public String getTeamName() {
		return teamName;
	}

	public int getTitles() {
		return titles;
	}

	public int getYearEst() {
		return yearEst;
	}

	public String getManager() {
		return manager;
	}

	public float getNetWorth() {
		return netWorth;
	}

	@Override
	public String toString() {

		return this.manager + " " + this.teamName + " " + this.titles + " " + this.yearEst + " " + this.netWorth;
	}

	public static void main(String args[]) {
		List<BarclaysPremierLeague> carList = new ArrayList<BarclaysPremierLeague>();

		carList.add(new BarclaysPremierLeague("Hotspurs", "Rajput", 1910, 20000, 10));
		carList.add(new BarclaysPremierLeague("Liverpool", "FrankLampard", 1856, 15000, 6));
		carList.add(new BarclaysPremierLeague("ManchesterUnited", "OleGunnarSolskjær", 1850, 600000, 7));
		carList.add(new BarclaysPremierLeague("ManCity", "PepGuardiola", 1920, 5000, 3));
		carList.add(new BarclaysPremierLeague("Chelsea", "Vishiboy", 1892, 20100, 10));
		System.out.println("Sorted by their experience:");
		List<BarclaysPremierLeague> sortedByYear = carList.stream()
				.sorted(Comparator.comparingInt(BarclaysPremierLeague::getYearEst)).collect(Collectors.toList());
		sortedByYear.forEach(System.out::println);

		System.out.println("Total titles received");
		List<BarclaysPremierLeague> sortedByMileage = carList.stream()
				.sorted(Comparator.comparingInt(BarclaysPremierLeague::getTitles)).collect(Collectors.toList());
		sortedByMileage.forEach(System.out::println);

		System.out.println("Sorted by their net worth:");
		List<BarclaysPremierLeague> sortedByPrice = carList.stream()
				.sorted(Comparator.comparingDouble(BarclaysPremierLeague::getNetWorth)).collect(Collectors.toList());
		sortedByPrice.forEach(System.out::println);

	}
}
