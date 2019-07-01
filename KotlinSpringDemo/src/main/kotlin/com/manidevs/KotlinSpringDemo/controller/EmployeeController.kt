package com.manidevs.KotlinSpringDemo.controller

import com.manidevs.KotlinSpringDemo.model.Employee
import com.manidevs.KotlinSpringDemo.model.EmployeeUpdateReq
import com.manidevs.KotlinSpringDemo.service.DepartmentService
import com.manidevs.KotlinSpringDemo.service.EmployeeService
import org.hibernate.validator.constraints.CodePointLength
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
    class EmployeeController{

        @Autowired
        lateinit var employeeService: EmployeeService

        @Autowired
        lateinit var departmentService: DepartmentService

        @PostMapping("/employee")
        fun createEmployee(@RequestBody employee: Employee){
            employeeService.createEmployee(employee)
        }

        @GetMapping("/employee/{id}")
        fun getEmpoyee(@PathVariable("id")id : Int ) = employeeService.getEmployee(id)

        @GetMapping("/employees")
        fun getEmployees() = employeeService.getAllEmployees()

        @GetMapping("/departments")
        fun getAllDepartments() = departmentService.getAllDepartments()

        @PutMapping("/employee/{id}")
        fun updateEmployee(@PathVariable id: Int,
                           @RequestBody updateEmployee: EmployeeUpdateReq){
            employeeService.updateEmployee(id, updateEmployee)
        }

        @DeleteMapping("/employee/{id}")
        fun deleteEmployee(@PathVariable id: Int){
            employeeService.deleteEmployee(id)
        }
    }