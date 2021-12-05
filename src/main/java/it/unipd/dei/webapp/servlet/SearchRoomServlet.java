
package it.unipd.dei.webapp.servlet;

import it.unipd.dei.webapp.database.SearchRoomDatabase;
import it.unipd.dei.webapp.resource.Message;
import it.unipd.dei.webapp.resource.Room;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;


    public final class SearchRoomServlet extends AbstractDatabaseServlet {
        /**
         *
         * @param req
         * @param res
         * @throws ServletException
         * @throws IOException
         */


        public void doPost(HttpServletRequest req, HttpServletResponse res)
                throws ServletException, IOException {

            // request parameter
            int capacity_persons;
            int n_bath;

            // model
            List<Room> el = null;
            Message m = null;

            try {

                // retrieves the request parameter
                String max_pers = req.getParameter("capacity_persons");
                String min_bath = req.getParameter("n_bath");
                if(max_pers == "" && min_bath == ""){
                    el = new SearchRoomDatabase(getDataSource().getConnection())
                            .searchRoom();

                } else  if(max_pers != "" && min_bath == ""){
                    capacity_persons = Integer.parseInt(max_pers);
                    n_bath = 0;
                    // creates a new object for accessing the database and searching the employees
                    el = new SearchRoomDatabase(getDataSource().getConnection(), capacity_persons, n_bath)
                            .searchRoom();
                } else  if(max_pers == "" && min_bath != ""){
                    n_bath = Integer.parseInt(min_bath);
                    capacity_persons = 0;
                    // creates a new object for accessing the database and searching the employees
                    el = new SearchRoomDatabase(getDataSource().getConnection(), capacity_persons, n_bath)
                            .searchRoom();
                } else {
                    n_bath = Integer.parseInt(min_bath);
                    capacity_persons = Integer.parseInt(max_pers);
                    // creates a new object for accessing the database and searching the employees
                    el = new SearchRoomDatabase(getDataSource().getConnection(), capacity_persons, n_bath)
                            .searchRoom();
                }

                m = new Message("Rooms successfully searched.");

            } catch (NumberFormatException ex) {
                m = new Message("Cannot search for rooms. Invalid input parameters: distance must be integer.",
                        "E100", ex.getMessage());
            } catch (SQLException ex) {
                m = new Message("Cannot search for rooms: unexpected error while accessing the database.",
                        "E200", ex.getMessage());
            }

            // stores the employee list and the message as a request attribute
            req.setAttribute("roomList", el);
            req.setAttribute("message", m);

            // forwards the control to the search-employee-result JSP
            req.getRequestDispatcher("/jsp/search-room-result.jsp").forward(req, res);
        }
}

