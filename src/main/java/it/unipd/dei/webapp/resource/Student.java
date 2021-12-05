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
 */

package it.unipd.dei.webapp.resource;

import java.io.InputStream;

/**
 * Represents the data about a student.
 *
 * @author Nicola Ferro (ferro@dei.unipd.it)
 * @version 1.00
 * @since 1.00
 */
public class Student {

    /**
     * tax code
     */
    private String s_taxcode;

    /**
     * The surname of the student
     */
    private String s_name;

    /**
     * age
     */
    private  int age;

    /**
     * country
     */
    private  String country;

    /**
     * language
     */
    private Enum<Languages> foreign_lang;

    /**
     * ID
     */
    private InputStream scannedID;

    /**
     *  scan_lenght
     */
    private long scan_lenght;

    /**
     *  status
     */
    private String status;

    /**
     * Creates a new student
     *  @param s_taxcode
     *            tax code
     * @param s_name
     *            surname
     * @param age
     *            age
     * @param country
     *            country
     * @param foreign_lang
     *            language
     * @param scannedID
     *             ID
     */
    public Student( String s_taxcode,  String s_name,  int age,  String country,  Enum<Languages> foreign_lang,  InputStream scannedID,  long scan_lenght ) {
        this.s_taxcode = s_taxcode;
        this.s_name = s_name;
        this.age = age;
        this.country = country;
        this.foreign_lang = foreign_lang;
        this.scannedID = scannedID;
        this.scan_lenght = scan_lenght;
        this.status = status;
    }
    public Student(String s_taxcode, String s_name, int age, String country, Enum<Languages> foreign_lang, String status, InputStream img_stream, long length) {
        this.s_taxcode = s_taxcode;
        this.s_name = s_name;
        this.age = age;
        this.country = country;
        this.foreign_lang = foreign_lang;
        this.scannedID = null;
        this.scan_lenght = -1;
        this.status = null;
        this.status = null;
    }

    public Student(String s_taxcode, String s_name, int age, String country,  Enum<Languages> foreign_lang, String status) {
        this.s_taxcode = s_taxcode;
        this.s_name = s_name;
        this.age = age;
        this.country = country;
        this.foreign_lang = foreign_lang;
        this.scannedID = null;
        this.scan_lenght = -1;
        this.status = status;
    }

    /**
     *
     * @return tax code
     */
    public final String gets_taxcode() {
        return s_taxcode;
    }

    /**
     *
     * @return surname
     */
    public final String gets_name() {
        return s_name;
    }

    /**
     *
     * @return the age
     */
    public final int gets_age() { return age; }

    /**
     *
     * @return country
     */
    public final String gets_country() {
        return country;
    }

    /**
     *
     * @return language
     */
    public String gets_foreign_lang() { return foreign_lang.toString(); }

    /**
     *
     * @return ID
     */
    public InputStream gets_scannedID() {
        return scannedID;
    }

    /**
     *
     * @return void
     */
    public long getScan_lenght() {
        return scan_lenght;
    }
    /**
     *
     * @return void
     */
    public void setScan_lenght(long scan_lenght) {
        this.scan_lenght=scan_lenght;
    }

    /**
     *
     * @return void
     */
    public void setScannedID(InputStream scannedID) {
        this.scannedID=scannedID;
    }

    /**
     *
     * @return status
     */
    public String getStatus() {
        return status;
    }
}
