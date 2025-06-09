package com.example.viagens

import java.math.BigDecimal
import java.time.LocalDate
import java.time.LocalTime

data class Viagem(
    val dataDeSaida: LocalDate,
    val dataEstimadaDeChegada: LocalDate,
    val horaDeSaida: LocalTime,
    val horaEstimadaDeChegada: LocalTime,
    val localDePartidaComDescricao: String,
    val localDeSaidaComDescricao: String,
    val valorEstimado: BigDecimal
)