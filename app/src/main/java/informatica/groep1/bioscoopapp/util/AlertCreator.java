//================================================================================
// This class is made by:
// - Thimo Koolen
//================================================================================

package informatica.groep1.bioscoopapp.util;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;

import static android.R.style.Theme_DeviceDefault_Dialog_Alert;
import static android.R.style.Theme_Material_Dialog_Alert;
import static android.app.AlertDialog.THEME_DEVICE_DEFAULT_DARK;

public class AlertCreator {
	
	//================================================================================
	// Properties
	//================================================================================
	
	private AlertDialog.Builder dialog;
	
	//================================================================================
	// Constructors
	//================================================================================
	
	public AlertCreator(Context context) {
		dialog = new AlertDialog.Builder(context);
	}
	
	public AlertCreator(Context context, String title, @DrawableRes int iconID, String message) {
		dialog = new AlertDialog.Builder(context, Theme_DeviceDefault_Dialog_Alert);
		setTitle(title);
		setIcon(iconID);
		setMessage(message);
	}
	
	//================================================================================
	// Mutators
	//================================================================================
	
	public void setTitle(String title) {
		dialog.setTitle(title);
	}
	
	public void setIcon(@DrawableRes int iconID) {
		dialog.setIcon(iconID);
	}
	
	public void setMessage(String message) {
		dialog.setMessage(message);
	}
	
	public void setPositiveButton(String text, DialogInterface.OnClickListener event) {
		dialog.setPositiveButton(text, event);
	}
	
	public void setPositiveButton(ButtonDefine button) {
		dialog.setPositiveButton(button.getText(), button.getEvent());
	}
	
	public void setNegativeButton(String text, DialogInterface.OnClickListener event) {
		dialog.setNegativeButton(text, event);
	}
	
	public void setNegativeButton(ButtonDefine button) {
		dialog.setNegativeButton(button.getText(), button.getEvent());
	}
	
	public AlertDialog show() {
		return dialog.show();
	}
}
