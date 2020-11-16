namespace java chavevalor
namespace py chavevalor


exception KeyNotFound
{
}


service ChaveValor
{
    string getKV(1:i32 key) throws (1:KeyNotFound knf),
    string setKV(1:i32 key, 2:string value),
    void delKV(1:i32 key)
}  

package chavevalor;

import org.apache.thrift.TException;
import java.util.HashMap;
import chavevalor.*;

public class ChaveValorHandler implements ChaveValor.Iface {
   private HashMap<Integer,String> kv = new HashMap<>();
   @Override
   public String getKV(int key) throws TException {
       if(kv.containsKey(key))
          return kv.get(key);
       else
          throw new KeyNotFound();
   }
   @Override
   public String setKV(int key, String valor) throws TException {
       if(kv.containsKey(key)){
          old_value = getKV(key);
          //KV já possui valor nesta chave
          return old_value;
       }
       //Atualiza o HashMap
       kv.put(key,valor);
       //Retorna o novo valor
       return valor;
   }
   @Override
   public void delKV(int key) throws TException {
       kv.remove(key);
   }    
}

