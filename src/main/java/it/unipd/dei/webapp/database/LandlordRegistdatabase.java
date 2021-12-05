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

import it.unipd.dei.webapp.resource.LandlordRegist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public final class LandlordRegistdatabase {


    private static final String STATEMENT = "INSERT INTO  PropertyRental.Landlord (l_taxcode, "
            +"l_name, scannedID, password ) VALUES ( ?, ?, ?, ?); ";



    private final Connection con;


    private final LandlordRegist newLandlord;

    /**
     *
     * @param con
     * @param newLandlord
     */
    public LandlordRegistdatabase(final Connection con, final LandlordRegist newLandlord) {
        this.con = con;
        this.newLandlord = newLandlord;
    }

    /**
     *
     * @throws SQLException
     */
    public void newLandlord() throws SQLException {

        PreparedStatement pstmt = null;


        try {
            pstmt = con.prepareStatement(STATEMENT);
            pstmt.setString(1, newLandlord.getl_taxcode());
            pstmt.setString(2, newLandlord.getl_name());
            pstmt.setBinaryStream(3, newLandlord.getscannedID(),newLandlord.getImg_lenght());
            pstmt.setString(4, newLandlord.getpassword());

            pstmt.execute();

        } finally {
            if (pstmt != null) {
                pstmt.close();
            }

            con.close();
        }

    }
}

