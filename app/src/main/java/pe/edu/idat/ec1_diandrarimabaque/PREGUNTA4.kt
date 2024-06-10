package pe.edu.idat.ec1_diandrarimabaque

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SerieSuma() {
    var limite by rememberSaveable { mutableStateOf("") }
    var resultado by rememberSaveable { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 25.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            Text(
                text = "Calcular Suma Serie",
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth().padding(vertical = 16.dp),
                style = TextStyle(
                    fontFamily = FontFamily.Cursive,
                    fontWeight = FontWeight.Bold,
                    fontSize = 30.sp,
                    color = Color.Blue
                )
            )
            OutlinedTextField(
                value = limite,
                onValueChange = { limite = it },
                modifier = Modifier.fillMaxWidth(),
                label = { Text("Ingrese número límite") },
                maxLines = 1,
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            MySpace(16)
            Button(
                onClick = {
                    resultado = calcularSuma(limite)
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Calcular Suma")
            }
            MySpace(16)
            Text(
                text = resultado,
                style = TextStyle(fontWeight = FontWeight.Bold, color = Color.Blue)
            )
        }
    }
}


fun calcularSuma(limite: String): String {
    return try {
        var limiteInt = limite.toInt()
        if (limiteInt > 0) {
            var suma = (1..limiteInt).sum()
            "La suma de los números hasta $limiteInt es: $suma"
        } else {
            "Error: Por favor, ingrese un número válido mayor que 0."
        }
    } catch (e: NumberFormatException) {
        "Error: Por favor, ingrese un número válido."
    }
}
