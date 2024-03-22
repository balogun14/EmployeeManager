package controllers;

import Models.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class employeeController {
    private final EmployeeService employeeService;

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
