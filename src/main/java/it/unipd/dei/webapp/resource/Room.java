package it.unipd.dei.webapp.resource;

import com.fasterxml.jackson.core.*;

import java.io.*;

public class Room  extends Resource {
    private final String address;
    private final int space_badge;
    private final String p_code;
    private final Enum<EnergyClass> energy_class;
    private final double totsquaremeter;
    private final int n_room;
    private final int n_bath;
    private final String s_kitchen;
    private final String other;
    private final String extra_info;
    private int capacity_persons;

    public Room(String address, int space_badge, String p_code, Enum<EnergyClass> energy_class, double totsquaremeter, int n_room, int n_bath, String s_kitchen, String other, String extra_info)
    {
        this.address = address;
        this.space_badge = space_badge;
        this.p_code = p_code;
        this.energy_class = energy_class;
        this.totsquaremeter = totsquaremeter;
        this.n_room = n_room;
        this.n_bath = n_bath;
        this.s_kitchen = s_kitchen;
        this.other = other;
        this.extra_info = extra_info;
        this.capacity_persons = 0;
    }

    public Room(String address, int space_badge, String p_code, EnergyClass energy_class, double totsquaremeter, int n_room, int n_bath, String s_kitchen, String other, String extra_info, int capacity_persons) {
        this.address = address;
        this.space_badge = space_badge;
        this.p_code = p_code;
        this.energy_class = energy_class;
        this.totsquaremeter = totsquaremeter;
        this.n_room = n_room;
        this.n_bath = n_bath;
        this.s_kitchen = s_kitchen;
        this.other = other;
        this.extra_info = extra_info;
        this.capacity_persons = capacity_persons;
    }

    public String getAddress() {
        return address;
    }

    public String getP_code() {
        return p_code;
    }

    public Enum<EnergyClass> getEnergy_class() {
        return energy_class;
    }

    public double getTotsquaremeter() {
        return totsquaremeter;
    }

    public int getN_bath() {
        return n_bath;
    }

    public int getN_room() {
        return n_room;
    }

    public String getS_kitchen() {
        return s_kitchen;
    }

    public String getExtra_info() {
        return extra_info;
    }

    public String getOther() {
        return other;
    }

    public int getCapacity_persons() {
        return capacity_persons;
    }

    public int getSpace_badge() {
        return space_badge;
    }

    @Override
    public final void toJSON(final OutputStream out) throws IOException {

        final JsonGenerator jg = JSON_FACTORY.createGenerator(out);

        jg.writeStartObject();

        jg.writeFieldName("room");

        jg.writeStartObject();

        jg.writeStringField("address", this.address);

        jg.writeNumberField("space_badge", this.space_badge);

        jg.writeStringField("p_code", this.p_code);

        jg.writeStringField("energy_class", this.energy_class.toString());

        jg.writeNumberField("totsquaremeter", this.totsquaremeter);

        jg.writeNumberField("n_room", this.n_room);

        jg.writeNumberField("n_bath", this.n_bath);
        jg.writeStringField("s_kitchen", this.s_kitchen);
        jg.writeStringField("other", this.other);
        jg.writeStringField("extra_info", this.extra_info);

        jg.writeNumberField("capacity_persons", this.capacity_persons);

        jg.writeEndObject();

        jg.writeEndObject();

        jg.flush();
    }

    /**
     * Creates a {@code Employee} from its JSON representation.
     *
     * @param in the input stream containing the JSON document.
     *
     * @return the {@code Employee} created from the JSON representation.
     *
     * @throws IOException if something goes wrong while parsing.
     */
    public static Room fromJSON(final InputStream in) throws IOException {

        // the fields read from JSON
        EnergyClass jenergy_class = null;
        String jaddress = null;
        int jspace_badge = -1;
        String jp_code = null;
        double jtotsquaremeter = -1;
        int jn_room = -1;
        int jn_bath = -1;
        int jcapacity_persons = -1;
        String js_kitchen = null;
        String jother = null;
        String jextra_info = null;
        
        final JsonParser jp = JSON_FACTORY.createParser(in);

        // while we are not on the start of an element or the element is not
        // a token element, advance to the next element (if any)
        while (jp.getCurrentToken() != JsonToken.FIELD_NAME || "room".equals(jp.getCurrentName()) == false) {

            // there are no more events
            if (jp.nextToken() == null) {
                throw new IOException("Unable to parse JSON: no employee object found.");
            }
        }

        while (jp.nextToken() != JsonToken.END_OBJECT) {

            if (jp.getCurrentToken() == JsonToken.FIELD_NAME) {

                switch (jp.getCurrentName()) {
                    case "space_badge":
                        jp.nextToken();
                        jspace_badge = jp.getIntValue();
                        break;
                    case "totsquaremeter":
                        jp.nextToken();
                        jtotsquaremeter = jp.getIntValue();
                        break;
                    case "n_room":
                        jp.nextToken();
                        jn_room = jp.getIntValue();
                        break;
                    case "n_bath":
                        jp.nextToken();
                        jn_bath = jp.getIntValue();
                        break;
                    case "capacity_persons":
                        jp.nextToken();
                        jcapacity_persons = jp.getIntValue();
                        break;
                    case "energy_class":
                        jp.nextToken();
                        jenergy_class = EnergyClass.valueOf(jp.getText());
                        break;
                    case "address":
                        jp.nextToken();
                        jaddress = jp.getText();
                        break;
                    case "p_code":
                        jp.nextToken();
                        jp_code = jp.getText();
                        break;
                    case "s_kitchen":
                        jp.nextToken();
                        js_kitchen = jp.getText();
                        break;
                    case "other":
                        jp.nextToken();
                        jother = jp.getText();
                        break;
                    case "extra_info":
                        jp.nextToken();
                        jextra_info = jp.getText();
                        break;
                }
            }
        }
        return new Room(jaddress, jspace_badge, jp_code, jenergy_class, jtotsquaremeter, jn_room, jn_bath, js_kitchen, jother, jextra_info, jcapacity_persons);
    }
}
