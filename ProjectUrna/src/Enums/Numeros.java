package Enums;

/**
 *
 * @author drextar
 */
public enum Numeros {
        UM(1),
        DOIS(2),
        TRES(3),
        QUATRO(4),
        CINCO(5),
        SEIS(6),
        SETE(7),
        OITO(8),
        NOVE(9),
        ZERO(0);
        
        private int numero;
        Numeros(int num){
            numero = num;
        }
        
        public int getNumero(){
            return numero;
        }
}
