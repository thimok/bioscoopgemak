package informatica.groep1.bioscoopapp.businesslogic;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;

import com.squareup.picasso.Transformation;

import at.favre.lib.dali.Dali;

public class BlurImage implements Transformation {
    private Context context;

    public BlurImage(Context context) {
        this.context = context;
    }

    @Override
    public Bitmap transform(Bitmap source) {
        //Dali.create(context).load(source).
        return null;
    }

    @Override
    public String key() {
        return "blur()";
    }
}
