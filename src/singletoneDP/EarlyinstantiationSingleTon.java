package singletoneDP;

public class EarlyinstantiationSingleTon {

	private static EarlyinstantiationSingleTon earlyinstantiationSingleTon = new EarlyinstantiationSingleTon();

	private EarlyinstantiationSingleTon() {
		// TODO Auto-generated constructor stub
	}

	public static EarlyinstantiationSingleTon getEarlyinstantiationSingleTon() {

		return earlyinstantiationSingleTon;
	}

}
