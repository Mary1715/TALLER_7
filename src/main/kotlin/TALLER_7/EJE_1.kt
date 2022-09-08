
package TALLER_7


import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFails
import kotlin.test.assertNull
import kotlin.test.assertTrue

/**
 * Ejercicio 01
 * Obtener el fondo de la pila
 */
fun <T> IStack<T>.bottom(): T {// esta funcion es o👎
    val copia = this.copy()
    var ultimo: T = copia.peek()
    while (!copia.isEmpty){

        ultimo = copia.peek()
        copia.pop()

    }
    return ultimo
}

/**
 * Ejercicio 02
 * Función para sumar los números pares de tres cifras que hay en una pila de enteros
 */
fun sumarParesTresCifras(pila: IStack<Int>): Int { // esta funcion es o👎

    val copia = pila.copy()
    var ultimo:Int
    var suma = 0
    while (!copia.isEmpty){

        ultimo = copia.peek()

        if((ultimo in 100..999)&& ultimo%2 == 0){
            suma = suma +ultimo
        }

        copia.pop()

    }

    return suma

}

/**
 * Ejercicio 03
 * Función para determinar cuál es el número más grande de dos cifras que hay
 * en una pila de números. Si no existe ningún número de dos cifras, retorne
 * null
 */
fun mayorDeDosCifras(pila: IStack<Int>): Int? {// esta función es O👎
    val copia = pila.copy()
    var ultimo:Int?
    var maximo:Int=0
    var nulo:Int? = null

    if (copia.isEmpty ){
        return null
    }else{
        while (!copia.isEmpty ){

            ultimo = copia.peek()

            if ((ultimo in 10..99) && (ultimo > maximo)){



                maximo = ultimo



            }
            if(maximo == 0){

                return null

            }


            copia.pop()

        }
        return maximo
    }



}

/**
 * Ejercicio 04
 * Hacer una función externa que permita guardar un elemento en el fondo
 * de la pila. GEnérica
 */
fun <T> guardarEnElFondo(p: IStack<T>, elem: T): Unit { //Esta funcion es O👎

    val aux:IStack<T> = TArrayStack()
    // pasar los datos a la pila auxiliar

    while (!p.isEmpty) { // O👎

        val tope = p.peek()
        aux.push(tope)
        p.pop()

    }
    p.push(elem) //O(1)
    // pasamos los elementos de aux a p
    while (!aux.isEmpty){ // O👎
        p.push(aux.peek())
        aux.pop()
    }




}

/**
 * Ejercicio 05
 * Función genérica para obtener el tamaño de una pila
 */
fun <T> tamPila(p: IStack<T>) : Int { // esta funcion es O👎
    val copia = p.copy()

    var contador:Int = 0

    while (!copia.isEmpty){
        copia.pop()
        contador = contador+1
    }
    return contador
}

/**
 * Ejercicio 06
 * Función genérica que permite Invertir una pila en otra. Recibe la pila y retorna la pila, pero invertida.
 * Solo puede usarse las operaciones de las pilas, no listas.
 */
fun <T> invertirPila(pila: IStack<T>): IStack<T> { //Esta funcion es O👎
    val copia = pila.copy()
    var ultimo: T = copia.peek()
    while (!pila.isEmpty){
        pila.pop()
    }
    while (!copia.isEmpty){
        ultimo = copia.peek()
        pila.push(ultimo)
        copia.pop()
    }



    return pila
}


/**
 * Ejercicio 07
 * Función genérica que copia una pila en otra.
 * La función recibe la pila y retorna la copia.
 * No debe usarse el método copy de la pila ni listas
 */
fun <T> copiarPila(pila: IStack<T>): IStack<T> {//Esta funcion es O👎
    val aux:IStack<T> = TArrayStack()
    val copia:IStack<T> = TArrayStack()
    var ultimo = pila.peek()
    while (!aux.isEmpty){
        aux.pop()
        copia.pop()
    }
    while (!pila.isEmpty){
        ultimo = pila.peek()
        aux.push(ultimo)
        pila.pop()
    }

    while (!aux.isEmpty()){
        ultimo=aux.peek()
        copia.push(ultimo)
        pila.push(ultimo)
        aux.pop()
    }



    return copia
}


/**
 * Ejercicio 08
 * Función genérica que recibe una pila y un elemento y que elimina de la
 * pila todas las ocurrencias del elemento que se recibe como parámetro.
 * No debe retornar nada.
 */
fun <T> eliminarElementoPila(pila: IStack<T>, elem: T) {// esta funcion es O👎
    val aux:IStack<T> = TArrayStack()

    var ultimo = pila.peek()
    while (!aux.isEmpty){
        aux.pop()

    }
    while (!pila.isEmpty){
        ultimo = pila.peek()
        aux.push(ultimo)
        pila.pop()
    }

    while (!aux.isEmpty){
        ultimo=aux.peek()
        if (ultimo != elem){

            pila.push(ultimo)

        }



        aux.pop()
    }
}

/**
 * Ejercicio 09
 * Invertir una lista de números utilizando una pila. La función no retorna,
 * debe modificar la lista
 */
fun invertirLista(list: IList<Int>) { // Esta función es O👎

    val nP: IStack<Int> = TArrayStack()
    list.forEach { nP.push(it) }
    list.clear()
    while (!nP.isEmpty) {
        list.add(nP.peek())
        nP.pop()
    }
}


/**
 * Ejercicio 10
 * Usar una pila de letras para Determinar si una frase es palindrome o no
 */
fun palindrome(frase: String): Boolean {//O(n^3)
    var CantString = frase.chars().count().toInt()
    var Pila1:TLinkedStack<Char> = TLinkedStack()
    var Pila2:TLinkedStack<Char> = TLinkedStack()
    var retorno = false
    for(i in 0 .. CantString-1){//O👎
        var caracter = frase.get(i)
        Pila1.push(caracter)
    }
    var CopiaPila1 = Pila1.copy()
    while(!CopiaPila1.isEmpty){//O👎
        var ultimo = CopiaPila1.peek()
        Pila2.push(ultimo)
        CopiaPila1.pop()
    }
    for(i in 1 .. CantString){//O👎
        if(Pila1.peek() == Pila2.peek()){
            retorno = true
            Pila1.pop()
            Pila2.pop()
        }
        else{
            retorno = false
        }
    }
    return retorno
/**
 * Ejercicio 11
 * Determinar si dos pilas son iguales
 */
fun <T> igualesPilas(pila1: IStack<T>, pila2: IStack<T>): Boolean { //Esta función es O👎

    var copia1 = pila1.copy()
    var copia2 = pila2.copy()
    var retorno = false
    while (!copia1.isEmpty&&!copia2.isEmpty){//O👎
        var ultimo1 = copia1.peek()
        var ultimo2 = copia2.peek()
        if(ultimo1!=null||ultimo2!=null){
            if(ultimo1==ultimo2){
                retorno = true
            }
            else{
                retorno = false
                break
            }
        }
        else{
            retorno = false
            break
        }
        copia1.pop()
        copia2.pop()
    }
    return retorno
}