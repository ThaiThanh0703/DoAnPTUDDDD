package com.example.appdatdoan.Interfaces;

public interface IProduct {
    void OnSucess();

    void OnFail();

    void getDataProduct(String id, String ten, Long gia, String hinhanh, String loaisp, String mota, Long soluong, String hansudung, Long type, String trongluong);
}
