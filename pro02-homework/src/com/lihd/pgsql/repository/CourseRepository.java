package com.lihd.pgsql.repository;

import com.lihd.pgsql.pojo.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course,String> {
}
