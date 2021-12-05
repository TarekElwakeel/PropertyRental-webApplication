package it.unipd.dei.webapp.rest;

import it.unipd.dei.webapp.database.SearchRoomDatabase;
import it.unipd.dei.webapp.resource.Message;
import it.unipd.dei.webapp.resource.ResourceList;
import it.unipd.dei.webapp.resource.Room;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

/**
 * Manages the REST API for the {@link Room} resource.
 *
 **/
public class SearchRoomRestResource extends RestResource {

    /**
     * Creates a new REST resource for managing {@code Employee} resources.
     *
     * @param req the HTTP request.
     * @param res the HTTP response.
     * @param con the connection to the database.
     */
    public SearchRoomRestResource(final HttpServletRequest req, final HttpServletResponse res, Connection con) {
        super(req, res, con);
    }


    /**
     * Reads an employee from the database.
     *
     * @throws IOException
     *             if any error occurs in the client/server communication.
     */
    public void readRooms() throws IOException {

        List<Room> e  = null;
        Message m = null;
        //int capacity_person = 0;
        //int n_bath = 0;

        try{
            // parse the URI path to extract the badge
            String path = req.getRequestURI();
            path = path.substring(path.lastIndexOf("room") + 4);
            //String[] select = path.split("/");
            int n_bath = 0;
            final int capacity_person = Integer.parseInt(path.substring(1));
            /*
            final String n_bath_str = path.substring(2);
            if(n_bath_str != ""){
                n_bath = Integer.parseInt(n_bath_str);
            }
            */
            // creates a new object for accessing the database and reads the employee
            e = new SearchRoomDatabase(con,capacity_person, 0 ).searchRoom();

            if(e != null) {
                res.setStatus(HttpServletResponse.SC_OK);
                new ResourceList<Room>(e).toJSON(res.getOutputStream());
            } else {
                m = new Message(String.format("Employee %d not found.", capacity_person), "E5A3", null);
                res.setStatus(HttpServletResponse.SC_NOT_FOUND);
                m.toJSON(res.getOutputStream());
            }
        } catch (Throwable t) {
            m = new Message("Cannot read Rooms: unexpected error.", "E5A1", t.getMessage());
            res.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            m.toJSON(res.getOutputStream());
        }
    }

}
