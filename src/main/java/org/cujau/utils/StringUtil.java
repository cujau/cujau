package org.cujau.utils;

import java.util.Collection;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Utility functions for Strings.
 */
public final class StringUtil {

    private static final Pattern PROPERTY_NAME_PATTERN = Pattern.compile( "(\\$\\{([\\w\\.]+)\\})" );

    /**
     * Convert the given array of objects into it's String representation. The array elements will
     * be separated by a comma (',').
     * 
     * @param <E>
     *            The type of the elements.
     * @param ary
     *            The array of the elements.
     * @return A String containg the String representation of each element in the array, separated
     *         by a comma.
     */
    public static <E> String toString( E[] ary ) {
        StringBuilder buf = new StringBuilder();
        for ( E e : ary ) {
            buf.append( e );
            buf.append( "," );
        }
        if ( buf.length() > 0 ) {
            buf.deleteCharAt( buf.length() - 1 );
        }
        return buf.toString();
    }

    /**
     * Convert the given collection of objects into it's String representation. The String
     * representation of an element of the collection will be separated from the next element with a
     * comma (',').
     * 
     * @param <E>
     *            The type of the elements.
     * @param col
     *            The collection of elements.
     * @return A String containing the String representation of each element in the Collection,
     *         separated by a comma.
     */
    public static <E> String toString( Collection<E> col ) {
        StringBuilder buf = new StringBuilder();
        for ( E e : col ) {
            buf.append( e.toString() );
            buf.append( "," );
        }
        if ( buf.length() > 0 ) {
            buf.deleteCharAt( buf.length() - 1 );
        }
        return buf.toString();
    }

    /**
     * Replace the delimited property keys in the given String with their values taken from the
     * System properties.
     * <p>
     * A delimited property key has the form
     * <tt>${<em>{@link #PROPERTY_NAME_PATTERN property.name}</em>}</tt>. Property names may
     * only contain alphanumeric characters plus the '_' and '.' characters.
     * 
     * @param orig
     *            The original String
     * @return The new String with the delimited properties replaced.
     */
    public static String replaceProperties( String orig ) {
        return replaceProperties( orig, System.getProperties() );
    }

    /**
     * Replace the delimited property keys in the given String with their values taken from the
     * given Properties object.
     * <p>
     * A delimited property key has the form
     * <tt>${<em>{@link #PROPERTY_NAME_PATTERN property.name}</em>}</tt>. Property names may
     * only contain alphanumeric characters plus the '_' and '.' characters.
     * 
     * @param orig
     *            The original String
     * @param replacements
     *            A Properties object from which the property values will be taken.
     * @return The new String with the delimited properties replaced.
     */
    public static String replaceProperties( String orig, Properties replacements ) {
        if ( replacements == null ) {
            return orig;
        }

        Matcher m = PROPERTY_NAME_PATTERN.matcher( orig );
        while ( m.find() ) {
            String propVal = replacements.getProperty( m.group( 2 ) );
            if ( propVal != null ) {
                orig = orig.replace( m.group( 1 ), propVal );
            }
        }
        return orig;
    }

}
