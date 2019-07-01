package com.manidevs.KotlinSpringDemo.model

    data class Employee(val id: Int,
                        val name: String,
                        val age: Int,
                        var department: String,
                        var salary: Double) {
        operator fun set(id: Int, value: Employee) {

        }
    }


data class EmployeeUpdateReq( val department: String?, val salary: Double?)
