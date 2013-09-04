package org.cujau.utils;

import java.util.Calendar;
import java.util.Date;

/**
 * Utility for working with {@link java.util.Calendar}s.
 */
public class CalendarUtil {

    public static final long MILLIS_IN_SECOND = 1000;
    public static final long MILLIS_IN_MINUTE = MILLIS_IN_SECOND * 60;
    public static final long MILLIS_IN_HOUR = MILLIS_IN_MINUTE * 60;
    public static final long MILLIS_IN_DAY = MILLIS_IN_HOUR * 24;

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
             && cal1.get( Calendar.DAY_OF_YEAR ) == cal2.get( Calendar.DAY_OF_YEAR ) ) {
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
     *         ignored). If <tt>date</tt> is <tt>null</tt>, <tt>false</tt> is returned.
     */
    public static boolean isSameDate( Calendar cal1, Date date ) {
        if ( date == null ) {
            return false;
        }
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
     * @return <tt>true</tt> if the Dates represent the same historical date (time is ignored). If
     *         either of the date objects are <tt>null</tt>, <tt>false</tt> is returned.
     */
    public static boolean isSameDate( Date date1, Date date2 ) {
        if ( date1 == null || date2 == null ) {
            return false;
        }
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime( date1 );
        return isSameDate( cal1, date2 );
    }

    /**
     * Compare the given dates, returning <tt>true</tt> if the given <tt>cal</tt> represents a date
     * that is the same as or younger (more recent) than the given <tt>baseDate</tt>.
     * 
     * @param cal
     *            A Calendar representing the date being compared.
     * @param baseDate
     *            The date used for comparison.
     * @return <tt>true</tt> if the <tt>cal</tt> is the same or younger than the <tt>baseDate</tt>,
     *         <tt>false</tt> otherwise. If <tt>baseDate</tt> is <tt>null</tt>, <tt>false</tt> is
     *         returned.
     */
    public static boolean isSameOrYounger( Calendar cal, Date baseDate ) {
        if ( baseDate == null ) {
            return false;
        }
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime( baseDate );
        return isSameOrYounger( cal, cal2 );
    }

    /**
     * Compare the two dates, returning <tt>true</tt> if the given <tt>date</tt> is the same as or
     * younger (more recent) than the given <tt>baseDate</tt>.
     * 
     * @param date
     *            The date being compared.
     * @param baseDate
     *            The date used for comparison.
     * @return <tt>true</tt> if the <tt>date</tt> is the same or younger than the <tt>baseDate</tt>,
     *         <tt>false</tt> otherwise. If either of the given dates are <tt>null</tt>,
     *         <tt>false</tt> is returned.
     */
    public static boolean isSameOrYounger( Date date, Date baseDate ) {
        if ( date == null || baseDate == null ) {
            return false;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime( date );
        Calendar baseCal = Calendar.getInstance();
        baseCal.setTime( baseDate );
        return isSameOrYounger( cal, baseCal );
    }

    /**
     * Compare the two dates, returning <tt>true</tt> if the given <tt>date</tt> is the same as or
     * younger (more recent) than the given <tt>baseDate</tt>.
     * 
     * @param date
     *            The date being compared.
     * @param baseDate
     *            The date used for comparison.
     * @return <tt>true</tt> if the <tt>date</tt> is the same or younger than the <tt>baseDate</tt>,
     *         <tt>false</tt> otherwise.
     */
    public static boolean isSameOrYounger( Calendar date, Calendar baseDate ) {
        if ( date.get( Calendar.YEAR ) > baseDate.get( Calendar.YEAR ) ) {
            return true;
        }
        if ( date.get( Calendar.YEAR ) < baseDate.get( Calendar.YEAR ) ) {
            return false;
        }
        // Same years here.
        if ( date.get( Calendar.MONTH ) > baseDate.get( Calendar.MONTH ) ) {
            return true;
        }
        if ( date.get( Calendar.MONTH ) < baseDate.get( Calendar.MONTH ) ) {
            return false;
        }
        // Same month here.
        if ( date.get( Calendar.DAY_OF_MONTH ) >= baseDate.get( Calendar.DAY_OF_MONTH ) ) {
            return true;
        }
        return false;
    }

    /**
     * Compare the given dates, returning <tt>true</tt> if the given <tt>cal</tt> represents a date
     * that is the same as or older than the given <tt>baseDate</tt>.
     * 
     * @param cal
     *            A Calendar representing the date being compared.
     * @param baseDate
     *            The date used for comparison.
     * @return <tt>true</tt> if the <tt>date</tt> is the same or older than the <tt>baseDate</tt>,
     *         <tt>false</tt> otherwise. If <tt>baseDate</tt> is <tt>null</tt>, <tt>false</tt> is
     *         returned.
     */
    public static boolean isSameOrOlder( Calendar cal, Date baseDate ) {
        if ( baseDate == null ) {
            return false;
        }
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime( baseDate );
        return isSameOrOlder( cal, cal2 );
    }

    /**
     * Compare the two dates, returning <tt>true</tt> if the given <tt>date</tt> is the same as or
     * older than the given <tt>baseDate</tt>.
     * 
     * @param date
     *            The date being compared.
     * @param baseDate
     *            The date used for comparison.
     * @return <tt>true</tt> if the <tt>date</tt> is the same or older than the <tt>baseDate</tt>,
     *         <tt>false</tt> otherwise. If either of the dates are <tt>null</tt>, <tt>false</tt> is
     *         returned.
     */
    public static boolean isSameOrOlder( Date date, Date baseDate ) {
        if ( date == null || baseDate == null ) {
            return false;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime( date );
        Calendar baseCal = Calendar.getInstance();
        baseCal.setTime( baseDate );
        return isSameOrOlder( cal, baseCal );
    }

    /**
     * Compare the two dates, returning <tt>true</tt> if the given <tt>date</tt> is the same as or
     * older than the given <tt>baseDate</tt>.
     * 
     * @param date
     *            The date being compared.
     * @param baseDate
     *            The date used for comparison.
     * @return <tt>true</tt> if the <tt>date</tt> is the same or older than the <tt>baseDate</tt>,
     *         <tt>false</tt> otherwise.
     */
    public static boolean isSameOrOlder( Calendar date, Calendar baseDate ) {
        if ( date.get( Calendar.YEAR ) < baseDate.get( Calendar.YEAR ) ) {
            return true;
        }
        if ( date.get( Calendar.YEAR ) > baseDate.get( Calendar.YEAR ) ) {
            return false;
        }
        // Same years here.
        if ( date.get( Calendar.MONTH ) < baseDate.get( Calendar.MONTH ) ) {
            return true;
        }
        if ( date.get( Calendar.MONTH ) > baseDate.get( Calendar.MONTH ) ) {
            return false;
        }
        // Same month here.
        if ( date.get( Calendar.DAY_OF_MONTH ) <= baseDate.get( Calendar.DAY_OF_MONTH ) ) {
            return true;
        }
        return false;
    }

    /**
     * Does the given date represent the same day as today (now).
     * 
     * @param date
     *            The date to test.
     * @return <tt>true</tt> if date is that same day as today (now). If <tt>date</tt> is
     *         <tt>null</tt>, <tt>false</tt> is returned.
     */
    public static boolean isToday( Date date ) {
        if ( date == null ) {
            return false;
        }
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
     * Determine if the date represented by the given Date is a weekend day (ie. Saturday or
     * Sunday).
     * 
     * @param date
     * @return <tt>true</tt> if the date is a Saturday or Sunday, <tt>false</tt> otherwise. If
     *         <tt>date</tt> is <tt>null</tt>, <tt>false</tt> is returned.
     */
    public static boolean isWeekend( Date date ) {
        if ( date == null ) {
            return false;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime( date );
        int dow = cal.get( Calendar.DAY_OF_WEEK );
        if ( dow == Calendar.SUNDAY || dow == Calendar.SATURDAY ) {
            return true;
        }
        return false;
    }

    /**
     * Determine if the date represented by the given Calendar is a weekend day (ie. Saturday or
     * Sunday).
     * 
     * @param cal
     * @return <tt>true</tt> if the date is a Saturday or Sunday, <tt>false</tt> otherwise.
     */
    public static boolean isWeekend( Calendar cal ) {
        int dow = cal.get( Calendar.DAY_OF_WEEK );
        if ( dow == Calendar.SUNDAY || dow == Calendar.SATURDAY ) {
            return true;
        }
        return false;
    }

    /**
     * Subtract N minutes from the current date.
     * 
     * @param mins
     *            The number of minutes in the past that the returned date should represent.
     * @return A date object N minutes in the past.
     */
    public static Date getNowLessMinutes( int mins ) {
        // return getAdjustedDate( Calendar.getInstance(), Calendar.HOUR_OF_DAY, -( days * 24 ) );
        return getAdjustedDate( Calendar.getInstance(), Calendar.MINUTE, -mins );
    }

    public static Date getDateAdjustMinutes( Date date, int mins ) {
        return getAdjustedDate( getCalendarFor( date ), Calendar.MINUTE, mins );
    }

    /**
     * Subtract N days from the current date.
     * 
     * @param days
     *            The number of days in the past that the returned date should represent.
     * @return A date object N days in the past.
     */
    public static Date getNowLessDays( int days ) {
        // return getAdjustedDate( Calendar.getInstance(), Calendar.HOUR_OF_DAY, -( days * 24 ) );
        return getAdjustedDate( Calendar.getInstance(), Calendar.DATE, -days );
    }

    public static Date getDateAdjustDays( Date date, int days ) {
        return getAdjustedDate( getCalendarFor( date ), Calendar.DATE, days );
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

    public static Date getDateAdjustMonths( Date date, int months ) {
        return getAdjustedDate( getCalendarFor( date ), Calendar.MONTH, months );
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

    public static Date getDateAdjustYears( Date date, int years ) {
        return getAdjustedDate( getCalendarFor( date ), Calendar.YEAR, years );
    }

    private static Date getAdjustedDate( Calendar cal, int calField, int adjustment ) {
        return getAdjustedCalendar( cal, calField, adjustment ).getTime();
    }

    private static Calendar getAdjustedCalendar( Calendar cal, int calField, int adjustment ) {
        cal.add( calField, adjustment );
        return cal;
    }

    /**
     * Get a Date object representing today. Only the year, month and day fields are set. All others
     * are not set. This generally results in a Date object such as: 2009-11-13 00:00:00.000
     * 
     * @return A Date object for today.
     */
    public static Date getToday() {
        Calendar calNow = Calendar.getInstance();
        Calendar cal = Calendar.getInstance();
        cal.clear();
        cal.set( calNow.get( Calendar.YEAR ), calNow.get( Calendar.MONTH ),
                 calNow.get( Calendar.DAY_OF_MONTH ) );
        return cal.getTime();
    }

    /**
     * Get a Date object representing yesterday. Only the year, month and day fields are set. All
     * others are not set. This generally results in a Date object such as: 2009-11-13 00:00:00.000
     * 
     * @return A Date object for yesterday.
     */
    public static Date getYesterday() {
        Calendar calNow = Calendar.getInstance();
        // calNow.add( Calendar.HOUR_OF_DAY, -24 );
        calNow.add( Calendar.DATE, -1 );
        Calendar cal = Calendar.getInstance();
        cal.clear();
        cal.set( calNow.get( Calendar.YEAR ), calNow.get( Calendar.MONTH ),
                 calNow.get( Calendar.DAY_OF_MONTH ) );
        return cal.getTime();
    }

    /**
     * Get a Date object representing tomorrow. Only the year, month and day fields are set. All
     * others are not set. This generally results in a Date object such as: 2009-11-13 00:00:00.000
     * 
     * @return A Date object for tomorrow.
     */
    public static Date getTomorrow() {
        Calendar calNow = Calendar.getInstance();
        // calNow.add( Calendar.HOUR_OF_DAY, -24 );
        calNow.add( Calendar.DATE, 1 );
        Calendar cal = Calendar.getInstance();
        cal.clear();
        cal.set( calNow.get( Calendar.YEAR ), calNow.get( Calendar.MONTH ),
                 calNow.get( Calendar.DAY_OF_MONTH ) );
        return cal.getTime();
    }

    /**
     * Get a Date object representing January, 1 of the current year. Only the year, month and day
     * fields are set.
     * 
     * @return A Date object for January 1st of this year.
     */
    public static Date getJanuary1ThisYear() {
        Calendar cal = Calendar.getInstance();
        int year = cal.get( Calendar.YEAR );
        cal.clear();
        cal.set( year, Calendar.JANUARY, 1 );
        return cal.getTime();
    }

    public static Date getNow() {
        return new Date();
    }

    public static Calendar getCalendarFor( Date date ) {
        Calendar cal = Calendar.getInstance();
        cal.setTime( date );
        return cal;
    }

    /**
     * Get a Date object representing the same calendar date as the given Date object, but with only
     * the year, month and day fields set. All other fields are not set. This generally results in a
     * Date object such as: 2009-11-13 00:00:00.000
     * 
     * @param date
     *            The Date object whose time should be removed.
     * @return A Date object for the same calendar date, and unset time fields.
     */
    public static Date toDateWithoutTime( Date date ) {
        Calendar calOrig = Calendar.getInstance();
        calOrig.setTime( date );
        Calendar cal = Calendar.getInstance();
        cal.clear();
        cal.set( calOrig.get( Calendar.YEAR ), calOrig.get( Calendar.MONTH ),
                 calOrig.get( Calendar.DAY_OF_MONTH ) );
        return cal.getTime();
    }

    /**
     * Get the number of days between the given dates, inclusive of the <tt>end</tt> date.
     * 
     * @param start
     *            The starting Date.
     * @param end
     *            The ending Date.
     * @return The number of days.
     */
    public static int getNumberOfDaysBetween( Date start, Date end ) {
        if ( start == null || end == null ) {
            return 0;
        }
        return (int) ( ( end.getTime() - start.getTime() ) / MILLIS_IN_DAY );
    }

    /**
     * Get the nearest, non-weekend day to the given calendar. If the date represented by the
     * calendar is on a weekend day, the calendar is rolled back 1 day until a non-weekend day is
     * found.
     * 
     * @param cal
     * @return
     */
    public static Calendar getNearestNonWeekendDay( Calendar cal ) {
        while ( isWeekend( cal ) ) {
            cal = getAdjustedCalendar( cal, Calendar.DATE, -1 );
        }
        return cal;
    }
}
