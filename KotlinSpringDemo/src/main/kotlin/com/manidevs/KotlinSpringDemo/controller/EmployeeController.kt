package com.manidevs.KotlinSpringDemo.controller

import com.manidevs.KotlinSpringDemo.model.Employee
import com.manidevs.KotlinSpringDemo.service.EmployeeService
import org.hibernate.validator.constraints.CodePointLength
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
    class EmployeeController{

        @Autowired
        lateinit var employeeService: EmployeeService

        @PostMapping("/employee")
        fun createEmployee(@RequestBody employee: Employee){
            employeeService.createEmployee(employee)
        }

        @GetMapping("/employee/{id}")
        fun getEmpoyee(@PathVariable("id")id : Int ) = employeeService.getEmployee(id)

        @GetMapping("/employee")
        fun getAllEmployees(@RequestParam("minAge", required = false) minAge: Int?,
                            @PathVariable("minSalary", required = false)minSalary: Double?)
                = employeeService.getAllEmployees( minAge, minSalary)
    }