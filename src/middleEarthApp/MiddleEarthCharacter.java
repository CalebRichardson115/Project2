package middleEarthApp;

public abstract class MiddleEarthCharacter {
	
	String name;
	double health;
	double power;

	public MiddleEarthCharacter(String name, double health, double power) {
		this.name = name;
		this.power = power;
		this.health = health;
	}
	
	public abstract String getRace();

	public abstract Boolean attack(MiddleEarthCharacter target);
	
	public void displayInfo() {
		System.out.println("Name: "+this.name+" Power: "+this.power+" HP: "+this.health+" Race: "+this.getRace());
	}
}
