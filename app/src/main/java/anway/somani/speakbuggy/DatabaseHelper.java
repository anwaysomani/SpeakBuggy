package anway.somani.speakbuggy;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;

    // Database name
    private static final String DATABASE_NAME = "SpeakBuggyRecords";

    // Table name
    private static final String TABLE_NAME = "Models";

    // Model table column names
    private static final String COL2 = "modelName";
    private static final String COL3 = "brandName";
    private static final String COL4 = "modelPrice";
    private static final String COL5 = "modelDesc";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CATEGORIES_TABLE = "CREATE TABLE " + TABLE_NAME + "(" + COL2 + " TEXT, " + COL3 + " TEXT, " + COL4 + " TEXT, " + COL5 + " TEXT)";
        db.execSQL(CREATE_CATEGORIES_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    // Inserting new data into table
    public void insertData(String modelName, String brandName, String modelPrice, String modelDesc) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COL2, modelName);
        values.put(COL3, brandName);
        values.put(COL4, modelPrice);
        values.put(COL5, modelDesc);

        // Inserting row
        //db.insert(TABLE_NAME, null. values);
        db.close();
    }

    // Getting all data
    public List<String> getAllData() {
        List<String> data = new ArrayList<String>();

        // Select all query
        String selectQuery = "SELECT * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // Looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                data.add(cursor.getString(2));
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return data;
    }

}
