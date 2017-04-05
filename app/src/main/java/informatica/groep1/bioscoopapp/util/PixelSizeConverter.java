//================================================================================
// This class is made by:
// - Sven Westerlaken
//================================================================================

package informatica.groep1.bioscoopapp.util;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;

public class PixelSizeConverter {

	//================================================================================
	// Accessors
	//================================================================================
	
    public static int convertDPtoPX(Context c, int pd) {
        Resources r = c.getResources();
        int px = (int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                pd,
                r.getDisplayMetrics()
        );

        return px;
    }

}
