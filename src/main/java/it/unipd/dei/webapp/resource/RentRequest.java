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


public class RentRequest {


    private final int requestnr;


    private final String student;


    private final String roomaddress;


    private final String roomBadge;


    private final String rtime;


    private final String status;


    public RentRequest(final int requestnr,final String student, final String roomaddress,
                       final String roomBadge, final String rtime, final String status) {
        this.requestnr = requestnr;
        this.student = student;
        this.roomaddress = roomaddress;
        this.roomBadge = roomBadge;
        this.rtime = rtime;
        this.status = status;
    }


    public final int getrequestnr() {
        return requestnr;
    }


    public final String getstudent() {
        return student;
    }


    public final String getroomaddress() {
        return roomaddress;
    }


    public final String getroomBadge() { return roomBadge; }


    public final String getrtime() {
        return rtime;
    }


    public String getstatus() { return status; }




}

