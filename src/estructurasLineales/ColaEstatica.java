package estructurasLineales;

import entradasalida.SalidaPorDefecto;

public class ColaEstatica implements Lote{

    protected Object[] informacion;
    protected int inicio;
    protected int fin;
    protected int MAXIMO;

    public ColaEstatica(int tamanio){
        informacion=new Object[tamanio];
        inicio=-1;
        fin=-1;
        MAXIMO=tamanio;
    }

    @Override
    public boolean lleno() {
        if((inicio==0 && fin==MAXIMO-1) || fin==inicio-1)return true;
        return false;
    }

    @Override
    public boolean vacio() {
        return inicio==-1 ? true:false;
    }

    @Override
    public boolean poner(Object info) {
        if(lleno())return false;
        if(vacio()){
            inicio=0;
            fin=0;
        } else if (MAXIMO==fin+1) {
            fin=0;
        } else {
            fin++;
        }
        informacion[fin]=info;
        return true;
    }

    @Override
    public Object quitar() {
        if(vacio())return null;
        Object respaldo = informacion[inicio];
        if(inicio==fin){
            inicio=-1;
            fin=-1;
        } else if (inicio==MAXIMO-1) {
            inicio=0;
        }else{
            inicio++;
        }

        return respaldo;
    }

    @Override
    public void imprimir() {
        if(vacio())return;
        if (inicio<=fin){
            for (int indice = inicio; indice <=fin ; indice++) {
                SalidaPorDefecto.terminal(informacion[indice]+" ");
            }
        }else {
            for (int indice = inicio; indice <MAXIMO ; indice++) {
                SalidaPorDefecto.terminal(informacion[indice]+" ");
            }
            for (int indice = 0; indice <=fin ; indice++) {
                SalidaPorDefecto.terminal(informacion[indice]+" ");
            }
        }
    }

    @Override
    public Object verTope() {
        if(!vacio())return informacion[fin];
        return null;
    }

    public Object verInicio(){
        if(!vacio())return informacion[inicio];
        return null;
    }
}
