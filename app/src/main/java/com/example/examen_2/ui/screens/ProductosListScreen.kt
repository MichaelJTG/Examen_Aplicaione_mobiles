package com.example.examen_2.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import com.example.examen_2.data.model.ProductosDto
import com.example.examen_2.presentation.viewmodel.ProductosViewModel
import com.example.examen_2.presentation.viewmodel.UiState
import com.example.examen_2.ui.theme.BackgroundCream
import com.example.examen_2.ui.theme.GoldRoyal
import com.example.examen_2.ui.theme.GreenForest
import com.example.examen_2.ui.theme.TextDarkGreen


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductosScreen(vm: ProductosViewModel) {
    val state = vm.state

    Scaffold(
        containerColor = BackgroundCream,
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        "ROYAL COLLECTION API",
                        style = MaterialTheme.typography.headlineSmall,
                        fontFamily = FontFamily.Serif, // Fuente clásica
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 1.sp //
                    )
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = GreenForest,
                    titleContentColor = GoldRoyal
                ),
                modifier = Modifier.shadow(10.dp)
            )
        }
    ) { paddingValues ->

        Box(modifier = Modifier
            .padding(paddingValues)
            .fillMaxSize()
        ) {
            when (state) {
                is UiState.Loading -> {
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        CircularProgressIndicator(color = GoldRoyal)
                    }
                }

                is UiState.Error -> {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text("Ocurrió un error", color = GreenForest)
                        Button(
                            onClick = { vm.loadProductos() },
                            colors = ButtonDefaults.buttonColors(containerColor = GreenForest)
                        ) { Text("Reintentar", color = GoldRoyal) }
                    }
                }

                is UiState.Success -> {
                    LazyColumn(
                        modifier = Modifier.fillMaxSize(),
                        contentPadding = PaddingValues(20.dp),
                        verticalArrangement = Arrangement.spacedBy(20.dp)
                    ) {
                        items(state.data) { producto ->
                            ProductoItemDeluxe(producto)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ProductoItemDeluxe(producto: ProductosDto) {
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        shape = RoundedCornerShape(4.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        border = BorderStroke(1.dp, GoldRoyal.copy(alpha = 0.5f)),
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // --- IMAGEN CON MARCO ---
            val painter = rememberAsyncImagePainter(model = producto.image)

            Box(
                modifier = Modifier
                    .size(110.dp)
                    .border(1.dp, GoldRoyal, RoundedCornerShape(4.dp)) // Marco dorado a la foto
                    .padding(4.dp) // Espacio entre marco y foto
                    .clip(RoundedCornerShape(2.dp))
                    .background(Color.White),
                contentAlignment = Alignment.Center
            ) {
                if (painter.state is AsyncImagePainter.State.Loading) {
                    CircularProgressIndicator(modifier = Modifier.size(20.dp), color = GoldRoyal)
                }
                Image(
                    painter = painter,
                    contentDescription = null,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier.fillMaxSize()
                )
            }

            Spacer(modifier = Modifier.width(20.dp))


            Column(modifier = Modifier.weight(1f)) {


                Text(
                    text = producto.category.uppercase(),
                    style = MaterialTheme.typography.labelSmall,
                    color = GoldRoyal,
                    fontWeight = FontWeight.SemiBold,
                    letterSpacing = 1.sp,
                    modifier = Modifier.padding(bottom = 8.dp)
                )


                Text(
                    text = producto.name,
                    style = MaterialTheme.typography.titleLarge,
                    fontFamily = FontFamily.Serif, // Toque elegante
                    fontWeight = FontWeight.Bold,
                    color = TextDarkGreen,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )


                Spacer(modifier = Modifier.height(8.dp))
                Box(modifier = Modifier
                    .width(40.dp)
                    .height(2.dp)
                    .background(GoldRoyal))
                Spacer(modifier = Modifier.height(8.dp))


                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "${producto.price} €",
                        style = MaterialTheme.typography.headlineSmall,
                        fontWeight = FontWeight.Medium,
                        fontFamily = FontFamily.Serif,
                        color = GreenForest
                    )


                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = null,
                        tint = GoldRoyal,
                        modifier = Modifier.size(20.dp)
                    )
                }
            }
        }
    }
}