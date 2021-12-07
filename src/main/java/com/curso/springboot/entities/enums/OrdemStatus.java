
package com.curso.springboot.entities.enums;

/**
 *
 * @author Evandro
 */
public enum OrdemStatus {
   WEINTING_PAIMENT(1),
   PAD(2),
   CHIPPED(3),
   DELIVERED(4),
   CANCELED(5);
   
   private int code;
   
   private OrdemStatus (int code){
       this.code = code;
   }
    public int getCodeStatus(){
        return code;
    }
    public static OrdemStatus valueOf (int codeStatus){
        for(OrdemStatus ordem : OrdemStatus.values()){
            if(ordem.getCodeStatus()== codeStatus){
                return ordem;
            }
        }
        throw new IllegalArgumentException("Invalid code, try another!");
        
    }
}
