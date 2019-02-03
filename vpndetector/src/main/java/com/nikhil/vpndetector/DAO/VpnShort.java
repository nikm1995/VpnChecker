package com.nikhil.vpndetector.DAO;

import com.nikhil.vpndetector.DA.Response;
import com.nikhil.vpndetector.DA.VpnCheck;

import java.io.IOException;

public class VpnShort {

    private String ipToLookup;
    private VpnCheck vpnCheck;
    private Response response;

    public VpnShort() throws IOException {
    }

    public VpnShort(String ipToLookup) throws IOException {
        this.ipToLookup = ipToLookup;
        this.vpnCheck=new VpnCheck();
        this.response=new Response();
    }

    public VpnShort(String ipToLookup, VpnCheck vpnCheck) throws IOException {
        this.ipToLookup = ipToLookup;
        this.vpnCheck = vpnCheck;
    }

    public VpnShort(String ipToLookup, VpnCheck vpnCheck, Response response) throws IOException {
        this.ipToLookup = ipToLookup;
        this.vpnCheck = vpnCheck;
        this.response = response;
    }

    public String getIpToLookup() {
        return ipToLookup;
    }

    public void setIpToLookup(String ipToLookup) {
        this.ipToLookup = ipToLookup;
    }

    public VpnCheck getVpnCheck() {
        return vpnCheck;
    }

    public void setVpnCheck(VpnCheck vpnCheck) {
        this.vpnCheck = vpnCheck;
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

    public boolean VpnorHosting() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    response = vpnCheck.getResponse(ipToLookup);
                    if (response.Status.equals("success")) {
                        System.out.println("Package: " + response.getPackage);
                        if (response.getPackage.equals("Free")) {
                            System.out.println("Remaining Requests: " + response.Remaining_Requests);
                        }
                        System.out.println("IP ADDRESS: " + response.IpAddress);
                        System.out.println("Is this IP a VPN or HOSTING NETWORK ? " + response.hostip);
                        System.out.println("Organisation: " + response.org);
                        if (response.Country != null) {
                            System.out.println("Country: " + response.Country.Name);
                        }
                    } else {
                        System.out.println("Error: " + response.Msg);
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        return response.hostip;

    }


}