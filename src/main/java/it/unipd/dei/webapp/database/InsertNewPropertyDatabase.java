package it.unipd.dei.webapp.database;

import it.unipd.dei.webapp.resource.Appartament;
import it.unipd.dei.webapp.resource.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertNewPropertyDatabase {
    /**
     * The SQL statement to be executed
     */
    private static String STATEMENT = null;
    //private static final String STATEMENT = "INSERT INTO  PropertyRental.Student(s_taxcode, s_name, age, country, foreign_lang, scannedID) VALUES (?, ?, ?, ?,?, ?)";
    //private static final String STATEMENT = "INSERT INTO  PropertyRental.Student(s_taxcode, s_name, age, country, foreign_lang ) VALUES (?, ?, ?, ?,?)";
    private static final String appartament_fix = "INSERT INTO PropertyRental.Appartment(address, ownership_proof, n_room, n_bath, extra_info )  VALUES( ? , ?, ? , ? , ? );";
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
    private final Appartament appartament;

    /**
     * Creates a new object for storing a appartament into the database.
     *
     * @param con
     *            the connection to the database.
     * @param appartament
     *            the appartament to be stored into the database.
     */
    public InsertNewPropertyDatabase(final Connection con, final Appartament appartament) {
        this.con = con;
        this.appartament = appartament;
    }

    /**
     * Stores a new Student into the database
     *
     * @throws SQLException
     *             if any error occurs while storing the Student.
     */
    public void CreateStudent() throws SQLException {

        PreparedStatement pstmt = null;
        //STATEMENT = "BEGING;"+appartament_fix+room_fix+insert_fix+verify_fix+"COMMIT;";
        //STATEMENT = "BEGING;"+appartament_fix+room_fix+"COMMIT;";
        STATEMENT = appartament_fix;

        //Appartment(address, ownership_proof, rooms, common_bathroom, extra_info
        // Room(app_address ,capacity_persons,Other)
        // Insert_App(landlord, app_address)
        // Verify (appartmentID, adminusername)

        try {
            pstmt = con.prepareStatement(STATEMENT);
            pstmt.setString(1, appartament.getAddress());
            pstmt.setBinaryStream(2, appartament.getContract(),appartament.getImg_lenght());
            //pstmt.setString(2, "REV");
            pstmt.setInt(3, appartament.getRoom());
            pstmt.setInt(4, appartament.getCommon_bathroom());
            pstmt.setString(5, appartament.getExtra_info());
            //pstmt.setString(5, appartament.getAddress());
            //pstmt.setInt(6, appartament.getCapacity_person());
            //pstmt.setString(7, appartament.getOther());
            //pstmt.setString(8, appartament.getLandlord());
            //pstmt.setString(9, appartament.getAddress());
            //pstmt.setString(10, appartament.getAddress());
            //pstmt.setString(11, appartament.get);// get adminuser
            // pstmt.setInt(6, student.getscannedID());


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
