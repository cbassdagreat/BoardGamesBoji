package cbassdagreat.github.boardgamesboji

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import cbassdagreat.github.boardgamesboji.databinding.ActivityMainBinding
import cbassdagreat.github.boardgamesboji.viewmodel.BojiViewModel

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val viewModel by viewModels<BojiViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.callBojiItem()
    }
}