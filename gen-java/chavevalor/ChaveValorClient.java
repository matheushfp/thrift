package chavevalor;

import org.apache.thrift.TException;
import org.apache.thrift.transport.TSSLTransportFactory;
import org.apache.thrift.server.TTransport;
import org.apache.thrift.server.TSocket;
import org.apache.thrift.server.TSSSLTransportFactory.TSSLTransportParameters;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;


public class ChaveValorClient{
  public static void main(String [] args) {
    try {
      TTransport transport;
      transport = new TSocket("localhost", 9090);
      transport.open();
      TProtocol protocol = new TBinaryProtocol(transport);
      ChaveValor.Client client = new ChaveValor.Client(protocol);
      
      System.out.println("String: " + client.setKV(8, "lalala"));
      System.out.println("String: " + client.setKV(4, "lelele"));
      System.out.println("String: " + client.setKV(6, "hello"));
      System.out.println("String: " + client.setKV(8, "test"));
      
      transport.close()
    } catch (TException x) {
      x.printStackTrace();
    }
  }
}
