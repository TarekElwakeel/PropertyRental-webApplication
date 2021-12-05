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

public class AdminReviewStudent {


    private final String s_taxcode ;
    private final String s_name ;
    private final int age ;
    private final String country ;
    private final String foreign_lang ;
    private final String status ;



    public AdminReviewStudent (final String s_taxcode, final String s_name, final int age,
                               final String country, final String foreign_lang, final String status) {
        this.s_taxcode = s_taxcode;
        this.s_name = s_name;
        this.age = age;
        this.country = country;
        this.foreign_lang = foreign_lang;
        this.status = status;
    }


    public final String gets_taxcode() { return s_taxcode; }

    public final String gets_name() { return s_name; }

    public final int getage() { return age; }

    public final String getcountry() { return country; }

    public final String getforeign_lang() { return foreign_lang; }

    public final String getstatus() { return status; }


}
