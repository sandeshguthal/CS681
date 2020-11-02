package edu.umb.cs681.hw2;

import java.util.stream.Collectors;

import java.util.*;

public class Car {

	public Car(String model, String make, int year, int price, int mileage) {
		super();
		this.make = make;
		this.model = model;
		this.year = year;
		this.price = price;
		this.mileage = mileage;
	}

	private int mileage, year;
	private float price;
	private int dominationCounts;
	private String make, model;

	public void setDominationCount(int count) {
		this.dominationCounts = count;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public void setMileage(int mileage) {
		this.mileage = mileage;
	}

	public String getModel() {
		return model;
	}

	public int getMileage() {
		return mileage;
	}

	public int getYear() {
		return year;
	}

	public String getMake() {
		return make;
	}

	public float getPrice() {
		return price;
	}

	public int getDominationCount() {
		return dominationCounts;
	}

	public void setDominationCount(ArrayList<Car> cars) {

		for (int i = 0; i < cars.size(); i++) {
			if ((cars.get(i).getYear() <= this.getYear()) && (cars.get(i).getPrice() >= this.getPrice())
					&& (cars.get(i).getMileage() >= this.getMileage())) {
				this.dominationCounts++;
			}
		}
		this.dominationCounts--;
	}

	@Override
	public String toString() {

		return this.make + " " + this.model + " " + this.mileage + " " + this.year + " " + this.price;
	}

	public static void main(String args[]) {
		List<Car> carList = new ArrayList<Car>();

		carList.add(new Car("Porsche", "911", 2019, 3000, 9));
		carList.add(new Car("AMG", "GTR", 2021, 600, 19));
		carList.add(new Car("BMW", "M8", 2021, 1400, 15));
		carList.add(new Car("RR", "Phantom", 2018, 400, 3));
		carList.add(new Car("Lamborghini", "Aventador", 2018, 650, 2));
		System.out.println("Year Sort:");
		List<Car> sortedByYear = carList.stream().sorted(Comparator.comparingInt(Car::getYear))
				.collect(Collectors.toList());
		sortedByYear.forEach(System.out::println);

		System.out.println("Mileage Sort:");
		List<Car> sortedByMileage = carList.stream().sorted(Comparator.comparingInt(Car::getMileage))
				.collect(Collectors.toList());
		sortedByMileage.forEach(System.out::println);

		System.out.println("Price Sort:");
		List<Car> sortedByPrice = carList.stream().sorted(Comparator.comparingDouble(Car::getPrice))
				.collect(Collectors.toList());
		sortedByPrice.forEach(System.out::println);

		System.out.println("Domination Count Sorted:");
		List<Car> sortedByDomCount = carList.stream().sorted(Comparator.comparingInt(Car::getDominationCount))
				.collect(Collectors.toList());
		sortedByDomCount.forEach(System.out::println);
	}
}
