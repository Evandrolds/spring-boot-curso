
package com.curso.springboot.entities.enums;

/**
 *
 * @author Evandro
 */
public enum OrderStatus {
   WEINTING_PAIMENT(1),
   PAD(2),
   CHIPPED(3),
   DELIVERED(4),
   CANCELED(5);
   
   private int code;
   
   private OrderStatus (int code){
       this.code = code;
   }
    public int getCodeStatus(){
        return code;
    }
    public static OrderStatus valueOf (int codeStatus){
        for(OrderStatus ordem : OrderStatus.values()){
            if(ordem.getCodeStatus()== codeStatus){
                return ordem;
            }
        }
        throw new IllegalArgumentException("Invalid code, try another!");
        
    }
}
