package com.example.viagens

import android.os.Bundle
import android.text.Selection
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.viagens.ui.theme.ViagensTheme
import java.math.BigDecimal
import java.time.LocalDate
import java.time.LocalTime

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viagem1 = Viagem(
            dataDeSaida = LocalDate.of(2025, 6, 9),
            dataEstimadaDeChegada = LocalDate.of(2025, 6, 10),
            horaDeSaida = LocalTime.of(8, 0),
            horaEstimadaDeChegada = LocalTime.of(12, 0),
            localDePartidaComDescricao = "São Paulo - Terminal Rodoviário",
            localDeSaidaComDescricao = "Rio de Janeiro - Rodoviária Novo Rio",
            valorEstimado = BigDecimal("150.00")
        )

        enableEdgeToEdge()
        setContent {
            ViagensTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MostrarViagens(
                        viagem1,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun MostrarViagens(viagem: Viagem, modifier: Modifier = Modifier) {

    Column(modifier = modifier.padding(0.dp, 5.dp)) {
        Text("Imagem")
        SelectExemplo()
    }

    Column(modifier = modifier.padding(16.dp)) {
        Text(text = "Selecionar Viagens")

    }


}

@Preview(showBackground = true)
@Composable
fun MostrarViagensPreview() {

    val viagem1 = Viagem(
        dataDeSaida = LocalDate.of(2025, 6, 9),
        dataEstimadaDeChegada = LocalDate.of(2025, 6, 10),
        horaDeSaida = LocalTime.of(8, 0),
        horaEstimadaDeChegada = LocalTime.of(12, 0),
        localDePartidaComDescricao = "São Paulo - Terminal Rodoviário",
        localDeSaidaComDescricao = "Rio de Janeiro - Rodoviária Novo Rio",
        valorEstimado = BigDecimal("150.00")
    )


    ViagensTheme {
        MostrarViagens(viagem1)
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SelectExemplo() {
    val opcoes = listOf("Opção 1", "Opção 2", "Opção 3")
    var opcaoSelecionada by remember { mutableStateOf(opcoes[0]) }
    var expanded by remember { mutableStateOf(false) }

    ExposedDropdownMenuBox (
        expanded = expanded,
        onExpandedChange = { expanded = !expanded }
    ) {
        TextField(
            value = opcaoSelecionada,
            onValueChange = {},
            readOnly = true,
            label = { Text("Selecione uma opção") },
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
            modifier = Modifier.menuAnchor()
        )

        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            opcoes.forEach { opcao ->
                DropdownMenuItem(
                    text = { Text(opcao) },
                    onClick = {
                        opcaoSelecionada = opcao
                        expanded = false
                    }
                )
            }
        }
    }
}