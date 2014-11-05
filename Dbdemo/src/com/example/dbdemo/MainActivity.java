package com.example.dbdemo;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
	Button Save;
	User_Profile up;
	EditText et1, et2;
	User_DAO User;
	MySQLiteHelper my;
	SQLiteDatabase sqlite;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		et1 = (EditText) findViewById(R.id.editText1);
		et2 = (EditText) findViewById(R.id.editText2);
		User = new User_DAO(this);
		up = new User_Profile();
		Save = (Button) findViewById(R.id.button1);
		Save.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub

				User.open();
				up.setUser_ID(1);
				Log.i("0", "" + up.getUser_ID());
				up.setUser_Name(et1.getText().toString());
				Log.i("1", up.getUser_Name());
				up.setUser_Email(et2.getText().toString());
				Log.i("2", up.getUser_Email());
				up.setUser_Image("UserImage" + up.getUser_ID());
				Log.i("3", up.getUser_Image());
				up.setUser_Level("0");
				Log.i("4", up.getUser_Level());
				up.setUser_Progress("0");
				Log.i("5", up.getUser_Progress());
				up.setUser_Star("0");
				Log.i("6", up.getUser_Star());
				up.setComment("This is Test User");
				Log.i("7", up.getComment());
				up.setUser_Title("TESTO");
				Log.i("8", up.getUser_Title());

				User.createUser(up);
				User.close();

			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
