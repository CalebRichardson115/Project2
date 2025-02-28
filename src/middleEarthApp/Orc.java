package middleEarthApp;

public class Orc extends MiddleEarthCharacter {

	public Orc(String name, double health, double power) {
		super(name,health,power);
	}
	
	@Override
	public String getRace() {
		return "Orc";
	}
	
	@Override
	public Boolean attack(MiddleEarthCharacter target) {
		if(target.getRace() == "Orc" || target.getRace() == "Elf") {
			return false;
		}
		if(target.getRace() == "Human") {
			target.health -= this.power*1.5;
		}
		else {
			target.health -= this.power;
		}
		return true;
	}

}
