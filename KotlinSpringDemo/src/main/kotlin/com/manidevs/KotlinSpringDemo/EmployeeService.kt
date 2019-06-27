package com.manidevs.KotlinSpringDemo

import org.springframework.stereotype.Service

    @Service
    class EmployeeService {
        val employee = hashMapOf(1 to "Mario Fraile ", 2 to "Adrian Homero", 3 to "Hang tu wang lee")

        fun findEmployee(id: Int) = employee[id] ?: "Not_Found"
    }