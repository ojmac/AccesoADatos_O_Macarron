CREATE TABLE tareas_pendientes (
    id INT PRIMARY KEY,
    descripcion VARCHAR(255) NOT NULL,
    fecha_inicio DATE NOT NULL,
    fecha_final DATE NOT NULL,
    finalizada BOOLEAN NOT NULL
);