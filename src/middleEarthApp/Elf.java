package middleEarthApp;

public class Elf extends MiddleEarthCharacter{
	//Initializes an Elf
	public Elf(String name, double health, double power) {
		super(name,health,power);
	}
	//Returns "Elf" for the attack method and displayInfo method.
	@Override
	public String getRace() {
		return "Elf";
	}
	@Override
	public Boolean attack(MiddleEarthCharacter target) {
		if(target.getRace() == "Elf" || target.getRace() == "Dwarf") {
			return false;
		}
		if(target.getRace() == "Orc") {
			target.health -= this.power*1.5;
		}
		else {
			target.health -= this.power;
		}
		return true;
	}

}