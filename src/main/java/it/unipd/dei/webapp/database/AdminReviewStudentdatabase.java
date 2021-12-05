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

import it.unipd.dei.webapp.resource.AdminReviewStudent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminReviewStudentdatabase {


    private static final String STATEMENT = "SELECT * FROM PropertyRental.Student WHERE status = CAST( ? as propertyrental.Status);";

    private final Connection con;

    private final String status;


    /**
     *
     * @param con
     * @param status
     */
    public AdminReviewStudentdatabase(final Connection con, final String status) {
        this.con = con;
        this.status = status;

    }

    /**
     *
     * @return
     * @throws SQLException
     */
    public List<AdminReviewStudent> ViewStudentad() throws SQLException {

        PreparedStatement pstmt = null;
        ResultSet rs = null;

        // the results of the search
        final List<AdminReviewStudent> studentads = new ArrayList<>();

        try {
            pstmt = con.prepareStatement(STATEMENT);
            pstmt.setString(1, status);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                studentads.add(new AdminReviewStudent(rs.getString("s_taxcode"),
                        rs.getString("s_name"), rs.getInt("age"),
                        rs.getString("country"), rs.getString("foreign_lang"),
                        rs.getString("status")));
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

        return studentads;
    }
}
