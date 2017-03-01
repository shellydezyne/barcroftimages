package com.example.android.barcroftimages;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dezyne 2 on 3/1/2017.
 */

public class DatabaseHandler extends SQLiteOpenHelper {

    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "imageGallery";

    // Contacts table name
    private static final String TABLE_CONTACTS = "images";

    // Contacts Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_IMAGE = "image";
    private static final String KEY_DATE = "date";
    private static final String KEY_SERIES= "series";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_CONTACTS + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_IMAGE + " BLOB,"
                + KEY_DATE + " TEXT," + KEY_SERIES + " INTEGER"+
                ")";
        sqLiteDatabase.execSQL(CREATE_CONTACTS_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS);

        // Create tables again
        onCreate(sqLiteDatabase);
    }



    void addEntry(DB_model_class model)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_ID, model.getId());
        values.put(KEY_IMAGE, model.getImage());
        values.put(KEY_DATE, model.getDate());
        values.put(KEY_SERIES,model.getSeries());

        db.insert(TABLE_CONTACTS, null, values);
        db.close();

    }

    DB_model_class getEntry(int id)
    {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_CONTACTS, new String[] { KEY_ID,
                        KEY_IMAGE, KEY_DATE, KEY_SERIES }, KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);

        if (cursor != null)
            cursor.moveToFirst();

        DB_model_class contact = new DB_model_class(Integer.parseInt(cursor.getString(0)),
                 cursor.getBlob(1),cursor.getString(1),Integer.parseInt(cursor.getString(2)));
        return contact;
    }


    // Getting All Contacts
    public List<DB_model_class> getAllContacts() {
        List<DB_model_class> contactList = new ArrayList<DB_model_class>();
// Select All Query
        String selectQuery = "SELECT * FROM images ORDER BY id";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
// looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                DB_model_class contact = new DB_model_class();
                contact.setId(Integer.parseInt(cursor.getString(0)));
                contact.setImage(cursor.getBlob(1));
                contact.setDate(cursor.getString(2));
                contact.setSeries(Integer.parseInt(cursor.getString(3)));
// Adding contact to list
                contactList.add(contact);
            } while (cursor.moveToNext());
        }
// close inserting data from database
        db.close();
// return contact list
        return contactList;

    }



    // Updating single contact
    public int updateContact(DB_model_class contact) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_ID, contact.getId());
        values.put(KEY_IMAGE, contact.getImage());
        values.put(KEY_DATE, contact.getDate());
        values.put(KEY_SERIES, contact.getSeries());

// updating row
        return db.update(TABLE_CONTACTS, values, KEY_ID + " = ?",
                new String[] { String.valueOf(contact.getId()) });

    }

    // Deleting single contact
    public void deleteContact(DB_model_class contact) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_CONTACTS, KEY_ID + " = ?",
                new String[] { String.valueOf(contact.getId()) });
        db.close();
    }



    // Getting entry Count
    public int getEntrysCount() {
        String countQuery = "SELECT * FROM " + TABLE_CONTACTS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

// return count
        return cursor.getCount();
    }

}
