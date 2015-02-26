import java.security.Provider;

public final class StribogProvider extends Provider {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public StribogProvider() {
		super("Stribog", 0.01, "Stribog (34.11-2012) Java implementation");
		put("MessageDigest.Stribog512", Stribog512.class.getCanonicalName());
		put("MessageDigest.Stribog256", Stribog256.class.getCanonicalName());
	}

}
