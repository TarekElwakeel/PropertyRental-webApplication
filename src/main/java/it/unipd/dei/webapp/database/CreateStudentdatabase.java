/*
 * Copyright 2018 University of Padua, Italy
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package it.unipd.dei.webapp.database;

import it.unipd.dei.webapp.resource.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Creates a new Student
 *
 * @author Nicola Ferro (ferro@dei.unipd.it)
 * @version 1.00
 * @since 1.00
 */
public final class CreateStudentdatabase {

    /**
     * The SQL statement to be executed
     */
    private static String STATEMENT = null;
    //private static final String STATEMENT = "INSERT INTO  PropertyRental.Student(s_taxcode, s_name, age, country, foreign_lang, scannedID) VALUES (?, ?, ?, ?,?, ?)";
    //private static final String STATEMENT = "INSERT INTO  PropertyRental.Student(s_taxcode, s_name, age, country, foreign_lang ) VALUES (?, ?, ?, ?,?)";
                                            //(s_taxcode ,s_name ,age ,country ,foreign_lang ,Status ,password ,scannedID )
    private static final String insert_fix = "INSERT INTO  PropertyRental.Student(s_taxcode, s_name, age, country, foreign_lang";
    private static final String insert_select = ") VALUES (?, ?, ?, ?,CAST( ? as propertyrental.knownlanguages) ";
    private static final String close = ");";

    /**
     * The connection to the database
     */
    private final Connection con;

    /**
     * The Student to be stored into the database
     */
    private final Student student;

    /**
     * Creates a new object for storing a student into the database.
     *
     * @param con
     *            the connection to the database.
     * @param student
     *            the student to be stored into the database.
     */
    public CreateStudentdatabase(final Connection con, final Student student) {
        this.con = con;
        this.student = student;
    }

    /**
     * Stores a new Student into the database
     *
     * @throws SQLException
     *             if any error occurs while storing the Student.
     */
    public void CreateStudent() throws SQLException {

        PreparedStatement pstmt = null;
        if(student.getScan_lenght()==-1) {
            STATEMENT=insert_fix + insert_select + close;
        } else {
            STATEMENT=insert_fix + ", scannedID " + insert_select + ", ? " + close;
        }

        try {
            pstmt = con.prepareStatement(STATEMENT);
            pstmt.setString(1, student.gets_taxcode());
            pstmt.setString(2, student.gets_name());
            pstmt.setInt(3, student.gets_age());
            pstmt.setString(4, student.gets_country());
            pstmt.setString(5, student.gets_foreign_lang());
            if(student.getScan_lenght()!=-1) {
                pstmt.setBinaryStream(6, student.gets_scannedID(), student.getScan_lenght());
            }// pstmt.setInt(6, student.getscannedID());


            pstmt.execute();

        } finally {
            if (pstmt != null) {
                pstmt.close();
            }

            con.close();
        }

    }
}
