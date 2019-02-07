package com.nikhil.vpndetector.DA;


public class ThreadVpn extends Thread {
    public Boolean Proxy;
    public String IpAddress;
    public String Org;
    public String Country;
    public String Region;
    public String Timezone;
    public String City;
    private VpnDetector vpnDetector;

    @Override
    public void run() {
        synchronized (this){

            vpnDetector=new VpnDetector();
            VpnResponse vr=vpnDetector.getResponse();
            Proxy=vr.Vpn;
            IpAddress=vr.IpAddress;
            Org=vr.Org;
            Country=vr.Country;
            Region=vr.Region;
            Timezone=vr.Timezone;
            City=vr.City;
            notify();
        }


    }
}
