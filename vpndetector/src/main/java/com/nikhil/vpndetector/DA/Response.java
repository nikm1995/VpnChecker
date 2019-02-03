package com.nikhil.vpndetector.DA;


import com.google.gson.annotations.SerializedName;

public class Response {
    public String Status;
    public String Msg;
    @SerializedName("package")
    public String getPackage;

    public String Remaining_Requests;
    public String IpAddress;
    @SerializedName("host-ip")
    public boolean hostip;

    public String hostname;
    public String org;
    public CharactersModule Country;
    public CharactersModule subDivision;
    public String City;
    public String Postal;
    public LatLong Location;

    public Response() {
    }
}
