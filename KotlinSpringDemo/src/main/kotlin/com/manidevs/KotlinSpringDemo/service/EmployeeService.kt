package com.manidevs.KotlinSpringDemo.service

import com.manidevs.KotlinSpringDemo.model.Employee
import com.manidevs.KotlinSpringDemo.model.EmployeeUpdateReq
import org.springframework.stereotype.Service
import reactor.core.publisher.toFlux
import reactor.core.publisher.toMono

@Service
    class EmployeeService {

        companion object{
            val employeeDb = mutableMapOf( 1 to Employee(1, "Rick Sanchez", 70,"Engineering", 50000.0),
                    2 to Employee(2, "Mario Fraile",  20,"Software", 26000.0))
        }

        fun createEmployee(employee: Employee) = employeeDb.put(employee.id, employee)

        fun getEmployee(id: Int) = employeeDb[id]?.toMono()

        fun getAllEmployees() = employeeDb.values.toFlux()

        fun updateEmployee(id :Int, updateEmployee : EmployeeUpdateReq){
            val employeeOnDb = employeeDb[id]!!
            employeeOnDb[id] = Employee(employeeOnDb.id, employeeOnDb.name, employeeOnDb.age,
                    updateEmployee.department ?: employeeOnDb.department,
                    updateEmployee.salary ?: employeeOnDb.salary)

        }

        fun deleteEmployee(id: Int)= employeeDb.remove(id)

    }




