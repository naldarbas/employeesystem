package tech.getarrays.employeemanager.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.getarrays.employeemanager.model.Employee;
import tech.getarrays.employeemanager.service.EmployeeService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:63308")
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    //ResponseEntity it is class
    //what type of data that's going to return in this case will return list od employee type
    //when use it must be return the status
    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployees(){
        List<Employee> employees=employeeService.findAllEmployee();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id){
        Employee employee =employeeService.findEmployeeById(id);
        return new ResponseEntity<>(employee , HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<Employee>addEmployee(@RequestBody Employee employee){
        Employee newEmployee=employeeService.addEmployee(employee);
        return new ResponseEntity<>(newEmployee , HttpStatus.CREATED);
    }
    @PutMapping("/update")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
        Employee updateEmployee =employeeService.updateEmployee(employee);
        return new ResponseEntity<>(updateEmployee , HttpStatus.OK);
    }

    //  ? will return nothing - another way for void
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") String id){
        System.out.println("inside delete Employee ");
        return ResponseEntity.ok().body(employeeService.deleteEmployeeById(id));

    }



}
