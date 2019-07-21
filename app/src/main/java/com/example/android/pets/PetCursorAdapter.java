package com.example.android.pets;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.example.android.pets.data.PetContract;

public class PetCursorAdapter extends CursorAdapter{

        /**
         * Recommended constructor.
         *
         * @param context The context
         * @param c       The cursor from which to get the data.
         * @param flags   Flags used to determine the behavior of the adapter; may
         *                be any combination of {@link #FLAG_AUTO_REQUERY} and
         *                {@link #FLAG_REGISTER_CONTENT_OBSERVER}.
         */
        public PetCursorAdapter(Context context, Cursor c) {
            super(context, c, 0);
        }

        /**
     * Makes a new view to hold the data pointed to by cursor.
     *
     * @param context Interface to application's global information
     * @param cursor  The cursor from which to get the data. The cursor is already
     *                moved to the correct position.
     * @param parent  The parent to which the new view is attached to
     * @return the newly created view.
     */
    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        View view= LayoutInflater.from(context).inflate(R.layout.list_item,parent,false);
        return view;
    }

    /**
     * Bind an existing view to the data pointed to by cursor
     *
     * @param view    Existing view, returned earlier by newView
     * @param context Interface to application's global information
     * @param cursor  The cursor from which to get the data. The cursor is already
     */
    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        TextView pName=view.findViewById(R.id.pet_name);
        TextView pBreed=view.findViewById(R.id.pet_breed);

        String name=cursor.getString(cursor.getColumnIndexOrThrow(PetContract.PetEntry.COLUMN_PET_NAME));
        String breed=cursor.getString(cursor.getColumnIndexOrThrow(PetContract.PetEntry.COLUMN_PET_BREED));

        pName.setText(name);
        pBreed.setText(breed);

    }
}

