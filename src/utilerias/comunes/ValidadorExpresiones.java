package utilerias.comunes;

import estructurasLineales.ColaEstatica;
import estructurasLineales.ListaEstatica;
import estructurasLineales.PilaEstatica;
import utilerias.matematicas.ExpresionesMatematicas;

/**
 * Clase que valida expresiones o archivos de codigo.
 */
public class ValidadorExpresiones {
    /**
     * Representa la lista de palabras reservadas.
     */
    private static ListaEstatica palabrasReservadas;

    /**
     * Representa la lista de tipos de datos.
     */
    private static ListaEstatica tiposDeDatos;

    /**
     * Metodo que valida lineas de expresiones para ver si son correctas.
     * @param lineas Representa las lineas de expresiones a validar.
     * @param numCaracteres Representa la cantidad de caracteres en la expresion completa.
     * @param esMatematica Representa una bandera para saber si es una expresion matematica o archivo de codigo.
     * @return Regresa una cola con los errores en la expresion.
     */
    public static ColaEstatica validadorExpresiones(ListaEstatica lineas, int numCaracteres, boolean esMatematica){
        llenarPalabrasReservadas();
        llenarTiposDatos();
        PilaEstatica pilaParentesis = new PilaEstatica(numCaracteres);
        PilaEstatica comentarios = new PilaEstatica(numCaracteres);
        boolean comentarioActivo = false;
        ColaEstatica colaErrores = new ColaEstatica(numCaracteres);
        ListaEstatica listaVariables = new ListaEstatica(numCaracteres);
        for (int iteradorLineas = 0; iteradorLineas < lineas.cantidad(); iteradorLineas++) {
            String expresion =(String) lineas.obtener(iteradorLineas);
            for (int iteradorExpresion = 0; iteradorExpresion < expresion.length(); iteradorExpresion++) {
                char caracterActual = expresion.charAt(iteradorExpresion);
                if(esSignoAgrupacionAbierto(caracterActual) && !comentarioActivo){
                    ListaEstatica listaTemporal = new ListaEstatica(3);
                    listaTemporal.agregar(iteradorExpresion);
                    listaTemporal.agregar(caracterActual);
                    listaTemporal.agregar(iteradorLineas);
                    pilaParentesis.poner(listaTemporal);
                } else if (esSignoAgrupacionCerrado(caracterActual) && !comentarioActivo) {
                    ListaEstatica listaPila =(ListaEstatica) pilaParentesis.quitar();
                    if(listaPila==null){
                        ListaEstatica listaTemporal = new ListaEstatica(3);
                        listaTemporal.agregar(iteradorExpresion+1);
                        listaTemporal.agregar(iteradorLineas+1);
                        listaTemporal.agregar(TipoError.ERROR_PARENTESIS_C);
                        colaErrores.poner(listaTemporal);
                        continue;
                    }
                    Character caracterPila = (Character) listaPila.obtener(1);
                    if(!validarSignosAgrupacion(caracterPila, caracterActual)) {
                        ListaEstatica listaTemporal = new ListaEstatica(3);
                        listaTemporal.agregar(((Integer)listaPila.obtener(0))+1);
                        listaTemporal.agregar((Integer) listaPila.obtener(2)+1);
                        listaTemporal.agregar(TipoError.ERROR_PARENTESIS_A);
                        //TODO
                        colaErrores.poner(listaTemporal);
                        iteradorExpresion--;
                        continue;
                    }

                } else if (esInicioComentario(expresion, iteradorExpresion, comentarios, iteradorLineas) && !esMatematica && !comentarioActivo) {
                    String temporal =(String) ((ListaEstatica)comentarios.verTope()).obtener(1);
                    iteradorExpresion+=temporal.length();
                    comentarioActivo=true;
                } else if (esFinComentario(expresion, iteradorExpresion) && !esMatematica && comentarioActivo) {
                    ListaEstatica temporal =(ListaEstatica) comentarios.quitar();
                    if(temporal==null){
                        temporal = new ListaEstatica(3);
                        temporal.agregar(iteradorExpresion+1);
                        temporal.agregar(iteradorLineas+1);
                        temporal.agregar(TipoError.ERROR_COMENTARIO_C);
                        colaErrores.poner(temporal);
                        continue;
                    }

                    String comentarioAnterior = (String) temporal.obtener(1);
                    String comentarioActual = leerComentario(expresion, iteradorExpresion);
                    if(!validarCorrespondenciaComentarios(comentarioAnterior, comentarioActual)){
                        temporal = new ListaEstatica(3);
                        temporal.agregar(iteradorExpresion+1);
                        temporal.agregar(iteradorLineas+1);
                        temporal.agregar(TipoError.ERROR_COMENTARIO_A);
                        colaErrores.poner(temporal);
                        continue;
                    }
                    iteradorExpresion+=comentarioActual.length();
                    comentarioActivo=false;
                } else if (expresion.charAt(iteradorExpresion)==' ') {
                    continue;
                } else if(!comentarioActivo && !esMatematica){
                    int tamanioVariable = (verificarVariableNoMatematica(expresion, iteradorExpresion, listaVariables));
                    if(tamanioVariable==0){
                        ListaEstatica temporal = new ListaEstatica(3);
                        temporal.agregar(iteradorExpresion+1);
                        temporal.agregar(iteradorLineas+1);
                        temporal.agregar(TipoError.ERROR_VARIABLE_MAL_DECLARADA);
                        colaErrores.poner(temporal);
                        iteradorExpresion+= ((String)listaVariables.eliminar()).length()+1;
                    }
                    if(tamanioVariable==-1)continue;
                    iteradorExpresion+=tamanioVariable;
                }
            }

        }
        if(!pilaParentesis.vacio()) {
            ListaEstatica listaTemporal = new ListaEstatica(3);
            ListaEstatica parentesis =(ListaEstatica) pilaParentesis.quitar();
            listaTemporal.agregar(((Integer)parentesis.obtener(0))+1);
            listaTemporal.agregar(((Integer)parentesis.obtener(2))+1);
            listaTemporal.agregar(TipoError.ERROR_PARENTESIS_A);
            colaErrores.poner(listaTemporal);
        }
        if(!comentarios.vacio()){
            ListaEstatica listaTemporal = new ListaEstatica(3);
            ListaEstatica comentario =(ListaEstatica) comentarios.quitar();
            listaTemporal.agregar(((Integer)comentario.obtener(0))+1);
            listaTemporal.agregar(((Integer)comentario.obtener(2))+1);
            listaTemporal.agregar(TipoError.ERROR_COMENTARIO_A);
            colaErrores.poner(listaTemporal);
        }
        return colaErrores;
    }

