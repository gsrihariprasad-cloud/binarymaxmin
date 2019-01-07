import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class DemoDate {

	public static void main(String[] args) {
		System.out.println(getCurrentDateInMilliSecFormat());
		
		System.out.println(new Timestamp(Calendar.getInstance().getTime().getTime()));
		
	}

	public static final String ISO_MS_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";
	public static String getCurrentDateInMilliSecFormat() {
		DateFormat simpleDateFormat = new SimpleDateFormat(ISO_MS_DATE_FORMAT);
		return simpleDateFormat.format(new Date());
	}
}
