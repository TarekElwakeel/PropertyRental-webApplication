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

import it.unipd.dei.webapp.resource.RentRequest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ViewRentRequestdatabase{


    private static final String STATEMENT = "select * from propertyrental.rent_request as ren inner join PropertyRental.Insert_App as " +
            "rel on ren.roomaddress = rel.app_address where  LANDLORD = ?;";

    private final Connection con;


    private final String l_taxcode;

    /**
     *
     * @param con
     * @param l_taxcode
     */
    public ViewRentRequestdatabase(final Connection con, final String l_taxcode) {
        this.con = con;
        this.l_taxcode = l_taxcode;
    }

    /**
     *
     * @return
     * @throws SQLException
     */
    public List<RentRequest> ViewRentRequest() throws SQLException {

        PreparedStatement pstmt = null;
        ResultSet rs = null;

        // the results of the search
        final List<RentRequest> RentRequests = new ArrayList<>();

        try {
            pstmt = con.prepareStatement(STATEMENT);
            pstmt.setString(1, l_taxcode);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                RentRequests.add(new RentRequest(rs.getInt("Request_nr"),rs
                        .getString("student"), rs.getString("roomaddress"), rs
                        .getString("roomBadge"), rs.getString("Rtime"),rs
                        .getString("status")));
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

        return RentRequests;
    }
}
