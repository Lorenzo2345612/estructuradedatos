package utilerias.matematicas;

import entradasalida.EntradaPorDefecto;
import estructurasLineales.ColaEstatica;
import estructurasLineales.ListaEstatica;
import estructurasLineales.PilaEstatica;
import registros.calculadora.VistaCalculadora;
import utilerias.comunes.TipoError;

public class ExpresionesMatematicas {
    /**
     * Metodo que transforma un string que representa
     * una operacion en formato infijo a una cola que
     * representa la operacion en formato postfijo.
     * @param infija Representa la operacion en formato infijo.
     * @return Regresa la operacion en formato postfijo en una
     * cola.
     */
    public static ColaEstatica infijaAPostFija(String infija){
        ColaEstatica expresionPostfija = new ColaEstatica(infija.length());
        PilaEstatica pilaOperadores = new PilaEstatica(infija.length());
        int iteradorCaracter =0;
        String variable = "";
        while(iteradorCaracter < infija.length()) {
            if(esNumero(infija.charAt(iteradorCaracter)) && variable.length()==0){
                String numeroTemporal=leerNumero(infija, iteradorCaracter);
                iteradorCaracter+=numeroTemporal.length();
                if(!expresionPostfija.poner(numeroTemporal))return null;
            } else if (esOperador(infija.charAt(iteradorCaracter)+"") && variable.length()==0) {
                agregarOperador(pilaOperadores,infija,expresionPostfija,iteradorCaracter);
                iteradorCaracter++;
            } else if (esOperador(infija.charAt(iteradorCaracter)+"") && variable.length()>0) {
                expresionPostfija.poner(obtenerValorVariable(variable));
                variable="";
                agregarOperador(pilaOperadores,infija,expresionPostfija,iteradorCaracter);
                iteradorCaracter++;
            } else if ((infija.charAt(iteradorCaracter)=='(' || infija.charAt(iteradorCaracter)=='[')) {
                pilaOperadores.poner(infija.charAt(iteradorCaracter));
                iteradorCaracter++;
            } else if ((infija.charAt(iteradorCaracter)==')' || infija.charAt(iteradorCaracter)==']') && variable.length()==0) {
                agregarOperadoresEntreParentesis(pilaOperadores, expresionPostfija);
                iteradorCaracter++;
            } else if ((infija.charAt(iteradorCaracter)==')' || infija.charAt(iteradorCaracter)==']') && variable.length()>0) {
                expresionPostfija.poner(obtenerValorVariable(variable));
                variable="";
                agregarOperadoresEntreParentesis(pilaOperadores, expresionPostfija);
                iteradorCaracter++;
            } else if (infija.charAt(iteradorCaracter)==' ' && variable.length()>0) {
                expresionPostfija.poner(obtenerValorVariable(variable));
                variable="";
                iteradorCaracter++;
            } else if (infija.charAt(iteradorCaracter)==' ' && variable.length()==0) {
                iteradorCaracter++;
            } else{
                variable+=infija.charAt(iteradorCaracter);
                iteradorCaracter++;
            }
        }
        if(variable.length()>0) expresionPostfija.poner(obtenerValorVariable(variable));
        while(!pilaOperadores.vacio()){
            expresionPostfija.poner(pilaOperadores.quitar());
        }
        return expresionPostfija;
    }

    /**
     * Agrega un operador a la pila siguiendo los lineamientos de una
     * operacion postfija.
     * @param pila Representa la pila en donde se guardara el operador.
     * @param infija Representa la operacion infija a utilizar.
     * @param ePos Representa la cola donde se agregaran los operadores
     *             procesados.
     * @param iterador Representa el iterador donde se encuentra la operacion actual.
     */
    public static void agregarOperador(PilaEstatica pila, String infija, ColaEstatica ePos, int iterador){
        Character operadorPila;
        while (true){
            operadorPila=(Character) pila.verTope();
            if(operadorPila==null){
                break;
            }
            if(!esOperadorMayorOIgual(infija.charAt(iterador),operadorPila)){
                break;
            }
            ePos.poner(pila.quitar());
        }
        pila.poner(infija.charAt(iterador));
    }

