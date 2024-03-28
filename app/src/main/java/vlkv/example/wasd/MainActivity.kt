package vlkv.example.wasd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.OnClickListener
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import vlkv.example.wasd.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val retrofit = Retrofit.Builder().baseUrl("https://api.quotable.io/").addConverterFactory(GsonConverterFactory.create()).build()
        val service = retrofit.create(service::class.java)
        binding.knopka.setOnClickListener{GlobalScope.launch (Dispatchers.Main)
        {val data = withContext(Dispatchers.IO)
        {return@withContext service.getdata()}
            binding.textView.text = data.content
        }
        }
    }
}