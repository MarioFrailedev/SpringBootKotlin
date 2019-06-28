package com.manidevs.KotlinSpringDemo.TestingCodeKotlin

import reactor.core.publisher.Flux
import reactor.core.publisher.toFlux

fun main(args:Array<String>){

    print("--filter---")
    val fluxInt = arrayListOf(1,2,3,4,5,6,7,8).toFlux()
    fluxInt
            .filter{it < 5}
            .subscribe{println(it)}

    println("--Map--")
    fluxInt
            .map { it * it }
            .subscribe{println(it)}

    println("--map vs flatMap---")
    val nameFlux = arrayListOf(
            arrayListOf("rick","sanchez").toFlux(),
            arrayListOf("morty", "Smith").toFlux(),
            arrayListOf("jerry", "summer").toFlux(),
            arrayListOf("birdPeron", "beth").toFlux()
            ).toFlux()
    nameFlux
            .flatMap { it }
            .subscribe{ println(it.capitalize())}
}