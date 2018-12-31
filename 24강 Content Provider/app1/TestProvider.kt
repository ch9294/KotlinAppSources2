package kr.co.softcampus.sqlite1

import android.content.ContentProvider
import android.content.ContentValues
import android.database.Cursor
import android.net.Uri

class TestProvider : ContentProvider() {

    override fun delete(uri: Uri, selection: String?, selectionArgs: Array<String>?): Int {
        // Implement this to handle requests to delete one or more rows.
        var helper = DBHelper(context)
        var db = helper.writableDatabase

        return db.delete("TestTable", selection, selectionArgs)
    }

    override fun getType(uri: Uri): String? {
        // TODO: Implement this to handle requests for the MIME type of the data
        // at the given URI.
        throw UnsupportedOperationException("Not yet implemented")
    }

    override fun insert(uri: Uri, values: ContentValues?): Uri? {
        // TODO: Implement this to handle requests to insert a new row.
        var helper = DBHelper(context)
        var db = helper.writableDatabase

        db.insert("TestTable", null, values)

        return uri
    }

    override fun onCreate(): Boolean {
        // TODO: Implement this to initialize your content provider on startup.
        return false
    }

    override fun query(uri: Uri, projection: Array<String>?, selection: String?,
                       selectionArgs: Array<String>?, sortOrder: String?): Cursor? {
        // TODO: Implement this to handle query requests from clients.
        var helper = DBHelper(context)
        var db = helper.writableDatabase

        return db.query("TestTable", projection, selection, selectionArgs, null, null, sortOrder)

    }

    override fun update(uri: Uri, values: ContentValues?, selection: String?,
                        selectionArgs: Array<String>?): Int {
        // TODO: Implement this to handle requests to update one or more rows.

        var helper = DBHelper(context)
        var db = helper.writableDatabase

        return db.update("TestTable", values, selection, selectionArgs)
    }
}
