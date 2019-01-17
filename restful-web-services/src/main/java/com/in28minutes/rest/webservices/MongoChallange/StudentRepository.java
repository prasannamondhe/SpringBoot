package com.in28minutes.rest.webservices.MongoChallange;

import com.in28minutes.rest.webservices.MongoChallange.studentRecords.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Prasanna.Mondhe on 1/16/2019.
 */
@Transactional
public interface StudentRepository extends MongoRepository<Student,String> {
}
