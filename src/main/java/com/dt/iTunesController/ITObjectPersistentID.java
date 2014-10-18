package com.dt.iTunesController;

/**
 * Simple utility wrapper class to represent the persistent object identity
 * ID numbers. Use the getHigh() and getLow() methods individually to get
 * each ID, or the combined hex string through toString().
 *
 * @author <a href="mailto:steve@dot-totally.co.uk">Steve Eyre</a>
 * @version 0.2
 */
public class ITObjectPersistentID {

	private long High;
	private long Low;
	private String hexString;

    /**
     * Create the ITObjectPersistentID. This class is not intended to be created
     * manually, and this function should only be used by classes implementing
     * this utility.
     * @param high The High Persistent ID
     * @param low The Low Persistent ID
     */
	public ITObjectPersistentID(long high, long low) {
		this.High=high;
		this.Low=low;
		this.hexString = String.format("%8s%8s",Long.toHexString(this.High),Long.toHexString(this.Low)).toUpperCase().replace(' ','0');
	}

    /**
     * Returns the high persistent ID.
     * @return The high persistent ID.
     */
	public long getHigh() {
		return this.High;
	}

    /**
     * Returns the low persistent ID.
     * @return The low persistent ID.
     */
	public long getLow() {
		return this.Low;
	}

    /**
     * Return a string representation (in hex) of the persistent IDs.
     * @return String representation of the persistent IDs.
     */
	public String toString() {
		return this.hexString;
	}
}
