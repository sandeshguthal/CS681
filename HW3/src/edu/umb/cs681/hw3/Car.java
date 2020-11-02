package edu.umb.cs681.hw3;
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
	private int price;
	private String make, model;



	public void setMake(String make) {
		this.make = make;
	}

	public void setPrice(int price) {
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

	public int getPrice() {
		return price;
	}


	public static void main(String args[]) {
		List<Car> carList = new ArrayList<Car>();

		carList.add(new Car("Porsche", "911", 2019, 3000, 9));
		carList.add(new Car("AMG", "GTR", 2021, 600, 19));
		carList.add(new Car("BMW", "M8", 2021, 1400, 15));
		carList.add(new Car("RR", "Phantom", 2018, 400, 3));
		carList.add(new Car("Lamborghini", "Aventador", 2018, 650, 2));
		int carCount = carList.stream()
                .map((Car car) -> car.getMake())
                .reduce(0, (answer,currCarMake) -> ++answer, (finalResult, intermediateResult) -> finalResult);

        System.out.println("Number of cars are " + carCount);
		int maxPrice = carList.stream()
                .map((Car car) -> car.getPrice())
                .reduce(0,(answer, currCarPrice) -> {
                    if (answer == 0)
                        return currCarPrice;
                    else if (currCarPrice > answer)
                        return currCarPrice;
                    else
                        return answer;
                });
        System.out.println("Max price " + maxPrice);
		int minPrice = carList.stream()
                .map((Car car) -> car.getPrice())
                .reduce(0,(answer, currCarPrice) -> {
                    if (answer == 0)
                        return currCarPrice;
                    else if (currCarPrice < answer)
                        return currCarPrice;
                    else
                        return answer;
                });
        System.out.println("Min price " + minPrice);

        

        
	}
}
