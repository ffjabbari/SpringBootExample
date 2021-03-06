package com.mikebryant.springboot.poc;

import com.mikebryant.springboot.poc.data.model.Department;
import com.mikebryant.springboot.poc.data.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DepartmentController {
    private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @Autowired
    private DepartmentService departmentService;


    @CrossOrigin
    @RequestMapping(
            value = "/department",
            method = RequestMethod.POST,
            produces = "application/json")
    public ResponseEntity<Department> add(@Valid @RequestBody Department department) {
        logger.debug("Add Department: " + department.toString());
        department = departmentService.save(department);

        return new ResponseEntity<>(department, HttpStatus.CREATED);
    }

    @CrossOrigin
    @RequestMapping(
            value = "/department",
            method = RequestMethod.PUT,
            produces = "application/json")
    public ResponseEntity<Department> update(@Valid @RequestBody Department department) {
        logger.debug("Update Department: " + department.toString());
        department = departmentService.save(department);

        return new ResponseEntity<>(department, HttpStatus.OK);
    }

    @CrossOrigin
    @RequestMapping(
            value = "/department/{uuid}",
            method = RequestMethod.GET,
            produces = "application/json")
    public ResponseEntity<Department> get(@PathVariable String uuid) {
        logger.debug("Get Department: " + uuid);
        Department department = departmentService.get(uuid);

        return new ResponseEntity<>(department, HttpStatus.OK);
    }

    @CrossOrigin
    @RequestMapping(
            value = "/department",
            method = RequestMethod.GET,
            produces = "application/json")
    public ResponseEntity<List<Department>> getAll() {
        logger.debug("Get all person");
        List<Department> departments = departmentService.getAll();

        return new ResponseEntity<>(departments, HttpStatus.OK);
    }

    @CrossOrigin
    @RequestMapping(
            value = "/department/{uuid}",
            method = RequestMethod.DELETE,
            produces = "application/json")
    public ResponseEntity<String> delete(@PathVariable String uuid) {
        logger.debug("Delete Department: " + uuid);
        departmentService.delete(uuid);

        return new ResponseEntity<>(" { \"status\": \"OK\" } ", HttpStatus.OK);
    }
}
