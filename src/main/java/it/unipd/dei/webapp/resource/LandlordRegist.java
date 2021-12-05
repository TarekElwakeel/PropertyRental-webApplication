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

import java.io.InputStream;

public class LandlordRegist {


    private final String l_taxcode ;
    private final String l_name ;
    private final InputStream scannedID ;
    private final long Img_lenght;
    private final String password ;



    public LandlordRegist (final String l_taxcode, final String l_name, final InputStream scannedID,
                           final long Img_lenght, final String password) {
        this.l_taxcode = l_taxcode;
        this.l_name = l_name;
        this.scannedID = scannedID;
        this.Img_lenght = Img_lenght;
        this.password = password;
    }


    public final String getl_taxcode() { return l_taxcode; }

    public final String getl_name() { return l_name; }

    public final InputStream  getscannedID() { return scannedID; }

    public final long  getImg_lenght() { return Img_lenght; }

    public final String getpassword() { return password; }


}