    /**
     * Metodo que llena la lista de palabras reservadas.
     */
    private static void llenarPalabrasReservadas(){
        palabrasReservadas = new ListaEstatica(20);
        palabrasReservadas.agregar("public");
        palabrasReservadas.agregar("private");
        palabrasReservadas.agregar("protected");
        palabrasReservadas.agregar("for");
        palabrasReservadas.agregar("while");
        palabrasReservadas.agregar("do");
        palabrasReservadas.agregar("void");
        palabrasReservadas.agregar("static");
        palabrasReservadas.agregar("return");
    }

    /**
     * Metodo que rellena la lista de tipos de datos.
     */
    private static void llenarTiposDatos(){
        tiposDeDatos = new ListaEstatica(20);
        tiposDeDatos.agregar("int");
        tiposDeDatos.agregar("Integer");
        tiposDeDatos.agregar("Double");
        tiposDeDatos.agregar("double");
        tiposDeDatos.agregar("String");
        tiposDeDatos.agregar("Character");
        tiposDeDatos.agregar("char");
        tiposDeDatos.agregar("package");
        tiposDeDatos.agregar("class");
    }

    /**
     * Metodo que valida la correspondencia entre dos comentarios.
     * @param comentarioAnterior Representa el comentario de entrada.
     * @param comentarioActual Representa el comentario de salida.
     * @return Regresa true si son correspondientes o false si no.
     */
    private static boolean validarCorrespondenciaComentarios(String comentarioAnterior, String comentarioActual) {
        switch (comentarioAnterior){
            case "/**": return comentarioActual.equals("**/");
            case "/*" : return comentarioActual.equals("*/");
            default: return false;
        }
    }


    /**
     * Metodo que valida si un caracter es el fin de un comentario.
     * @param expresion Representa la expresion a validar.
     * @param iteradorExpresion Posicion del caracter a validar.
     * @return Regresa true si es el fin de un comentario o false si no.
     */
    private static boolean esFinComentario(String expresion, int iteradorExpresion) {
        String comentario = leerComentario(expresion, iteradorExpresion);
        if(comentario.equals("**/") || comentario.equals("*/"))return true;
        return false;
    }

    /**
     * Metodo que lee un comentario de salida.
     * @param expresion Expresion a validar.
     * @param iteradorExpresion Posicion del caracter a validar.
     * @return Regresa el comentario leido.
     */
    private static String leerComentario(String expresion, int iteradorExpresion) {
        if(expresion.charAt(iteradorExpresion)!='*')return "";
        iteradorExpresion++;
        if(expresion.length()-1 >= iteradorExpresion){
            if(expresion.charAt(iteradorExpresion)=='*'){
                iteradorExpresion++;
                if(expresion.length()-1 >= iteradorExpresion){
                    if(expresion.charAt(iteradorExpresion)=='/'){
                        return "**/";
                    }
                    return "";
                }
                return "";
            }
            else if (expresion.charAt(iteradorExpresion)=='/'){
                return "*/";
            }
            else{
                return "";
            }
        }
        return "";
    }

