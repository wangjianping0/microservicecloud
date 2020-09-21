package com.atguigu.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class Dept implements Serializable {//Dept(Entity) ORM mysql->Dept(Table) 类表关系映射
    private Long deptno;//主键
    private String dname;//部门名称
    private String db_source;//来自哪一个数据库,因为微服务架构可以一个服务一个数据库

    public static void main(String[] args) {
        Dept dept=new Dept();
        dept.setDeptno(0001l).setDname("测试").setDb_source("DB_01");
        System.out.println(dept.toString());
    }
}
