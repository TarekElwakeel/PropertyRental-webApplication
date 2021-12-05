package it.unipd.dei.webapp.database;

import it.unipd.dei.webapp.resource.Languages;
import it.unipd.dei.webapp.resource.Student;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ViewStudentDatabase {


    private static final String STATEMENT_element = "select s_taxcode, s_name, age, country, foreign_lang, status, scannedID from  PropertyRental.Student where s_taxcode = ?;";
    private static final String STATEMENT_image = "select scannedID from  PropertyRental.Student where s_taxcode ilike ?;";

    private final Connection con;


    private final String s_taxcode;

    /**
     *
     * @param con
     * @param s_taxcode
     */
    public ViewStudentDatabase(final Connection con, final String s_taxcode) {
        this.con = con;
        this.s_taxcode = s_taxcode;
    }

    /**
     *
     * @return
     * @throws SQLException
     */
    public List<Student> ViewStudentServlet() throws SQLException {

        PreparedStatement pstmt = null;

        ResultSet rs = null;

        // the results of the search
        final List<Student> students = new ArrayList<Student>();


        try {
            //Savepoint save1 = con.setSavepoint();
            pstmt = con.prepareStatement(STATEMENT_element);
            pstmt.setString(1, s_taxcode);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                byte[] img = rs.getBytes(7);

                InputStream img_stream = new ByteArrayInputStream( img );

                students.add(
                        new Student(
                                rs.getString(1),
                                rs.getString(2),
                                rs.getInt(3),
                                rs.getString(4),
                                Languages.valueOf( rs.getString(5)),
                                rs.getString(6),
                                img_stream,
                                (long)img.length
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

        return students;
    }
}
