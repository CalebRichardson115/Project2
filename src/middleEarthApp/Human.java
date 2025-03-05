package middleEarthApp;
//Human is a subclass of MiddleEarthCharacter
public class Human extends MiddleEarthCharacter {
	//Initializes a Human. 
	public Human(String name, double health, double power) {
		super(name,health,power);
	}
	//Returns "Human" for the attack method and displayInfo method.
	@Override
	public String getRace() {
		return "Human";
	}
	//Attack logic for Human subclass. Returns false (zero damage) for Human and Orc targets, 1.5 damage for Wizard targets, and regular damage for other classes.
	@Override
	public Boolean attack(MiddleEarthCharacter target) {
		if(target.getRace() == "Human" || target.getRace() == "Orc") {
			return false;
		}
		if(target.getRace() == "Wizard") {
			target.health -= this.power*1.5;
		}
		else {
			target.health -= this.power;
		}
		return true;
	}

}
