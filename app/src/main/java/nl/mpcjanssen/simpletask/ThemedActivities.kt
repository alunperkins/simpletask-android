package nl.mpcjanssen.simpletask

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import java.util.Locale

abstract class ThemedNoActionBarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(TodoApplication.config.activeTheme)
        if (TodoApplication.config.forceEnglish) {
            val conf = resources.configuration
            conf.locale = Locale.ENGLISH
            resources.updateConfiguration(conf, resources.displayMetrics)
        }
        super.onCreate(savedInstanceState)
    }
}

abstract class ThemedActionBarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(TodoApplication.config.activeActionBarTheme)
        if (TodoApplication.config.forceEnglish) {
            val conf = resources.configuration
            conf.locale = Locale.ENGLISH
            resources.updateConfiguration(conf, resources.displayMetrics)
        }
        super.onCreate(savedInstanceState)
    }
}

abstract class ThemedPreferenceActivity : AppCompatPreferenceActivity() {

    @Deprecated("Deprecated in Java")
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(TodoApplication.config.activeActionBarTheme)
        if (TodoApplication.config.forceEnglish) {
            val conf = resources.configuration
            conf.locale = Locale.ENGLISH
            resources.updateConfiguration(conf, resources.displayMetrics)
        }
        super.onCreate(savedInstanceState)
    }
}