    /**
     * Metodo que agrega los operadores que se encuentran entre parentesis o corchetes.
     * @param pila Representa la pila de donde se sacaran los operadores.
     * @param ePos Representa la cola donde se agregaran los operadores.
     */
    private static void agregarOperadoresEntreParentesis(PilaEstatica pila, ColaEstatica ePos){
        while(true){
            Character operadorActual =(Character) pila.quitar();
            if(operadorActual=='(' || operadorActual=='['){
                break;
            }
            ePos.poner(operadorActual);
        }
    }

    /**
     * Metodo que verifica si un operador es de mayor o igual jerarquia.
     * @param operadorActual Representa el operador actual.
     * @param operadorPila Representa el operador que se obtuvo de la pila.
     * @return Regresa true si el operador de la pila es de mayor o igual importancia
     * que el operador actual.
     */
    private static boolean esOperadorMayorOIgual(char operadorActual, char operadorPila){
        return jerarquiaOperador(operadorPila)>=jerarquiaOperador(operadorActual);
    }

    /**
     * Metodo que obtiene la jerarquia de un operador.
     * @param operando Representa el operador del que se obtendra la jerarquia.
     * @return Regresa la jerarquia del operador en cuestion.
     */
    private static int jerarquiaOperador(char operando){
        return switch (operando){
            case '^' -> 4;
            case '/', '%', '*' -> 3;
            case '+', '-' -> 2;
            default -> 1;
        };
    }

    /**
     * Metodo que lee un numero completo en una string.
     * @param infija Representa la expresion infija de donde se obtendra el numero.
     * @param iteradorCaracter Representa la posicion donde inicia el numero en la
     *                         cadena.
     * @return Regresa el numero completo representado en cadena.
     */
    private static String leerNumero(String infija, int iteradorCaracter){
        String actual="";
        do{
            actual+=infija.charAt(iteradorCaracter);
            iteradorCaracter++;
        }while (iteradorCaracter < infija.length() && (esNumero(infija.charAt(iteradorCaracter)) || infija.charAt(iteradorCaracter)=='.'));
        return actual;
    }

    /**
     * Metodo que verifica si un caracter es un numero.
     * @param caracter Representa el caracter a revisar.
     * @return Regresa true si es un numero o false si no.
     */
    public static boolean esNumero(char caracter){
        try{
            Integer.parseInt(caracter+"");
            return true;
        }catch (Exception e){
            return false;
        }
    }

    /**
     * Metodo que convierte de infija a prefija.
     * @param infija Representa la expresion a convertir.
     * @return Regresa una string con la cadena en orden prefija.
     */
    public static String infijaAPrefija(String infija){
        return "";
    }

    /**
     * Metodo que evalua una expresion postfija.
     * @param postFija Representa la string a evaluar.
     * @return Regresa el resultado de la operacion.
     */
    public static Double evaluarPostFija(String postFija){
        PilaEstatica pila = new PilaEstatica(postFija.length());
        for(int indiceToken=0; indiceToken<postFija.length();indiceToken++) {
            // 1 Tokenizar izq->der
            char token = postFija.charAt(indiceToken);
            // 2 Si es operando meter a la pila
            if (esOperando(""+token)){
                if(!(pila.poner(""+token)))return null;
            }else{
                // 3 Si es operador, sacar dos operandos.
                String operandoDos = pila.quitar().toString();
                String operandoUno = pila.quitar().toString();

                if(operandoDos==null || operandoUno==null)return null;

                // Aplicar operacion con ellos
                Double resultadoParcial = operacion(Double.parseDouble(operandoUno),Double.parseDouble(operandoDos), token);

                if(resultadoParcial==null)return null;
                // Meter el resultado en la pila
                pila.poner(resultadoParcial);
            }
        }
        // 4 El resultado final esta en la pila.
        String resultadoFinal =pila.quitar().toString();

        if(resultadoFinal==null)return null;

        return Double.parseDouble(resultadoFinal);
    }

