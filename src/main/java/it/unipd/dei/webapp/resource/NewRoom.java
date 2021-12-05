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

public class NewRoom {


    private final String app_address;


    private final int capacity_persons;


    private final String other;



    public NewRoom (final String app_address, final int capacity_persons, final String other) {
        this.app_address = app_address;
        this.capacity_persons = capacity_persons;
        this.other = other;
    }


    public final String getapp_address() {
        return app_address;
    }


    public final int getcapacity_persons() { return capacity_persons; }


    public final String getother() {
        return other;
    }


}
