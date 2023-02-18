package com.example.appdatdoan.Fragments.bill;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appdatdoan.Adapters.HoaDonAdapter;
import com.example.appdatdoan.Models.HoaDon;
import com.example.appdatdoan.Presenters.HoaDonPreSenter;
import com.example.appdatdoan.R;
import com.example.appdatdoan.Views.CTHDActivity;
import com.example.appdatdoan.Interfaces.HoaDonView;
import com.example.appdatdoan.Interfaces.IClickCTHD;

import java.util.ArrayList;


public class DangGiaoFragment extends Fragment implements HoaDonView {

    private TextView tvNullDanggiao;
    private View view;
    private RecyclerView rcvBill;
    private HoaDonPreSenter hoaDonPreSenter;
    private HoaDonAdapter hoaDonAdapter;
    private ArrayList<HoaDon> listHoadon;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_dang_giao, container, false);

        tvNullDanggiao = view.findViewById(R.id.tv_null_danggiao);
        rcvBill = view.findViewById(R.id.rcv_bill_danggiao);
        hoaDonPreSenter = new HoaDonPreSenter(this);
        listHoadon = new ArrayList<>();
        hoaDonPreSenter.HandleReadDataHDStatus(2);
        return view;
    }

    @Override
    public void getDataHD(String id, String uid, String ghichu, String diachi, String hoten, String ngaydat, String phuongthuc, String sdt, String tongtien, Long type) {
        listHoadon.add(new HoaDon(id,uid,ghichu,diachi,hoten,ngaydat,phuongthuc,sdt,tongtien,type));
        if (listHoadon.size() != 0){
            tvNullDanggiao.setVisibility(View.GONE);
        } else tvNullDanggiao.setVisibility(View.VISIBLE);
        hoaDonAdapter = new HoaDonAdapter();
        hoaDonAdapter.setDataHoadon(listHoadon, new IClickCTHD() {
            @Override
            public void onClickCTHD(int pos) {
                HoaDon hoaDon = listHoadon.get(pos);
                Intent intent = new Intent(getContext(), CTHDActivity.class);
                intent.putExtra("HD",hoaDon);
                intent.putExtra("CM", false);
                startActivity(intent);
            }
        });
        rcvBill.setLayoutManager(new LinearLayoutManager(getContext()));
        rcvBill.setAdapter(hoaDonAdapter);
    }

    @Override
    public void OnFail() {

    }

    @Override
    public void OnSucess() {

    }
}