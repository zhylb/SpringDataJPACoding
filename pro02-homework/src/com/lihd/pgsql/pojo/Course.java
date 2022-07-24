package com.lihd.pgsql.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/4/22 22:51
 */
@Entity
public class Course {
    private String cno;
    private Profession spno;
    private String cname;
    private CourseType ctno;
    private Integer experiment;
    private Integer semester;
    private Integer credit;


    @Id
    public String getCno() {
        return cno;
    }

    public void setCno(String cno) {
        this.cno = cno;
    }

    @ManyToOne
    @JoinColumn(name = "spno",referencedColumnName = "spno")
    public Profession getSpno() {
        return spno;
    }

    public void setSpno(Profession spno) {
        this.spno = spno;
    }




    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    @ManyToOne
    @JoinColumn(name = "ctno",referencedColumnName = "ctno")
    public CourseType getCtno() {
        return ctno;
    }

    public void setCtno(CourseType ctno) {
        this.ctno = ctno;
    }

    public Integer getExperiment() {
        return experiment;
    }

    public void setExperiment(Integer experiment) {
        this.experiment = experiment;
    }

    public Integer getSemester() {
        return semester;
    }

    public void setSemester(Integer semester) {
        this.semester = semester;
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

}
