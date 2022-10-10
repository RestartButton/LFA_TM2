//compile: javac -d build/classes src/gals/*.java src/main/*.java
//run: java -cp build/classes main/Main
//arg1: "A = 100; B = 10; B = 111 + A / B; show(B);"
//arg2: "A=(100+11*11)^11;B=A;show(B);"

package main;

import gals.*;

public class Main {

    public static void main(String[] args) {
        try {
            if(args.length <= 0){
                throw new Exception("Numero de argumentos invalido!");
            }

            Lexico lexico = new Lexico(args[0]);

            Sintatico sintatico = new Sintatico();
            Semantico semantico = new Semantico();

            sintatico.parse(lexico, semantico);
        } catch ( LexicalError | SyntaticError | SemanticError e ) {
            System.out.println( "Comando nao identificado! \n " + e.getMessage() );
        } catch ( Exception e ) {
            System.out.println( e.getMessage() );
            
        }
    }
    
}
