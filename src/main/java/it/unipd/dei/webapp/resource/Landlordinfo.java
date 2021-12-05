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
package it.unipd.dei.webapp.resource;

import com.fasterxml.jackson.core.JsonGenerator;

import java.io.IOException;
import java.io.OutputStream;

public class Landlordinfo extends  Resource{


    private final String la_taxcode ;
    private final String l_name ;
    private final String l_Status ;



    public Landlordinfo (final String la_taxcode, final String l_name, final String l_Status) {
        this.la_taxcode = la_taxcode;
        this.l_name = l_name;
        this.l_Status = l_Status;
    }


    public final String getla_taxcode() { return la_taxcode; }

    public final String getl_name() { return l_name; }

    public final String getl_Status() { return l_Status; }

    public final void toJSON(final OutputStream out) throws IOException {
        final JsonGenerator jg = JSON_FACTORY.createGenerator(out);

        jg.writeStartObject();

        jg.writeFieldName("Landlordinfo");

        jg.writeStartObject();

        jg.writeStringField("la_taxcode", this.la_taxcode);
        jg.writeStringField("l_name", this.l_name);
        jg.writeStringField("l_Status", this.l_Status);

        jg.writeEndObject();

        jg.writeEndObject();

        jg.flush();
    }



}
