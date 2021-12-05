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


public class UpdateRentRequestdatabase{


    private static final String STATEMENT = "update PropertyRental.rent_request set status ="+
            "CAST( ? as propertyrental.RequestStatus) where request_nr = ?;";

    private final Connection con;

    private final String status;

    private final int request_nr;


    /**
     *
     * @param con
     * @param status
     * @param request_nr
     */
    public UpdateRentRequestdatabase(final Connection con, final String status, final int request_nr) {
        this.con = con;
        this.status = status;
        this.request_nr = request_nr;
    }

    /**
     *
     * @throws SQLException
     */
    public void UpdateRentRequest() throws SQLException {
        PreparedStatement pstmt = null;
        ResultSet rs = null;


        try {
        pstmt = con.prepareStatement(STATEMENT);
        pstmt.setString(1, status);
        pstmt.setInt(2, request_nr);
        pstmt.execute();

    } finally {
        if (pstmt != null) {
            pstmt.close();
        }

        con.close();
        }

    }
}
