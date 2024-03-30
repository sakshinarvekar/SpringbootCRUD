package com.example.SpringbootDemo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Product")

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pid;
    private String pname;
    private String pdesc;
    private Double pprice;



    @ManyToOne
    @JoinColumn(name = "categoryId")
    @JsonBackReference

    private Category category;
    public String getCategoryName() {
        if (category != null) {
            return category.getCname();
        } else {
            return null;
        }
    }
    public Product(){
    }

    public Product(int pid, String pname, String pdesc, Double pprice, Category category) {
        this.pid = pid;
        this.pname = pname;
        this.pdesc = pdesc;
        this.pprice = pprice;
        this.category = category;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPdesc() {
        return pdesc;
    }

    public void setPdesc(String pdesc) {
        this.pdesc = pdesc;
    }

    public Double getPprice() {
        return pprice;
    }

    public void setPprice(Double pprice) {
        this.pprice = pprice;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }


}
