package com.manidevs.KotlinSpringDemo.service

import com.manidevs.KotlinSpringDemo.model.Employee
import org.springframework.stereotype.Service
import reactor.core.publisher.toFlux
import reactor.core.publisher.toMono

@Service
    class EmployeeService {

        companion object{
            val employeeDb = mutableMapOf( 1 to Employee(1, "Rick Sanchez", 70,"Engineering", 50000.0),
                    2 to Employee(2, "Mario Fraile",  20,"Engineering", 26000.0))
        }

        fun createEmployee(employee: Employee) = employeeDb.put(employee.id, employee)

        fun getEmployee(id: Int) = employeeDb[id]?.toMono()

        fun getAllEmployees(minAge: Int?, minSalary: Double?)
                = employeeDb.values.toFlux()
                .filter { it.age >= minAge ?: Int.MIN_VALUE }
                .filter { it.salary >= minSalary ?: Double.MAX_VALUE }

    }