    /**
     * Metodo que evalua una expresion postfija.
     * @param colaPostFija Representa la expresion a evaluar.
     * @param tamanio Repressenta el tamaño de la expresion postfija.
     * @return Regresa el valor de la evaluacion.
     */
    public static Double evaluarPostFija(ColaEstatica colaPostFija, int tamanio){
        PilaEstatica pila = new PilaEstatica(tamanio);
        while (true){
            Object pre = colaPostFija.quitar();
            if(pre==null)break;
            String token = pre.toString();
            if (esOperando(token)){
                if(!(pila.poner(token)))return null;
            }else{
                String operandoDos =(String) pila.quitar();
                String operandoUno =(String) pila.quitar();

                if(operandoDos==null || operandoUno==null)return null;

                Double resultadoParcial = operacion(Double.parseDouble(operandoUno),Double.parseDouble(operandoDos), token.charAt(0));

                if(resultadoParcial==null)return null;
                pila.poner(resultadoParcial.toString());
            }
        }
        String resultadoFinal =(String) pila.quitar();

        if(resultadoFinal==null)return null;

        return Double.parseDouble(resultadoFinal);
    }

    /**
     * Metodo que evalua una expresion prefija.
     * @param preFija Representa la expre
     * @return Regresa el resultado de evaluar la expresion.
     */
    public static Double evaluarPreFija(String preFija){
        PilaEstatica pila = new PilaEstatica(preFija.length());
        for(int indiceToken=preFija.length()-1; indiceToken>=0;indiceToken--) {
            char token = preFija.charAt(indiceToken);
            if (esOperando(""+token)){
                if(!(pila.poner(""+token)))return null;
            }else{
                String operandoUno = pila.quitar().toString();
                String operandoDos = pila.quitar().toString();

                if(operandoDos==null || operandoUno==null)return null;

                Double resultadoParcial = operacion(Double.parseDouble(operandoUno),Double.parseDouble(operandoDos), token);

                if(resultadoParcial==null)return null;
                pila.poner(resultadoParcial+"");
            }
        }
        // 4 El resultado final esta en la pila.
        String resultadoFinal =pila.quitar().toString();

        if(resultadoFinal==null)return null;

        return Double.parseDouble(resultadoFinal);
    }

    /**
     * Metodo que realiza una operacion entre dos operandos.
     * @param operando1 Representa el valor del operando 1.
     * @param operando2 Representa el valor del operando 2.
     * @param operador Representa el operador que se usara en la operacion.
     * @return Regresa el valor de realizar la operacion.
     */
    public static Double operacion(double operando1, double operando2, char operador){
        String newOperador=operador+"";
        switch (newOperador){
            case "+":   return operando1+operando2;
            case "-":   return operando1-operando2;
            case "/":   if(operando2==0)return null;
                        return operando1/operando2;
            case "*":   return operando1*operando2;
            case "^":   return Math.pow(operando1,operando2);
            case "%":   return operando1%operando2;
            default: return null;
        }
    }

    /**
     * Metodo que verifica si un caracter es un operando.
     * @param token Representa el caraacter a validar.
     * @return Regresa true si es un operando y false si no.
     */
    public static boolean esOperando(String token){
        return switch (token) {
            case "+", "-", "/", "*", "^", "%", ")", "(" -> false;
            default -> true;
        };
    }

    /**
     * Metodo que verifica si un caracter es un operador.
     * @param token Representa el caracter a validar.
     * @return Regresa true si es operador o false si no.
     */
    public static boolean esOperador(String token){
        return switch (token) {
            case "+", "-", "/", "*", "^", "%" -> true;
            default -> false;
        };
    }

    /**
     * Metodo que obtiene el valor de una variable.
     * @param nombreVariable Representa el nombre de
     *                       la variable a obtener.
     * @return Regresa el valor de la variable en formato string.
     */
    public static String obtenerValorVariable(String nombreVariable){
        VistaCalculadora.obtenerValorVariable(nombreVariable);
        return EntradaPorDefecto.consolaCadenas();
    }

}
