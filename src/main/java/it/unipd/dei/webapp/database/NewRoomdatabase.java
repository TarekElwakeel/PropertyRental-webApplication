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

import it.unipd.dei.webapp.resource.NewRoom;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public final class NewRoomdatabase {


    private static final String STATEMENT = "INSERT INTO  PropertyRental.Room (app_address, "
            +"capacity_persons, other ) VALUES (?, ?, ? ); ";



    private final Connection con;


    private final NewRoom Room;

    /**
     *
     * @param con
     * @param Room
     */
    public NewRoomdatabase(final Connection con, final NewRoom Room) {
        this.con = con;
        this.Room = Room;
    }

    /**
     *
     * @throws SQLException
     */
    public void NewRoom() throws SQLException {

        PreparedStatement pstmt = null;


        try {
            pstmt = con.prepareStatement(STATEMENT);
            pstmt.setString(1, Room.getapp_address());
            pstmt.setInt(2, Room.getcapacity_persons());
            pstmt.setString(3, Room.getother());



            pstmt.execute();

        } finally {
            if (pstmt != null) {
                pstmt.close();
            }

            con.close();
        }

    }
}

