package com.example.examen_2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Surface
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.examen_2.presentation.viewmodel.ProductosViewModel
import com.example.examen_2.ui.screens.ProductosScreen
import com.example.examen_2.ui.theme.Examen_2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Examen_2Theme {
                Surface() {
                    val vm: ProductosViewModel = viewModel()
                    ProductosScreen(vm)
                }
            }
        }
    }
}
