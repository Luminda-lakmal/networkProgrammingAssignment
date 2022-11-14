package com.example.demo.service;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;

    public void addEmp(Employee e) {
        employeeRepo.save(e);
    }

    public List<Employee> getAllEmp() {
        return employeeRepo.findAll();
    }

    public Employee getEMpById(Long id) {
        Optional<Employee> e = employeeRepo.findById( id);
        if (e.isPresent()) {
            return e.get();
        }
        return null;
    }

    public void deleteEMp(Long id) {
        employeeRepo.deleteById(id);
    }

    public Page<Employee> getEMpByPaginate(int currentPage, int size) {
        Pageable p = PageRequest.of(currentPage, size);
        return employeeRepo.findAll(p);
    }
}
