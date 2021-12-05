package it.unipd.dei.webapp.database;

import it.unipd.dei.webapp.resource.VerifyContract;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ViewContractDatabase {


    private static final String STATEMENT ="SELECT r.request_nr AS req_nb, r.student AS stud, r.roomaddress AS addr, r.roombadge AS badge, r.rtime AS start_req, r.status AS status, c.duration_months AS dur, c.ctime AS start_contr \n" +
                    "FROM rent_request AS r left outer JOIN contract AS c \n" +
                    "ON r.Request_nr = c.Contract_nr ";
    private static final String STATEMENT_image = "select scannedID from  PropertyRental.Student where s_taxcode ilike ?;";

    private final Connection con;


    private final String s_taxcode;

    /**
     *
     * @param con
     * @param s_taxcode
     */
    public ViewContractDatabase(final Connection con, String s_taxcode) {
        this.con = con;
        this.s_taxcode = s_taxcode;
    }

    /**
     *
     * @return
     * @throws SQLException
     */
    public List<VerifyContract> viewContract() throws SQLException {

        PreparedStatement pstmt = null;

        ResultSet rs = null;

        // the results of the search
        final List<VerifyContract> requests = new ArrayList<VerifyContract>();


        try {
            //Savepoint save1 = con.setSavepoint();

            if(this.s_taxcode == ""){
                pstmt = con.prepareStatement(STATEMENT+" ;");

            } else {
                pstmt = con.prepareStatement(STATEMENT+" WHERE student = ? ;");
                pstmt.setString(1, s_taxcode);
            }
            rs = pstmt.executeQuery();

            while (rs.next()) {

                requests.add(
                        new VerifyContract(
                                rs.getInt("req_nb"),
                                rs.getString("stud"),
                                rs.getString("addr"),
                                rs.getInt("badge"),
                                rs.getString("start_req"),
                                rs.getString("status"),
                                rs.getInt("dur"),
                                rs.getString("start_contr")
                        ));
            }
        } finally {
            if (rs != null) {
                rs.close();
            }


            if (pstmt != null) {
                pstmt.close();
            }

            con.close();
        }

        return requests;
    }
}
