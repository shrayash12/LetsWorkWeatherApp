package shradha.com.letsworkweatherapp.data.local

import android.content.Context
import java.io.InputStream

object LocalDataSource {
    fun jsonDataFromAsset(context: Context): String? {
        var input: InputStream? = null
        var jsonString: String

        try {
            input = context.assets.open("weather.json")
            val size = input.available()
            val buffer = ByteArray(size)
            input.read(buffer)
            jsonString = String(buffer)

            return jsonString
        } catch (ex: Exception) {
            ex.printStackTrace()
        } finally {
            input?.close()
        }
        return null
    }
}

