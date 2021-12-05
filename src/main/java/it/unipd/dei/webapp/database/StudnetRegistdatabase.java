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

import it.unipd.dei.webapp.resource.StudnetRegist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public final class StudnetRegistdatabase {


    private static final String STATEMENT = "INSERT INTO  PropertyRental.Student (s_taxcode, "
            +"s_name, age, country, foreign_lang, password, scannedID ) VALUES " +
            "( ?, ?, ?, ?, CAST( ? as propertyrental.KnownLanguages), ?, ? ); ";



    private final Connection con;


    private final StudnetRegist newStudnet;

    /**
     *
     * @param con
     * @param newStudnet
     */
    public StudnetRegistdatabase(final Connection con, final StudnetRegist newStudnet) {
        this.con = con;
        this.newStudnet = newStudnet;
    }

    /**
     *
     * @throws SQLException
     */
    public void NewStudnet() throws SQLException {

        PreparedStatement pstmt = null;


        try {
            pstmt = con.prepareStatement(STATEMENT);
            pstmt.setString(1, newStudnet.gets_taxcode());
            pstmt.setString(2, newStudnet.gets_name());
            pstmt.setInt(3, newStudnet.getage());
            pstmt.setString(4, newStudnet.getcountry());
            pstmt.setString(5, newStudnet.getforeign_lang());
            pstmt.setString(6, newStudnet.getpassword());
            pstmt.setBinaryStream(7, newStudnet.getscannedID(),newStudnet.getImg_lenght());

            pstmt.execute();

        } finally {
            if (pstmt != null) {
                pstmt.close();
            }

            con.close();
        }

    }
}

