package middleEarthApp;

public abstract class Orc extends MiddleEarthCharacter{

	public Orc(String name, double health, double power) {
		super(name,health,power);
	}
	
	@Override
	public String getRace() {
		return "Orc";
	}

}
