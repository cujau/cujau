package org.cujau.utils.converters;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.regex.Pattern;

/**
 * Helper methods for converting Strings to integers or floats.
 */
public class StringConverterHelper {

    private final static Pattern NUM_STRIPPER_FLOAT_RE = Pattern.compile( "[^0-9\\.\\-\\'\\,]" );
    private final static Pattern NUM_STRIPPER_ALL_FLOAT_RE = Pattern.compile( "[^0-9\\.\\-]" );
    private final static Pattern NUM_STRIPPER_INT_RE = Pattern.compile( "[^0-9\\-\\'\\,]" );
    private final static Pattern NUM_STRIPPER_ALL_INT_RE = Pattern.compile( "[^0-9\\-]" );

    private static String stripNonIntlFloatJunk( String str ) {
        return NUM_STRIPPER_FLOAT_RE.matcher( str ).replaceAll( "" );
    }

    private static String stripNonIntlIntJunk( String str ) {
        return NUM_STRIPPER_INT_RE.matcher( str ).replaceAll( "" );
    }

    public static BigDecimal simpleBigDecimalValueOf( String str )
            throws ParseException {
        str = NUM_STRIPPER_ALL_FLOAT_RE.matcher( str ).replaceAll( "" );
        BigDecimal ret;
        try {
            DecimalFormat fmt = (DecimalFormat) NumberFormat.getInstance();
            fmt.setParseBigDecimal( true );
            ret = (BigDecimal) fmt.parse( str );
//            ret = new BigDecimal( str );
        } catch ( ParseException e ) {
            throw e;
        }
        return ret;
    }

    public static BigDecimal bigDecimalValueOf( String str )
            throws ParseException {
        BigDecimal ret;
        try {
            DecimalFormat fmt = (DecimalFormat) NumberFormat.getInstance();
            fmt.setParseBigDecimal( true );
            ret = (BigDecimal) fmt.parse( str );
//            ret = new BigDecimal( str );
        } catch ( ParseException e ) {
            try {
                DecimalFormat fmt = (DecimalFormat) NumberFormat.getInstance();
                fmt.setParseBigDecimal( true );
                ret = (BigDecimal) fmt.parse( str );
//                ret = new BigDecimal( stripNonIntlFloatJunk( str ) );
            } catch ( ParseException e2 ) {
                return simpleBigDecimalValueOf( str );
            }
        }
        return ret;
    }

    public static float simpleFloatValueOf( String str )
            throws NumberFormatException {
        str = NUM_STRIPPER_ALL_FLOAT_RE.matcher( str ).replaceAll( "" );
        float ret;
        try {
            ret = Float.valueOf( str );
        } catch ( NumberFormatException e ) {
            throw e;
        }
        return ret;
    }

    public static float floatValueOf( String str ) {
        NumberFormat nf = NumberFormat.getInstance();
        Number nbr;
        try {
            nbr = nf.parse( str );
            return nbr.floatValue();
        } catch ( ParseException e1 ) {
            try {
                nbr = nf.parse( stripNonIntlFloatJunk( str ) );
                return nbr.floatValue();
            } catch ( ParseException e2 ) {
                return simpleFloatValueOf( str );
            }
        }
    }

    public static double simpleDoubleValueOf( String str )
            throws NumberFormatException {
        str = NUM_STRIPPER_ALL_FLOAT_RE.matcher( str ).replaceAll( "" );
        double ret;
        try {
            ret = Double.valueOf( str );
        } catch ( NumberFormatException e ) {
            throw e;
        }
        return ret;
    }

    public static double doubleValueOf( String str ) {
        NumberFormat nf = NumberFormat.getInstance();
        Number nbr;
        try {
            nbr = nf.parse( str );
            return nbr.doubleValue();
        } catch ( ParseException e1 ) {
            try {
                nbr = nf.parse( stripNonIntlFloatJunk( str ) );
                return nbr.doubleValue();
            } catch ( ParseException e2 ) {
                return simpleDoubleValueOf( str );
            }
        }
    }

    public static int simpleIntValueOf( String str )
            throws NumberFormatException {
        str = NUM_STRIPPER_ALL_INT_RE.matcher( str ).replaceAll( "" );
        int ret;
        try {
            ret = Integer.valueOf( str );
        } catch ( NumberFormatException e ) {
            throw e;
        }
        return ret;
    }

    public static int intValueOf( String str ) {
        NumberFormat nf = NumberFormat.getInstance();
        Number nbr;
        try {
            nbr = nf.parse( str );
            return nbr.intValue();
        } catch ( ParseException e ) {
            try {
                nbr = nf.parse( stripNonIntlIntJunk( str ) );
                return nbr.intValue();
            } catch ( ParseException e2 ) {
                return simpleIntValueOf( str );
            }
        }
    }

    public static boolean booleanValueOf( String str ) {
        if ( str != null && ( str.equals( "1" ) || str.toLowerCase().equals( "yes" ) ) ) {
            return true;
        }
        return Boolean.valueOf( str );
    }
}
