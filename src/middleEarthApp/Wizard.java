package middleEarthApp;

public class Wizard extends MiddleEarthCharacter {
	//Initializes a Wizard
	public Wizard(String name, double health, double power) {
		super(name,health,power);
	}
	//Returns "Wizard" for the attack method and displayInfo method.
	@Override
	public String getRace() {
		return "Wizard";
	}
	
	@Override
	public Boolean attack(MiddleEarthCharacter target) {
		if(target.getRace() == "Wizard" || target.getRace() == "Human") {
			return false;
		}
		if(target.getRace() == "Dwarf") {
			target.health -= this.power*1.5;
		}
		else {
			target.health -= this.power;
		}
		return true;
	}

}
