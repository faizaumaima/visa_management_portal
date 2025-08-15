package com.example.ms3_group47_evisa.ApplicationIntakeOfficer;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class AppendableObjectOutputStream  extends ObjectOutputStream {
    public AppendableObjectOutputStream(ObjectOutputStream out) throws IOException{
        super(out);
    }
    public void writeStreamHeader() throws IOException{
        //nothing
    }
}
