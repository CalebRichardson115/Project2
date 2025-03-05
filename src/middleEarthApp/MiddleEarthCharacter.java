package middleEarthApp;
//Parent class for character subclasses.
public abstract class MiddleEarthCharacter {
	//Variables that make up a character/
	String name;
	double health;
	//Refers to attack power.
	double power;
	//Constructor for any MiddleEarthCharacter
	public MiddleEarthCharacter(String name, double health, double power) {
		this.name = name;
		this.power = power;
		this.health = health;
	}
	//Getter method that returns the race. Implemented in subclasses.
	public abstract String getRace();
	/*
	 * Allows a character to attack another character.
	 * Implementation of the damage mechanics is developed in the character subclasses.
	 * Returns false upon encounters that result in zero damage and true for ones that do.
	 * Each subclass has a race they are strong against and a race they are weak against.
	 */
	public abstract Boolean attack(MiddleEarthCharacter target);
	//Displays all of the information tied to a character. 
	public void displayInfo() {
		System.out.println("Name: "+this.name+" Power: "+this.power+" HP: "+this.health+" Race: "+this.getRace());
	}
}
