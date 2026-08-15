package com.example.coursemanagementsystem.controller;
/*
import com.example.coursemanagementsystem.entity.Student;
import jakarta.persistence.EntityManagerFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor */
public class AdminController {

/*
    private final EntityManagerFactory entityManagerFactory;

    @GetMapping("/{id}")
    public List<Student> getRevisions(@PathVariable Long id){
        AuditReader reader = AuditReaderFactory.get(entityManagerFactory.createEntityManager());

        List<Number> revisions = reader.getRevisions(Student.class, id);
        return revisions
                .stream()
                .map(revisionNumber -> reader.find(Student.class, id, revisionNumber))
                .toList();
    }
*/
}
