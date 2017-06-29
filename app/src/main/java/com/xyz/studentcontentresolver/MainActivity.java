package com.xyz.studentcontentresolver;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    Uri CONTENT_URI = Uri.parse("content://s1p/student");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ContentResolver c = getContentResolver();

        ContentValues cv = new ContentValues();
        cv.put("rno", 11);
        cv.put("name", "Rashmi");
//        c.insert(CONTENT_URI, cv);
//        c.update(CONTENT_URI, cv, "rno= 10", null);
//        c.delete(CONTENT_URI, "rno= 10", null);

        Cursor cursor = c.query(CONTENT_URI, null, null, null, null);

        if(cursor.getCount()>0) {

            while (cursor.moveToNext()){
                String rno = cursor.getString(cursor.getColumnIndex("rno"));
                String name = cursor.getString(cursor.getColumnIndex("name"));

//                Log.d("STU123", rno + " " + name);
                Log.d("STU123", "Deleted");

                c.delete(CONTENT_URI, "rno= 10", null);

            }
            cursor.close();
        }
        else {
            Log.d("STU123", "Nothing to Delete");
        }
//
//        while (cursor.moveToNext()){
//            String rno = cursor.getString(cursor.getColumnIndex("rno"));
//            String name = cursor.getString(cursor.getColumnIndex("name"));
//
//            Log.d("STU123", rno + " " + name);
//        }
//        cursor.close();
    }
}
