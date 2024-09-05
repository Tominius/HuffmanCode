package ColaPrioridad;

public interface ColaPrioridadTDA {
    void InicializarCola();
    int Prioridad();
    boolean ColaVacia();
    int Primero();
    void Desacolar();
    void Acolar(int x, int prioridad);
}
