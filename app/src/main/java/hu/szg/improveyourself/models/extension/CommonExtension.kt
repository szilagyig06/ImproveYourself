package hu.szg.improveyourself.models.extension

import android.content.Context
import android.widget.Toast


fun String.show(context: Context, long: Boolean) {
    Toast.makeText(context , this, if(long) Toast.LENGTH_LONG else Toast.LENGTH_SHORT).show()
}