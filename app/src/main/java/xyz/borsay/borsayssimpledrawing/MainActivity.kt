package xyz.borsay.borsayssimpledrawing

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.core.view.get

class MainActivity : AppCompatActivity() {
    private var mDrawingView: DrawingView? = null
    private var mImageButtonCurrentPaint: ImageButton? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mDrawingView = findViewById(R.id.drawing_view)
        mDrawingView?.setSizeForBrush(20.toFloat())

        val linearLayoutPaintColor = findViewById<LinearLayout>(R.id.ll_paint_colors)
        mImageButtonCurrentPaint = linearLayoutPaintColor[1] as ImageButton
        mImageButtonCurrentPaint!!.setImageDrawable(
            ContextCompat.getDrawable(this, R.drawable.pallet_normal)
        )

        val ibBrushOpenDialog: ImageButton = findViewById(R.id.ib_brush)
        ibBrushOpenDialog.setOnClickListener(){
            showBrushSizeChooserDialog()
        }


    }

    private fun showBrushSizeChooserDialog(){
        val brushDialog = Dialog(this)
        brushDialog.setContentView(R.layout.dialog_brush_size)

        val smallBtn: ImageButton = brushDialog.findViewById(R.id.ib_small_brush)
        smallBtn.setOnClickListener(){
            mDrawingView?.setSizeForBrush(10.toFloat())
            brushDialog.dismiss()
        }
        val mediumBtn: ImageButton = brushDialog.findViewById(R.id.ib_medium_brush)
        mediumBtn.setOnClickListener(){
            mDrawingView?.setSizeForBrush(20.toFloat())
            brushDialog.dismiss()
        }
        val largeBtn: ImageButton = brushDialog.findViewById(R.id.ib_large_brush)
        largeBtn.setOnClickListener(){
            mDrawingView?.setSizeForBrush(30.toFloat())
            brushDialog.dismiss()
        }

        brushDialog.show()

    }
}