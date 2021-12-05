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

import it.unipd.dei.webapp.resource.NewApartment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public final class NewApartmentdatabase {


    private static final String STATEMENT = "INSERT INTO  PropertyRental.Appartment (address, "
        +"ownership_proof, n_room, n_bath, s_kitchen, p_code, energy_class, totSquareMeter," +
            " extra_info ) VALUES ( ?, ?, ?, ?, ?, ?, CAST( ? as propertyrental.energyClass)," +
            " ?, ? ); ";



    private final Connection con;


    private final NewApartment apartment;

    /**
     *
     * @param con
     * @param apartment
     */
    public NewApartmentdatabase(final Connection con, final NewApartment apartment) {
        this.con = con;
        this.apartment = apartment;
    }

    /**
     *
     * @throws SQLException
     */
    public void NewApartment() throws SQLException {

        PreparedStatement pstmt = null;


        try {
            pstmt = con.prepareStatement(STATEMENT);
            pstmt.setString(1, apartment.getaddress());
            pstmt.setBinaryStream(2, apartment.getownership_proof(),apartment.getImg_lenght());
            pstmt.setInt(3, apartment.getn_room());
            pstmt.setInt(4, apartment.getn_bath());
            pstmt.setString(5, apartment.gets_kitchen());
            pstmt.setInt(6, apartment.getp_code());
            pstmt.setString(7, apartment.getenergy_class());
            pstmt.setDouble(8, apartment.gettotSquareMeter());
            pstmt.setString(9, apartment.getextra_info());

            pstmt.execute();

        } finally {
            if (pstmt != null) {
                pstmt.close();
            }

            con.close();
        }

    }
}

