package id.endgame.app.utils

import android.content.Context
import java.io.IOException
import java.nio.charset.Charset
import android.graphics.Bitmap
import android.graphics.Matrix
import android.graphics.RectF
import java.io.InputStream
import java.net.URL
import android.graphics.drawable.Drawable

object FileUtils {

    @Throws(IOException::class)
    fun loadJSONFromAsset(context: Context, jsonFileName: String): String {
        (context.assets).open(jsonFileName).let {
            val buffer = ByteArray(it.available())
            it.read(buffer)
            it.close()
            return String(buffer, Charset.forName("UTF-8"))
        }
    }

    fun loadImageFromURL(url: String?): Drawable? {
        try {
            val stream = URL(url).content as InputStream
            return Drawable.createFromStream(stream, "")
        } catch (e: Exception) {
            return null
        }
    }

    fun getScaledBitmap(b: Bitmap, reqWidth: Int, reqHeight: Int): Bitmap {
        val m = Matrix()
        m.setRectToRect(
            RectF(0f, 0f, b.width.toFloat(), b.height.toFloat()),
            RectF(0f, 0f, reqWidth.toFloat(), reqHeight.toFloat()),
            Matrix.ScaleToFit.CENTER
        )
        return Bitmap.createBitmap(b, 0, 0, b.width, b.height, m, true)
    }
}
