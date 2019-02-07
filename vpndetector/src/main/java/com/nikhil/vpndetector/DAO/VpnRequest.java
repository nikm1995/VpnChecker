package com.nikhil.vpndetector.DAO;

import com.nikhil.vpndetector.DA.ThreadVpn;

public class VpnRequest {

    public VpnRequest() {
    }

    public ThreadVpn GetThreadProxy(){
        ThreadVpn tv=new ThreadVpn();
        tv.start();

        synchronized (tv){
            try {
                System.out.println("waiting  for the user");
                tv.wait();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        return tv;

    }
}
