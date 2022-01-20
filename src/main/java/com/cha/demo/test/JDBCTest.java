package com.cha.demo.test;

import java.util.ArrayList;

import com.cha.demo.Addr;
import com.cha.demo.AddrDB;

public class JDBCTest {

	public static void main(String[] args) {
		AddrDB db = new AddrDB();
		ArrayList<Addr> list = db.selectDatas();
		
		for(int i = 0; i < list.size(); i++) {
			Addr addr = list.get(i);
			System.out.println("번호 : " + addr.getIdx());
			System.out.println("이름 : " + addr.getName());
			System.out.println("주소 : " + addr.getAddress());
			System.out.println("번호 : " + addr.getPhone());
			System.out.println("========================");
		}
	}

}
