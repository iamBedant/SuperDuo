package barqsoft.footballscores.Utils;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.widget.RemoteViews;

import com.squareup.picasso.Picasso;

import java.io.IOException;

import barqsoft.footballscores.DatabaseContract;
import barqsoft.footballscores.R;

/**
 * Created by bebi2 on 2/2/2016.
 */
public class WidgetUtils {



    public static void setFixtureView(Context context, RemoteViews views, Cursor cursor) {
String homeTeamName = cursor.getString(cursor.getColumnIndex(DatabaseContract.scores_table.HOME_COL));
        views.setTextViewText(R.id.home_name, homeTeamName);
         if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH_MR1) {
            Utils.setImageContentDescription(views, R.id.home_crest, homeTeamName);
        }
        views.setTextViewText(R.id.score_textview, Utils.getScores(
                cursor.getInt(cursor.getColumnIndex(DatabaseContract.scores_table.HOME_GOALS_COL)),
                cursor.getInt(cursor.getColumnIndex(DatabaseContract.scores_table.AWAY_GOALS_COL))));
        views.setTextViewText(R.id.date_textview, cursor.getString(cursor.getColumnIndex(DatabaseContract.scores_table.TIME_COL)));
      String awayTeamName = cursor.getString(cursor.getColumnIndex(DatabaseContract.scores_table.AWAY_COL));
        views.setTextViewText(R.id.away_name, awayTeamName);
      if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH_MR1) {
            Utils.setImageContentDescription(views, R.id.away_crest, awayTeamName);
        }
    }



}
