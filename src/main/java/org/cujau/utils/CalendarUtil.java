package org.cujau.utils;

import java.util.Calendar;
import java.util.Date;

/**
 * Utility for working with {@link java.util.Calendar}s.
 */
public class CalendarUtil {

    /**
     * Do the given {@link java.util.Calendar}s represent the same historical date?
     * 
     * @param cal1
     *            A Calendar to compare.
     * @param cal2
     *            A Calendar to compare.
     * @return <tt>true</tt> if the Calendars represent the same historical date (time is ignored).
     */
    public static boolean isSameDate( Calendar cal1, Calendar cal2 ) {
        if ( cal1.get( Calendar.YEAR ) == cal2.get( Calendar.YEAR )
             && cal1.get( Calendar.MONTH ) == cal2.get( Calendar.MONTH )
             && cal1.get( Calendar.DAY_OF_MONTH ) == cal2.get( Calendar.DAY_OF_MONTH ) ) {
            return true;
        }
        return false;
    }

    /**
     * Do the given dates represent the same historical date?
     * 
     * @param cal1
     *            A Calendar to compare.
     * @param date
     *            A Date to compare.
     * @return <tt>true</tt> if the Calendar and Date represent the same historical date (time is
     *         ignored).
     */
    public static boolean isSameDate( Calendar cal1, Date date ) {
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime( date );
        return isSameDate( cal1, cal2 );
    }

    /**
     * Do the given {@link java.util.Date}s represent the same historical date?
     * 
     * @param date1
     *            A Date to compare.
     * @param date2
     *            A Date to compare.
     * @return <tt>true</tt> if the Dates represent the same historical date (time is ignored).
     */
    public static boolean isSameDate( Date date1, Date date2 ) {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime( date1 );
        return isSameDate( cal1, date2 );
    }

    /**
     * Does the given date represent the same day as today (now).
     * 
     * @param date
     *            The date to test.
     * @return <tt>true</tt> if date is that same day as today (now).
     */
    public static boolean isToday( Date date ) {
        Calendar calToday = Calendar.getInstance();
        Calendar calDate = Calendar.getInstance();
        calDate.setTime( date );

        if ( calToday.get( Calendar.YEAR ) == calDate.get( Calendar.YEAR )
             && calToday.get( Calendar.DAY_OF_YEAR ) == calDate.get( Calendar.DAY_OF_YEAR ) ) {
            return true;
        }
        return false;
    }

    /**
     * Subtract N days from the current date.
     * 
     * @param days
     *            The number of days in the past that the returned date should represent.
     * @return A date object N days in the past.
     */
    public static Date getNowLessDays( int days ) {
        return getAdjustedDate( Calendar.getInstance(), Calendar.HOUR_OF_DAY, -( days * 24 ) );
    }

    /**
     * Subtract N months from the current date.
     * 
     * @param months
     *            The number of months in the past that the returned date should represent.
     * @return A date object N months in the past.
     */
    public static Date getNowLessMonths( int months ) {
        return getAdjustedDate( Calendar.getInstance(), Calendar.MONTH, -months );
    }

    /**
     * Subtract N years from the current date.
     * 
     * @param days
     *            The number of years in the past that the returned date should represent.
     * @return A date object N years in the past.
     */
    public static Date getNowLessYears( int years ) {
        return getAdjustedDate( Calendar.getInstance(), Calendar.YEAR, -years );
    }

    private static Date getAdjustedDate( Calendar cal, int calField, int adjustment ) {
        cal.add( calField, adjustment );
        return cal.getTime();
    }

}