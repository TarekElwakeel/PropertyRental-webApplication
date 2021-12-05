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

import it.unipd.dei.webapp.resource.MyProperty;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ViewMyPropertydatabase {


    private static final String STATEMENT = "select * from propertyrental.appartment as app inner join " +
            "propertyrental.insert_app as rel on app.address = rel.app_address where LANDLORD = ?;";

    private final Connection con;


    private final String l_taxcode;

    /**
     *
     * @param con
     * @param l_taxcode
     */
    public ViewMyPropertydatabase(final Connection con, final String l_taxcode) {
        this.con = con;
        this.l_taxcode = l_taxcode;
    }

    /**
     *
     * @return
     * @throws SQLException
     */
    public List<MyProperty> ViewMyProperty() throws SQLException {

        PreparedStatement pstmt = null;
        ResultSet rs = null;

        // the results of the search
        final List<MyProperty> myProperties = new ArrayList<>();

        try {
            pstmt = con.prepareStatement(STATEMENT);
            pstmt.setString(1, l_taxcode);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                myProperties.add(new MyProperty(rs.getString("address"), rs.getInt("n_room"),
                        rs.getInt("n_bath"),rs.getString("s_kitchen"),
                        rs.getInt("p_code"), rs.getString("energy_class"),
                        rs.getDouble("totSquareMeter"),rs.getString("Status"),
                        rs.getBigDecimal("coordinate"),rs.getString("extra_info")));
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

        return myProperties;
    }
}
