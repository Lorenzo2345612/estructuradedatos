package utilerias.matematicas;

import estructurasLineales.PilaEstatica;

public class ExpresionesMatematicas {

    public static String infijaAPostFija(String infija){
        return "";
    }

    public static String infijaAPrefija(String infija){
        return "";
    }

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

    public static Double evaluarPreFija(String preFija){
        PilaEstatica pila = new PilaEstatica(preFija.length());
        for(int indiceToken=preFija.length()-1; indiceToken>=0;indiceToken--) {
            // 1 Tokenizar izq->der
            char token = preFija.charAt(indiceToken);
            // 2 Si es operando meter a la pila
            if (esOperando(""+token)){
                if(!(pila.poner(""+token)))return null;
            }else{
                // 3 Si es operador, sacar dos operandos.
                String operandoUno = pila.quitar().toString();
                String operandoDos = pila.quitar().toString();

                if(operandoDos==null || operandoUno==null)return null;

                // Aplicar operacion con ellos
                Double resultadoParcial = operacion(Double.parseDouble(operandoUno),Double.parseDouble(operandoDos), token);

                if(resultadoParcial==null)return null;
                // Meter el resultado en la pila
                pila.poner(resultadoParcial+"");
            }
        }
        // 4 El resultado final esta en la pila.
        String resultadoFinal =pila.quitar().toString();

        if(resultadoFinal==null)return null;

        return Double.parseDouble(resultadoFinal);
    }

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

    public static boolean esOperando(String token){
        switch (token){
            case "+":
            case "-":
            case "/":
            case "*":
            case "^":
            case "%":
            case ")":
            case "(":return false;
            default: return true;
        }
    }
}
