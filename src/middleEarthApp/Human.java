package middleEarthApp;

public abstract class Human extends MiddleEarthCharacter {

	public Human(String name, double health, double power) {
		super(name,health,power);
	}
	
	@Override
	public String getRace() {
		return "Human";
	}
	
	@Override
	public Boolean attack(MiddleEarthCharacter target) {
		if(target.getRace() == "Orc" || target.getRace() == "Human") {
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
