public class Stribog512 extends Stribog {

	private static final int[] IV = new int[64];

	@Override
	protected byte[] engineDigest() {
		return getDigest(IV);
	}

}
