package atulsprograms;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class GregorianToJulian 
{

	public static void main(String args[])
	{
		GregorianToJulian gtj=new GregorianToJulian();
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	    Date dateobj = new Date();
	    System.out.println(df.format(dateobj));
	    
	    Calendar calobj = Calendar.getInstance();
	    System.out.println(gtj.dateToJulian(calobj));
	}
	public double dateToJulian(Calendar date) {
	    int year = date.get(Calendar.YEAR);
	    int month = date.get(Calendar.MONTH)+1;
	    int day = date.get(Calendar.DAY_OF_MONTH);
	    int hour = date.get(Calendar.HOUR_OF_DAY);
	    int minute = date.get(Calendar.MINUTE);
	    int second = date.get(Calendar.SECOND);

	    double extra = (100.0 * year) + month - 190002.5;
	    return (367.0 * year) -
	      (Math.floor(7.0 * (year + Math.floor((month + 9.0) / 12.0)) / 4.0)) + 
	      Math.floor((275.0 * month) / 9.0) +  
	      day + ((hour + ((minute + (second / 60.0)) / 60.0)) / 24.0) +
	      1721013.5 - ((0.5 * extra) / Math.abs(extra)) + 0.5;
	  }

}