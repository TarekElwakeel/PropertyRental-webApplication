package it.unipd.dei.webapp.resource;

import java.io.InputStream;

public class Appartament {

    private final String address ;
    private final String landlord;
    private final String room ;
    private final int common_bathroom ;
    private final String extra_info ;
    private final String other ;
    private final int capacity_person ;
    private final int adminUserName ;
    private InputStream contract ;
    private  long img_lenght;

    public Appartament( String address, String landlord, String room, int common_bathroom,
                        String extra_info, InputStream image, long img_lenght, String other, int capacity_person,int adminUserName){
        this.address = address;
        this.landlord = landlord;
        this.room = room;
        this.common_bathroom=common_bathroom;
        this.extra_info = extra_info;
        this.other = other;
        this.capacity_person = capacity_person;
        this.adminUserName = adminUserName;
        this.contract = image;
        this.img_lenght = img_lenght;
    }
    public Appartament( String address, String room, int common_bathroom,String extra_info){
        this.address = address;
        this.room = room;
        this.common_bathroom=common_bathroom;
        this.extra_info = extra_info;
        this.landlord=null;
        this.other = null ;
        this.capacity_person = -1 ;
        this.adminUserName = -1 ;
    }
    public Appartament(String address, String room, int common_bathroom, String extra_info, InputStream image, long img_lenght){
        this.address = address;
        this.room = room;
        this.common_bathroom=common_bathroom;
        this.extra_info = extra_info;
        this.img_lenght = img_lenght;
        this.landlord=null;
        this.other = null ;
        this.capacity_person = -1 ;
        this.adminUserName = -1 ;
        this.contract = image;
    }

    public int getAdminUserName() {
        return adminUserName;
    }

    public int getCapacity_person() {
        return capacity_person;
    }

    public int getCommon_bathroom() {
        return common_bathroom;
    }

    public int getRoom() {
        return Integer.parseInt(room);
    }

    public String getAddress() {
        return address;
    }

    public String getExtra_info() {
        return extra_info;
    }

    public String getLandlord() {
        return landlord;
    }

    public String getOther() {
        return other;
    }

    public InputStream getContract() {
        return contract;
    }
    public long getImg_lenght() {
        return img_lenght;
    }
}
