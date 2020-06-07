package com.example.journal.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

@Entity
public class EntryJournal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String orders;
    private String product_name;
    private String type_of_test;
    private int quantity;
    private String testers_name;
    private Date date;
    private String note;

    public EntryJournal() {
    }

    public EntryJournal(String orders, String product_name, String type_of_test, int quantity, String testers_name, Date date, String note) {
        this.orders = orders;
        this.product_name = product_name;
        this.type_of_test = type_of_test;
        this.quantity = quantity;
        this.testers_name = testers_name;
        this.date = date;
        this.note = note;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrders() {
        return orders;
    }

    public void setOrders(String orders) {
        this.orders = orders;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getType_of_test() {
        return type_of_test;
    }

    public void setType_of_test(String type_of_test) {
        this.type_of_test = type_of_test;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getTesters_name() {
        return testers_name;
    }

    public void setTesters_name(String testers_name) {
        this.testers_name = testers_name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
