package com.lihd.pgsql.pojo;

import javax.persistence.*;
import java.util.Set;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/4/22 22:58
 */
@Entity
@Table(name = "teacher_course")
public class TeacherCourse {
    private Integer tcid;
    private Teacher tno;
    private Profession spno;
    private String classno;
    private CourseType ctno;

    private String semester;
    private String schoolyear;
    private String classtime;
    private String classroom;
    private Integer weektime;

    private Set<Student> students;

    @Id
    public Integer getTcid() {
        return tcid;
    }

    public void setTcid(Integer tcid) {
        this.tcid = tcid;
    }

    @ManyToOne
    @JoinColumn(name = "tno",referencedColumnName ="tno")
    public Teacher getTno() {
        return tno;
    }

    public void setTno(Teacher tno) {
        this.tno = tno;
    }

    @ManyToOne
    @JoinColumn(name = "spno",referencedColumnName ="spno")
    public Profession getSpno() {
        return spno;
    }

    public void setSpno(Profession spno) {
        this.spno = spno;
    }

    public String getClassno() {
        return classno;
    }

    public void setClassno(String classno) {
        this.classno = classno;
    }


    @ManyToOne
    @JoinColumn(name = "ctno",referencedColumnName ="ctno")
    public CourseType getCtno() {
        return ctno;
    }

    public void setCtno(CourseType ctno) {
        this.ctno = ctno;
    }





    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getSchoolyear() {
        return schoolyear;
    }

    public void setSchoolyear(String schoolyear) {
        this.schoolyear = schoolyear;
    }

    public String getClasstime() {
        return classtime;
    }

    public void setClasstime(String classtime) {
        this.classtime = classtime;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public Integer getWeektime() {
        return weektime;
    }

    public void setWeektime(Integer weektime) {
        this.weektime = weektime;
    }

    @ManyToMany(mappedBy = "teacherCourses")
    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
}
