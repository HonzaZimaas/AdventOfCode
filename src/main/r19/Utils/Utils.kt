package main.r19.Utils

import java.io.InputStream

class Utils {

    fun loadInputData(path: String): InputStream {
        return {}.javaClass.getResourceAsStream(path)!!
    }
}