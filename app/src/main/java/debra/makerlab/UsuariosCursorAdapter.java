package debra.makerlab;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by tineo on 07/09/16.
 */
public class UsuariosCursorAdapter extends CursorAdapter{


    public UsuariosCursorAdapter(Context context, Cursor c) {
        super(context, c, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        return inflater.inflate(R.layout.list_item_usuario, parent, false);

    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {// Referencias UI.
        TextView nameText = (TextView) view.findViewById(R.id.tv_name);
        final ImageView avatarImage = (ImageView) view.findViewById(R.id.iv_avatar);

        // Get valores.
        //String name = cursor.getString(cursor.getColumnIndex(LawyerEntry.NAME));
        //String avatarUri = cursor.getString(cursor.getColumnIndex(LawyerEntry.AVATAR_URI));

        String name = "meow";
        String avatarUri = "jpg";

        // Setup.
        nameText.setText(name);
        /*Glide
                .with(context)
                .load(Uri.parse("file:///android_asset/" + avatarUri))
                .asBitmap()
                .error(R.drawable.ic_account_circle)
                .centerCrop()
                .into(new BitmapImageViewTarget(avatarImage) {
                    @Override
                    protected void setResource(Bitmap resource) {
                        RoundedBitmapDrawable drawable
                                = RoundedBitmapDrawableFactory.create(context.getResources(), resource);
                        drawable.setCircular(true);
                        avatarImage.setImageDrawable(drawable);
                    }
                });

        */
    }
}
