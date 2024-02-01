package one.digitalinnovation;

public class Fila<T> {
    private No<T> refNoEntradaFila;

    public Fila(){
        this.refNoEntradaFila = null;
    }

    public void enqueue(T object) {
        No novoNo = new No(object);
//        setando o novo no p/ ser o ultimo da fila
        novoNo.setRefNo(refNoEntradaFila);
//        referenciando no inicio da fila p/ o novo no
        refNoEntradaFila = novoNo;
    }

    public T dequeue(){
        if(!this.isEmpty()){
            No primeiroNo = refNoEntradaFila;
            No noAuxiliar = refNoEntradaFila;
            while(true){
                if(primeiroNo.getRefNo() != null) {
                    noAuxiliar = primeiroNo;
                    primeiroNo = primeiroNo.getRefNo();
                }
                else {
                    noAuxiliar.setRefNo(null);
                    break;
                }
            }
            return (T) primeiroNo.getObject();
        }
        return null;
    }

    public T first() {
//        fila n esta vazia
        if(!this.isEmpty()){
//            caso tenha apenas um objeto na fila
            No primeiroNo = refNoEntradaFila;
            while(true){
//                iterando sobre os nos ate encontrar uma referencia vazia, que indica o primeiro da fila
                if(primeiroNo.getRefNo() != null) primeiroNo = primeiroNo.getRefNo();
                else break;
            }
            return (T) primeiroNo.getObject();
        }
        return null;
    }

    public boolean isEmpty(){
        return refNoEntradaFila == null ? true : false;
    }

    @Override
    public String toString() {
        String stringRetorno = "";
        No noAuxiliar = refNoEntradaFila;

        if(refNoEntradaFila != null) {
            while(true){
                stringRetorno += "[No{objeto=" + noAuxiliar.getObject() + "}]--->";
                if(noAuxiliar.getRefNo() != null) noAuxiliar = noAuxiliar.getRefNo();
                else {
                    stringRetorno += "null";
                    break;
                }
            }
        } else {
            stringRetorno = "null";
        }
        return stringRetorno;
    }
}