    /**
     * Metodo que verifica si un caracter es el inicio de un comentario.
     * @param expresion Expresion a validar.
     * @param iteradorExpresion Posicion del caracter donde se encuentra el
     *                          posibe inicio del comentario.
     * @param comentarios PilaEstatica donde se guardara el inicio del comentario.
     * @return Regresa true si fue inicio o false si no.
     */
    private static boolean esInicioComentario(String expresion, int iteradorExpresion, PilaEstatica comentarios, int iteradorLinea) {
        ListaEstatica listaTemporal = new ListaEstatica(3);
        listaTemporal.agregar(iteradorExpresion);
        if(expresion.charAt(iteradorExpresion)!='/')return false;
        iteradorExpresion++;
        if(expresion.length()-1 < iteradorExpresion || expresion.charAt(iteradorExpresion)!='*') return false;
        iteradorExpresion++;
        if(expresion.length()-1 >= iteradorExpresion){
            if(expresion.charAt(iteradorExpresion)=='*'){
                listaTemporal.agregar("/**");
                listaTemporal.agregar(iteradorLinea);
                comentarios.poner(listaTemporal);
                return true;
            }else{
                listaTemporal.agregar("/*");
                listaTemporal.agregar(iteradorLinea);
                comentarios.poner(listaTemporal);
                return true;
            }
        }else {
            listaTemporal.agregar("/*");
            listaTemporal.agregar(iteradorLinea);
            comentarios.poner(listaTemporal);
            return true;
        }
    }

    /**
     * Metodo que valida si un caracter es un signo de agrupacion
     * abierto.
     * @param signo Caracter a validar.
     * @return Regresa true si es y false si no.
     */
    public static boolean esSignoAgrupacionAbierto(char signo){
        return switch (signo){
            case '(', '[', '{'-> true;
            default -> false;
        };
    }

    /**
     * Metodo que valida si un caracter es un signo de agrupacion
     * cerrado.
     * @param signo Caracter a validar.
     * @return Regresa true si es y false si no.
     */
    public static boolean esSignoAgrupacionCerrado(char signo){
        return switch (signo){
            case ')', ']', '}'-> true;
            default -> false;
        };
    }

    /**
     * Metodo que valida si dos signos de agrupacion son
     * correspondientes.
     * @param abre Representa al caracter que abre.
     * @param cierra Representa al caracter que cierra.
     * @return Regresa true si corresponden o false si no.
     */
    public static boolean validarSignosAgrupacion(char abre, char cierra){
        return switch (cierra){
            case ')'-> abre=='(';
            case ']'-> abre=='[';
            case '}'-> abre=='{';
            default -> false;
        };
    }

    /**
     * Metodo que lee una variable.
     * @param expresion Representa la expresion donde se leera.
     * @param iterador Representa la posicion de la expresion donde se iniciara la lectura.
     * @return Regresa la palabra leida.
     */
    private static String leerPalabra(String expresion, int iterador){
        String res = "";
        if(ExpresionesMatematicas.esNumero(expresion.charAt(iterador)))return res;
        while (iterador<expresion.length() &&
                !ExpresionesMatematicas.esOperador(""+expresion.charAt(iterador))
                && expresion.charAt(iterador)!=';'
                && expresion.charAt(iterador)!=' '
                && expresion.charAt(iterador)!='>'
                && expresion.charAt(iterador)!='<'
                && expresion.charAt(iterador)!='='
                && expresion.charAt(iterador)!=','){
            res+=expresion.charAt(iterador);
            iterador++;
        }
        return res;
    }

    /**
     * Metodo que valida la existencia de una variable.
     * @param expresion Representa la expresion donde se leera.
     * @param iterador Representa la posicion de la expresion donde se iniciara la lectura.
     * @param variables Representa la lista de variables que ya existen.
     * @return Regresa el numero de caracteres de la variable, -1 si la palabra no tiene caracteres
     * o 0 si es una variable existente.
     */
    private static int verificarVariableNoMatematica(String expresion, int iterador, ListaEstatica variables){
        String palabra = leerPalabra(expresion, iterador);

        if(palabra.length()==0)return -1;
        if(((Integer) palabrasReservadas.buscar(palabra)!=-1)) return palabra.length()-1;
        if((Integer) tiposDeDatos.buscar(palabra)!=-1){
            iterador+=palabra.length()+1;
            String variable = leerPalabra(expresion, iterador);
            variables.agregar(variable);
            iterador+=variable.length();
            int caracteresIgual=0;
            while (expresion.length()>iterador && expresion.charAt(iterador)!=';'){
                caracteresIgual++;
                iterador++;
            }
            return palabra.length()+variable.length()+caracteresIgual;
        }
        if((Integer) variables.buscar(palabra)==-1){
            variables.agregar(palabra);
            return 0;
        }
        return palabra.length();
    }
}
