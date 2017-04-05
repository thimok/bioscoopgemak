//================================================================================
// This class is made by:
// - Thimo Koolen
//================================================================================

package informatica.groep1.bioscoopapp.util;

import android.graphics.Bitmap;

import net.glxn.qrgen.android.QRCode;

public class QRGenerator {
	
	public static Bitmap generate(String movieTitle, String showDay, String showTime, int ticketID) {
		String encodedString = movieTitle + "akdfg"
				+ showDay + "akdfg" + showTime + "akdfg"
				+ ticketID;
		
		return QRCode.from(encodedString).bitmap();
	}
}
