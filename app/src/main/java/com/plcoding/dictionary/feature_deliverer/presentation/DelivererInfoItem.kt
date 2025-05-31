package com.plcoding.dictionary.feature_deliverer.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.plcoding.dictionary.feature_deliverer.domain.model.Deliverer

@Composable
fun DelivererIntoItem(
    deliverer: Deliverer,
    modifier: Modifier = Modifier
){
    Column(modifier = modifier) {
        Text(text = deliverer.name, fontSize = 24.sp, fontWeight = FontWeight.Bold, color = Color.Black)
        Spacer(modifier = Modifier.height(16.dp))
        deliverer.products?.forEach { name ->
            Text(text = name.name, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = name.pricePerAmount, fontWeight = FontWeight.Bold)
        }
    }
}