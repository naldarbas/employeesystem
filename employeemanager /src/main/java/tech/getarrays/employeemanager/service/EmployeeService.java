package tech.getarrays.employeemanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.getarrays.employeemanager.exception.UserNotFoundException;
import tech.getarrays.employeemanager.model.Employee;
import tech.getarrays.employeemanager.repo.EmployeeRepo;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeService {
    private final EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public Employee addEmployee(Employee employee){
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return  employeeRepo.save(employee);
    }
    public List<Employee> findAllEmployee(){
        return employeeRepo.findAll();
    }

//    public Optional findEmployeeById(Long id){
//        return employeeRepo.findEmployeeById(id);
//    }

    //create Exception help us to use it every time need to search about employee by id
    public Employee findEmployeeById(Long id){
        return employeeRepo.findEmployeeById(id).orElseThrow(()->new UserNotFoundException("User by id" +id+ "Not Found"));
    }

    public Employee updateEmployee(Employee employee){
        return employeeRepo.save(employee);
    }

    public String deleteEmployeeById(String id){
        System.out.println(employeeRepo.findEmployeeById(Long.parseLong(id)));
        employeeRepo.deleteById(Long.parseLong(id));
        return  ("Employee "+ id + " Deleted successfully..");
    }


}
