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

import it.unipd.dei.webapp.resource.Studnetinfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Studentinfologgingdatabase {


    private static final String STATEMENT = "SELECT  s_name, age, country, foreign_lang, status " +
            " FROM PropertyRental.Student where s_taxcode = ? and password = ? ;";

    private final Connection con;


    private final String s_taxcode;

    private final String password;

    /**
     *
     * @param con
     * @param s_taxcode
     * @param password
     */
    public Studentinfologgingdatabase(final Connection con, final String s_taxcode, final String password) {
        this.con = con;
        this.s_taxcode = s_taxcode;
        this.password = password;
    }

    /**
     *
     * @return
     * @throws SQLException
     */
    public List<Studnetinfo> GetStudnetinfo() throws SQLException {

        PreparedStatement pstmt = null;
        ResultSet rs = null;

        // the results of the search
        final List<Studnetinfo> studnetinfos = new ArrayList<Studnetinfo>();

        try {
            pstmt = con.prepareStatement(STATEMENT);
            pstmt.setString(1, s_taxcode);
            pstmt.setString(2, password);

            rs = pstmt.executeQuery();

            if (rs.next()) {
                studnetinfos.add(new Studnetinfo( this.s_taxcode,
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

        return studnetinfos;
    }
}
