package generics;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class GenericAppendStream extends ObjectOutputStream
{
    protected GenericAppendStream() throws IOException, SecurityException
    {
        super();
    }

    public GenericAppendStream(OutputStream out) throws IOException
    {
        super(out);
    }

    @Override
    protected void writeStreamHeader() throws IOException
    {
//        super.writeStreamHeader();
    }
}
