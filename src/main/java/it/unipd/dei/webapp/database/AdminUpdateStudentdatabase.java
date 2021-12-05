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
 * Author: Tarek Elwakeel under supervision of professor Nicola Ferro (ferro@dei.unipd.it)
 * Version: 1.0
 * Since: 1.0
 */
package it.unipd.dei.webapp.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class AdminUpdateStudentdatabase {


    private static final String STATEMENT = "update PropertyRental.Student set " +
            "status =  CAST( ? as propertyrental.Status) where s_taxcode = ?;";

    private final Connection con;

    private final String status;

    private final String s_taxcode;


    /**
     *
     * @param con
     * @param status
     * @param s_taxcode
     */
    public AdminUpdateStudentdatabase(final Connection con, final String status, final String s_taxcode) {
        this.con = con;
        this.status = status;
        this.s_taxcode = s_taxcode;
    }

    /**
     *
     * @throws SQLException
     */
    public void AdminUpdateStudent() throws SQLException {
        PreparedStatement pstmt = null;
        ResultSet rs = null;


        try {
            pstmt = con.prepareStatement(STATEMENT);
            pstmt.setString(1, status);
            pstmt.setString(2, s_taxcode);
            pstmt.execute();

        } finally {
            if (pstmt != null) {
                pstmt.close();
            }

            con.close();
        }

    }
}
