package net.theawwal.employeemanager.service;

import net.theawwal.employeemanager.Models.Employee;
import net.theawwal.employeemanager.service.EmployeeService;
import net.theawwal.employeemanager.exceptions.UserNotFoundException;
import net.theawwal.employeemanager.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {
    private final EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public Employee addEmployee(Employee employee) {
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepo.save(employee);
    }

    public List<Employee> findAllEmployees() {
        return employeeRepo.findAll();
    }

    public Employee updateEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }

    public void deleteEmployee(Long id){
        employeeRepo.deleteEmployeeById(id);
    }

    public Employee findEmployeeById(long id) {
        return  employeeRepo.findEmployeeById(id).orElseThrow(()-> new UserNotFoundException("Employee with that "+ id +" does not exist"));
    }
}
