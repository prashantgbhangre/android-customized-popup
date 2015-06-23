/*
// Call From Java File
// create object
final CustomizedDecigionPopup obj = new CustomizedDecigionPopup(this);
// Set data 1 - icon id , 2 - Title , 3 - message , 4 - positive button text , 5 - negative button text
obj.setData(0,"Really Exit ?","Do you want to exit ?","Yes","No");
// get positive button for click listener
Button bt_yes = obj.onPositiveClick();
bt_yes.setOnClickListener(new View.OnClickListener() {

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        // do what ever u want when click on yes button
    }
});

Button bt_no = obj.onNegativeClick();
bt_no.setOnClickListener(new View.OnClickListener() {

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        // do what ever u want when click on no button
    }
});
// for show view its compulsary
obj.show();


Note : for dismiss use
obj.dismiss();

*/

package com.prashantb.demo.utils;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.prashantb.demo.R;

/**
 * Created by a588272 on 23-06-2015.
 */
public class CustomizedDecigionPopup {

    private Context mContext;
    private Dialog dialog = null;
    private ImageView icon;
    private TextView tv_header , tv_title;
    private Button bt_yes , bt_no;

    public CustomizedDecigionPopup(Context context)
    {
        this.mContext = context;
        dialog = new Dialog(mContext);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawable(
                new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.setContentView(R.layout.popup_decigion);
        icon = (ImageView) dialog.findViewById(R.id.iv_decigion_icon);
        tv_header = (TextView) dialog
                .findViewById(R.id.tv_decigion_heading);
        tv_title = (TextView) dialog
                .findViewById(R.id.tv_decigion_title);
        bt_yes = (Button) dialog.findViewById(R.id.bt_yes);

        bt_no = (Button) dialog.findViewById(R.id.bt_no);

    }

    public void setData(int imageId , String title , String message , String yes , String no)
    {
        if(imageId != 0)
            icon.setImageResource(imageId);
        else if(title != null)
            tv_header.setText(title);
        else if(message != null)
            tv_title.setText(message);
        else if(yes != null)
            bt_yes.setText(yes);
        else if(no != null)
            bt_no.setText(no);
    }

    public Button onPositiveClick()
    {
        return bt_yes;
    }

    public Button onNegativeClick()
    {
        return bt_no;
    }

    public void show()
    {
        dialog.show();
    }

    public void dismiss()
    {
        dialog.dismiss();
    }

}
