package nl.mpcjanssen.simpletask.util

import android.util.Log


open class ActionQueue(val qName: String) : Thread() {


    fun add(description: String, r: () -> Unit) {
        Log.i(qName, "-> $description")
//        TODO doAsync {
            Log.i(qName, "<- $description")
            r.invoke()
//        }
    }
}

object FileStoreActionQueue : ActionQueue("FSQ")



