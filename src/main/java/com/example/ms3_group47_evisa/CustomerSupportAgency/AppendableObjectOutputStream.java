package com.example.ms3_group47_evisa.CustomerSupportAgency;

import java.io.IOException;
import java.io.ObjectOutputStream;

public class AppendableObjectOutputStream  extends ObjectOutputStream {
        public AppendableObjectOutputStream(ObjectOutputStream out) throws IOException {
            super(out);
        }
        public void writeStreamHeader() throws IOException {
            //nothing
        }
}
