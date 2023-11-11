/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.entity;

/**
 *
 * @author tuna
 */
public class Tickets {
//CREATE TABLE [dbo].[tickets] (
//    [id]              INT            IDENTITY (1, 1) NOT NULL,
//    [route_id]        INT            NULL,
//    [seat_id]         INT            NULL,
//    [order_id]        INT            NULL,
//    [status]      INT             NOT NULL,
//    [passenger_name]  NVARCHAR (255) NOT NULL,
//    [passenger_phone] NVARCHAR (255) NOT NULL,
//    PRIMARY KEY CLUSTERED ([id] ASC),
//    FOREIGN KEY ([order_id]) REFERENCES [dbo].[orders] ([id]),
//    FOREIGN KEY ([route_id]) REFERENCES [dbo].[carroutes] ([id]),
//    FOREIGN KEY ([seat_id]) REFERENCES [dbo].[seats] ([id])
//);
    private int id;
    private int route_id;
    private int seat_id;
    private int order_id;
    private int status;
    private String passenger_name;
    private String passenger_phone;

    public Tickets() {
    }

    public Tickets(int id, int route_id, int seat_id, int order_id, int status, String passenger_name, String passenger_phone) {
        this.id = id;
        this.route_id = route_id;
        this.seat_id = seat_id;
        this.order_id = order_id;
        this.status = status;
        this.passenger_name = passenger_name;
        this.passenger_phone = passenger_phone;
    }

    public Tickets(int route_id, int seat_id, int order_id, int status, String passenger_name, String passenger_phone) {
        this.route_id = route_id;
        this.seat_id = seat_id;
        this.order_id = order_id;
        this.status = status;
        this.passenger_name = passenger_name;
        this.passenger_phone = passenger_phone;
    }

    public Tickets(int route_id, int seat_id, int order_id, int status) {
        this.route_id = route_id;
        this.seat_id = seat_id;
        this.order_id = order_id;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoute_id() {
        return route_id;
    }

    public void setRoute_id(int route_id) {
        this.route_id = route_id;
    }

    public int getSeat_id() {
        return seat_id;
    }

    public void setSeat_id(int seat_id) {
        this.seat_id = seat_id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getPassenger_name() {
        return passenger_name;
    }

    public void setPassenger_name(String passenger_name) {
        this.passenger_name = passenger_name;
    }

    public String getPassenger_phone() {
        return passenger_phone;
    }

    public void setPassenger_phone(String passenger_phone) {
        this.passenger_phone = passenger_phone;
    }

    @Override
    public String toString() {
        return "Tickets{" + "id=" + id + ", route_id=" + route_id + ", seat_id=" + seat_id + ", order_id=" + order_id + ", status=" + status + ", passenger_name=" + passenger_name + ", passenger_phone=" + passenger_phone + '}';
    }

    
}
