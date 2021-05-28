package tw.edu.pu.s1082821.crazyshape

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.module.AppGlideModule
@GlideModule
public final class MyAppGlideModule : AppGlideModule()


class MainActivity : AppCompatActivity() {

    var Flag:Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Toast.makeText(baseContext, "作者：胡琪碩", Toast.LENGTH_LONG).show()
        rndShape()

        GlideApp.with(this)
            .load(R.drawable.cover)
            .override(800, 600)
            .into(imgView)

        imgNext.setOnClickListener(object:View.OnClickListener{
            override fun onClick(p0: View?) {
                rndShape()
            }
        })
    }

    fun rndShape(){
        Flag = (1..4).random()
        when (Flag){
            1->imgNext.setImageResource(R.drawable.circle)
            2->imgNext.setImageResource(R.drawable.square)
            3->imgNext.setImageResource(R.drawable.star)
            4->imgNext.setImageResource(R.drawable.triangle)
        }

        imgNext.setOnLongClickListener(object : View.OnLongClickListener {
            override fun onLongClick(p0: View?): Boolean {
                intent = Intent(this@MainActivity, GameActivity::class.java).apply {
                    putExtra("形狀", Flag)
                }
                startActivity(intent)
                return true
            }
        })
    }
}

