package com.subham.lld;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

enum VehicleType {
    MOTORCYLE, CAR, BUS;

    public int getRequiredSpace() {
	if (this.equals(BUS))
	    return 5;
	if (this.equals(CAR))
	    return 3;
	if (this.equals(MOTORCYLE))
	    return 1;
	return -1;
    }
}

final class Person {
    private String name;

    public Person(String name) {
	this.name = name;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    @Override
    public String toString() {
	return "Person [name=" + name + "]";
    }
}

abstract class Vehicle {
    protected final VehicleType type;
    protected final Person owner;
    protected final String token;

    public Vehicle(VehicleType type, Person owner) {
	this.type = type;
	this.owner = owner;
	this.token = Long.toHexString(System.currentTimeMillis());
    }

    public int getRequiredSpace() {
	return type.getRequiredSpace();
    }

    public VehicleType getType() {
	return type;
    }

    public Person getOwner() {
	return owner;
    }

    public String getToken() {
	return token;
    }

    @Override
    public String toString() {
	return "Vehicle [type=" + type + ", owner=" + owner + ", token=" + token + "]";
    }

}

class Car extends Vehicle {
    public Car(Person owner) {
	super(VehicleType.CAR, owner);
    }
}

class Motorcyle extends Vehicle {
    public Motorcyle(Person owner) {
	super(VehicleType.MOTORCYLE, owner);
    }
}

class Bus extends Vehicle {
    public Bus(Person owner) {
	super(VehicleType.BUS, owner);
    }
}

class ParkingSpot {
    private String tokenOfCurrentVehicle;
    private boolean isEmpty;

    public ParkingSpot() {
	isEmpty = true;
    }

    public Optional<String> getToken() {
	if (isEmpty)
	    return Optional.empty();
	return Optional.of(tokenOfCurrentVehicle);
    }

    public boolean isEmpty() {
	return isEmpty;
    }

    public boolean free() {
	if (!isEmpty) {
	    this.tokenOfCurrentVehicle = null;
	    isEmpty = true;
	    return true;
	} else {
	    return false;
	}
    }

    public boolean park(String token) {
	if (isEmpty) {
	    isEmpty = false;
	    tokenOfCurrentVehicle = token;
	    return true;
	}
	return false;
    }

    @Override
    public String toString() {
	return String.format("%s", isEmpty ? "*" : tokenOfCurrentVehicle);
    }

}

class Level implements Comparable<Level>, Serializable {
    private static final long serialVersionUID = 1L;
    final int size;
    private final ParkingSpot[] parkingSpots;
    private int lastVehicleIndex = -1;

    public Level(int size) {
	this.size = size;
	this.parkingSpots = new ParkingSpot[size];
	for (int i = 0; i < size; ++i)
	    parkingSpots[i] = new ParkingSpot();
    }

    public int getLastVehicleIndex() {
	return lastVehicleIndex;
    }

    public int getAvailableSpace() {
	return size - getLastVehicleIndex() - 1;
    }

    public boolean park(Vehicle vehicle) {
	if (getAvailableSpace() >= vehicle.getRequiredSpace()) {
	    int count = vehicle.getRequiredSpace();
	    for (++lastVehicleIndex; count-- > 0; ++lastVehicleIndex) {
		if (parkingSpots[lastVehicleIndex].isEmpty()) {
		    parkingSpots[lastVehicleIndex].park(vehicle.getToken());
		}
	    }
	    --lastVehicleIndex;
	    System.out.println("--" + vehicle.getOwner().getName() + " booked " + vehicle.type);
	    return true;
	}
	return false;
    }
    
    public boolean free(int index) {
	if (index < 0 || index >= size)
	    return false;
	if (parkingSpots[index].isEmpty())
	    return false;
	return parkingSpots[index].free();
    }

    @Override
    public String toString() {
	return "[" + Arrays.toString(parkingSpots) + ", available spots : " + getAvailableSpace()
		+ "]";
    }

    @Override
    public int compareTo(Level o) {
	return Integer.compare(getAvailableSpace(), o.getAvailableSpace());
    }

}

final class ParkingLot implements Serializable {
    private static final long serialVersionUID = 1L;
    private final Level[] levels;
    private final int noOfLevels;

    public ParkingLot(int noOfLevels, int levelSize) {
	this.noOfLevels = noOfLevels;
	levels = new Level[this.noOfLevels];
	for (int i = 0; i < this.noOfLevels; ++i)
	    levels[i] = new Level(levelSize);
    }

    public boolean park(Vehicle vehicle) {
	for (int i = 0; i < noOfLevels; ++i) {
	    if (levels[i].getAvailableSpace() >= vehicle.getRequiredSpace()) {
		levels[i].park(vehicle);
		return true;
	    }
	}
	return false;
    }

    @Override
    public String toString() {
	StringBuilder builder = new StringBuilder();
	builder.append("\n\t");
	for (int i = 0; i < noOfLevels; ++i) {
	    builder.append(levels[i]);
	    if (i <= noOfLevels - 2)
		builder.append("\n\t");
	}
	return "PARKING LOT" + builder.toString() + "\nNUMBER OF LEVELS : " + noOfLevels;
    }

}

public class DesignAParkingLotSystem {

    public DesignAParkingLotSystem() {
    }

    public static void main(String[] args) {
	List<Person> listOfPersons = List.of(new Person("First Santra"), new Person("Second Santra"),
		new Person("Third Santra"));
	List<Vehicle> listOfVehicles = List.of(new Car(listOfPersons.get(0)), new Car(listOfPersons.get(0)),
		new Bus(listOfPersons.get(1)), new Motorcyle(listOfPersons.get(2)),
		new Motorcyle(listOfPersons.get(1)));

	ParkingLot parkingLot = new ParkingLot(3, 8);

	System.out.println(parkingLot);
	for (Vehicle vehicle : listOfVehicles) {
	    parkingLot.park(vehicle);
	    System.out.println(parkingLot);
	}
    }
}
