package com.jxd_DVD;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

/**
 * @ClassName TestDvdAdmin
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/7/24
 * @Version 1.0
 */

public class TestDvdAdmin {
    public static void main(String[] args) {
     DvdAdministration dvdAdministration = new DvdAdministration();
     for (int i = 0; i < dvdAdministration.dvds.length; i++) {
         dvdAdministration.dvds[i] = new Dvd();
        }
        dvdAdministration.start(dvdAdministration);
    }

}
