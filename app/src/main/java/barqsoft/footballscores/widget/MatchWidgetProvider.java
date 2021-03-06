package barqsoft.footballscores.widget;

import android.annotation.TargetApi;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.widget.RemoteViews;

import barqsoft.footballscores.MainActivity;
import barqsoft.footballscores.R;

/**
 * Created by FM on 9/10/2015.
 */
public class MatchWidgetProvider extends AppWidgetProvider{

    // appWidgetIds: is ht unique id for the widget
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        //int weatherArtResourceId = R.drawable.abc_ab_share_pack_holo_dark;
        String description = "Clear";
        double maxTemp = 24;
        //String formattedMaxTemperature = Utility.formatTemperature(context, maxTemp);
        String widget_title="footBall";
        /**
         * The first loop says, for each int in the array numbers, print the int.
         The second for loops says, for each String in the list, print the String.
         */
        /*int[] numbers = {1,2,3,4,5};
        List<String> list = new ArrayList<String>();
        list.add("Fred");
        list.add("Esther");
        list.add("Grady");
        list.add("Lamont");
        list.add("Bubba");
        list.add("Donna");
        for (int number : numbers)
            System.out.println(number);

        for (String name : list)
            System.out.println(name);
            */


        // Perform this loop procedure for each Today widget
        for (int appWidgetId : appWidgetIds) {
            int layoutId = R.layout.widget_match;
            RemoteViews views = new RemoteViews(context.getPackageName(), layoutId);

            // Add the data to the RemoteViews
            //views.setImageViewResource(R.id.widget_icon, weatherArtResourceId);
            // Content Descriptions for RemoteViews were only added in ICS MR1
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH_MR1) {
                setRemoteContentDescription(views, description);
            }
            views.setTextViewText(R.id.widget_title, widget_title);

            // Create an Intent to launch MainActivity
            Intent launchIntent = new Intent(context, MainActivity.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, launchIntent, 0);
            views.setOnClickPendingIntent(R.id.widget, pendingIntent);

            // Tell the AppWidgetManager to perform an update on the current app widget
            appWidgetManager.updateAppWidget(appWidgetId, views);
        }
    }

    @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH_MR1)
    private void setRemoteContentDescription(RemoteViews views, String description) {
       // views.setContentDescription(R.id.widget_icon, description);
    }

}
