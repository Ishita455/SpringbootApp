package com.mycompany.springapp.employee.repository;

import com.mycompany.springapp.employee.model.EmployeeModel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeRepository {

    List<EmployeeModel> employeeList = new ArrayList<>();

    public EmployeeModel addEmployee(EmployeeModel em)
    {
        this.employeeList.add(em);
        return em;
    }

    public List<EmployeeModel> getAllEmployees()
    {
        return employeeList;
    }

    public EmployeeModel deleteEmployee(Long employeeId)
    {
        EmployeeModel employeeDeleted = null;
        for(int i=0; i<this.employeeList.size(); i++)
        {
            employeeDeleted = this.employeeList.get(i);
            if(employeeDeleted.getEmpId().longValue() == employeeId.longValue())
            {
                this.employeeList.remove(i);
                break;
            }
        }
        return employeeDeleted;
    }

    public EmployeeModel updateEmployee(Long employeeId,EmployeeModel employee) {
        EmployeeModel employeeUpdated = null;
        for (int i = 0; i < this.employeeList.size(); i++) {
            employeeUpdated = this.employeeList.get(i);
            if (employeeUpdated.getEmpId() == employeeId) {
                employeeUpdated.setEmpName(employee.getEmpName());
                employeeUpdated.setEmpSalary(employee.getEmpSalary());
                employeeUpdated.setDepartment(employee.getDepartment());
                this.employeeList.set(i, employeeUpdated);
                break;
            }
        }
        return employeeUpdated;
    }

    public List<EmployeeModel> searchEmployee(String department,double fromSalary,double toSalary)
    {
        List<EmployeeModel> employees = new ArrayList<>();
        EmployeeModel es = null;
        for(int i = 0; i<this.employeeList.size(); i++)
        {
            es = this.employeeList.get(i);
            if(es.getDepartment().contains(department) && es.getEmpSalary()>=fromSalary && es.getEmpSalary()<=toSalary)
            {
                employees.add(es);
            }
        }
        return employees;
    }

}