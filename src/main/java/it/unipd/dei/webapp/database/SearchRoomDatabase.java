package it.unipd.dei.webapp.database;


        import it.unipd.dei.webapp.resource.EnergyClass;
        import it.unipd.dei.webapp.resource.Room;

        import java.sql.Connection;
        import java.sql.PreparedStatement;
        import java.sql.ResultSet;
        import java.sql.SQLException;
        import java.util.ArrayList;
        import java.util.List;

/**
 * Searches employees by their salary.
 *
 * @author Nicola Ferro (ferro@dei.unipd.it)
 * @version 1.00
 * @since 1.00
 */
public final class SearchRoomDatabase extends AbstractDAO{

    /**
     * The SQL statement to be executed
     */
    private static final String STATEMENT = "SELECT address, space_badge, p_code, energy_class, totsquaremeter, n_room, n_bath, s_kitchen, other, extra_info, capacity_persons"+
            " FROM room AS R JOIN appartment AS A ON r.app_address = A.address ";
    /**
     * The connection to the database
     */
    private final Connection con;

    /**
     * The salary of the employee
     */
    private final int capacity_persons ;
    private final int n_bath ;

    /**
     * Creates a new object for searching employees by salary.
     *
     * @param con
     *            the connection to the database.
     */
    public SearchRoomDatabase(final Connection con) {
        this.con = con;
        this.capacity_persons = 0;
        this.n_bath = 0;
    }
    /**
     * Creates a new object for searching employees by salary.
     *
     * @param con
     *            the connection to the database.
     * @param capacity_person
     *            the capacity_persons of the Apartment.
     * @param n_bath
     *            the n_bath of the Apartment
     */
    public SearchRoomDatabase(final Connection con, final int capacity_person, int n_bath) {
        this.con = con;
        this.capacity_persons = capacity_person;
        this.n_bath = n_bath;
    }


    /**
     * Searches employees by their salary.
     *
     * @return a list of {@code Employee} object matching the salary.
     *
     * @throws SQLException
     *             if any error occurs while searching for employees.
     */
    public List<Room> searchRoom() throws SQLException{
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        // the results of the search
        final List<Room> rooms = new ArrayList<Room>();

        try {
            if( this.n_bath != 0 && this.capacity_persons !=0 ){
                pstmt = this.con.prepareStatement(STATEMENT+" WHERE r.capacity_persons <= ? AND a.n_bath >= ? ;");
                pstmt.setInt(1, capacity_persons);
                pstmt.setInt(2, n_bath);
            } else if( this.n_bath == 0 && this.capacity_persons !=0 ){
                pstmt = this.con.prepareStatement(STATEMENT+" WHERE r.capacity_persons <= ? ;");
                pstmt.setInt(1, capacity_persons);
            } else if( this.n_bath != 0 && this.capacity_persons == 0 ){
                pstmt = this.con.prepareStatement(STATEMENT+" WHERE a.n_bath >= ? ;");
                pstmt.setInt(1, n_bath);
            } else {
                pstmt = this.con.prepareStatement(STATEMENT+" ;");
            }

            rs = pstmt.executeQuery();

            while (rs.next()) {
                rooms.add(new Room(
                        rs.getString("address"),
                        rs.getInt("space_badge"),
                        rs.getString("p_code"),
                        EnergyClass.valueOf(rs.getString("energy_class")),
                        rs.getDouble("totsquaremeter"),
                        rs.getInt("n_room"),
                        rs.getInt("n_bath"),
                        rs.getString("s_kitchen"),
                        rs.getString("other"),
                        rs.getString("extra_info"),
                        rs.getInt("capacity_persons")
                ));
            }
        } finally {
            cleaningOperations(pstmt,null, con);
        }

        return rooms;
    }
}
