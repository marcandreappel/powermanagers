package `fun`.appel.powermanagers.sample

import `fun`.appel.powermanagers.Powermanagers
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val powermanagerIntent: Intent? = Powermanagers.present(this)

        if (powermanagerIntent != null) {
            powermanager_message.text = getString(R.string.powermanager_absent)
            powermanager_message.setTextColor(resources.getColor(R.color.colorAccent))
            addButton(powermanagerIntent)
        }
    }

    private fun addButton(intent: Intent) {
        val btnLayoutParams = ConstraintLayout.LayoutParams(
                ConstraintLayout.LayoutParams.WRAP_CONTENT,
                ConstraintLayout.LayoutParams.WRAP_CONTENT)
        btnLayoutParams.topToBottom = powermanager_message.id
        btnLayoutParams.topMargin = 16
        btnLayoutParams.startToStart = activity_main_layout.id
        btnLayoutParams.endToEnd = activity_main_layout.id

        val button = Button(this)
        button.layoutParams = btnLayoutParams
        button.text = getString(R.string.open_powermanager)
        button.setOnClickListener {
            startActivity(intent)
        }

        activity_main_layout.addView(button)
    }
}
