package com.example.kotlintutorials.activities

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.TaskStackBuilder
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.kotlintutorials.R
import kotlinx.android.synthetic.main.activity_show_notifications.*

class ShowNotificationsActivity : AppCompatActivity() {

    //id to differentialte different channels
    val CHANNEL_ID = "channelId"
    val CHANNEL_NAME = "channelName"
    val NOTIFICATION_ID = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_notifications)

        //we only need to create this channel only once
        createNotificationChannel()

        //when we receive notification in notification bar, on clicking the notifiv=cation, open activity
        val intent = Intent(this, ShowNotificationsActivity::class.java)
        val pendingIntent = TaskStackBuilder.create(this).run {
            addNextIntentWithParentStack(intent)
            getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT)
        }

        // create notification
        val notification = NotificationCompat.Builder(this, CHANNEL_ID)
            .setContentTitle("Awesome Notifications")
            .setContentText("This is the content text")
            .setSmallIcon(R.drawable.ic_baseline_person_24)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setContentIntent(pendingIntent)
            .build()

        val notificationManager = NotificationManagerCompat.from(this)

        //handle btn_show_notifications click lestner
        btn_show_notifications.setOnClickListener {
            notificationManager.notify(NOTIFICATION_ID, notification)
        }
    }

    fun createNotificationChannel(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q){
            val channel = NotificationChannel(CHANNEL_ID, CHANNEL_NAME, NotificationManager.IMPORTANCE_DEFAULT).apply {
                lightColor = Color.GREEN
                enableLights(true)
            }
            val manager = getSystemService(Context.NOTIFICATION_SERVICE ) as NotificationManager
            manager.createNotificationChannel(channel)
        }
    }
}