package com.lihd.pgsql.pojo;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/4/22 22:08
 */
@Entity
public class Student {
    private String sno;
    private String sname;
    private String sex;
    private String s_native;

    private Date birthday;
    private String dno;
    private Profession spno;
    private Date entime;
    private String home;
    private String tel;

    private Set<TeacherCourse> teacherCourses;

    @Id
    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Column(name = "native")
    public String getS_native() {
        return s_native;
    }


    public void setS_native(String s_native) {
        this.s_native = s_native;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getDno() {
        return dno;
    }

    public void setDno(String dno) {
        this.dno = dno;
    }


    @ManyToOne
    @JoinColumn(name = "spno",referencedColumnName = "spno")
    public Profession getSpno() {
        return spno;
    }

    public void setSpno(Profession spno) {
        this.spno = spno;
    }

    public Date getEntime() {
        return entime;
    }

    public void setEntime(Date entime) {
        this.entime = entime;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @JoinTable(name = "student_course",
            joinColumns = {@JoinColumn(name = "sno",referencedColumnName = "sno")},
            inverseJoinColumns = {@JoinColumn(name = "tcid",referencedColumnName = "tcid")}

    )
    @ManyToMany
    public Set<TeacherCourse> getTeacherCourses() {
        return teacherCourses;
    }

    public void setTeacherCourses(Set<TeacherCourse> teacherCourses) {
        this.teacherCourses = teacherCourses;
    }

    public Student() {
    }

    public Student(String sno, String sname, String sex, String s_native, Date birthday, String dno, Profession spno, Date entime, String home, String tel) {
        this.sno = sno;
        this.sname = sname;
        this.sex = sex;
        this.s_native = s_native;
        this.birthday = birthday;
        this.dno = dno;
        this.spno = spno;
        this.entime = entime;
        this.home = home;
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sno='" + sno + '\'' +
                ", sname='" + sname + '\'' +
                ", sex='" + sex + '\'' +
                ", s_native='" + s_native + '\'' +
                ", birthday=" + birthday +
                ", dno='" + dno + '\'' +
                ", spno=" + spno +
                ", entime=" + entime +
                ", home='" + home + '\'' +
                ", tel='" + tel + '\'' +
                '}';
    }
}
