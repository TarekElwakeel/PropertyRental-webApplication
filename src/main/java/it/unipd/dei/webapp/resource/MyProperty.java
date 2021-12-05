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


import java.math.BigDecimal;



public class MyProperty {


    private final String proaddress;

    private final int n_room;

    private final int n_bath;

    private final String s_kitchen;

    private final Integer p_code;

    private final String energy_class;

    private final Double totSquareMeter;

    private final String appStatus;

    private final BigDecimal coordinate;

    private final String extra_info;



    public MyProperty (final String proaddress, final int n_room, final int n_bath, final String s_kitchen,
                       final Integer p_code, final String energy_class, final Double totSquareMeter,
                       final String appStatus, final BigDecimal coordinate, final String extra_info ) {
        this.proaddress = proaddress;
        this.n_room = n_room;
        this.n_bath = n_bath;
        this.s_kitchen=s_kitchen;
        this.p_code=p_code;
        this.energy_class=energy_class;
        this.totSquareMeter=totSquareMeter;
        this.appStatus=appStatus;
        this.coordinate=coordinate;
        this.extra_info = extra_info;
    }


    public final String getproaddress() {
        return proaddress;
    }

    public final int getn_room() { return n_room; }

    public final int getn_bath() { return n_bath; }

    public final String gets_kitchen() { return s_kitchen; }

    public final int getp_code() { return p_code; }

    public final String getenergy_class() { return energy_class; }

    public final Double gettotSquareMeter() { return totSquareMeter; }

    public final String getappStatus() { return appStatus; }

    public final BigDecimal getcoordinate() { return coordinate; }

    public final String getextra_info() { return extra_info; }


}
