package edu.fje.m03uf4projecte;

public class ClaseGenerica2 <A,B>{
        private A ob;
        private B ob2;

    public ClaseGenerica2(A ob, B ob2) {
        this.ob = ob;
        this.ob2 = ob2;
    }

    public A getOb() {
        return ob;
    }
    public void setOb(A ob) {
        this.ob = ob;
    }
    public B getOb2() {
        return ob2;
    }
    public void setOb2(B ob2) {
        this.ob2 = ob2;
    }

    public void mostrarTipo(){
        System.out.println("El tipo del primer parametro es: "+ob.getClass().getName());
        System.out.println("El tipo del segundo parametro es: "+ob2.getClass().getName());
    }
}
