package middleEarthApp;

public class Human extends MiddleEarthCharacter {

	public Human(String name, double health, double power) {
		super(name,health,power);
	}
	
	@Override
	public String getRace() {
		return "Human";
	}

}
