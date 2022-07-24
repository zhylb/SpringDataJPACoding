package com.lihd.pgsql.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/4/22 22:03
 */
@Entity
@Table(name = "course_type")
public class CourseType {

    private Integer ctno;
    private String tname;


    @Id
    public Integer getCtno() {
        return ctno;
    }

    public void setCtno(Integer ctno) {
        this.ctno = ctno;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }


}
