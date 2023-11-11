/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.entity;

import java.sql.Date;

/**
 *
 * @author tuna
 */
public class Orders {
    
//    CREATE TABLE [dbo].[orders] (
//    [id]          INT             IDENTITY (0, 1) NOT NULL,
//    [user_id]     INT             NULL,
//    [status]      INT             NOT NULL,
//    [total_price] INT               NOT NULL,
//    [date_order] DATETIME DEFAULT GETDATE() NOT NULL,
//    PRIMARY KEY CLUSTERED ([id] ASC),
//    FOREIGN KEY ([user_id]) REFERENCES [dbo].[users] ([id])
//);

    private int id;
    private int user_id;
    private int status;
    private int total_price;
    private Date date_order;

    public Orders() {
    }

    public Orders(int user_id, int status, int total_price, Date date_order) {
        this.user_id = user_id;
        this.status = status;
        this.total_price = total_price;
        this.date_order = date_order;
    }

    public Orders(int id, int user_id, int status, int total_price, Date date_order) {
        this.id = id;
        this.user_id = user_id;
        this.status = status;
        this.total_price = total_price;
        this.date_order = date_order;
    }

    public Orders(int id, int user_id, int status, int total_price) {
        this.id = id;
        this.user_id = user_id;
        this.status = status;
        this.total_price = total_price;
    }
    
    

    public Orders(int user_id, int status, int total_price) {
        this.user_id = user_id;
        this.status = status;
        this.total_price = total_price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getTotal_price() {
        return total_price;
    }

    public void setTotal_price(int total_price) {
        this.total_price = total_price;
    }

    public Date getDate_order() {
        return date_order;
    }

    public void setDate_order(Date date_order) {
        this.date_order = date_order;
    }
    
}
