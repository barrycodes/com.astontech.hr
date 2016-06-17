package com.astontech.hr.domain;

import javax.persistence.*;
import java.util.List;

/**
 * Created by barrsmit1 on 6/16/2016.
 */
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Version
    private Integer version;

    private String username;
}
