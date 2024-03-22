package net.theawwal.employeemanager.controllers;

import net.theawwal.employeemanager.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import net.theawwal.employeemanager.Models.Employee;

@RestController
@RequestMapping("/employee")
public class employeeController {
    private final EmployeeService employeeService;
@Autowired
    public employeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployees(){
        List<Employee> employeeList = employeeService.findAllEmployees();
        return new ResponseEntity<>(employeeList,HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Employee> findEmployee(@PathVariable("id") Long Id){
        Employee employee = employeeService.findEmployeeById(Id);
        return new ResponseEntity<>(employee,HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employeerequest){
        Employee employee = employeeService.addEmployee(employeerequest);
        return new ResponseEntity<>(employee,HttpStatus.CREATED);
    }
    
    @PutMapping("/update")
    public  ResponseEntity<Employee> updateEmployee(@RequestBody Employee employeerequest){
        Employee updateEmployee = employeeService.addEmployee(employeerequest);
        return  new ResponseEntity<>(updateEmployee,HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public  ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id){
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
