package middleEarthApp;

public abstract class Wizard extends MiddleEarthCharacter{

	public Wizard(String name, double health, double power) {
		super(name,health,power);
	}
	
	@Override
	public String getRace() {
		return "Wizard";
	}

}
