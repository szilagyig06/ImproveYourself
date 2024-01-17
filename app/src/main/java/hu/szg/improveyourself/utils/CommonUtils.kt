package hu.szg.improveyourself.utils

import java.text.SimpleDateFormat
import java.util.*

object CommonUtils {

    fun getUuid() : String {
        return SimpleDateFormat("yyyyMMddHHmmss").format(Date()) + UUID(0,10)
    }
}