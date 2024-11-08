package POM;

import UtilityFunctions.BaseClass;

import java.awt.*;
import java.io.IOException;

public class MainClass {
    public static void main(String []args) throws IOException, InterruptedException, AWTException {
        BaseClass.driverInitializer();
//        RegistrationClass.CreateNewAccount();
        LoginClass.LogInFacebook();
        PostUploadClass.UploadImage();
    }
}
