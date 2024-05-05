package br.com.darlison.alcoolOuGasolina

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.darlison.alcoolOuGasolina.ui.theme.AlcoolOuGasolinaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AlcoolOuGasolinaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                   App()
                }
            }
        }
    }
}

@Composable
fun App() {
    var valGasolina = remember {
        mutableStateOf("")
    }

    var valorAlcool = remember {
        mutableStateOf("")
    }


    Column(
        Modifier
            .background(color = Color(0xFF00BCD4))
            .fillMaxSize(),

        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Álcool ou Gasolina?",
                style = TextStyle(
                    color = Color.White,
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold
                )
        )

        Spacer(modifier = Modifier.size(16.dp))

        AnimatedVisibility(visible = valGasolina.value.isNotBlank() && valorAlcool.value.isNotBlank()) {
            if (valGasolina.value.isNotBlank() && valorAlcool.value.isNotBlank()){
                val valorAlcoolDouble = valorAlcool.value.toDouble()
                val valGasolinaDouble = valGasolina.value.toDouble()

                val ehGasolina = (valGasolinaDouble / valorAlcoolDouble > 0.7)
                val alcoolOuGasolina = if (ehGasolina) {
                    "Gasolina"
                } else {
                    "Álcool"
                }

                val cor = if (ehGasolina) {
                    Color.Red
                } else {
                    Color.Green
                }
                Text(text = alcoolOuGasolina, style = TextStyle(color = cor, fontSize = 40.sp, fontWeight = FontWeight.Bold))
            }

        }




        TextField(
            value = valorAlcool.value,
            onValueChange = {novoValor ->
                             valorAlcool.value = novoValor
            },
            label = {
                Text(text = "Álcool")
            }
        )

        Spacer(modifier = Modifier.size(16.dp))


//        var valGasolina = remember {
//            mutableStateOf("")
//        }

        TextField(
            value = valGasolina.value,
            onValueChange = {novoValor ->
                           valGasolina.value = novoValor
            },
            label = {
                Text(text = "Gasolina")
            }
        )
    }

}



