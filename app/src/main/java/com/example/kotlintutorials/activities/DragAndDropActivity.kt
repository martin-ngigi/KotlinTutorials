package com.example.kotlintutorials.activities

import android.content.ClipData
import android.content.ClipDescription
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.DragEvent
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import com.example.kotlintutorials.R
import kotlinx.android.synthetic.main.activity_drag_and_drop.*

class DragAndDropActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drag_and_drop)

        dragView.setOnLongClickListener{
            val clipText = "This Will clip data text"
            val item = ClipData.Item(clipText)
            val mimeType = arrayOf(ClipDescription.MIMETYPE_TEXT_PLAIN)
            val data = ClipData(clipText, mimeType, item)

            //set drag listener
            ll_top.setOnDragListener(dragListener)
            ll_bottom.setOnDragListener(dragListener)

            val dragShadowBuilder = View.DragShadowBuilder(it)
                it.startDragAndDrop(data, dragShadowBuilder, it, 0)

            it.visibility = View.INVISIBLE
            true //return
        }

    }

    val dragListener = View.OnDragListener { view, event ->
        when(event.action){
            DragEvent.ACTION_DRAG_STARTED ->{
                event.clipDescription.hasMimeType(ClipDescription.MIMETYPE_TEXT_PLAIN)
            }
            DragEvent.ACTION_DRAG_ENTERED ->{
                view.invalidate()
                true
            }
            DragEvent.ACTION_DRAG_LOCATION -> true
            DragEvent.ACTION_DRAG_EXITED ->{
                view.invalidate()
                true
            }
            DragEvent.ACTION_DROP ->{
                val item = event.clipData.getItemAt(0)
                val dragData = item.text
                Toast.makeText(this, dragData, Toast.LENGTH_SHORT).show()

                view.invalidate()

                val v = event.localState as View
                val ownerLayout = v.parent as ViewGroup
                ownerLayout.removeView(v)
                val destination = view as LinearLayout
                destination.addView(v)
                v.visibility = View.VISIBLE
                true
            }
            DragEvent.ACTION_DRAG_ENDED ->{
                view.invalidate()
                true
            }
            else -> false
        }

    }

}