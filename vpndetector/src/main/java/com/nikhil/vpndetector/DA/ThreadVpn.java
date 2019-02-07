package com.nikhil.vpndetector.DA;


public class ThreadVpn extends Thread {
    Boolean proxy;
    private VpnDetector vpnDetector;

    @Override
    public void run() {
        synchronized (this){

            vpnDetector=new VpnDetector();
            VpnResponse vr=vpnDetector.getResponse();
            proxy=vr.Vpn;
            notify();
        }


    }
}
