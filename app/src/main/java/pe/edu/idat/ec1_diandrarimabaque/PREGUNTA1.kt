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
fun Salario() {
    var horasTrabajadas by rememberSaveable { mutableStateOf("") }
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
                text = "Cálculo Salario ",
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp),
                style = TextStyle(
                    fontFamily = FontFamily.Cursive,
                    fontWeight = FontWeight.Bold,
                    fontSize = 30.sp,
                    color = Color.Blue)
                )

            OutlinedTextField(
                value = horasTrabajadas,
                onValueChange = { horasTrabajadas = it },
                modifier = Modifier.fillMaxWidth(),
                label = { Text("Ingrese horas trabajadas")
                      },
                maxLines = 1,
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)


            )
            MySpace(16)
            Button(
                onClick = {
                    resultado = calcularSalario(horasTrabajadas.toInt())
                },
                modifier = Modifier.fillMaxWidth()
            ) {

                Text("Calcular Salario")
                TextStyle(fontWeight = FontWeight.Bold, color = Color.Black)
            }
            MySpace(16)
            Text(
                text = resultado,
                style = TextStyle(fontWeight = FontWeight.Bold, color = Color.Blue)


            )
        }
    }
}

@Composable
fun MySpace(espacio: Int) {
    Spacer(modifier = Modifier.size(espacio.dp))
}

fun calcularSalario(horasTrabajadas: Int): String {
    var horasNormales = 40
    var salarioNormal = 16
    var salarioExtra = 20

    var salarioTotal = if (horasTrabajadas <= horasNormales) {
        horasTrabajadas * salarioNormal
    } else {
        var horasExtras = horasTrabajadas - horasNormales
        (horasNormales * salarioNormal) + (horasExtras * salarioExtra)
    }

    return "El salario es: $$salarioTotal"
}
