/**
 * 
 */
package com;

/**
 * @author srichakradhar
 *
 */
public class IDGenerator {
    
	private static int id = 1;

    public static int next()
    {
            int thisOne = id++;
            return thisOne;
    }
}
