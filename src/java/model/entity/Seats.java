/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.entity;

/**
 *
 * @author tuna
 */
public class Seats {

    private int id;
    private int status;
    private int seat_number;
    private int id_car;

    public Seats() {
    }

    public Seats(int id, int status, int seat_number, int id_car) {
        this.id = id;
        this.status = status;
        this.seat_number = seat_number;
        this.id_car = id_car;
    }

    public Seats(int status, int seat_number, int id_car) {
        this.status = status;
        this.seat_number = seat_number;
        this.id_car = id_car;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getSeat_number() {
        return seat_number;
    }

    public void setSeat_number(int seat_number) {
        this.seat_number = seat_number;
    }

    public int getId_car() {
        return id_car;
    }

    public void setId_car(int id_car) {
        this.id_car = id_car;
    }

    
    
    
}