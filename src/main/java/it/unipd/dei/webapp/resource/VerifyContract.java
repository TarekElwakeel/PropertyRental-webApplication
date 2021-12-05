package it.unipd.dei.webapp.resource;

public class VerifyContract {
    
    public final int req_nb;
    public final String stud;
    public final String addr;
    public final int badge;
    public final String start_req;
    public final String status;
    public final int dur;
    public final String start_contr;

    // req_nb stud addr badge start_req status dur start_contr
    public VerifyContract( int req_nb, String stud, String addr, int badge, String start_req, String status, int dur, String start_contr) {
        this.req_nb = req_nb;
        this.stud = stud;
        this.addr = addr;
        this.badge = badge;
        this.start_req = start_req;
        this.status = status;
        this.dur = dur;
        this.start_contr = start_contr;
    }

    public int getReq_nb() {
        return req_nb;
    }

    public String getStud() {
        return stud;
    }

    public String getAddr() {
        return addr;
    }

    public int getBadge() {
        return badge;
    }

    public String getStart_req() {
        return start_req;
    }

    public String getStatus() {
        return status;
    }

    public int getDur() {
        return dur;
    }

    public String getStart_contr() {
        return start_contr;
    }
}


