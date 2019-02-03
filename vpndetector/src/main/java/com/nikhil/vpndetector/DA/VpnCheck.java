package com.nikhil.vpndetector.DA;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public final class VpnCheck {
    private String Vpn_Key;
    private int Vpn_TimeOut=5500;
    private String Vpn_Add="http://api.vpnblocker.net/v2/json/";

    public VpnCheck() {
        this.Vpn_Key =null;
    }
    public VpnCheck(String Vpn_Key){
        this.Vpn_Key=Vpn_Key;
    }
    public VpnCheck(String Vpn_Key,int Vpn_TimeOut){
        this.Vpn_Key=Vpn_Key;
        this.Vpn_TimeOut=Vpn_TimeOut;
    }

    /***
     * Obtain key from https://vpnblocker.net
     *(optional) is used
     * @param vpn_Key
     */
    public void setVpn_Key(String vpn_Key) {
        Vpn_Key = vpn_Key;
    }

    /**
     * Units are in Milliseconds Allows to wait for request the period of Tmeseconds
     *
     * @param vpn_TimeOut
     */
    public void setVpn_TimeOut(int vpn_TimeOut) {
        Vpn_TimeOut = vpn_TimeOut;
    }
    /**
     * allow you to use SSl on the Query
     */
    public void useSSL(){
        this.Vpn_Add=this.Vpn_Add.replace("http://","https://");

    }

    /**
     *
     * @param ip
     * @return
     * @throws IOException
     */

    public Response getResponse(String ip) throws IOException{
        String query_add=this.get_Query_add(ip);
        String query_result=this.query(query_add,this.Vpn_TimeOut,"Java library");
        return new Gson().fromJson(query_result,Response.class);
    }

    /**
     *
     *
     * @param Ip
     * @return
     */

    public String get_Query_add(String Ip){
        String query_add;
        if(this.Vpn_Key==null){
            query_add=this.Vpn_Add+Ip;
        }else{
            query_add=this.Vpn_Add+Ip+"/"+this.Vpn_Key;
        }
        return query_add;
    }

    /**
     *
     * @param add
     * @param vpn_TimeOut
     * @param UserAgent
     * @return
     * @throws IOException
     */

    public String query(String add,int vpn_TimeOut,String UserAgent) throws IOException {
        StringBuilder response=new StringBuilder();
        URL website=new URL(add);
        URLConnection connection=website.openConnection();
        connection.setConnectTimeout(vpn_TimeOut);
        connection.setRequestProperty("User-Agent",UserAgent);
        BufferedReader in=null;
        InputStreamReader ir=null;
        try{
            ir=new InputStreamReader(connection.getInputStream());
            in=new BufferedReader(ir);
            while((add=in.readLine())!=null){
                response.append(add);
            }
            in.close();
        }catch (IOException e){
            e.printStackTrace();
        }
        return response.toString();


    }


}
