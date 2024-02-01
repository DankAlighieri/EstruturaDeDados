package one.digitalinnovation;

public class ListaEncadeada<T> {
    No<T> refEntrada;

    public ListaEncadeada(){
        this.refEntrada = null;
    }

    public void add(T conteudo){
        No<T> novoNo = new No<>(conteudo);
//        verificando se a classe Lista esta vazia
        if (this.isEmpty()) {
            refEntrada = novoNo;
            return;
        }

        No<T> noAux = refEntrada;
        for (int i = 0; i < this.size()-1; i++){
//            percorrendo a lista
            noAux = noAux.getProximoNo();
        }
//        setando o novo no apos percorrer a lista inteira
        noAux.setProximoNo(novoNo);
    }

    public T get(int index) {
        return getNo(index).getConteudo();
    }

    private No<T> getNo(int index) {
        validaIndice(index);
        No<T> noAux = refEntrada;
        No<T> noRetorno = null;

        for (int i = 0; i <= index; i++) {
            noRetorno = noAux;
            noAux = noAux.getProximoNo();
        }
        return noRetorno;
    }

    private void validaIndice(int index) {
        if (index >= size()) {
            int ultimoIndice = size() - 1;
            throw new IndexOutOfBoundsException("Não existe conteúdo no indice " + " desta lista. Esta lista só vai até o indíce" + ultimoIndice + ".");
        }
    }

    public T remove(int index){
        // selecionando o no a ser removido
        No<T> noPivor = this.getNo(index);

        // condicao p/ caso seja o primeiro no
        if(index == 0){
            // ref de entrada sera o no seguinte o no pivor que foi selecionado
            refEntrada = noPivor.getProximoNo();
            return noPivor.getConteudo();
        }
        // Reatribuindo a entrada da lista, pulando o no do indice passado
        No<T> noAnterior = getNo(index - 1);
        // removendo a referencia de entrada do no
        noAnterior.setProximoNo(noPivor.getProximoNo());
        return noPivor.getConteudo();
    }
    public int size(){
        int tamanhoLista = 0;
        No<T> referenciaAux = refEntrada;

        while(true) {
            if (referenciaAux != null) {
                tamanhoLista++;
                if (referenciaAux.getProximoNo() != null){
                    referenciaAux = referenciaAux.getProximoNo();
                } else break;
            } else break;
        }

        return tamanhoLista;
    }

    public boolean isEmpty() {
        return refEntrada == null ? true : false;
    }

    @Override
    public String toString() {
        String strRetorno = "";
        No<T> noAux = refEntrada;

        for(int i = 0; i < this.size(); i++) {
            strRetorno += "[No {conteudo=" + noAux.getConteudo() + "}]--->";
            noAux = noAux.getProximoNo();
        }
        strRetorno += "null";
        return strRetorno;
    }
}
