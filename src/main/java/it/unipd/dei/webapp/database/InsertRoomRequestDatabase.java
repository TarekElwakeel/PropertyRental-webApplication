package it.unipd.dei.webapp.database;

import it.unipd.dei.webapp.resource.RentRequest;
import it.unipd.dei.webapp.resource.RentRequest1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertRoomRequestDatabase {
    /**
     * The SQL statement to be executed
     */
    private static String STATEMENT = null;
    private static final String Rent_Request = "INSERT INTO PropertyRental.Rent_Request(student, roomaddress, roomBadge, rtime) VALUES( ? , ?, ? , NOW() );";
    private static final String room_fix = "INSERT INTO PropertyRental.Room(app_address ,capacity_persons,other) VALUES( ? , ? , ? );";
    private static final String insert_fix = "INSERT INTO PropertyRental.Insert_App(landlord, app_address) VALUES( ? , ? );";
    private static final String verify_fix ="INSERT INTO PropertyRental.Verify (appartmentID, adminusername) VALUES( ? , ? );";


    /**
     * The connection to the database
     */
    private final Connection con;

    /**
     * The Student to be stored into the database
     */
    private final RentRequest1 rentrequest;

    /**
     * Creates a new object for storing a appartament into the database.
     *
     * @param con
     *            the connection to the database.
     * @param rentrequest
     *            the rentrequest to be stored into the database.
     */
    public InsertRoomRequestDatabase(final Connection con, final RentRequest1 rentrequest) {
        this.con = con;
        this.rentrequest = rentrequest;
    }

    /**
     * Stores a new Student into the database
     *
     * @throws SQLException
     *             if any error occurs while storing the Student.
     */
    public void CreateRoomRequest() throws SQLException {

        PreparedStatement pstmt = null;
        //STATEMENT = "BEGING;"+appartament_fix+room_fix+insert_fix+verify_fix+"COMMIT;";
        //STATEMENT = "BEGING;"+appartament_fix+room_fix+"COMMIT;";
        STATEMENT = Rent_Request;

        //Appartment(address, ownership_proof, rooms, common_bathroom, extra_info
        // Room(app_address ,capacity_persons,Other)
        // Insert_App(landlord, app_address)
        // Verify (appartmentID, adminusername)

        try {
            pstmt = con.prepareStatement(STATEMENT);
            pstmt.setString(1, rentrequest.getStudent());
            pstmt.setString(2, rentrequest.getAddress());
            pstmt.setInt(3, rentrequest.getBadge() );

            pstmt.execute();

        } finally {
            if (pstmt != null) {
                pstmt.close();
            }
            //appartament.getContract().
            con.close();
        }

    }
}
