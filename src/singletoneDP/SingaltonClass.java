package singletoneDP;

public class SingaltonClass {

	private static SingaltonClass singaltonClassObj;

	private SingaltonClass() {
	}

	public static SingaltonClass singaltonClassObj() {

		if (singaltonClassObj == null)
			singaltonClassObj = new SingaltonClass();
		return singaltonClassObj;

	}

}
