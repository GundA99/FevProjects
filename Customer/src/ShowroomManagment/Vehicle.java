package ShowroomManagment;

import java.time.LocalDate;

public class Vehicle implements Comparable<Vehicle> {

	private String chasisNo;
	private Color vehicleColor;
	private double price;// base price
	private LocalDate manufactureDate;
	private String company;
	private boolean isAvailable;

	public Vehicle(String str) {
		this.chasisNo = str;
	}

	public Vehicle(String chasisNo, Color vehicleColor, double price, LocalDate manufactureDate, String company) {
		super();
		this.chasisNo = chasisNo;
		this.vehicleColor = vehicleColor;
		this.price = price;
		this.manufactureDate = manufactureDate;
		this.company = company;
		this.isAvailable = true;
	}

	@Override
	public String toString() {
		return "Vehicle [chasisNo=" + chasisNo + ", vehicleColor=" + vehicleColor + ", price=" + price
				+ ", manufactureDate=" + manufactureDate + ", company=" + company + ", isAvailable=" + isAvailable
				+ "]";
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof Vehicle) {
			Vehicle v = (Vehicle) o;
			return this.chasisNo.equals(v.chasisNo);
		}
		return false;
	}

	@Override
	public int compareTo(Vehicle anotherVehicle) {
		System.out.println("in compareTo");
		return this.chasisNo.compareTo(anotherVehicle.chasisNo);
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getChasisNo() {
		return chasisNo;
	}

	public Color getVehicleColor() {
		return vehicleColor;
	}

	public LocalDate getManufactureDate() {
		return manufactureDate;
	}

}
