package com.mobile.pocketrivals.notification

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import com.mobile.pocketrivals.MainActivity
import com.mobile.pocketrivals.R
import kotlin.random.Random

const val notificationChannelID = "learning_android_notification_channel"
// BroadcastReceiver for handling notifications
class NotificationReceiver : BroadcastReceiver() {

    // Method called when the broadcast is received
    override fun onReceive(context: Context, intent: Intent) {
        val openAppIntent = Intent(context, MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }


        val pendingIntent: PendingIntent = PendingIntent.getActivity(context, 0, openAppIntent, PendingIntent.FLAG_IMMUTABLE)
        val notificationManager = context.getSystemService(NotificationManager::class.java)
        val notification = NotificationCompat.Builder(context, notificationChannelID)
            .setContentTitle(context.getString(R.string.ultron_has_arrived))
            .setContentText(context.getString(R.string.check_out_the_latest_patch_notes))
            .setSmallIcon(R.drawable.mk)
            .setPriority(NotificationManager.IMPORTANCE_HIGH)
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)
            .build()
        notificationManager.notify(Random.nextInt(), notification)
    }
}
